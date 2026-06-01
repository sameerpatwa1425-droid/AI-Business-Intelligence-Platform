async function loadDashboard() {

    const response = await fetch("http://localhost:8080/analytics/dashboard");

    const data = await response.json();

    document.getElementById("revenue").innerText =
        "₹" + data.totalRevenue;

    document.getElementById("profit").innerText =
        "₹" + data.totalProfit;

    document.getElementById("topProduct").innerText =
        data.topProduct;

    document.getElementById("topCategory").innerText =
        data.topCategory;
}

async function loadMonthlySalesChart() {

    const response = await fetch(
        "http://localhost:8080/analytics/monthly-sales"
    );

    const data = await response.json();

    const labels = data.map(item => item.month);

    const revenue = data.map(item => item.revenue);

    const ctx = document
        .getElementById("monthlySalesChart")
        .getContext("2d");

    new Chart(ctx, {
        type: "line",
        data: {
            labels: labels,
            datasets: [{
                label: "Monthly Revenue",
                data: revenue
            }]
        }
    });
}

async function loadCategoryChart() {

    const response = await fetch(
        "http://localhost:8080/analytics/category-revenue"
    );

    const data = await response.json();

    const labels = data.map(item => item.category);

    const revenue = data.map(item => item.revenue);

    const ctx = document
        .getElementById("categoryChart")
        .getContext("2d");

    new Chart(ctx, {
        type: "pie",
        data: {
            labels: labels,
            datasets: [{
                data: revenue
            }]
        }
    });
}

async function loadTopProductsTable() {

    const response = await fetch(
        "http://localhost:8080/analytics/top-products"
    );

    const data = await response.json();

    const tableBody =
        document.getElementById("topProductsBody");

    tableBody.innerHTML = "";

    data.forEach((item, index) => {

        tableBody.innerHTML += `
            <tr>
                <td>${index + 1}</td>
                <td>${item.product}</td>
                <td>₹${item.revenue}</td>
            </tr>
        `;
    });
}
async function loadInsights() {

    const dashboardResponse =
        await fetch("http://localhost:8080/analytics/dashboard");

    const dashboard =
        await dashboardResponse.json();

    const profitMargin =
        ((dashboard.totalProfit / dashboard.totalRevenue) * 100)
            .toFixed(2);

    const insights =
        document.getElementById("insightsList");

    insights.innerHTML = `
        <li>Total Revenue: ₹${dashboard.totalRevenue}</li>
        <li>Total Profit: ₹${dashboard.totalProfit}</li>
        <li>Profit Margin: ${profitMargin}%</li>
        <li>${dashboard.topProduct} is the top-performing product.</li>
        <li>${dashboard.topCategory} is the highest revenue category.</li>
    `;
}

loadDashboard();
loadMonthlySalesChart();
loadCategoryChart();
loadTopProductsTable();
loadInsights();