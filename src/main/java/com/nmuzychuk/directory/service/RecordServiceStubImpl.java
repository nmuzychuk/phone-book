package com.nmuzychuk.directory.service;

import com.nmuzychuk.directory.model.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordServiceStubImpl implements RecordService {
    private static List<Record> recordList = new ArrayList<>();

    @Override
    public List<Record> getAllRecords() {
        return recordList;
    }

    @Override
    public Record getRecord(int id) throws Exception {
        for (Record record : recordList) {
            if (record.getId() == id) {
                return record;
            }
        }

        throw new Exception("Record " + id + " is not found");
    }

    @Override
    public void addRecord(Record record) {
        recordList.add(record);
    }

    @Override
    public void updateRecord(Record record) throws Exception {
        for (Record r : recordList) {
            if (r.getId() == record.getId()) {
                r.setFirstName(record.getFirstName());
                r.setLastName(record.getLastName());
                r.setPhoneNumber(record.getPhoneNumber());
                return;
            }
        }

        throw new Exception("Record " + record.getId() + " is not found");
    }

    @Override
    public void deleteRecord(int id) throws Exception {
        for (Record record : recordList) {
            if (record.getId() == id) {
                recordList.remove(record);
                return;
            }
        }

        throw new Exception("Record " + id + " is not found");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("[");

        for (int i = 0; i < recordList.size(); i++) {
            Record record = recordList.get(i);
            result.append(record.getId());

            if (i < recordList.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");

        return result.toString();
    }
}
