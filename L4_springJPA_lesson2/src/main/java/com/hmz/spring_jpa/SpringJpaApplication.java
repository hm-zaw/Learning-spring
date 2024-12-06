package com.hmz.spring_jpa;

import com.github.javafaker.Faker;
import com.hmz.spring_jpa.models.Author;
import com.hmz.spring_jpa.models.File;
import com.hmz.spring_jpa.models.Video;
import com.hmz.spring_jpa.repository.AuthorRepository;
import com.hmz.spring_jpa.repository.FileRepository;
import com.hmz.spring_jpa.repository.VideoRepository;
import com.hmz.spring_jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
		AuthorRepository repository,
		FileRepository fileRepository
	){
		return args -> {
//			List<Author> aa = repository.findByNamedQuery(35);
//			for (Author author: aa){
//				System.out.println("Author: " + author.getName() + ", Email: " + author.getEmail());
//			}

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(44));
			repository.findAll(spec).forEach(System.out::println);

//			repository.deleteByNamedQuery(60);
		/*
		// Searching an author
			String name = "Rory";
			List<Author> authorList = repository.findAllByNameContainingIgnoreCase(name);
			for (Author author : authorList) {
				System.out.println("Author: " + author.getName() + ", Email: " + author.getEmail());
			}
		*/
        };
	}
}
