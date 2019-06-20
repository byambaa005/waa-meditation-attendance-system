package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.StudentAttendanceResponse;
import edu.mum.waa.meditation.gui.model.TmAttendance;
import edu.mum.waa.meditation.gui.model.TmCheckResponse;
import edu.mum.waa.meditation.gui.model.UserSummary;
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
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @GetMapping("/attendance")
    public String getStudentAttendance(Model model, HttpSession session) {

        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }

        UserSummary curUser = (UserSummary) session.getAttribute("curUser");

        System.out.println(curUser);

        RestTemplate restTemplate = new RestTemplate();
        String studentAttendanceUrl = "http://localhost:8082/student/attendance-overall?studentId=986979";

//        if (curUser.getRoles().contains("USER_ADMIN") || curUser.getRoles().contains("USER_FACULTY")) {
//            studentAttendanceUrl += "";
//            System.out.println("ADMIN OR FACULTY");
//        } else {
//            System.out.println("USER STUDENT");
//            studentAttendanceUrl += "?studentId=986979";
//        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(session.getAttribute("access_token"));
        headers.add("Authorization", "Bearer " + session.getAttribute("access_token"));

        ResponseEntity<StudentAttendanceResponse> response = restTemplate.exchange(studentAttendanceUrl,
                HttpMethod.GET, new HttpEntity<>("parameters", headers), new ParameterizedTypeReference<StudentAttendanceResponse>() {});
        StudentAttendanceResponse studentAttendanceResponses = response.getBody();
//        List<TmAttendance> attendances = studentAttendanceResponses.getAttendanceList();

        model.addAttribute("attendanceInfo", studentAttendanceResponses);

        System.out.println(response);

        return "student";
    }

}
