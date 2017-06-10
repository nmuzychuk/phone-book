package com.nmuzychuk.directory.service;

import com.nmuzychuk.directory.model.Record;

import java.util.List;

public interface RecordService {
    List<Record> getAllRecords();

    Record getRecord(int id) throws Exception;

    void addRecord(Record record);

    void updateRecord(Record record) throws Exception;

    void deleteRecord(int id) throws Exception;
}
