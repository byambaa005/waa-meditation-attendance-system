package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/attendance/tmchecking")
public class TmCheckingController {




    public String getTmList(Model model){

        return "tmchecking";
    }
}
