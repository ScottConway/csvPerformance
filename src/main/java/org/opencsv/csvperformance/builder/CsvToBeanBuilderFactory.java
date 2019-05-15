package org.opencsv.csvperformance.builder;

import org.opencsv.csvperformance.Constants;
import org.opencsv.csvperformance.ReadValues;
import org.opencsv.csvperformance.domain.Simple10;
import org.opencsv.csvperformance.domain.Simple50;

public class CsvToBeanBuilderFactory {
    private static final CSVToBeanBuilder<Simple10> simple10CsvToBeanBuilder = new CSVToBeanBuilder<>();
    private static final CSVToBeanBuilder<Simple50> simple50CsvToBeanBuilder = new CSVToBeanBuilder<>();

    public CSVToBeanBuilder getBuilder(ReadValues readValues) {
        // TODO make this a switch statement when there is more than two types.
        return Constants.SIMPLE10KEY.equals(readValues.getReadInto()) ? simple10CsvToBeanBuilder : simple50CsvToBeanBuilder;
    }
}
