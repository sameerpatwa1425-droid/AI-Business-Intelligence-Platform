package com.sameer.business.intelligent_model.service;

import com.sameer.business.intelligent_model.entity.SalesRecord;
import com.sameer.business.intelligent_model.repository.SalesRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRecordService {

    @Autowired
    private SalesRecordRepository repository;

    public SalesRecord saveRecord(SalesRecord record) {
        return repository.save(record);
    }

    public List<SalesRecord> getAllRecords() {
        return repository.findAll();
    }

}