package com.nmuzychuk.directory.service;

import com.nmuzychuk.directory.model.Record;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordServiceImplTest {
    @Test
    public void testRecordService() {
        RecordService recordService = new RecordServiceImpl();

        assertEquals(0, recordService.getAllRecords().size());

        Record record1 = new Record(1, "First", "Last", "101");
        recordService.addRecord(record1);

        assertEquals(1, recordService.getAllRecords().size());

        Record record2 = new Record(2, "John", "Smith", "102");
        recordService.addRecord(record2);

        assertEquals(2, recordService.getAllRecords().size());

        Record updatedRecord2 = new Record(2, "John", "Smith", "202");

        recordService.updateRecord(updatedRecord2);
        Record record = recordService.getRecord(2);

        assertEquals("202", record.getPhoneNumber());

        recordService.deleteRecord(1);

        assertEquals(1, recordService.getAllRecords().size());

        recordService.deleteRecord(2);

        assertEquals(0, recordService.getAllRecords().size());
    }
}
