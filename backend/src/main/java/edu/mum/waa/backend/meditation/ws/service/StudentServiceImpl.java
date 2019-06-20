package edu.mum.waa.backend.meditation.ws.service;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.repository.BlockRepository;
import edu.mum.waa.backend.meditation.ws.repository.StudentRepository;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import edu.mum.waa.backend.meditation.ws.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    TmAttendanceRepository tmAttendanceRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BlockRepository blockRepository;


    @Override
    public AttendanceReport generateReportByStudentId(Integer studentId){

    List<TmAttendance> attendanceList = tmAttendanceRepository.findAllByStudentId(studentId);

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

    @Override
    public AttendanceReport generateReportByBlockId(Long blockId,Integer studentId) {

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


}

