package com.sameer.business.intelligent_model.dto;

public class MonthlySalesResponse {

    private String month;
    private Double revenue;

    public MonthlySalesResponse(String month, Double revenue) {
        this.month = month;
        this.revenue = revenue;
    }

    public String getMonth() {
        return month;
    }

    public Double getRevenue() {
        return revenue;
    }
}