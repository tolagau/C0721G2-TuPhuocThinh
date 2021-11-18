package com.controller;

import com.bean.Blog;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("list", iBlogService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("showCreate", new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("msg","Create new blog to ok !!!");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @GetMapping("/info/{id}")
    public ModelAndView viewBlog(@PathVariable("id") Integer id){
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/info");
        modelAndView.addObject("infoBlog",blog);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id){
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("showEditBlog",blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("updateBlog",blog);
        modelAndView.addObject("msg","Update Blog ok!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id")Integer id, RedirectAttributes redirectAttributes){
        iBlogService.delete(iBlogService.findById(id));
        redirectAttributes.addFlashAttribute("msg","Delete Blog ok!");
        return "redirect:/blog";
    }
}
