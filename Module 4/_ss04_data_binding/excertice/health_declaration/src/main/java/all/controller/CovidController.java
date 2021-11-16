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

    @GetMapping("/home")
    public String showForm(Model model){
        model.addAttribute("medicalDeclaration" , new KhaiBao());
        String [] nationals = {"Vietnamese", "Japanese", "English", "Korea"};
        model.addAttribute("nationals",nationals);
        String [] cities = {"Da Nang", "Ha Noi", "Ho Chi Minh", "Hue"};
        model.addAttribute("cities",cities);
        String [] districts = {"1", "2", "3", "4"};
        model.addAttribute("districts",districts);
        String [] wards = {"1", "2", "3"};
        model.addAttribute("wards",wards);
        String [] choices ={"Yes", "No"};
        model.addAttribute("choices",choices);
        return "home";
    }
    @PostMapping("/info")
    public ModelAndView showInfo(@ModelAttribute("medicalDeclaration") KhaiBao khaiBao){
        ModelAndView modelAndView = new ModelAndView("show",
                "medicalDeclaration", khaiBao);
        System.out.println(khaiBao.toString());
        return modelAndView;
    }
}
