package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class TmCheckingController {

    @GetMapping("/attendance/tmchecking")
    public String getTmList(Model model){

        return "tmchecking";
    }
}
