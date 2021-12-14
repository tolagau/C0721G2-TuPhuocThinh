package com.example.demo.controller;

import com.example.demo.model.employee.*;
import com.example.demo.repository.employee.*;
import com.example.demo.service.employee.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IPositionService iPositionService;
    @Autowired
    IDivisionService iDivisionService;
    @Autowired
    IEducationDegreeService iEducationDegreeService;
    @Autowired
    IUserService iUserService;

    @ModelAttribute("divisionList")
    public Iterable<Division> divisionIterable() {
        return iDivisionService.findAll();
    }

    @ModelAttribute("positionList")
    public Iterable<Position> positionIterable() {
        return iPositionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public Iterable<EducationDegree> educationDegreeIterable() {
        return iEducationDegreeService.findAll();
    }

    @ModelAttribute("userList")
    public Iterable<User> userIterable() {
        return iUserService.findAll();
    }

    @GetMapping()
    public String showListEmployee(Optional<String> keywork, Optional<Integer> positionId , @PageableDefault(size = 5) Pageable pageable, Model model) {

//        if (!keywork.isPresent() || keywork.get().equals("")){
//            if (!positionId.isPresent()){
//                iEmployeeService.search(keywork);
//            }else {
//                iEmployeeService.search(positionId);
//            }
//
//
//        }

        Page<Employee> employeePage = iEmployeeService.findAll(pageable);
        model.addAttribute("listEmployee", employeePage);
//        List<Employee> emplSear = iEmployeeService.search(keywork);
//        model.addAttribute("searchResult", emplSear);
        return "employee/list";
    }

    @GetMapping("/create")
    public String showCreateEmployee(Model model) {
        model.addAttribute("createEmployee", new Employee());
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model) {
        Optional<Employee> employee = iEmployeeService.findById(id);
        model.addAttribute("employeeEdit", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        iEmployeeService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/employee";
    }


}
