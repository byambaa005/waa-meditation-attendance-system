package edu.mum.waa.backend.meditation.ws.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.waa.backend.meditation.ws.entity.Student;
import edu.mum.waa.backend.meditation.ws.repository.StudentRepository;
import edu.mum.waa.backend.meditation.ws.service.AutoCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/search")
@RestController
public class SearchController {

    @Autowired
    AutoCompleteService autoCompleteService;

    @GetMapping
    public ResponseEntity<String> doAutoComplete(@RequestParam("q") final String input) {
        List<String> strings = autoCompleteService.doAutoComplete(input);
        ObjectMapper mapper = new ObjectMapper();
        String resp = "";
        try {
            resp = mapper.writeValueAsString(strings);
        } catch (JsonProcessingException e) {
        }
        return new ResponseEntity<String>(resp, HttpStatus.OK);
    }
}
