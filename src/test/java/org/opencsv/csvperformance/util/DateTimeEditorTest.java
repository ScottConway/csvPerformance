package org.opencsv.csvperformance.util;

import org.joda.time.DateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeEditorTest {
    private static final DateTime NOW = DateTime.now();
    private static final String NOW_STRING = NOW.toString();

    @Test
    @DisplayName("Convert String back to proper DateTime")
    public void convertStringToDateTime() {
        DateTimeEditor editor = new DateTimeEditor();
        editor.setAsText(NOW_STRING);
        assertEquals(0, NOW.compareTo((DateTime) editor.getValue()));
    }
}
