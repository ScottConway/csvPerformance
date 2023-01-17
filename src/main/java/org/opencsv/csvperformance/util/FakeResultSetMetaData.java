package org.opencsv.csvperformance.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.opencsv.csvperformance.Constants;
import org.opencsv.csvperformance.WriteValues;
import org.opencsv.csvperformance.domain.PopulatedData;
import org.opencsv.csvperformance.domain.Simple50;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class FakeResultSetMetaData implements ResultSetMetaData {
    static final String[] COLUMNS = {"ASTRING1", "ASTRING10", "ASTRING2", "ASTRING3", "ASTRING4", "ASTRING5", "ASTRING6", "ASTRING7", "ASTRING8", "ASTRING9", "DOUBLE1", "DOUBLE10", "DOUBLE2", "DOUBLE3", "DOUBLE4", "DOUBLE5", "DOUBLE6", "DOUBLE7", "DOUBLE8", "DOUBLE9", "LONG1", "LONG10", "LONG2", "LONG3", "LONG4", "LONG5", "LONG6", "LONG7", "LONG8", "LONG9", "NUM1", "NUM10", "NUM2", "NUM3", "NUM4", "NUM5", "NUM6", "NUM7", "NUM8", "NUM9", "TEXT1", "TEXT10", "TEXT2", "TEXT3", "TEXT4", "TEXT5", "TEXT6", "TEXT7", "TEXT8", "TEXT9"};
    static final int[] COLUMN_TYPES = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.DOUBLE, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.BIGINT, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};

    static final int MAX_OBJECTS = 100;
    static List<Simple50> objectList = new ArrayList<>(MAX_OBJECTS);

    int lineNumber;

    private int getArrayLocation() {
        return lineNumber % MAX_OBJECTS;
    }

    /**
     * Default constructor
     */
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

    public String getColumnValueAsString(int columnIndex) {
        try {
            return PropertyUtils.getSimpleProperty(objectList.get(getArrayLocation()), COLUMNS[columnIndex]).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
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
        return 0;
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
}
