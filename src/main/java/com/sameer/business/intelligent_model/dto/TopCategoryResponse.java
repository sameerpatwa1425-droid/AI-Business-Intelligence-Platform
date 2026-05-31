package com.sameer.business.intelligent_model.dto;

public class TopCategoryResponse {

    private String category;

    public TopCategoryResponse(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}