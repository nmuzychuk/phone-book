package com.nmuzychuk.directory.service;

import com.nmuzychuk.directory.model.Record;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordServiceStubImplTest {
    @Test
    public void testRecordServiceStub() throws Exception {
        RecordServiceStubImpl recordServiceStub = new RecordServiceStubImpl();

        assertEquals("[]", recordServiceStub.toString());

        Record record1 = new Record(1, "First", "Last", "101");
        recordServiceStub.addRecord(record1);

        assertEquals("[1]", recordServiceStub.toString());

        Record record2 = new Record(2, "John", "Smith", "102");
        recordServiceStub.addRecord(record2);

        assertEquals("[1, 2]", recordServiceStub.toString());

        Record updatedRecord2 = new Record(2, "John", "Smith", "202");

        recordServiceStub.updateRecord(updatedRecord2);
        Record record = recordServiceStub.getRecord(2);

        assertEquals("202", record.getPhoneNumber());

        recordServiceStub.deleteRecord(1);
        recordServiceStub.deleteRecord(2);

        assertEquals("[]", recordServiceStub.toString());
    }
}
