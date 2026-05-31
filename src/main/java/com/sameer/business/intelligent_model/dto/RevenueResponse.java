package com.sameer.business.intelligent_model.dto;

public class RevenueResponse {

    private Double totalRevenue;

    public RevenueResponse(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}