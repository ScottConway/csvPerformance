package org.opencsv.csvperformance.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeResultSetMetaDataTest {
    @Test
    @DisplayName("Size of column names and column types match.")
    public void compareColumnArraySizes() {
        assertEquals(50, FakeResultSetMetaData.COLUMNS.length);
        assertEquals(FakeResultSetMetaData.COLUMNS.length, FakeResultSetMetaData.COLUMN_TYPES.length);
    }
}
