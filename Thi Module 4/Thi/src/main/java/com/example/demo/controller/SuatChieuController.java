package com.example.demo.controller;

import com.example.demo.model.Phim;
import com.example.demo.model.SuatChieu;
import com.example.demo.service.IPhimService;
import com.example.demo.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/crud")
public class SuatChieuController {
    @Autowired
    ISuatChieuService iSuatChieuService;
    @Autowired
    IPhimService iPhimService;

    @ModelAttribute("tenPhimList")
    public Iterable<Phim> phimIterable() {
        return iPhimService.findAll();
    }

    @GetMapping()
    public String showList(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<SuatChieu> suatChieuList = iSuatChieuService.findAll(pageable);
        model.addAttribute("suatChieuList", suatChieuList);
        return "crud/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("suatchieu", new SuatChieu());
        return "crud/create";
    }

    @PostMapping("/create")
    public String createSuatChieu(@Valid @ModelAttribute("suatchieu") SuatChieu suatChieu, BindingResult bindingResult,
                                  Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return"crud/create";
        }else {
            iSuatChieuService.save(suatChieu);
            redirectAttributes.addFlashAttribute("mess","ok man");
            return "redirect:/crud";
        }
    }

    //delete làm bằng ajax
    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable("id") String id, Model model) {
        Optional<SuatChieu> suatChieu = iSuatChieuService.findById(id);
        model.addAttribute("suatchieu", suatChieu.get());
        return "crud/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String id, RedirectAttributes redirectAttributes) {
        iSuatChieuService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/crud";
    }

    @PostMapping("/search")
    public String searchPhim(@RequestParam @PageableDefault(size = 5)String phim, Pageable pageable, Model model){
        System.out.println(phim);
        Page<SuatChieu> page = iSuatChieuService.findByPhim(phim,pageable);
        model.addAttribute("suatChieuList",page);
        return "crud/list";
    }

}
