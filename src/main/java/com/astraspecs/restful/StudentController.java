/*
*
* Should not have any logic
*
* */


package com.astraspecs.restful;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Creating Endpoints


    @PostMapping("/students")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentResponseDTO saveStudent(
            @RequestBody StudentDTO studentDTO
    ){
        return this.studentService.saveStudent(studentDTO);
    }


    @GetMapping("/students")

    public List<StudentResponseDTO> getStudents(){

        return this.studentService.getStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDTO getStudentById(
            @PathVariable("student-id") Integer id
    ){
        return this.studentService.getStudentById(id);
    }

    @GetMapping("/students/search/{student-firstname}")
    public List<StudentResponseDTO> getStudentByFirstName(
            @PathVariable("student-firstname") String name
    ){
        return this.studentService.getStudentByFirstName(name);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(
            @PathVariable("student-id") Integer id
    ){
        this.studentService.delete(id);
    }
}
