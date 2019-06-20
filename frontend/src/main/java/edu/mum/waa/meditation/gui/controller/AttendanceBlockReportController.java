package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/report/blockreport")
public class AttendanceBlockReportController {


    @Autowired
    ReferenceService referenceService;

    @GetMapping
    public String index(Model model, HttpSession session) {
        //Create headers
        model.addAttribute("blocks", referenceService.getBlocks(session));

        return "blockreport";
    }


    @GetMapping("/detail")
    public String getDetail() {
//        redirectAttributes.addFlashAttribute("success", );

        return "blockreport-detail";
    }
}
