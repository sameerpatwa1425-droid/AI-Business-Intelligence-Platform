package com.sameer.business.intelligent_model.repository;

import com.sameer.business.intelligent_model.entity.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, Long> {

    @Query("SELECT SUM(s.sales) FROM SalesRecord s")
    Double getTotalRevenue();

    @Query("SELECT SUM(s.profit) FROM SalesRecord s")
    Double getTotalProfit();

    @Query(value = """
            SELECT product
            FROM sales_records
            GROUP BY product
            ORDER BY SUM(sales) DESC
            LIMIT 1
            """, nativeQuery = true)
    String getTopProduct();

    @Query(value = """
            SELECT category
            FROM sales_records
            GROUP BY category
            ORDER BY SUM(sales) DESC
            LIMIT 1
            """, nativeQuery = true)
    String getTopCategory();
}