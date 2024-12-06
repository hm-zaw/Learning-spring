package com.hmz.spring_jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

@NamedQueries({
    @NamedQuery(name = "Author.deleteByNamedQuery", query = "DELETE FROM Author a WHERE a.id = :id"),
    @NamedQuery(name = "Author.findByNamedQuery", query = "SELECT a FROM Author a WHERE a.age > :age")
})
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

    /*
       int value - default value is 0
       Integer value - default value is null
    */

    /*
        @Builder is used to create builder method for a single class,
            and it does not support the inheritance hierarchy.

        @SuperBuilder Extends the functionality of @Builder to support inheritance.
            Generates builders that can handle fields from both parent and child classes.
            Helps avoid duplication when you need to build objects in an inheritance hierarchy.
     */
}
