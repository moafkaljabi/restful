/*
*
* Should not have any logic
*
* */


package com.astraspecs.restful.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        @Valid @RequestBody StudentDTO studentDTO
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


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String /* field name */ ,/* message name */ String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    
                });
    }

}
