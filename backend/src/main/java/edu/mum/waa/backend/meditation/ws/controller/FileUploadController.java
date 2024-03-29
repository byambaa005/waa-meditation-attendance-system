package edu.mum.waa.backend.meditation.ws.controller;

import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;


@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;
    @PostMapping( "/uploadFile")
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        if(fileUploadService.processFile(file)){
            return "successfull";
        }
        else{
            return "error";
        }
    }

}
