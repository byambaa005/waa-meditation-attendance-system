package edu.mum.waa.backend.meditation.ws.controller;

import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.entity.User;
import edu.mum.waa.backend.meditation.ws.exception.ResourceNotFoundException;
import edu.mum.waa.backend.meditation.ws.model.AttendanceReport;
import edu.mum.waa.backend.meditation.ws.model.UserIdentityAvailability;
import edu.mum.waa.backend.meditation.ws.model.UserProfile;
import edu.mum.waa.backend.meditation.ws.model.UserSummary;
import edu.mum.waa.backend.meditation.ws.repository.BlockRepository;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import edu.mum.waa.backend.meditation.ws.repository.UserRepository;
import edu.mum.waa.backend.meditation.ws.security.CurrentUser;
import edu.mum.waa.backend.meditation.ws.security.UserPrincipal;
import edu.mum.waa.backend.meditation.ws.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TmAttendanceRepository tmAttendanceRepository;
    @Autowired
    private BlockRepository blockRepository;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private UserQuestionAnswerRepository userQuestionAnswerRepository;
//
//    @Autowired
//    private UserQuestionRatingRepository userQuestionRatingRepository;


    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getAuthorities().stream().map(e->((GrantedAuthority) e).getAuthority()).collect(Collectors.toList()));
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getCreatedAt());

        return userProfile;
    }

    @GetMapping("/user/attendance-block")
    public AttendanceReport facultyReportBlock(@RequestParam(name="blockId") Integer blockId){

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

    @GetMapping("/user/attendance-entry")
    public AttendanceReport facultyReportEntry(@RequestParam(name="entry") String entry){


        AttendanceReport attendanceReport = new AttendanceReport();

        /*
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


         */
        return attendanceReport;

    }
}
