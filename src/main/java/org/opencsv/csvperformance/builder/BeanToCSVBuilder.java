package org.opencsv.csvperformance.builder;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.opencsv.csvperformance.WriteValues;

import java.io.FileWriter;
import java.io.IOException;

public class BeanToCSVBuilder<T> {
    public StatefulBeanToCsv<T> build(WriteValues writeValues) {
        ICSVParser parser = ParserBuilder.build(writeValues.getParserToUse());

        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(writeValues.getFile());
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
            return null;
        }
        ICSVWriter csvWriter = new CSVWriterBuilder(fileWriter)
                .withParser(parser)
                .build();
        StatefulBeanToCsvBuilder<T> builder = new StatefulBeanToCsvBuilder<>(csvWriter);
        return builder.build();
    }
}
