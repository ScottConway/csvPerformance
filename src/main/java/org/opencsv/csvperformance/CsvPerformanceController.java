package org.opencsv.csvperformance;

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
        model.addAttribute("readValues", readValues);
        return "readTest";
    }

    @PostMapping("/readTest")
    public String readTestSubmit(@ModelAttribute ReadValues readValues) {
        return "readResults";
    }

    @GetMapping("/writeTest")
    public String setupWriteTestForm(Model model) {
        WriteValues writeValues = new WriteValues();
        writeValues.setNumRecords(5000);
        model.addAttribute("writeValues", writeValues);
        return "writeTest";
    }

    @PostMapping("/writeTest")
    public String writeTestSubmit(@ModelAttribute WriteValues writeValues) {
        return "writeResults";
    }

}
