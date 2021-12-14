package com.example.demo.service;

import com.example.demo.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionTypeService {
    Iterable<QuestionType> findAll();

    Page<QuestionType> findAll(Pageable pageable);

    Optional<QuestionType> findById(Integer id);

    void save(QuestionType questionType);

    void remove(Integer id);
}
