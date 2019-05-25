package org.opencsv.csvperformance.builder;

import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.opencsv.csvperformance.Constants;
import org.opencsv.csvperformance.WriteValues;
import org.opencsv.csvperformance.domain.Annotated10;
import org.opencsv.csvperformance.domain.Annotated50;
import org.opencsv.csvperformance.domain.Simple10;
import org.opencsv.csvperformance.domain.Simple50;

public class BeanToCSVBuilderFactory {

    public StatefulBeanToCsvBuilder getBuilder(WriteValues writeValues, ICSVWriter csvWriter) {

        switch (writeValues.getWriteFrom()) {
            case Constants.SIMPLE10KEY:
                return new StatefulBeanToCsvBuilder<Simple10>(csvWriter);
            case Constants.SIMPLE50KEY:
                return new StatefulBeanToCsvBuilder<Simple50>(csvWriter);
            case Constants.ANNOTATED10KEY:
                return new StatefulBeanToCsvBuilder<Annotated10>(csvWriter);
            default:
                return new StatefulBeanToCsvBuilder<Annotated50>(csvWriter);
        }
    }
}
