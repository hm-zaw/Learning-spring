package com.hmz.spring_jpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    @Qualifier("bean1")
    public MySprBoot firstBean(){
        return new MySprBoot("first bean");
    }

    @Bean
    @Qualifier("bean2")
    public MySprBoot secondBean(){
        return new MySprBoot("second bean");
    }

}
