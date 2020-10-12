package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String home(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/create")
    public String showAddForm(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateCustomer(Customer customer, Model model){
        customerService.save(customer);
        List<Customer>customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.remove(id);
        return "redirect:/customers";
    }

}
