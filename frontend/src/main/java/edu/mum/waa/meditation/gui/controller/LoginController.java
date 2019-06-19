package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.JwtAuthenticationResponse;
import edu.mum.waa.meditation.gui.model.LoginRequest;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage(@ModelAttribute ("user") LoginRequest loginRequest) {
        return "login";
    }

    @PostMapping("/login")
    public String signin(@Valid @ModelAttribute ("user") LoginRequest loginRequest, Model model, BindingResult bindingResult, HttpSession session) {

        System.out.println("-----------------login credentials-----------------------------");
        System.out.println(loginRequest);
        System.out.println("-----------------login credentials-----------------------------");

        if (bindingResult.hasErrors()) {
            return "login";
        } else {

            JSONObject user = new JSONObject();
            user.put("username", loginRequest.getUsername());
            user.put("password", loginRequest.getPassword());

            final String uri = "http://localhost:8082/api/auth/signin";
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(user.toString(), headers);
            ResponseEntity<JwtAuthenticationResponse> response = restTemplate.postForEntity(uri, entity, JwtAuthenticationResponse.class);

            model.addAttribute("user", response);
            session.setAttribute("access_token", response.getBody().getAccessToken());

            return "redirect:/";
        }

    }

}
