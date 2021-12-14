package com.example.demo.controller;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.model.employee.Employee;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypeList")
    public Iterable<CustomerType> customerTypes(Model model) {
        return iCustomerTypeService.findAll();
    }

    @GetMapping()
    public String showlistCustomer(Model model, @PageableDefault(size = 4) Pageable pageable) {
        Page<Customer> customerPage = iCustomerService.findAll(pageable);
        model.addAttribute("listCustomer", customerPage);
        return "customer/list";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable String id) {
        Optional<Customer> customer = iCustomerService.findById(id);
        model.addAttribute("editCustomer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(Model model, @ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit ok");
        return "redirect:/customer";
    }

    @GetMapping("/create")
    public String showCreateEmployee(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("customer") Customer customer,
                                 BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customer/create";
        } else {
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("mess", "ok");
            return "redirect:/customer";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/customer";
    }
}
