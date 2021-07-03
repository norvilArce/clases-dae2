package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
