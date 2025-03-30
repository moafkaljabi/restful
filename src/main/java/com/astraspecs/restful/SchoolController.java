package com.astraspecs.restful;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class SchoolController {


    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/schools")
    public SchoolDTO create(
            @RequestBody SchoolDTO schoolDTO
    ){
        return this.schoolService.create(schoolDTO) ;
    }



    @GetMapping("/schools")
    public List<SchoolDTO> findAll(){
        return this.schoolService.findAll();

    }

}
