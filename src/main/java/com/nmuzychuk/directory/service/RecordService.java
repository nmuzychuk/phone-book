package com.nmuzychuk.directory.service;

import com.nmuzychuk.directory.model.Record;

import java.util.List;

public interface RecordService {
    public List<Record> getAllRecords();

    public Record getRecord(int id) throws Exception;

    public void addRecord(Record record);

    public void updateRecord(Record record) throws Exception;

    public void deleteRecord(int id) throws Exception;
}
