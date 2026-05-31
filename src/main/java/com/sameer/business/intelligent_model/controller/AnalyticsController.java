package com.sameer.business.intelligent_model.controller;

import com.sameer.business.intelligent_model.dto.ProfitResponse;
import com.sameer.business.intelligent_model.dto.DashboardResponse;
import com.sameer.business.intelligent_model.dto.RevenueResponse;
import com.sameer.business.intelligent_model.service.SalesRecordService;
import com.sameer.business.intelligent_model.dto.TopProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sameer.business.intelligent_model.dto.TopCategoryResponse;

@RestController
public class AnalyticsController {

    @Autowired
    private SalesRecordService service;

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
}