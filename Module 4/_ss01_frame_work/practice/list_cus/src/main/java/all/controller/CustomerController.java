package all.controller;

import all.bean.Customer;
import all.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public String showList(Model mode) {
        List<Customer> customers = customerService.findAll();
        mode.addAttribute("customers", customers);
        return "list";
    }
}
