package org.opencsv.csvperformance.util;

import org.joda.time.DateTime;

import java.beans.PropertyEditorSupport;

public class DateTimeEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String valueString) {
        this.setValue(valueString == null ? null : DateTime.parse(valueString));
    }
}
