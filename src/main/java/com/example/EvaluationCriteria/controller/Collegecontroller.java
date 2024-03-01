package com.example.EvaluationCriteria.controller;
import com.example.EvaluationCriteria.model.College;
import com.example.EvaluationCriteria.service.Collegeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class Collegecontroller {

    @Autowired
    private Collegeservice collegeService;

    @PostMapping
    public ResponseEntity<College> addCollege(@RequestBody College college) {
        College addedCollege = collegeService.addCollege(college);
        return new ResponseEntity<>(addedCollege, HttpStatus.CREATED);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable int id) {
        College college = collegeService.getCollegeById(id);
        if (college != null) {
            return new ResponseEntity<>(college, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable int id, @RequestBody College college) {
        College updatedCollege = collegeService.updateCollege(id, college);
        if (updatedCollege != null) {
            return new ResponseEntity<>(updatedCollege, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable int id) {
        if (collegeService.deleteCollege(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}