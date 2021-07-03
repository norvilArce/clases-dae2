package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
