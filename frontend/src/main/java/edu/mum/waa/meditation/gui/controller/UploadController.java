package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

    @GetMapping("/admin/upload")
    public String getForm(){
        return "uploadFile";
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("mediation-file") MultipartFile file, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("success", );
        return "redirect:/admin/upload";
    }
}
