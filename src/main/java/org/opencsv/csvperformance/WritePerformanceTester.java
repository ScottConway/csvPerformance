package org.opencsv.csvperformance;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.opencsv.csvperformance.builder.BeanToCSVBuilder;
import org.opencsv.csvperformance.builder.BeanToCSVBuilderFactory;
import org.opencsv.csvperformance.domain.PopulatedData;
import org.springframework.util.StopWatch;

import java.util.List;

public class WritePerformanceTester {
    public void runPerformanceTest(WriteValues writeValues) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        StatefulBeanToCsv beanToCsv = createBeanToCSV(writeValues);
        if (beanToCsv == null) return;

        List beanList = PopulatedData.getList(writeValues);

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        for (long i = 0; i < writeValues.getNumRecords(); i++) {
            beanToCsv.write(beanList.get((int) (i % PopulatedData.LIST_SIZE)));
        }

        stopWatch.stop();

        writeValues.setTimeToRun(stopWatch.getTotalTimeSeconds());
    }

    private StatefulBeanToCsv createBeanToCSV(WriteValues writeValues) {
        BeanToCSVBuilderFactory beanToCSVBuilderFactory = new BeanToCSVBuilderFactory();
        BeanToCSVBuilder builder = beanToCSVBuilderFactory.getBuilder(writeValues);
        return builder.build(writeValues);
    }
}
