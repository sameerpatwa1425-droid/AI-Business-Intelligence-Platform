package com.sameer.business.intelligent_model.dto;

public class ProfitResponse {

    private Double totalProfit;

    public ProfitResponse(Double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }
}