package org.opencsv.csvperformance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CsvPerformanceController {

    @GetMapping("/start")
    public String greetingForm(Model model) {
        model.addAttribute("startValues", new StartValues());
        return "start";
    }

    @PostMapping("/start")
    public String greetingSubmit(@ModelAttribute StartValues startValues) {
        return "results";
    }

}
