package com.example.demo.service;

import com.example.demo.model.QuestionType;
import com.example.demo.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    IQuestionTypeRepository iQuestionTypeRepository;

    @Override
    public Iterable<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }

    @Override
    public Page<QuestionType> findAll(Pageable pageable) {
        return iQuestionTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<QuestionType> findById(Integer id) {
        return iQuestionTypeRepository.findById(id);
    }

    @Override
    public void save(QuestionType questionType) {
    iQuestionTypeRepository.save(questionType);
    }

    @Override
    public void remove(Integer id) {
        iQuestionTypeRepository.deleteById(id);

    }
}
