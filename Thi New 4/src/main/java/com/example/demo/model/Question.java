package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Table
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Không được bỏ trống phần tiêu đề")
    @Size(min = 5, max = 100, message = "Tiêu đề phải từ 5 đến 100 ký tự")
    private String title;

    @Column(name = "questions", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Không được bỏ trổng phần nội dung")
    @Size(min = 10,max = 500,message = "Nội dung bạn nhập không được ngắn hơn 10 ký tự hoặc dài hơn 500 ký tự")
    private String questions;

    @Column(name = "answer", columnDefinition = "VARCHAR(255)")
    private String answer;

    @ManyToOne(targetEntity = QuestionType.class)
    private QuestionType questionType;

    @Column(name = "date_create", columnDefinition = "VARCHAR(45)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "không bỏ trống")
    private LocalDate date_create;

    @Column(name = "status", columnDefinition = "VARCHAR(10)")
    private Boolean status;

    public Question() {
    }

    public Question(int id, String title, String question, String answer, QuestionType questionType, LocalDate date_create, Boolean status) {
        this.id = id;
        this.title = title;
        this.questions = question;
        this.answer = answer;
        this.questionType = questionType;
        this.date_create = date_create;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String question) {
        this.questions = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public LocalDate getDate_create() {
        return date_create;
    }

    public void setDate_create(LocalDate date_create) {
        this.date_create = date_create;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
