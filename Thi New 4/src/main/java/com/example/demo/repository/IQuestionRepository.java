package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "select * \n" +
            " from question\n" +
            " where question.title like  concat('%',:title,'%')", nativeQuery = true)
    Page<Question>findAllTitle(@Param("title")String title, Pageable pageable);


}
