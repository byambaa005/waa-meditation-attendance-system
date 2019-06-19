package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/faculty")
public class FacultyController {

    @GetMapping("/entry")
    public String entryReport() {
        return "faculty-entry";
    }

    @GetMapping("/block")
    public String blockReport() {
        return "faculty-block";
    }
}
