package org.opencsv.csvperformance;

import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.opencsv.csvperformance.builder.BeanToCSVBuilderFactory;
import org.opencsv.csvperformance.builder.WriterBuilder;
import org.opencsv.csvperformance.domain.PopulatedData;
import org.opencsv.csvperformance.util.FakeResultSet;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ResultSetPerformanceTester {
    public void runPerformanceTest(WriteValues writeValues) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException, SQLException {
        WriterBuilder writerBuilder = new WriterBuilder();
        ICSVWriter writer = writerBuilder.build(writeValues);
        FakeResultSet fakeResultSet = new FakeResultSet((int)writeValues.getNumRecords());

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        writer.writeAll(fakeResultSet, true);

        writer.close();

        stopWatch.stop();

        writeValues.setTimeToRun(stopWatch.getTotalTimeSeconds());
    }

    private StatefulBeanToCsv createBeanToCSV(WriteValues writeValues, ICSVWriter csvWriter) {
        BeanToCSVBuilderFactory beanToCSVBuilderFactory = new BeanToCSVBuilderFactory();

        return beanToCSVBuilderFactory.getBuilder(writeValues, csvWriter).build();
    }
}
