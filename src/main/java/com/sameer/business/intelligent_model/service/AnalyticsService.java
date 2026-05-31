package com.sameer.business.intelligent_model.service;

import com.sameer.business.intelligent_model.repository.SalesRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sameer.business.intelligent_model.dto.CategoryRevenueResponse;
import com.sameer.business.intelligent_model.dto.ProductRevenueResponse;
import com.sameer.business.intelligent_model.dto.MonthlySalesResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private SalesRecordRepository repository;

    public Double getTotalRevenue() {
        return repository.getTotalRevenue();
    }

    public Double getTotalProfit() {
        return repository.getTotalProfit();
    }

    public String getTopProduct() {
        return repository.getTopProduct();
    }

    public String getTopCategory() {
        return repository.getTopCategory();
    }

    public Long getTotalRecords() {
        return repository.count();
    }

    public List<CategoryRevenueResponse> getRevenueByCategory() {

        List<Object[]> results = repository.getRevenueByCategory();

        List<CategoryRevenueResponse> response = new ArrayList<>();

        for (Object[] row : results) {

            String category = (String) row[0];
            Double revenue = ((Number) row[1]).doubleValue();

            response.add(new CategoryRevenueResponse(category, revenue));
        }

        return response;
    }

    public List<ProductRevenueResponse> getTopProducts() {

        List<Object[]> results = repository.getTopProducts();

        List<ProductRevenueResponse> response = new ArrayList<>();

        for (Object[] row : results) {

            String product = (String) row[0];
            Double revenue = ((Number) row[1]).doubleValue();

            response.add(new ProductRevenueResponse(product, revenue));
        }

        return response;
    }

    public List<MonthlySalesResponse> getMonthlySales() {

        List<Object[]> results = repository.getMonthlySales();

        List<MonthlySalesResponse> response = new ArrayList<>();

        for (Object[] row : results) {

            String month = (String) row[0];
            Double revenue = ((Number) row[1]).doubleValue();

            response.add(new MonthlySalesResponse(month, revenue));
        }

        return response;
    }
}
