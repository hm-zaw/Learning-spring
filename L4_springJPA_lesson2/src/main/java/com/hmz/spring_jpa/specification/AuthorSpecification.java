package com.hmz.spring_jpa.specification;

import com.hmz.spring_jpa.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {
    public static Specification<Author> hasAge(int age){
        return (
            Root<Author> root,
            CriteriaQuery<?> query,
            CriteriaBuilder builder
        ) -> {
            if (age < 0){
                return null;
            }
            return builder.equal(root.get("age"), age);
        };
    }

    public static Specification<Author> nameContains(String name){
        return (
            Root<Author> root,
            CriteriaQuery<?> query,
            CriteriaBuilder builder
        ) -> {
            if (name == null){
                return null;
            }
            return builder.like(root.get("name"), "%" + name + "%");
        };
    }
}
