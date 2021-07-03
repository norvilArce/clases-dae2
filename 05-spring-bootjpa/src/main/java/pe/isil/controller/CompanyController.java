package pe.isil.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Company;
import pe.isil.service.CompanyService;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public String companies(Model model){
        companyService.findAll()
                .ifPresent(companies -> model.addAttribute("companies", companies));
        return "company";
    }

    @GetMapping("/companies/add")
    public String companiesAdd(Model model){
        model.addAttribute("company", new Company());
        return "company-add";
    }

    @PostMapping("/companies/save")
    public String companiesSave(Company company){
        companyService.saveOrUpdate(company);
        return "redirect:/companies";
    }

    @GetMapping("/companies/edit/{id}")
    public String companiesEdit(@PathVariable Long id, Model model){
        companyService.findById(id)
                .ifPresent(company -> model.addAttribute("company", company));
        return "company-add";
    }

    @GetMapping("/companies/delete/{id}")
    public String companiesDelete(@PathVariable Long id){
        companyService.deleteById(id);
        return "redirect:/companies";
    }
}
