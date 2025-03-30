package com.astraspecs.restful;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository){
        this.repository = repository;
    }

    // Creating Endpoints


    @PostMapping("/students")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentResponseDTO postStudents(
            @RequestBody StudentDTO studentDTO
    ){
        var student = toStudent(studentDTO);
        var saveStudent = repository.save(student);
        return toStudentResponseDTO(saveStudent);
    }

    private Student toStudent(StudentDTO dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }


    private StudentResponseDTO toStudentResponseDTO(Student student){
        return new StudentResponseDTO(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
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
