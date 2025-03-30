package com.astraspecs.restful;

import org.aspectj.apache.bcel.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class FirstController {

    private final StudentRepository repository;

    public FirstController(StudentRepository repository){
        this.repository = repository;
    }

    // Creating Endpoints

    @GetMapping("/hello!!")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello(){
        return "Hello from Spring";
    }

    @PostMapping("/students")
    public Student postStudents(
            @RequestBody Student student
    ){
        return repository.save(student);
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student getStudents(
            @PathVariable("student-id") Integer id
    ){
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{student-firstname}")
    public List<Student> getStudentByFirstName(
            @PathVariable("student-firstname") String name
    ){
        return repository.findAllByFirstNameContaining(name);
    }

}
