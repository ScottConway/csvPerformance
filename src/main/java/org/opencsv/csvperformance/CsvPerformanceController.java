package org.opencsv.csvperformance;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.opencsv.csvperformance.domain.DataType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class CsvPerformanceController {

    @GetMapping("/readTest")
    public String setupReadTestForm(Model model) {
        ReadValues readValues = new ReadValues();
        readValues.setIterations(1);
        readValues.setParserToUse(Constants.CSVPARSER);
        model.addAttribute("readValues", readValues);
        model.addAttribute("dataValues", DataType.buildIdNameMap());
        return "readTest";
    }

    @PostMapping("/readTest")
    public String readTestSubmit(@ModelAttribute ReadValues readValues) {
        ReadPerformanceTester tester = new ReadPerformanceTester();

        tester.runPerformanceTest(readValues);

        return "readResults";
    }

    @GetMapping("/writeTest")
    public String setupWriteTestForm(Model model) {
        WriteValues writeValues = new WriteValues();
        writeValues.setNumRecords(50000);
        writeValues.setParserToUse(Constants.CSVPARSER);
        model.addAttribute("writeValues", writeValues);
        model.addAttribute("dataValues", DataType.buildIdNameMap());
        return "writeTest";
    }

    @PostMapping("/writeTest")
    public String writeTestSubmit(@ModelAttribute WriteValues writeValues) {
        WritePerformanceTester tester = new WritePerformanceTester();

        try {
            tester.runPerformanceTest(writeValues);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
            e.printStackTrace();
        }

        return "writeResults";
    }

    @GetMapping("/resultSetTest")
    public String setupResultSetTestForm(Model model) {
        WriteValues writeValues = new WriteValues();
        writeValues.setNumRecords(50000);
        writeValues.setParserToUse(Constants.CSVPARSER);
        model.addAttribute("writeValues", writeValues);
        model.addAttribute("dataValues", DataType.buildIdNameMap());
        return "resultSetTest";
    }

    @PostMapping("/resultSetTest")
    public String resultSetTestSubmit(@ModelAttribute WriteValues writeValues) {
        ResultSetPerformanceTester tester = new ResultSetPerformanceTester();

        try {
            tester.runPerformanceTest(writeValues);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException | SQLException e) {
            e.printStackTrace();
        }

        return "resultSetResults";
    }
}
