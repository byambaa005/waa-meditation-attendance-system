package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacultyController {

    @GetMapping("/faculty/entry")
    public String entryReport() {
        return "faculty-entry";
    }

    @GetMapping("/faculty/block")
    public String blockReport() {
        return "faculty-block";
    }
}
