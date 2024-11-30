package com.hmz.spring_jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor

public class Course extends BaseEntity {

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
        name = "authors_courses", // The join table name
        joinColumns = @JoinColumn(name = "course_id"), // Foreign key column in the join table for this entity
        inverseJoinColumns = @JoinColumn(name = "author_id") // Foreign key column in the join table for the related entity
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}

