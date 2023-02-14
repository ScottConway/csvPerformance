package org.opencsv.csvperformance.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FakeResultSetMetaDataTest {
    private static final int TEST_SIZE = 100;
    @Test
    @DisplayName("Size of column names and column types match.")
    public void compareColumnArraySizes() {
        assertEquals(50, FakeResultSetMetaData.COLUMNS.length);
        assertEquals(FakeResultSetMetaData.COLUMNS.length, FakeResultSetMetaData.COLUMN_TYPES.length);
    }

    @Test
    @DisplayName("Construct an actual metadata.")
    public void constructMetaData() {
        FakeResultSetMetaData md = new FakeResultSetMetaData();
        assertNotNull(md);
    }

    @Test
    @DisplayName("Check column types.")
    public void checkColumnType() throws SQLException {
        FakeResultSetMetaData md = new FakeResultSetMetaData();
        for (int i = 1; i <= FakeResultSetMetaData.NUMBER_OF_COLUMNS; i++) {
            assertEquals(FakeResultSetMetaData.COLUMN_TYPES[i-1], md.getColumnType(i),
                    String.format("For column %s expected type %s but got %s",
                            Integer.toString(i), Integer.toString(FakeResultSetMetaData.COLUMN_TYPES[i-1]),
                            Integer.toString(md.getColumnType(i))));
        }
    }

}
