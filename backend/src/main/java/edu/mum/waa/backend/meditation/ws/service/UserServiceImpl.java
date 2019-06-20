package edu.mum.waa.backend.meditation.ws.service;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.model.EntryReport;
import edu.mum.waa.backend.meditation.ws.repository.BlockRepository;
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


        AttendanceReport attendanceReport = new AttendanceReport();

        List<TmAttendance> attendanceList = new ArrayList<TmAttendance>();

        //attendanceList = tmAttendanceRepository.findTmAttendancesByEntry(entry);
    /*
        Integer attendanceCount = attendanceList.size();
        Integer requiredCount = block.getTotalDate();
        Integer numOfStudents = tmAttendanceRepository.findDistinctByStudentIdAndDateIsBetween(block.getStartDate(),block.getEndDate()).intValue();
        requiredCount = requiredCount*numOfStudents;
        // one block
        Double percentage = Common.calcAttendancePercentage(attendanceCount,requiredCount);
        //AttendanceReport for Faculty per block
        attendanceReport.setAttendanceList(attendanceList);
        attendanceReport.setAttendence(attendanceCount);
        attendanceReport.setRequiredAttendance(requiredCount);
        attendanceReport.setPercentage(percentage);
        attendanceReport.setExtraPoint(Common.calcExtraPoint(percentage));
         */
        return null;
    }
}
