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

    static {
        for (int i = 0; i < LIST_SIZE; i++) {
            Simple10 simple10 = new Simple10();
            Simple50 simple50 = new Simple50();

            RandomDataSetter.setRandomValues(simple10);
            RandomDataSetter.setRandomValues(simple50);
            SIMPLE10LIST.add(simple10);
            SIMPLE50LIST.add(simple50);
        }
    }

    public static List getList(WriteValues writeValues) {
        // TODO make switch/case once more than two types.
        return Constants.SIMPLE10KEY.equals(writeValues.getWriteFrom()) ? SIMPLE10LIST : SIMPLE50LIST;
    }

    public static Class getClassForType(ReadValues readValues) {
        // TODO make switch/case once more than two types.
        return Constants.SIMPLE10KEY.equals(readValues.getReadInto()) ? Simple10.class : Simple50.class;
    }
}
