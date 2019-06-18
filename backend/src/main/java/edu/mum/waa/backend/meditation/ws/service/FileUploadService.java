package edu.mum.waa.backend.meditation.ws.service;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    TmAttendanceRepository attendanceRepository;

    public boolean processFile(MultipartFile file){

        if(file == null || file.isEmpty()) return false;

        try{
            String Record;

            //Read file using buffer
            BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            //To save all attendance records
            List<TmAttendance> attendanceList =new ArrayList<TmAttendance>();

            //temporary attendence to add to list of records
            TmAttendance attendanceRecord = null;

            //temporary fields
            LocalDate date;
            Integer studentId;
            Long cardId;
            String type;
            String location;
            String name;

            DateTimeFormatter formatterWithFullYear = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter formatterWithYear= DateTimeFormatter.ofPattern("MM/dd/yy");

            while((Record = reader.readLine())!=null){

                String[] fields =Record.split(",");

                //fields (date,studentId,name)
                if(fields.length == 3){
                    date = LocalDate.parse(fields[0],formatterWithFullYear);
                    studentId = Integer.parseInt(fields[1].replaceAll("-",""));
                    type = "AM";
                    name = fields[2];
                    attendanceRecord = new TmAttendance(date,studentId,type,name);
                }
                //fields (cardId,date,AM,DB)
                else if(fields.length == 4){
                    // System.out.println("before convert : "+fields[0]);
                    cardId = Long.parseLong(fields[0]);
                    //System.out.println(cardId);
                    date = LocalDate.parse(fields[1],formatterWithYear);
                    Long temp = cardId %1000000;
                    studentId = temp != null ? temp.intValue() : null;
                    type = fields[2];
                    location = fields[3];
                    attendanceRecord = new TmAttendance(cardId,studentId,date,type,location);
                }
                //add attendance record to list
                attendanceList.add(attendanceRecord);

            }

            //Save attendance records to
            attendanceRepository.saveAll(attendanceList);

            return true;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }


        return false;
    }
}
