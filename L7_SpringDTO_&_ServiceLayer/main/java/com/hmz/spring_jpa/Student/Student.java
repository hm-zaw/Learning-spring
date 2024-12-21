package com.hmz.spring_jpa.Student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hmz.spring_jpa.School.School;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_id_seq", allocationSize = 1)
    private Integer id;

    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;

    @NotEmpty(message = "LastName should not be empty")
    private String lastName;

    @Column(unique = true)
    private String email;

    private int age;

    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
        name = "school_id"
    )
    @JsonBackReference
    private School school;
}
