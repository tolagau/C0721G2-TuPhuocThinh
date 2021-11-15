package all.controller;

import all.bean.KhaiBao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CovidController {

    @GetMapping(value = "/home")
    public String showList(Model model) {
        String[] genders = {"nam", "nữ"};


        model.addAttribute("genders", genders);
        model.addAttribute("khaibao", new KhaiBao());
        return "home";
    }

    @PostMapping(value = "/info")
    public String create(Model model, @ModelAttribute("khaibao") KhaiBao khaiBao,
                         RedirectAttributes redirectAttributes) {

        // khaiBao = new KhaiBao();
        model.addAttribute("name", khaiBao);
        model.addAttribute("dateOfBirth",khaiBao);
        model.addAttribute("",khaiBao);
        return "info";
    }
}
