package com.astraspecs.restful;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;



    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }


    public SchoolDTO create(
             SchoolDTO schoolDTO
    ){
        var school = schoolMapper.toSchool(schoolDTO);
        var savedSchool = schoolRepository.save(school);
        return schoolDTO;
    }


    public List<SchoolDTO> findAll(){
        return schoolRepository.findAll()
                .stream()
                .map(SchoolMapper::toSchoolDTO)
                .collect(Collectors.toList());

    }

}
