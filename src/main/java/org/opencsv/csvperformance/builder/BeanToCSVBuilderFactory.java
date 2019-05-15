package org.opencsv.csvperformance.builder;

import org.opencsv.csvperformance.Constants;
import org.opencsv.csvperformance.WriteValues;
import org.opencsv.csvperformance.domain.Simple10;
import org.opencsv.csvperformance.domain.Simple50;

public class BeanToCSVBuilderFactory {
    private static final BeanToCSVBuilder<Simple10> simple10BeanToCSVBuilder = new BeanToCSVBuilder<>();
    private static final BeanToCSVBuilder<Simple50> simple50BeanToCSVBuilder = new BeanToCSVBuilder<>();

    public BeanToCSVBuilder getBuilder(WriteValues writeValues) {
        // TODO change this to a switch case statement when more than two options.
        return writeValues.getWriteFrom().equals(Constants.SIMPLE10KEY) ? simple10BeanToCSVBuilder : simple50BeanToCSVBuilder;
    }
}
