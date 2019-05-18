package org.opencsv.csvperformance.builder;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.ICSVWriter;
import org.opencsv.csvperformance.WriteValues;

import java.io.FileWriter;
import java.io.IOException;

public class WriterBuilder {
    public ICSVWriter build(WriteValues writeValues) {
        ICSVParser parser = ParserBuilder.build(writeValues.getParserToUse());

        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(writeValues.getFile().getName());
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
            return null;
        }
        ICSVWriter csvWriter = new CSVWriterBuilder(fileWriter)
                .withParser(parser)
                .build();
        return csvWriter;
    }
}
