package pe.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.isil.model.Student;
import pe.isil.service.StudentService;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(@Qualifier("studentServiceFake") StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "student"; //nombre de la pagina que queremos resolver
    }

    @GetMapping("/students/add")
    public String studentAdd(Model model) {
        model.addAttribute("student", new Student());
        return "student-add";
    }

    @GetMapping("/students/edit/{documentNumber}")
    public String studentEdit(@PathVariable String documentNumber, Model model) {
        model.addAttribute("student", studentService.read(documentNumber));
        return "student-edit";
    }

    @GetMapping("/students/delete/{documentNumber}")
    public String studentDelete(@PathVariable String documentNumber){
        studentService.delete(documentNumber);
        return "redirect:/students";
    }

    @PostMapping("/students/save")
    public String studentSave(Student student){
        studentService.create(student);
        return "redirect:/students";
    }

    @PostMapping("/students/update")
    public String studentUpdate(Student student){
        studentService.update(student);
        return "redirect:/students";
    }

}