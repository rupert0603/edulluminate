package com.edulluminate.school_service.school;

import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public SchoolResponse toSchoolResponse(School school) {
        return new SchoolResponse(
                school.getId(),
                school.getName(),
                school.getCountry().getName()
        );
    }
}
