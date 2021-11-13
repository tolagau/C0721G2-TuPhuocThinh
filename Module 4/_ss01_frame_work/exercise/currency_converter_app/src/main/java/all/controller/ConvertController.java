package all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("")
    public String showForm() {
        return "customers/form";
    }
    @PostMapping ("")
    public String showResult(@RequestParam double usd, Model model) {
        double vnd = usd * 22000;
        model.addAttribute("vnd", vnd);
        return "customers/form";
    }
}