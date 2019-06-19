package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.TmCheckResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class TmCheckingController {

    @GetMapping("/attendance/tmchecking")
    public String getTmList(Model model, HttpSession session){

        String tmCheckListUrl = "http://localhost:8082/crud/checks";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PagedResources<TmCheckResponse>> response = restTemplate.exchange(tmCheckListUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<PagedResources<TmCheckResponse>>() {});
        PagedResources<TmCheckResponse> tmCheckResources = response.getBody();
        Collection<TmCheckResponse> tmChecks = tmCheckResources.getContent();

        model.addAttribute("tms", tmChecks);

        return "tmchecking";
    }
}
