package com.hmz.spring_jpa.repository;

import com.hmz.spring_jpa.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {
}
