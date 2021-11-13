package all.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@org.springframework.stereotype.Controller


public class Controller {
    @GetMapping("")
    public String showList() {
        return "list";
    }

    @PostMapping("")
    public String showResult(@RequestParam String vietnameseWord, Model model) {
        String english;
        switch (vietnameseWord) {
            case "so mot":
                english = "one";
                break;
            case "so hai":
                english = "two";
                break;
            case "so ba":
                english = "three";
                break;
            case "so bon":
                english = "four";
                break;
            case "so nam":
                english = "five";
                break;
            case "so sau":
                english = "six";
                break;
            case "so bay":
                english = "seven";
                break;
            default:
                english = "i dont know";
                break;
        }
        model.addAttribute("english", english);
        return "list";
    }
}
