package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/report/entryreport")
public class EntiryReportController {


    @Autowired
    ReferenceService referenceService;

    @GetMapping
    public String index(Model model, HttpSession session) {
        //Create headers
        model.addAttribute("entries", referenceService.getEntries(session));

        return "entryreport";
    }

    @GetMapping("/detail/{entry}")
    public String getAttendance(Model model, HttpSession session, @PathVariable("entry")String entry) {
        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }
        model.addAttribute("attendanceInfoByBlock", referenceService.getEntryReports(entry,session));
        return "entryreport-detail";
    }
}
