package com.amrita.project.StudentController;

import com.amrita.project.StudentService;
import com.amrita.project.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer  id) {
        return service.getStudentById(id);
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

}