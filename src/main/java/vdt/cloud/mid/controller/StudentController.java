package vdt.cloud.mid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vdt.cloud.mid.service.StudentService;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.ok(studentService.listAllStudents());
    }

}

