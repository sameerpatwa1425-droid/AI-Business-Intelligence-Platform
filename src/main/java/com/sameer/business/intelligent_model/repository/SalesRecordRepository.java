package com.sameer.business.intelligent_model.repository;

import java.util.List;
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

        @Query(value = """
                        SELECT category, SUM(sales)
                        FROM sales_records
                        GROUP BY category
                        """, nativeQuery = true)
        List<Object[]> getRevenueByCategory();

        @Query(value = """
                        SELECT product, SUM(sales)
                        FROM sales_records
                        GROUP BY product
                        ORDER BY SUM(sales) DESC
                        """, nativeQuery = true)
        List<Object[]> getTopProducts();

        @Query(value = """
                        SELECT SUBSTRING(date, 1, 7) AS month,
                               SUM(sales) AS revenue
                        FROM sales_records
                        GROUP BY SUBSTRING(date, 1, 7)
                        ORDER BY month
                        """, nativeQuery = true)
        List<Object[]> getMonthlySales();
}