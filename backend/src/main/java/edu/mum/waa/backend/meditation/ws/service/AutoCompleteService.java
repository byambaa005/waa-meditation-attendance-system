package edu.mum.waa.backend.meditation.ws.service;

import edu.mum.waa.backend.meditation.ws.entity.Student;
import edu.mum.waa.backend.meditation.ws.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoCompleteService {

    @Autowired
    StudentRepository studentRepository;

    public List<String> doAutoComplete(final String input) {
        List<Student> studentList = studentRepository.search(input);
        return studentList.stream().map(s->s.studentId.toString()).collect(Collectors.toList());
    }
}
