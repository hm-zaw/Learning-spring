package com.hmz.spring_jpa.repository;

import com.hmz.spring_jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
