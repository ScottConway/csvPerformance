package org.opencsv.csvperformance;

import org.opencsv.csvperformance.domain.DataType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CsvPerformanceController {

    @GetMapping("/readTest")
    public String setupReadTestForm(Model model) {
        ReadValues readValues = new ReadValues();
        readValues.setIterations(5);
        readValues.setParserToUse(Constants.CSVPARSER);
        model.addAttribute("readValues", readValues);
        model.addAttribute("dataValues", DataType.buildIdNameMap());
        return "readTest";
    }

    @PostMapping("/readTest")
    public String readTestSubmit(@ModelAttribute ReadValues readValues) {
        return "readResults";
    }

    @GetMapping("/writeTest")
    public String setupWriteTestForm(Model model) {
        WriteValues writeValues = new WriteValues();
        writeValues.setNumRecords(15000);
        writeValues.setParserToUse(Constants.CSVPARSER);
        model.addAttribute("writeValues", writeValues);
        model.addAttribute("dataValues", DataType.buildIdNameMap());
        return "writeTest";
    }

    @PostMapping("/writeTest")
    public String writeTestSubmit(@ModelAttribute WriteValues writeValues) {
        return "writeResults";
    }

}
