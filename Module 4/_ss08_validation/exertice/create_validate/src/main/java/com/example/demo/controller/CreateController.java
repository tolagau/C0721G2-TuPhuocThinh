package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreateController {

    @GetMapping(value = "/validate")
    public String showForm(Model model){
        model.addAttribute("list",new User());
        return "/form";
    }
    @PostMapping("create")
    public String showKQ(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "/form";
        }
        return "/result";

    }
}
