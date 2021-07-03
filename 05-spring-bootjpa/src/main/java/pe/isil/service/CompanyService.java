package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Company;
import pe.isil.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements BaseService<Company, Long> {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Optional<List<Company>> findAll() {
        return Optional.of(companyRepository.findAll());
    }

    @Override
    public Company saveOrUpdate(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public boolean deleteById(Long id) {
        return findById(id).map(company -> {
            companyRepository.delete(company);
            return true;
        }).orElse(false);
    }
}
