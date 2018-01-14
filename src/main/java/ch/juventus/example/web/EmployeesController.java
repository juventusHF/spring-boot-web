package ch.juventus.example.web;

import ch.juventus.example.data.Employee;
import ch.juventus.example.data.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class EmployeesController {

    private EmployeeRepository employeeRepository;

    @Autowired
    MessageSource messageSource;

    @Autowired
    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public String employees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

}
