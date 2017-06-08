package com.nmuzychuk.directory.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordTest {
    @Test
    public void testRecord() {
        final String expected = "{id: 1, firstName: John, lastName: Smith, phoneNumber: +1-234-567-8901}";

        Record record = new Record();

        record.setId(1);
        record.setFirstName("John");
        record.setLastName("Smith");
        record.setPhoneNumber("+1-234-567-8901");

        assertEquals(expected, record.toString());
    }
}
