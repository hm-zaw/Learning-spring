package com.hmz.spring_jpa.Student;

public record StudentResponseDto(
    String firstName,
    String lastName,
    String email
) {
}
