package edu.mum.waa.backend.meditation.ws.controller;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.Student;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.repository.BlockRepository;
import edu.mum.waa.backend.meditation.ws.repository.StudentRepository;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import edu.mum.waa.backend.meditation.ws.service.StudentService;
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

    @Autowired
    StudentService studentService;

    @GetMapping("/getByUserId")
    public Student getByUserId(@RequestParam(name="userId") Long userId){
        return studentRepository.findUserByStudentId(userId);
    }

    @GetMapping("/attendance-block")
    public AttendanceReport generateReportByBlock(@RequestParam(name="studentId") Integer studentId,@RequestParam(name = "blockId") Long blockId){

        return studentService.generateReportByBlockId(blockId,studentId);

    }

    @GetMapping("/attendance-overall")
    public AttendanceReport generateReportOverall(@RequestParam(name="studentId") Integer studentId){

        return studentService.generateReportByStudentId(studentId);
    }

}
