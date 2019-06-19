package edu.mum.waa.meditation.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/attendance/tmchecking")
public class TmCheckingController {



//    //Students
//    Student s1=new Student(Long.parseLong("1"), "Nov-2018", "KHUYAGAA", "B");
//    Student s2=new Student(Long.parseLong("2"), "Feb-2019", "Ankh", "B");
//    Student s3=new Student(Long.parseLong("3"), "Apr-2019", "Byambaa", "B");
//    Student s4=new Student(Long.parseLong("4"), "Feb-2019", "Baya", "B");
//    Student s5=new Student(Long.parseLong("5"), "Nov-2018", "Hugo", "B");
//    Student s6=new Student(Long.parseLong("6"), "Apr-2019", "John", "B");
//
//    //TmCheckin list
//    TmCheck tmc1=new TmCheck(LocalDate.of(2019, 06, 10), "TM-Retreat", s1);
//    TmCheck tmc2=new TmCheck(LocalDate.of(2019, 05, 11), "TM-Check", s2);
//    TmCheck tmc3=new TmCheck(LocalDate.of(2019, 05, 15), "TM-Retreat", s3);
//    TmCheck tmc4=new TmCheck(LocalDate.of(2019, 05, 18), "TM-Check", s4);
//    TmCheck tmc5=new TmCheck(LocalDate.of(2019, 06, 8), "TM-Retreat", s5);
//    TmCheck tmc6=new TmCheck(LocalDate.of(2019, 06, 11), "TM-Retreat", s6);
//
//    List<TmCheck> lists= Arrays.asList(
//            tmc1,
//            tmc2,
//            tmc3,
//            tmc4,
//            tmc5,
//            tmc6
//    );


    public String getTmList(Model model){

        return "tmchecking";
    }
}
