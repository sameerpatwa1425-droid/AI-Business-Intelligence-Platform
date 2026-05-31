package com.sameer.business.intelligent_model.dto;

public class TopProductResponse {

    private String product;
    private Double sales;

    public TopProductResponse(String product, Double sales) {
        this.product = product;
        this.sales = sales;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }
}