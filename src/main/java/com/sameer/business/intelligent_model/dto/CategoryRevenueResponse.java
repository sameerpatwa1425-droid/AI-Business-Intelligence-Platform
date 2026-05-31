package com.sameer.business.intelligent_model.dto;

public class CategoryRevenueResponse {

    private String category;
    private Double revenue;

    public CategoryRevenueResponse(String category, Double revenue) {
        this.category = category;
        this.revenue = revenue;
    }

    public String getCategory() {
        return category;
    }

    public Double getRevenue() {
        return revenue;
    }
}