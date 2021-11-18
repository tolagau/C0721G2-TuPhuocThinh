package ahihi.controller;

import ahihi.bean.Music;
import ahihi.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/music")
public class MusicController {

   @Autowired
   IMusicService iMusicService;

    @GetMapping("")
   public String showList(Model model){
        model.addAttribute("showList",iMusicService.findAll());
        return "list";
    }
    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("listEdit",iMusicService.findById(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Music music, Model model, RedirectAttributes redirectAttributes){
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("cuccu","Edit thành thụ");
        return "redirectAttributes:/music";
    }

}
