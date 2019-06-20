package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.AttendDetailReport;
import edu.mum.waa.meditation.gui.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("/detail/{blockId}")
    public String getAttendance(Model model, HttpSession session, @PathVariable("blockId") long blockId) {
        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }
        model.addAttribute("attendanceInfoByBlock", referenceService.getBlockReports(blockId,session));
        return "blockreport-detail";
    }
}
