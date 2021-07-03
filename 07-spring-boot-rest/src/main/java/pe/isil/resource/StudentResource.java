package pe.isil.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Student;
import pe.isil.service.StudentService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class StudentResource {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        Optional<List<Student>> studentServiceAll = studentService.findAll();
        if (studentServiceAll.isPresent()){
            List<Student> students = studentServiceAll.get();
            return students.isEmpty() ?
                    new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //probar
        /*return studentService.findAll()
                .map(students -> students.isEmpty() ? new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Student>>(students, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));*/
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.createOrUpdate(student), HttpStatus.CREATED);
    }

    //PUT  -> actualizar todo
    //PATH -> actializar un campo

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.findById(id)
                .map(s -> {
                    student.setId(id);
                    return new ResponseEntity<>(studentService.createOrUpdate(student), HttpStatus.OK);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id) {
        return studentService.deleteById(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}