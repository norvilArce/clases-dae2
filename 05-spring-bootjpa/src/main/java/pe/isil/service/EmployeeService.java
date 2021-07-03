package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Employee;
import pe.isil.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements BaseService<Employee, Long> {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<List<Employee>> findAll() {
        return Optional.of(employeeRepository.findAll());
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id).map(
                employee -> {
                    employeeRepository.delete(employee);
                    return true;
                }
        ).orElse(false);
    }
}
