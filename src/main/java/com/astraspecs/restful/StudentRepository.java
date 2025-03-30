package com.astraspecs.restful;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Create methods to filter e.g. filterByFirstName

public interface StudentRepository extends JpaRepository<Student, Integer> {

     List<Student> findAllByFirstNameContaining(String firstname);

}


