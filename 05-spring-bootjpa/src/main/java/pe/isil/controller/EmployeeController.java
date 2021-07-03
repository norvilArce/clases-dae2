package pe.isil.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Employee;
import pe.isil.service.CompanyService;
import pe.isil.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/employees")
    public String employees(Model model){
        employeeService.findAll()
                .ifPresent(employees -> model.addAttribute("employees",employees));
        return "employee";
    }

    @GetMapping("/employees/add")
    public String employeeAdd(Model model){
        model.addAttribute("employee", new Employee());
        companyService.findAll()
                .ifPresent(companies -> model.addAttribute("companies", companies));
        return "employee-add";
    }

    @PostMapping("employees/save")
    public String employeeSave(Employee employee){
        employeeService.saveOrUpdate(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String employeeEdit(@PathVariable Long id, Model model){
        employeeService.findById(id)
                .ifPresent(employee -> model.addAttribute("employee", employee));
        companyService.findAll()
                .ifPresent(companies -> model.addAttribute("companies", companies));
        return "employee-add";
    }

    @GetMapping("/employees/delete/{id}")
    public String employeeDelete(@PathVariable Long id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }


}
