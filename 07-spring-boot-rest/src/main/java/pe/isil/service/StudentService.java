package pe.isil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.isil.model.Student;
import pe.isil.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService implements CrudService<Student, Long>{

    private final StudentRepository studentRepository;

    @Override
    public Student createOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id).map(
                student -> {
                    studentRepository.delete(student);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<List<Student>> findAll() {
        return Optional.of(studentRepository.findAll());
    }
}
