package all.controller;

import all.bean.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ahihi {
    @GetMapping("")
    public String showForm(Model model) {
        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        Integer[] pageSizes = {5, 10, 15, 25, 50, 100};
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        model.addAttribute("configEmail",new Email());
        return "home";
    }

    @PostMapping(value = "/info")
    public ModelAndView showConfig(@ModelAttribute("configEmail") Email email) {
        ModelAndView modelAndView = new ModelAndView("/info", "configEmail", email);
        return modelAndView;
    }
}
