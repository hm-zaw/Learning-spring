package com.hmz.spring_jpa.repository;

import com.hmz.spring_jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    // select * from author where name = ?
    List<Author> findAllByName(String nn1);

    // select * from author where name = "ht"
    List<Author> findAllByNameIgnoreCase(String nn2);

    // select * from author where name like '%al%'
    List<Author> findAllByNameContainingIgnoreCase(String nn3);

    List<Author> findAllByNameStartsWithIgnoreCase(String nn4);

    // update Author a set a.age = 22 where a.id = 1;
    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.age = :age WHERE a.id = :id")
    void updateAuthor(int age, int id);

    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void deleteByNamedQuery(@Param("id") int id);
    
}
