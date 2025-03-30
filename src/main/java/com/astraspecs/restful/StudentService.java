package com.astraspecs.restful;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(
            StudentDTO studentDTO
    ){
        var student = studentMapper.toStudent(studentDTO);
        var saveStudent = repository.save(student);
        return studentMapper.toStudentResponseDTO(saveStudent);
    }

    public List<StudentResponseDTO> getStudents(){
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList())
                ;
    }

    public StudentResponseDTO getStudentById(Integer id){
        return repository.findById(id)
                .map(studentMapper::toStudentResponseDTO)
                .orElse(null);
    }

    public List<StudentResponseDTO> getStudentByFirstName(String name){
        return repository.findAllByFirstNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList())
                ;
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }


}
