package com.sameer.business.intelligent_model.controller;

import com.sameer.business.intelligent_model.entity.SalesRecord;
import com.sameer.business.intelligent_model.service.SalesRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
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