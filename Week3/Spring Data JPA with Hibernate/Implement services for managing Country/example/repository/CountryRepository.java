package org.example.repository;

import org.example.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByCoNameContainingIgnoreCase(String name);
}
