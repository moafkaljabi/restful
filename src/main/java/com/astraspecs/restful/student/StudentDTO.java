package com.astraspecs.restful.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(

        @NotEmpty
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
