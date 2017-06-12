package com.nmuzychuk.directory.util;

import org.junit.Test;

import java.sql.Connection;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class DBConnectionTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection connection = DBConnection.getConnection();
        assertThat(connection, instanceOf(org.h2.jdbc.JdbcConnection.class));
    }
}
