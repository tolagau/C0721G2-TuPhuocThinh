package com.example.demo.service;

import com.example.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionService {
    Iterable<Question> findAll();

    Page<Question> findAll(Pageable pageable);

    Page<Question> findAllTitle(String title, Pageable pageable);

    Optional<Question> findById(Integer id);

    void save(Question question);

    void remove(Integer id);
}
