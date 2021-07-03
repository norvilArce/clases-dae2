package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("studentServiceFake")
public class StudentServiceFakeImpl implements StudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student("0001234", "Jose", "Ventura", "Arteaga", 30),
                    new Student("0001235", "Franco", "Ventura", "Arteaga", 25),
                    new Student("0001236", "Maria", "Lopez", "Arteaga", 30)
            )
    );

    @Override
    public void create(Student student) {
        students.add(student);
    }

    @Override
    public Student read(String documentNumber) {
        return students.stream()
                .filter(s -> documentNumber.equals(s.getDocumentNumber()))
                .findFirst()
                .orElseGet(null);
    }

    @Override
    public void update(Student student) {
        Student currentStudent = read(student.getDocumentNumber());
        if (currentStudent != null) {
            int index = students.indexOf(currentStudent);
            students.set(index, student);
        }
    }

    @Override
    public void delete(String documentNumber) {
        Student currentStudent = read(documentNumber);
        students.remove(currentStudent);
    }

    @Override
    public List<Student> getAll() {
        return students;
    }
}