package com.paledev.hobbsched.services;

import com.paledev.hobbsched.dto.CompanyDTO;
import com.paledev.hobbsched.models.Company;
import com.paledev.hobbsched.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    private void setCompanyValues(Company company, CompanyDTO dto) {
        company.setCompanyName(dto.getCompanyName());
        company.setCnpj(dto.getCnpj());
    }

    public Company save(CompanyDTO dto) {
        Company company = new Company();
        setCompanyValues(company, dto);
        return companyRepository.save(company);
    }

    public Company update(Long id,CompanyDTO dto) {
        Company company = companyRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Company not found with id " + id));
        setCompanyValues(company, dto);
        return companyRepository.save(company);
    }
    public void delete(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Company not found with id " + id));
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }
    public Optional<Company> findCompanyById(Long id) {
        return companyRepository.findById(id);
    }
}
