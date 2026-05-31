package com.sameer.business.intelligent_model.dto;

public class DashboardResponse {

    private Double totalRevenue;
    private Double totalProfit;
    private String topProduct;
    private String topCategory;
    private Long totalRecords;

    public DashboardResponse(
            Double totalRevenue,
            Double totalProfit,
            String topProduct,
            String topCategory,
            Long totalRecords) {

        this.totalRevenue = totalRevenue;
        this.totalProfit = totalProfit;
        this.topProduct = topProduct;
        this.topCategory = topCategory;
        this.totalRecords = totalRecords;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public String getTopProduct() {
        return topProduct;
    }

    public String getTopCategory() {
        return topCategory;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }
}