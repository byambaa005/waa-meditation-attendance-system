package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.TmCheckNew;
import edu.mum.waa.meditation.gui.model.TmCheckResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;;
import java.util.Collection;


@Controller
@RequestMapping("/attendance")
public class TmCheckingController {

    static String BACKEND_URI = "http://localhost:8082/crud/checks";

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyMDAiLCJpYXQiOjE1NjA5OTI3MTcsImV4cCI6MTU2MTU5NzUxN30.0rw9wGWWEwQCoOkxpyhczK8f9E3qvUvMX8xMpIKdkMgJdfyFa8tS3SdtlNx_qnX3rn752dD41LliH5kfHJQqXA");
        return headers;
    }

    @GetMapping("/list")
    public String getTmList(Model model, HttpSession session) {


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PagedResources<TmCheckResponse>> response = restTemplate.exchange(BACKEND_URI,
                HttpMethod.GET, null, new ParameterizedTypeReference<PagedResources<TmCheckResponse>>() {
                });
        PagedResources<TmCheckResponse> tmCheckResources = response.getBody();
        Collection<TmCheckResponse> tmChecks = tmCheckResources.getContent();

        model.addAttribute("tms", tmChecks);

        return "tmchecking";
    }

    @GetMapping("/gui/add")
    public String getAddForm(@ModelAttribute("tmcheck") TmCheckNew tmCheckResponse, BindingResult bindingResult, Model model) {

        return "tmcheckform";
    }

    @PostMapping("/add")
    public String saveTmCheck(@Valid @ModelAttribute("tmcheck") TmCheckNew tmCheckResponse, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "tmcheckform";
        } else {

            RestTemplate restTemplate = new RestTemplate();
            System.out.println(tmCheckResponse.toString());
            HttpEntity<TmCheckNew> entity = new HttpEntity<>(tmCheckResponse, buildHeaders());
            System.out.println(tmCheckResponse.toString());
            ResponseEntity<String> result = restTemplate.postForEntity(
                    BACKEND_URI,entity, String.class);

            model.addAttribute("tmcheck", result.getBody());

            return "redirect:/attendance/list";
        }
    }

    @GetMapping("/guiEdit/{id}")
    public String editTmCheck(@ModelAttribute("tmcheck") TmCheckResponse tmCheckResponse, @PathVariable("id") long id, Model model) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(null, buildHeaders());
        ResponseEntity<TmCheckResponse> result = restTemplate.exchange(
                BACKEND_URI + "/" + id, HttpMethod.GET, entity,
                TmCheckResponse.class);

        model.addAttribute("tmcheck", result.getBody());

        return "tmcheckEditform";
    }

    @PostMapping("/edit")
    public String editTmCheckSave(@Valid @ModelAttribute("tmcheck") TmCheckResponse tmCheckResponse, BindingResult bindingResult, Model model, HttpSession session) {
        System.out.println("++++++++++");
        if (bindingResult.hasErrors()) {
            return "tmcheckEditform";
        } else {

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<TmCheckResponse> entity = new HttpEntity<>(tmCheckResponse, buildHeaders());
            ResponseEntity<String> result = restTemplate.exchange(
                    BACKEND_URI+"/" +tmCheckResponse.getId(), HttpMethod.PUT, entity,
                    String.class);
            model.addAttribute("tmcheck", result.getBody());
            return "redirect:/attendance/list";
        }
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteTmCheck(@PathVariable long id, TmCheckResponse tmCheckResponse) {

        HttpEntity<String> entity = new HttpEntity<>(null, buildHeaders());
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result = restTemplate.exchange(
                BACKEND_URI + "/" + id, HttpMethod.DELETE, entity,
                String.class);

        return "redirect:/attendance/list";
    }
}
