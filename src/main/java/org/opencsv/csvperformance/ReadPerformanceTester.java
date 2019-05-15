package org.opencsv.csvperformance;

import com.opencsv.bean.CsvToBean;
import org.opencsv.csvperformance.builder.CSVToBeanBuilder;
import org.opencsv.csvperformance.builder.CsvToBeanBuilderFactory;
import org.springframework.util.StopWatch;

import java.util.Iterator;

public class ReadPerformanceTester {
    public void runPerformanceTest(ReadValues readValues) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        Object o;

        for (long i = 0; i < readValues.getIterations(); i++) {
            CsvToBean csvToBean = createCsvToBean(readValues);
            if (csvToBean == null) return;
            Iterator iterator = csvToBean.iterator();
            while (iterator.hasNext()) {
                o = iterator.next();
            }
        }

        stopWatch.stop();

        readValues.setTimeToRun(stopWatch.getTotalTimeSeconds());
    }

    private CsvToBean createCsvToBean(ReadValues readValues) {
        CsvToBeanBuilderFactory factory = new CsvToBeanBuilderFactory();
        CSVToBeanBuilder builder = factory.getBuilder(readValues);
        return builder.build(readValues);
    }
}
