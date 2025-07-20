package com.cognizant.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/loan")
public class LoanApplication {

    @Autowired
    private LoanRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
    }

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return repository.save(loan);
    }
}
