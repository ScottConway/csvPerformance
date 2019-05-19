package org.opencsv.csvperformance.util;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import org.joda.time.DateTime;

public class JodaDateTimeConverter<T, I> extends AbstractBeanField<T, I> {

    public JodaDateTimeConverter() {

    }

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return DateTime.parse(value);
    }
}
