package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceDetailController {

    @GetMapping(value = "attendance/detail")
    public String getDetail(Model model){
        return "attendanceDetail";
        }
}
