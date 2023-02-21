package org.opencsv.csvperformance.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import static org.junit.jupiter.api.Assertions.*;

public class FakeResultSetTest {
    FakeResultSet fakeResultSet;

    private static final int TEST_SIZE = 200;

    @Test
    @DisplayName("Construct and return a given number of objects")
    public void createResultSet() throws SQLException {
        fakeResultSet = new FakeResultSet(TEST_SIZE);
        ResultSetMetaData metaData = fakeResultSet.getMetaData();
        assertNotNull(metaData);
        for (int i = 0; i < TEST_SIZE; i++) {
            assertTrue(fakeResultSet.next(),
                    String.format("Expected %s call to next to return true but returned false.", Integer.toString(i)));
        }
        assertFalse(fakeResultSet.next(), "Expected last call to next to return false but returned true.");
    }

    @Test
    @DisplayName("Check the actual values")
    public void createResultSetValues() throws SQLException {
        fakeResultSet = new FakeResultSet(TEST_SIZE);
        ResultSetMetaData md = fakeResultSet.getMetaData();
        for (int i = 1; i <= TEST_SIZE; i++) {
            fakeResultSet.next();
            for (int j = 1; j <= FakeResultSetMetaData.NUMBER_OF_COLUMNS; j++) {
                switch (md.getColumnType(j)) {
                    case Types.VARCHAR:
                        String columnValue = fakeResultSet.getString(j);
                        assertNotNull(columnValue);
                        break;
                    case Types.BIGINT:
                        BigDecimal bd = fakeResultSet.getBigDecimal(j);
                        assertNotNull(bd);
                        break;
                    case Types.DOUBLE:
                        double d = fakeResultSet.getDouble(j);
                        assertNotEquals(0.0, d);
                        break;
                    case Types.INTEGER:
                        int integerValue = fakeResultSet.getInt(j);
                        assertNotEquals(0, integerValue);
                        break;
                    default:
                        fail(String.format("Unexpected type from ResultSet: %s", Integer.toString(md.getColumnType(i))));
                }
            }
        }
        assertFalse(fakeResultSet.next(), "Expected last call to next to return false but returned true.");
    }

}
