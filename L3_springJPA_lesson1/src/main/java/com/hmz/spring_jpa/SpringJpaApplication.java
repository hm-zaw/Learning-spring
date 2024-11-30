package com.hmz.spring_jpa;

import com.hmz.spring_jpa.models.Author;
import com.hmz.spring_jpa.models.Video;
import com.hmz.spring_jpa.repository.AuthorRepository;
import com.hmz.spring_jpa.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
		AuthorRepository repository,
		VideoRepository videoRepository
	){
		return args -> {
//			var author = Author.builder()
//					.age(20)
//					.email("jack@spring.com")
//					.name("Jack Spring")
//					.build();
//			repository.save(author);
			var video = Video.builder()
							.name("lecture_1")
							.length(200).build();
			videoRepository.save(video);
		};
	}
}
