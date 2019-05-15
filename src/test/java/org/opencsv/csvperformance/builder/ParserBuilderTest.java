package org.opencsv.csvperformance.builder;

import com.opencsv.CSVParser;
import com.opencsv.RFC4180Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opencsv.csvperformance.Constants;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserBuilderTest {

    @Test
    @DisplayName("Can build CSVParser")
    public void buildCSVParser() {
        assertTrue(ParserBuilder.build(Constants.CSVPARSER) instanceof CSVParser);
    }

    @Test
    @DisplayName("Can build RFC4180Parser")
    public void buildRFC4180Parser() {
        assertTrue(ParserBuilder.build(Constants.RFC4180PARSER) instanceof RFC4180Parser);
    }

    @Test
    @DisplayName("Bad String returns null")
    public void nullOnBadString() {
        assertNull(ParserBuilder.build(Constants.RFC4180PARSER + "abc"));
    }

    @Test
    @DisplayName("Null String returns null")
    public void nullOnNull() {
        assertNull(ParserBuilder.build(null));
    }
}
