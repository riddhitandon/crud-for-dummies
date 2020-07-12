package io.riddhi.spring.student.controller;

import io.riddhi.spring.student.pojo.Student;
import io.riddhi.spring.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/{rollNumber}")
    public Student getStudentByRollNumber(@PathVariable Integer rollNumber){
        return studentService.getStudentByRollNumber(rollNumber);
    }

    @PostMapping("/")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/")
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudentDetails(student);
    }

    @DeleteMapping("/{rollNumber}")
    public String deleteStudents(@PathVariable Integer rollNumber){
        return studentService.deleteStudentByRollNumber(rollNumber);
    }
}
