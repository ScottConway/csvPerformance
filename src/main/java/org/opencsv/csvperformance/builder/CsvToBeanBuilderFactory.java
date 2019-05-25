package org.opencsv.csvperformance.builder;

import org.opencsv.csvperformance.Constants;
import org.opencsv.csvperformance.ReadValues;
import org.opencsv.csvperformance.domain.Annotated10;
import org.opencsv.csvperformance.domain.Annotated50;
import org.opencsv.csvperformance.domain.Simple10;
import org.opencsv.csvperformance.domain.Simple50;

public class CsvToBeanBuilderFactory {
    private static final CSVToBeanBuilder<Simple10> simple10CsvToBeanBuilder = new CSVToBeanBuilder<>();
    private static final CSVToBeanBuilder<Simple50> simple50CsvToBeanBuilder = new CSVToBeanBuilder<>();
    private static final CSVToBeanBuilder<Annotated10> annotated10CsvToBeanBuilder = new CSVToBeanBuilder<>();
    private static final CSVToBeanBuilder<Annotated50> annotated50CsvToBeanBuilder = new CSVToBeanBuilder<>();

    public CSVToBeanBuilder getBuilder(ReadValues readValues) {
        switch (readValues.getReadInto()) {
            case Constants.SIMPLE10KEY:
                return simple10CsvToBeanBuilder;
            case Constants.SIMPLE50KEY:
                return simple50CsvToBeanBuilder;
            case Constants.ANNOTATED10KEY:
                return annotated10CsvToBeanBuilder;
            default:
                return annotated50CsvToBeanBuilder;
        }
    }
}
