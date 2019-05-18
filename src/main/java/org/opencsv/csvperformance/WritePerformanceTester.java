package org.opencsv.csvperformance;

import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.opencsv.csvperformance.builder.BeanToCSVBuilderFactory;
import org.opencsv.csvperformance.builder.WriterBuilder;
import org.opencsv.csvperformance.domain.PopulatedData;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.List;

public class WritePerformanceTester {
    public void runPerformanceTest(WriteValues writeValues) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
        WriterBuilder writerBuilder = new WriterBuilder();
        ICSVWriter writer = writerBuilder.build(writeValues);
        StatefulBeanToCsv beanToCsv = createBeanToCSV(writeValues, writer);
        if (beanToCsv == null) return;

        List beanList = PopulatedData.getList(writeValues);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        for (long i = 0; i < writeValues.getNumRecords(); i++) {
            beanToCsv.write(beanList.get((int) (i % PopulatedData.LIST_SIZE)));
        }

        writer.close();

        stopWatch.stop();

        writeValues.setTimeToRun(stopWatch.getTotalTimeSeconds());
    }

    private StatefulBeanToCsv createBeanToCSV(WriteValues writeValues, ICSVWriter csvWriter) {
        BeanToCSVBuilderFactory beanToCSVBuilderFactory = new BeanToCSVBuilderFactory();

        return beanToCSVBuilderFactory.getBuilder(writeValues, csvWriter).build();
    }
}
