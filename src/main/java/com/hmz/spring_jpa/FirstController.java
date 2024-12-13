package com.hmz.spring_jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello-spring")
    public String sayHello(){
        return "Hello from my controller";
    }

    @PostMapping("/post")
    public String doSomething(@RequestBody String msg){
        return "I am posting " + msg;
    }

    @PostMapping("/post-order")
    public String doSomething(@RequestBody Order order){
        return "Request accepted and the order is: " + order.toString();
    }

    @PostMapping("/product-record")
    public String viewProduct(@RequestBody ProductRecord pr){
        return "Request accepted and the product is: " + pr.toString();
    }

    // https://localhost:8080/hello-spring/myName
    @GetMapping("/hello-spring/{user_name}")
    public String pathVar(
        @PathVariable("user_name") String user_name
    ){
        return "my value is " + user_name;
    }

    // https://localhost:8080/hello-spring/param
    @GetMapping("/hello-param")
    public String paramVar(
            @RequestParam("username") String username,
            @RequestParam("age") int age
    ){
        return "My name is " + username + " and I am " + age;
    }
}
