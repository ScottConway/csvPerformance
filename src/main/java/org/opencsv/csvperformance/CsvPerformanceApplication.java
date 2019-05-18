package org.opencsv.csvperformance;

import org.joda.time.DateTime;
import org.opencsv.csvperformance.util.DateTimeEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.beans.PropertyEditorManager;

@SpringBootApplication
public class CsvPerformanceApplication {

    public static void main(String[] args) throws Exception {
        PropertyEditorManager.registerEditor(DateTime.class, DateTimeEditor.class);
        SpringApplication.run(CsvPerformanceApplication.class, args);
    }

}
