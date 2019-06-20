package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        String studentAttendanceUrl = "http://localhost:8082/student/attendance-overall?studentId=986979";

//        if (curUser.getRoles().contains("USER_ADMIN") || curUser.getRoles().contains("USER_FACULTY")) {
//            studentAttendanceUrl += "";
//            System.out.println("ADMIN OR FACULTY");
//        } else {
//            System.out.println("USER STUDENT");
//            studentAttendanceUrl += "?studentId=986979";
//        }


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

    @GetMapping("/attendance/block")
    public String getAttendance(Model model, HttpSession session) {
        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + session.getAttribute("access_token"));

        RestTemplate restTemplate = new RestTemplate();
        String studentAttendanceByBlockUrl = "http://localhost:8082/student/attendance-block?studentId=986979&blockId=100";

        ResponseEntity<StudentAttendanceResponse> blockResponse = restTemplate.exchange(studentAttendanceByBlockUrl,
                HttpMethod.GET, new HttpEntity<>("parameters", headers), new ParameterizedTypeReference<StudentAttendanceResponse>() {});
        StudentAttendanceResponse studentAttendanceByBlockResponses = blockResponse.getBody();

        model.addAttribute("attendanceInfoByBlock", studentAttendanceByBlockResponses);

        return "student-attendance-block";
    }

}
