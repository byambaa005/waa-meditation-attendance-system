package edu.mum.waa.backend.meditation.ws.controller;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.Student;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.repository.BlockRepository;
import edu.mum.waa.backend.meditation.ws.repository.StudentRepository;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import edu.mum.waa.backend.meditation.ws.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    BlockRepository blockRepository;

    @Autowired
    TmAttendanceRepository tmAttendanceRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/getByUserId")
    public Student getByUserId(@RequestParam(name="userId") Long userId){
        return studentRepository.findUserByStudentId(userId);
    }

    @GetMapping("/attendance-block")
    public AttendanceReport generateReportByBlock(@RequestParam(name="studentId") Integer studentId,@RequestParam(name = "blockId") Long blockId){


        Block block = new Block();
        block= blockRepository.findById(blockId).get();

        List<TmAttendance> attendanceList;
        attendanceList = tmAttendanceRepository.findByBlock(studentId,block.getStartDate(),block.getEndDate());


        Integer attendanceCount = attendanceList.size();
        Integer requiredCount = block.getTotalDate();
        Double percentage = Common.calcAttendancePercentage(attendanceCount,requiredCount);

        //AttendanceReport for Student per block

        AttendanceReport attendanceReport = new AttendanceReport();
        attendanceReport.setAttendanceList(attendanceList);
        attendanceReport.setAttendence(attendanceCount);
        attendanceReport.setRequiredAttendance(requiredCount);
        attendanceReport.setPercentage(percentage);
        attendanceReport.setExtraPoint(Common.calcExtraPoint(percentage));

        return attendanceReport;
    }

    @GetMapping("/attendance-overall")
    public AttendanceReport generateReportOverall(@RequestParam(name="studentId") Integer studentId){

        List<TmAttendance> attendanceList = tmAttendanceRepository.findAllByStudentId(studentId);
        System.out.println("working until this -----------------------");

        Integer attendanceCount = attendanceList.size();
        Integer requiredCount = studentRepository.getTotalDay(studentId).intValue();

        Double percentage = Common.calcAttendancePercentage(attendanceCount,requiredCount);

        //AttendanceReport for Student overall

        AttendanceReport attendanceReport = new AttendanceReport();
        attendanceReport.setAttendanceList(attendanceList);
        attendanceReport.setAttendence(attendanceCount);
        attendanceReport.setRequiredAttendance(requiredCount);
        attendanceReport.setPercentage(percentage);
        attendanceReport.setExtraPoint(Common.calcExtraPoint(percentage));

        return attendanceReport;
    }

}
