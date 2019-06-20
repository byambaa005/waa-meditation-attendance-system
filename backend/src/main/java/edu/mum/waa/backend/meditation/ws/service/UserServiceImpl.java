package edu.mum.waa.backend.meditation.ws.service;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.Student;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.model.EntryReport;
import edu.mum.waa.backend.meditation.ws.repository.BlockRepository;
import edu.mum.waa.backend.meditation.ws.repository.StudentRepository;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import edu.mum.waa.backend.meditation.ws.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    BlockRepository blockRepository;
    @Autowired
    TmAttendanceRepository tmAttendanceRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public AttendanceReport generateReportByBlockId(Long blockId) {

        AttendanceReport attendanceReport = new AttendanceReport();

        List<TmAttendance> attendanceList = new ArrayList<TmAttendance>();

        Block block = new Block();
        block = blockRepository.findById(blockId).get();

        attendanceList = tmAttendanceRepository.findTmAttendancesByDateBetween(block.getStartDate(),block.getEndDate());


        Integer attendanceCount = attendanceList.size();
        Integer requiredCount = block.getTotalDate();
        Integer numOfStudents = tmAttendanceRepository.findDistinctByStudentIdAndDateIsBetween(block.getStartDate(),block.getEndDate()).intValue();
        requiredCount = requiredCount*numOfStudents;
        Double percentage = Common.calcAttendancePercentage(attendanceCount,requiredCount);

        //AttendanceReport for Faculty per block

        attendanceReport.setAttendanceList(attendanceList);
        attendanceReport.setAttendence(attendanceCount);
        attendanceReport.setRequiredAttendance(requiredCount);
        attendanceReport.setPercentage(percentage);
        attendanceReport.setExtraPoint(Common.calcExtraPoint(percentage));
        return attendanceReport;
    }

    @Override
    public List<EntryReport> generateReportByEntry(String entry) {


        List<EntryReport> reportList = new ArrayList<EntryReport>();
        List<Student> studentList = studentService.getStudentsByEntry(entry);

        studentList.forEach(student -> {
            final int required;
            final int attended;
            final Double percentage;
            EntryReport report = new EntryReport();
            required = studentRepository.getTotalDay(student.getStudentId().intValue()).intValue();
            attended = tmAttendanceRepository.countDistinctByStudentId(student.getStudentId()).intValue();
            percentage= Common.calcAttendancePercentage(attended,required);

            report.setRequired(required);
            report.setAttended(attended);
            report.setPercentage(percentage);
            report.setBonusPoint(Common.calcExtraPoint(percentage));
            report.setStudentId(student.getStudentId());

            reportList.add(report);
        });

        return reportList;
    }

    @Override
    public List<EntryReport> generateReportEntryByBlock(Long blockId){

        List<EntryReport> reportList = new ArrayList<EntryReport>();
        List<Student> studentList = studentRepository.findStudentsByBlockId(blockId);

        studentList.forEach(student -> {
            final int required;
            final int attended;
            final Double percentage;
            EntryReport report = new EntryReport();
            required = studentRepository.getTotalDay(student.getStudentId().intValue()).intValue();
            attended = tmAttendanceRepository.countDistinctByStudentId(student.getStudentId()).intValue();
            percentage= Common.calcAttendancePercentage(attended,required);

            report.setRequired(required);
            report.setAttended(attended);
            report.setPercentage(percentage);
            report.setBonusPoint(Common.calcExtraPoint(percentage));
            report.setStudentId(student.getStudentId());

            reportList.add(report);
        });

        return reportList;

    }
}
