package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/attendance")
public class FacultyController {

    @GetMapping("/entryreport")
    public String entryReport() {
        return "faculty-entry";
    }

    @GetMapping("/blockreport")
    public String blockReport() {
        return "faculty-block";
    }
}
