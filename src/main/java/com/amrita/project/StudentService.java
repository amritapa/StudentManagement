package com.amrita.project;


import com.amrita.project.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student>getStudents() {
      //  return List.of(new Student("amf",8,"fg",4.5f));
     return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }


    public Student createStudent(Student student) {
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Student with this email already exists");
        }
        return studentRepository.save(student);
    }
}
