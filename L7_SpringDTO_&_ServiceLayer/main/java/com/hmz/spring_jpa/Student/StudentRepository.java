package com.hmz.spring_jpa.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByFirstNameContainingIgnoreCase(String name);
}
