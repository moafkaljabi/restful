package com.astraspecs.restful;

public record StudentDTO(

        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
