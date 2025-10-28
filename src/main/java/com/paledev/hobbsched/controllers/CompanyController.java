package com.paledev.hobbsched.controllers;

import com.paledev.hobbsched.dto.CompanyDTO;
import com.paledev.hobbsched.models.Company;
import com.paledev.hobbsched.services.ClientService;
import com.paledev.hobbsched.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {return ResponseEntity.ok(companyService.findAllCompanies());}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody CompanyDTO company) {
        return ResponseEntity.ok(companyService.save(company));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO company) {
        return ResponseEntity.ok(companyService.update(id,company));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
