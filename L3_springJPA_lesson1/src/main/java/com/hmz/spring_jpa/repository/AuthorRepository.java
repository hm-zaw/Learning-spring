package com.hmz.spring_jpa.repository;

import com.hmz.spring_jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
