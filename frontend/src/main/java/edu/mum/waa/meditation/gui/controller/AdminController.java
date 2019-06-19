package edu.mum.waa.meditation.gui.controller;

import edu.mum.waa.meditation.gui.model.JwtAuthenticationResponse;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @GetMapping("/process")
    public String processAttendanceData() {
        return "process-data";
    }

    @PostMapping("/uploadData")
    public String uploadData(@RequestParam("attendance-file") MultipartFile file, RedirectAttributes redirectAttributes) {

        if (file == null || file.isEmpty()) return "process-data";

            try {
                final String uri = "http://localhost:8082/uploadFile";
                RestTemplate restTemplate = new RestTemplate();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.MULTIPART_FORM_DATA);

                MultiValueMap<String, Object> body
                        = new LinkedMultiValueMap<>();
//                body.add("file", file);
                body.add("file", new ByteArrayResource(file.getBytes()));

                HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(body, headers);
                System.out.println(entity);

//                ResponseEntity<String> response = restTemplate
//                        .postForEntity(uri, requestEntity, String.class);

                ResponseEntity<String> result = restTemplate.exchange(
                        uri, HttpMethod.POST, entity,
                        String.class);

                redirectAttributes.addFlashAttribute("success", true);
                return "redirect:/admin/process";
            } catch (IOException e) {
                e.printStackTrace();
            }

        return "process-data";
    }

}
