package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.model.QuestionType;
import com.example.demo.service.IQuestionService;
import com.example.demo.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/crud")
public class QuestionController {

    @Autowired
    IQuestionTypeService iQuestionTypeService;
    @Autowired
    IQuestionService iQuestionService;

    @ModelAttribute("questionTypeList")
    public Iterable<QuestionType> questionTypeIterable() {
        return iQuestionTypeService.findAll();
    }

    @GetMapping()
    public String showList(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("questionList", iQuestionService.findAll(pageable));
        return "crud/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("question", new Question());
        return "crud/create";

    }

    @PostMapping("/create")
    public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult bindingResult,
                                  Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "crud/create";
        } else {
            iQuestionService.save(question);
            redirectAttributes.addFlashAttribute("mess", "Tạo thành công");
            return "redirect:/crud";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") Integer id, Model model) {
        Optional<Question> questionOptional = iQuestionService.findById(id);
        model.addAttribute("question", questionOptional.get());
        return "crud/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iQuestionService.remove(id);
//        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/crud";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Integer id, Model model){
        Optional<Question> question = iQuestionService.findById(id);
        model.addAttribute("question", question.get());
        return "crud/detail";
    }


    @PostMapping("/search")
    public String searchTitle(@RequestParam @PageableDefault(size = 3) String title, Pageable pageable, Model model) {
        System.out.println(title);
        Page<Question> page = iQuestionService.findAllTitle(title, pageable);
        model.addAttribute("questionList", page);
        return "crud/list";
    }

}
