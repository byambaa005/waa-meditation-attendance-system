package edu.mum.waa.backend.meditation.ws.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import edu.mum.waa.backend.meditation.ws.entity.Block;
import edu.mum.waa.backend.meditation.ws.entity.TmAttendance;
import edu.mum.waa.backend.meditation.ws.entity.User;
import edu.mum.waa.backend.meditation.ws.exception.ResourceNotFoundException;
import edu.mum.waa.backend.meditation.ws.model.*;
import edu.mum.waa.backend.meditation.ws.repository.BlockRepository;
import edu.mum.waa.backend.meditation.ws.repository.TmAttendanceRepository;
import edu.mum.waa.backend.meditation.ws.repository.UserRepository;
import edu.mum.waa.backend.meditation.ws.security.CurrentUser;
import edu.mum.waa.backend.meditation.ws.security.UserPrincipal;
import edu.mum.waa.backend.meditation.ws.service.StudentService;
import edu.mum.waa.backend.meditation.ws.service.UserService;
import edu.mum.waa.backend.meditation.ws.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private UserQuestionAnswerRepository userQuestionAnswerRepository;
//
//    @Autowired
//    private UserQuestionRatingRepository userQuestionRatingRepository;


    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER') or hasRole('FACULTY') or hasRole('ADMIN')")
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
    public AttendanceReport facultyReportBlock(@RequestParam(name="blockId") Long blockId){

        return userService.generateReportByBlockId(blockId);

    }

    @GetMapping("/user/attendance-entry")
    public List<EntryReport> facultyReportEntry(@RequestParam(name="entry") String entry){

        return userService.generateReportByEntry(entry.toUpperCase());

    }

    @GetMapping("/user/attendance-entry-summary")
    public BlockSummaryReport facultyReportEntrySummary(@RequestParam(name="entry") String entry){
        BlockSummaryReport blockSummaryReport = new BlockSummaryReport();
        blockSummaryReport.setAttendanceList(userService.generateReportByEntry(entry.toUpperCase()));
        return blockSummaryReport;

    }

    @GetMapping("/user/attendance-block-summary")
    public BlockSummaryReport facultyReportSummaryBlock(@RequestParam(name="blockId") Long blockId){
        BlockSummaryReport blockSummaryReport = new BlockSummaryReport();
        blockSummaryReport.setAttendanceList(userService.generateReportEntryByBlock(blockId));
        return blockSummaryReport;

    }
    @GetMapping("/user/export-block/{blockId}")
    public void exportBlockCSV(HttpServletResponse response,@PathVariable(name = "blockId")Long blockId) throws Exception{

        String filename = "BlockReport-"+ LocalDate.now().toString()+".csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<EntryReport> writer = new StatefulBeanToCsvBuilder<EntryReport>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        List<EntryReport> reportList = userService.generateReportEntryByBlock(blockId);

        //write all users to csv file
        writer.write(reportList);

    }

    @GetMapping("/user/export-entry/{entry}")
    public void exportEntryCSV(HttpServletResponse response,@PathVariable(name = "entry")String entry) throws Exception{

        String filename = "EntryReport-"+ LocalDate.now().toString()+".csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<EntryReport> writer = new StatefulBeanToCsvBuilder<EntryReport>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        List<EntryReport> reportList = userService.generateReportByEntry(entry);
        System.out.println("Size entry : "+reportList.size());

        //write all users to csv file
        writer.write(reportList);

    }
}
