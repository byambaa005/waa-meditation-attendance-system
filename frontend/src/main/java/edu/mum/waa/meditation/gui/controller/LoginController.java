package edu.mum.waa.meditation.gui.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import edu.mum.waa.meditation.gui.model.JwtAuthenticationResponse;
import edu.mum.waa.meditation.gui.model.LoginRequest;
import edu.mum.waa.meditation.gui.model.TmCheckResponse;
import edu.mum.waa.meditation.gui.model.UserSummary;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/")
    public String root(HttpSession session) {
        System.out.println(session.getAttribute("user"));
        if (session.getAttribute("curUser") == null) {
            return "redirect:/login";
        }
        return "index";
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute ("user") LoginRequest loginRequest, HttpSession session) {
        session.removeAttribute("curUser");
        session.removeAttribute("access_token");
        return "login";
    }

    @GetMapping("/login")
    public String loginPage(@ModelAttribute ("user") LoginRequest loginRequest) {
        return "login";
    }

    @PostMapping("/login")
    public String signin(@Valid @ModelAttribute ("user") LoginRequest loginRequest, BindingResult bindingResult, Model model,  HttpSession session) {

        System.out.println("-----------------login credentials-----------------------------");
        System.out.println(loginRequest);
        System.out.println("-----------------login credentials-----------------------------");

        if (bindingResult.hasErrors()) {
            return "login";
        } else {

            //Creating user JSON object
            JSONObject user = new JSONObject();
            user.put("username", loginRequest.getUsername());
            user.put("password", loginRequest.getPassword());

            //Sign in API call
            final String uri = "http://localhost:8082/api/auth/signin";
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<String>(user.toString(), headers);
            ResponseEntity<JwtAuthenticationResponse> response = restTemplate.postForEntity(uri, entity, JwtAuthenticationResponse.class);

            model.addAttribute("user", response);
            session.setAttribute("access_token", response.getBody().getAccessToken());

            headers.add("Authorization", "Bearer " + response.getBody().getAccessToken());

            //Saving signed in USER info to session
            String userInfoUrl = "http://localhost:8082/api/user/me";

            ResponseEntity<UserSummary> userResponse = restTemplate.exchange(userInfoUrl,
                    HttpMethod.GET, new HttpEntity<>("parameters", headers), new ParameterizedTypeReference<UserSummary>() {});
            UserSummary userInfoResponse = userResponse.getBody();

            session.setAttribute("curUser", userInfoResponse);

            return "redirect:/";
        }

    }

}
