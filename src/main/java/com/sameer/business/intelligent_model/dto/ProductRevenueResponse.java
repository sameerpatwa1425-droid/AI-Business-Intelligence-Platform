package com.sameer.business.intelligent_model.dto;

public class ProductRevenueResponse {

    private String product;
    private Double revenue;

    public ProductRevenueResponse(String product, Double revenue) {
        this.product = product;
        this.revenue = revenue;
    }

    public String getProduct() {
        return product;
    }

    public Double getRevenue() {
        return revenue;
    }
}