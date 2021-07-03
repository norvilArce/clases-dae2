package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
