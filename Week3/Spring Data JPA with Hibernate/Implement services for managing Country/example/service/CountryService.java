package org.example.service;

import org.example.model.Country;
import org.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country findByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, String newName) {
        Optional<Country> country = countryRepository.findById(code);
        if (country.isPresent()) {
            Country c = country.get();
            c.setCoName(newName);
            return countryRepository.save(c);
        }
        return null;
    }

    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    public List<Country> searchByPartialName(String name) {
        return countryRepository.findByCoNameContainingIgnoreCase(name);
    }
}
