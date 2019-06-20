package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private static String BLOCKS_URL = "http://localhost:8082/crud/blocks";

    @GetMapping("/attendance")
    public String getStudentAttendance(Model model, HttpSession session) {

        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }

        RestTemplate restTemplate = new RestTemplate();
        Object studentId = session.getAttribute("studentId");
        String studentAttendanceUrl = "http://localhost:8082/student/attendance-overall?studentId=" + studentId;

        //Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + session.getAttribute("access_token"));

        //Get blocks list
        ResponseEntity<PagedResources<Block>> blocksResponse = restTemplate.exchange(BLOCKS_URL,
                HttpMethod.GET, new HttpEntity<>("parameters", headers), new ParameterizedTypeReference<PagedResources<Block>>() {
                });
        PagedResources<Block> Block = blocksResponse.getBody();
        Collection<Block> blocks = Block.getContent();

        //Get student attendance info
        ResponseEntity<StudentAttendanceResponse> response = restTemplate.exchange(studentAttendanceUrl,
                HttpMethod.GET, new HttpEntity<>("parameters", headers), new ParameterizedTypeReference<StudentAttendanceResponse>() {});
        StudentAttendanceResponse studentAttendanceResponses = response.getBody();

        //Add block and attendance info to model
        model.addAttribute("attendanceInfo", studentAttendanceResponses);
        model.addAttribute("blocks", blocks);

        System.out.println(response);

        return "student";
    }

    @GetMapping("/attendance/block/{blockId}")
    public String getAttendance(Model model, HttpSession session, @PathVariable("blockId") long blockId) {
        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }

        Object studentId = session.getAttribute("studentId");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + session.getAttribute("access_token"));

        RestTemplate restTemplate = new RestTemplate();
        String studentAttendanceByBlockUrl = "http://localhost:8082/student/attendance-detail?studentId=" + studentId + "&blockId=" + blockId;

        ResponseEntity<AttendDetailReport> blockResponse = restTemplate.exchange(studentAttendanceByBlockUrl,
                HttpMethod.GET, new HttpEntity<>("parameters", headers), new ParameterizedTypeReference<AttendDetailReport>() {});
        AttendDetailReport studentAttendanceByBlockResponses = blockResponse.getBody();

        model.addAttribute("attendanceInfoByBlock", studentAttendanceByBlockResponses);
        System.out.println(blockResponse);

        return "student-attendance-block";
    }

    @GetMapping("/attendance/admin")
    public String getAttendanceAdmin(Model model, HttpSession session) {
        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }

        return "student-attendance-admin";
    }

}
