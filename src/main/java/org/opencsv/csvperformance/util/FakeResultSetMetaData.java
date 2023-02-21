package org.opencsv.csvperformance.util;

import org.opencsv.csvperformance.Constants;
import org.opencsv.csvperformance.WriteValues;
import org.opencsv.csvperformance.domain.PopulatedData;
import org.opencsv.csvperformance.domain.Simple50;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class FakeResultSetMetaData implements ResultSetMetaData {

    Logger logger = LoggerFactory.getLogger(FakeResultSetMetaData.class);

    static final String[] FIELD_NAMES = {"aString1", "aString10", "aString2", "aString3", "aString4", "aString5", "aString6", "aString7", "aString8", "aString9", "double1", "double10", "double2", "double3", "double4", "double5", "double6", "double7", "double8", "double9", "long1", "long10", "long2", "long3", "long4", "long5", "long6", "long7", "long8", "long9", "num1", "num10", "num2", "num3", "num4", "num5", "num6", "num7", "num8", "num9", "text1", "text10", "text2", "text3", "text4", "text5", "text6", "text7", "text8", "text9"};

    static final String[] COLUMNS = {"ASTRING1", "ASTRING10", "ASTRING2", "ASTRING3", "ASTRING4", "ASTRING5", "ASTRING6", "ASTRING7", "ASTRING8", "ASTRING9", "DOUBLE1", "DOUBLE10", "DOUBLE2", "DOUBLE3", "DOUBLE4", "DOUBLE5", "DOUBLE6", "DOUBLE7", "DOUBLE8", "DOUBLE9", "LONG1", "LONG10", "LONG2", "LONG3", "LONG4", "LONG5", "LONG6", "LONG7", "LONG8", "LONG9", "NUM1", "NUM10", "NUM2", "NUM3", "NUM4", "NUM5", "NUM6", "NUM7", "NUM8", "NUM9", "TEXT1", "TEXT10", "TEXT2", "TEXT3", "TEXT4", "TEXT5", "TEXT6", "TEXT7", "TEXT8", "TEXT9"};
    static final int[] COLUMN_TYPES = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
    static final int NUMBER_OF_COLUMNS = COLUMN_TYPES.length;
    static final int MAX_OBJECTS = 100;
    static List<Simple50> objectList = new ArrayList<>(MAX_OBJECTS);

    int lineNumber;

    public FakeResultSetMetaData() {
        lineNumber = 0;
        if (objectList.size() == 0) {
            createObjectList();
        }
    }

    private void createObjectList() {
        WriteValues writeValues = new WriteValues();
        writeValues.setNumRecords(MAX_OBJECTS);
        writeValues.setWriteFrom(Constants.SIMPLE50KEY);

        List values = PopulatedData.getList(writeValues);
        int valuesSize = values.size();

        for (int i = 0; i < MAX_OBJECTS; i++) {
            objectList.add((Simple50) values.get(i % valuesSize));
        }
    }

    @Override
    public int getColumnCount() throws SQLException {
        return COLUMNS.length;
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        return false;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        return 0;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        return false;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        return COLUMNS[column - 1];
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        return null;
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        return 0;
    }

    @Override
    public int getScale(int column) throws SQLException {
        return 0;
    }

    @Override
    public String getTableName(int column) throws SQLException {
        return null;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        return COLUMN_TYPES[column - 1];
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        return null;
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return false;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    private Simple50 getObjectAtRow(int rowPosition) {
        return objectList.get(rowPosition % MAX_OBJECTS);
    }
    public String getStringAtRowColumn(int rowPosition, int columnIndex) {
        Simple50 simple50 = getObjectAtRow(rowPosition);

        Field field = null;
        try {
            field = simple50.getClass().getDeclaredField(FIELD_NAMES[columnIndex-1]);
        } catch (NoSuchFieldException e) {
            return null;
        }
        field.setAccessible(true);
        try {
            Object value = field.get(simple50);
            return value.toString();
        } catch (IllegalAccessException e) {
            return null;
        }

    }

    public double getDoubleAtRowColumn(int rowPosition, int columnIndex) {
        Simple50 simple50 = getObjectAtRow(rowPosition);

        Field field = null;
        try {
            field = simple50.getClass().getDeclaredField(FIELD_NAMES[columnIndex-1]);
        } catch (NoSuchFieldException e) {
            return -1;
        }
        field.setAccessible(true);
        Object value = null;
        try {
            value = field.get(simple50);
            Double dv;
            if (!(value instanceof Double)) {
                dv = Double.valueOf(value.toString());
            } else {
                dv = (Double) value;
            }
            return dv.doubleValue();
        } catch (IllegalAccessException e) {
            return -1;
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(String.format("For input String: %s rowPosition: %d columnPostion: %d", value, rowPosition, columnIndex));
        }
    }

    public BigDecimal getBigDecimalAtRowColumn(int rowPosition, int columnIndex) {
        Simple50 simple50 = getObjectAtRow(rowPosition);

        Field field = null;
        try {
            field = simple50.getClass().getDeclaredField(FIELD_NAMES[columnIndex-1]);
        } catch (NoSuchFieldException e) {
            return null;
        }
        field.setAccessible(true);
        try {
            Object value = field.get(simple50);
            return new BigDecimal(value.toString());
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public int getIntAtRowColumn(int rowPosition, int columnIndex) {
        Simple50 simple50 = getObjectAtRow(rowPosition);

        Field field = null;
        try {
            field = simple50.getClass().getDeclaredField(FIELD_NAMES[columnIndex-1]);
        } catch (NoSuchFieldException e) {
            return -1;
        }
        field.setAccessible(true);
        try {
            Object value = field.get(simple50);
            if (!(value instanceof Double)) {
                return -2;
            }
            Integer iv = (Integer) value;
            return iv.intValue();
        } catch (IllegalAccessException e) {
            return -1;
        }
    }
}
