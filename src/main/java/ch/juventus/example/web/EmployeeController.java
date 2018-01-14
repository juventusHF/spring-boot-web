package ch.juventus.example.web;

import ch.juventus.example.data.Employee;
import ch.juventus.example.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee")
    public String edit(Model model, @RequestParam Long id) {
        Employee employee = employeeRepository.getOne(id);
        model.addAttribute(employee);
        return "employee";
    }

    @PostMapping("/saveEmployee")
    public String save(Model model, @Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            employeeRepository.save(employee);
        }
        model.addAttribute(employee);
        return "employee";
    }
}
