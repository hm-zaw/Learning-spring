package com.hmz.spring_jpa.Student;

public record StudentDto(
        String firstName,
        String lastName,
        String email,
        int age,
        Integer schoolId
) {
}
