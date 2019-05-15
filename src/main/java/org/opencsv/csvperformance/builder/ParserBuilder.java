package org.opencsv.csvperformance.builder;

import com.opencsv.CSVParserBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.RFC4180ParserBuilder;
import org.opencsv.csvperformance.Constants;

import java.util.Objects;

public class ParserBuilder {
    private static final CSVParserBuilder csvParserBuilder = new CSVParserBuilder();
    private static final RFC4180ParserBuilder rfc4180ParserBuilder = new RFC4180ParserBuilder();

    public static ICSVParser build(String parserType) {

        switch (Objects.requireNonNullElse(parserType, "")) {
            case Constants.CSVPARSER:
                return csvParserBuilder.build();
            case Constants.RFC4180PARSER:
                return rfc4180ParserBuilder.build();
            default:
                return null;
        }
    }
}
