package edu.mum.waa.backend.meditation.ws.controller;

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
import edu.mum.waa.backend.meditation.ws.service.UserService;
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
    private UserService userService;


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

        return userService.generateReportByEntry(entry);

    }
}
