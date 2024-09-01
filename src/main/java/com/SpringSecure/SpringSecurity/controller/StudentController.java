package com.SpringSecure.SpringSecurity.controller;

import com.SpringSecure.SpringSecurity.DataModel.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> studentList = new ArrayList<Student>(List.of(
            new Student(1, "Yash", 70),
            new Student(2,"Prath", 80)
    ));

    @GetMapping("/students")
    public List<Student> getStudents()
    {
       return studentList;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student)
    {
        studentList.add(student);
        return student;
    }

}
