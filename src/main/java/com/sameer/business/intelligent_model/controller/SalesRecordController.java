package com.sameer.business.intelligent_model.controller;

import com.sameer.business.intelligent_model.entity.SalesRecord;
import com.sameer.business.intelligent_model.service.SalesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesRecordController {

    @Autowired
    private SalesRecordService service;

    @PostMapping
    public SalesRecord addRecord(@RequestBody SalesRecord record) {
        return service.saveRecord(record);
    }

    @GetMapping
    public List<SalesRecord> getAllRecords() {
        return service.getAllRecords();
    }
}
