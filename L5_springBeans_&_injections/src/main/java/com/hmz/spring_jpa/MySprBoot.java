package com.hmz.spring_jpa;

import org.springframework.stereotype.Component;

import java.util.Scanner;

public class MySprBoot {

    private String myVar;

    public MySprBoot(String myVar){
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello again, myvar = " + myVar;
    }
}
