package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
public class QuestionType {
    @Id
    private int id;
   @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String name;
    @OneToMany(targetEntity= Question.class, mappedBy = "questions")
    List<Question> questionList;

    public QuestionType() {
    }

    public QuestionType(int id, String name, List<Question> questionList) {
        this.id = id;
        this.name = name;
        this.questionList = questionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
