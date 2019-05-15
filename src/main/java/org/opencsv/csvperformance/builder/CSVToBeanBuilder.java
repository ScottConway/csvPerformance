package org.opencsv.csvperformance.builder;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;
import com.opencsv.bean.CsvToBean;
import org.opencsv.csvperformance.ReadValues;
import org.opencsv.csvperformance.domain.PopulatedData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CSVToBeanBuilder<T> {
    public CsvToBean<T> build(ReadValues readValues) {
        ICSVParser parser = ParserBuilder.build(readValues.getParserToUse());
        FileReader fileReader;
        try {
            fileReader = new FileReader(readValues.getFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build();

        return new com.opencsv.bean.CsvToBeanBuilder<T>(csvReader).withType(PopulatedData.getClassForType(readValues)).build();
    }
}
