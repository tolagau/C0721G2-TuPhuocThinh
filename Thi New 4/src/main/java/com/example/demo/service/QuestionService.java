package com.example.demo.service;

import com.example.demo.model.Question;
import com.example.demo.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    IQuestionRepository iQuestionRepository;


    @Override
    public Iterable<Question> findAll() {
        return iQuestionRepository.findAll();
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return iQuestionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> findAllTitle(String title, Pageable pageable) {
        return iQuestionRepository.findAllTitle(title, pageable);
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return iQuestionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        iQuestionRepository.save(question);
    }

    @Override
    public void remove(Integer id) {
        iQuestionRepository.deleteById(id);
    }
}
