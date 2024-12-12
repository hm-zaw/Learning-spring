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

		var ctx = SpringApplication.run(SpringJpaApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		String msg = myFirstService.tellAStory();
		System.out.println(msg);

		System.out.println(myFirstService.getMyCustom());
	}

}
