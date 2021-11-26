package com.example.demo.model;

import com.example.demo.util.Regex;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @NotBlank(message = "Không được bỏ trống")
    @Size(min = 5, max = 45, message = "Tối thiểu là 5, tối đa là 45")
    private String firstName;
    @NotBlank(message = "Không được bỏ trống")
    @Size(min = 5, max = 45, message = "Tối thiểu là 5, tối đa là 45")
    private String lastName;

    private String phoneNumber;

    private String email;

    @Min(value = 18)
    private int age;

    public User() {
    }

    public User(int id, String firstName, String lastName, String phoneNumber, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.firstName.matches(Regex.NAME_REGEX)){
            errors.rejectValue("name","name.invalidFormat");
        }
    }
}
