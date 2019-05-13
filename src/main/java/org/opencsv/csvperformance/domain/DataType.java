package org.opencsv.csvperformance.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum DataType {
    SIMPLE10("S10", "Simple 10 Columns"),
    SIMPLE50("S50", "Simple 50 Columns");

    private String shortId;
    private String name;

    private static Map<String, String> idMap = new HashMap<String, String>();

    DataType(String shortId, String name) {
        this.shortId = shortId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getShortId() {
        return shortId;
    }

    public static DataType getDataTypeFromId(String id) {
        if (id == null) return null;
        for (DataType dataType : DataType.values()) {
            if (dataType.shortId.toUpperCase().equals(id.toUpperCase())) {
                return dataType;
            }
        }
        return null;
    }

    public static Map<String, String> buildIdNameMap() {
        if (idMap.isEmpty()) {
            for (DataType dataType : DataType.values()) {
                idMap.put(dataType.shortId, dataType.getName());
            }
        }
        return Collections.unmodifiableMap(idMap);
    }
}
