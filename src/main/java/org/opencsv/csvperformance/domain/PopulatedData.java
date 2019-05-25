package org.opencsv.csvperformance.domain;

import org.opencsv.csvperformance.Constants;
import org.opencsv.csvperformance.ReadValues;
import org.opencsv.csvperformance.WriteValues;
import org.opencsv.csvperformance.util.RandomDataSetter;

import java.util.ArrayList;
import java.util.List;

public class PopulatedData {
    public static final int LIST_SIZE = 100;
    public static final List<Simple10> SIMPLE10LIST = new ArrayList<>(LIST_SIZE);
    public static final List<Simple50> SIMPLE50LIST = new ArrayList<>(LIST_SIZE);
    public static final List<Annotated10> ANNOTATED10LIST = new ArrayList<>(LIST_SIZE);
    public static final List<Annotated50> ANNOTATED50LIST = new ArrayList<>(LIST_SIZE);

    static {
        for (int i = 0; i < LIST_SIZE; i++) {
            Simple10 simple10 = new Simple10();
            Simple50 simple50 = new Simple50();
            Annotated10 annotated10 = new Annotated10();
            Annotated50 annotated50 = new Annotated50();

            RandomDataSetter.setRandomValues(simple10);
            RandomDataSetter.setRandomValues(simple50);
            RandomDataSetter.setRandomValues(annotated10);
            RandomDataSetter.setRandomValues(annotated50);

            SIMPLE10LIST.add(simple10);
            SIMPLE50LIST.add(simple50);
            ANNOTATED10LIST.add(annotated10);
            ANNOTATED50LIST.add(annotated50);
        }
    }

    public static List getList(WriteValues writeValues) {
        switch (writeValues.getWriteFrom()) {
            case Constants.SIMPLE10KEY:
                return SIMPLE10LIST;
            case Constants.SIMPLE50KEY:
                return SIMPLE50LIST;
            case Constants.ANNOTATED10KEY:
                return ANNOTATED10LIST;
            default:
                return ANNOTATED50LIST;
        }
    }

    public static Class getClassForType(ReadValues readValues) {
        switch (readValues.getReadInto()) {
            case Constants.SIMPLE10KEY:
                return Simple10.class;
            case Constants.SIMPLE50KEY:
                return Simple50.class;
            case Constants.ANNOTATED10KEY:
                return Annotated10.class;
            default:
                return Annotated50.class;
        }
    }
}
