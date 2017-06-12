package com.nmuzychuk.directory.service;

import com.nmuzychuk.directory.model.Record;

import java.util.List;

public interface RecordService {
    List<Record> getAllRecords();

    Record getRecord(int id);

    void addRecord(Record record);

    void updateRecord(Record record);

    void deleteRecord(int id);
}
