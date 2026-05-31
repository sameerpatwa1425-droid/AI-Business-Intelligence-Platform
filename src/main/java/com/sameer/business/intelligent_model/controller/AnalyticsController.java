package com.sameer.business.intelligent_model.controller;

import com.sameer.business.intelligent_model.dto.ProfitResponse;
import com.sameer.business.intelligent_model.dto.DashboardResponse;
import com.sameer.business.intelligent_model.dto.RevenueResponse;
import com.sameer.business.intelligent_model.service.AnalyticsService;
import com.sameer.business.intelligent_model.dto.TopProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sameer.business.intelligent_model.dto.TopCategoryResponse;
import java.util.List;
import com.sameer.business.intelligent_model.dto.CategoryRevenueResponse;
import com.sameer.business.intelligent_model.dto.ProductRevenueResponse;
import com.sameer.business.intelligent_model.dto.MonthlySalesResponse;

@RestController
public class AnalyticsController {

    @Autowired
    private AnalyticsService service;

    @GetMapping("/analytics/revenue")
    public RevenueResponse getRevenue() {

        Double revenue = service.getTotalRevenue();

        return new RevenueResponse(revenue);
    }

    @GetMapping("/analytics/profit")
    public ProfitResponse getProfit() {

        Double profit = service.getTotalProfit();

        return new ProfitResponse(profit);
    }

    @GetMapping("/analytics/top-product")
    public TopProductResponse getTopProduct() {

        String product = service.getTopProduct();

        Double revenue = service.getTotalRevenue();

        return new TopProductResponse(product, revenue);
    }

    @GetMapping("/analytics/top-category")
    public TopCategoryResponse getTopCategory() {

        String category = service.getTopCategory();

        return new TopCategoryResponse(category);
    }

    @GetMapping("/analytics/dashboard")
    public DashboardResponse getDashboard() {

        return new DashboardResponse(
                service.getTotalRevenue(),
                service.getTotalProfit(),
                service.getTopProduct(),
                service.getTopCategory(),
                service.getTotalRecords());
    }

    @GetMapping("/analytics/category-revenue")
    public List<CategoryRevenueResponse> getCategoryRevenue() {

        return service.getRevenueByCategory();
    }

    @GetMapping("/analytics/top-products")
    public List<ProductRevenueResponse> getTopProducts() {

        return service.getTopProducts();
    }

    @GetMapping("/analytics/monthly-sales")
    public List<MonthlySalesResponse> getMonthlySales() {

        return service.getMonthlySales();
    }
}