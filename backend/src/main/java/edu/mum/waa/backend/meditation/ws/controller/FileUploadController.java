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

    @GetMapping("/export-attendance")
    public void exportCSV(HttpServletResponse response) throws Exception{
        /*

            String filename = "Attendance.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<TmAttendance> writer = new StatefulBeanToCsvBuilder<TmAttendance>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        for(int i=1;i<100;i++){
            TmAttendance temp = new TmAttendance();
            temp.setId(i);
            temp.setCardId((long) 1000000+i);
            temp.setStudentId(986979+i);
            temp.setName(null);
            temp.setType("AM");
            temp.setDate(LocalDate.now());
            temp.setLocation("DB");
            attendanceList.add(temp);
        }

        //write all users to csv file
        writer.write(attendanceList);
*/
    }
}
