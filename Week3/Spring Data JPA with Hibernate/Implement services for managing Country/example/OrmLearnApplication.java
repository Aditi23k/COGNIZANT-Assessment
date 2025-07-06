package org.example;

import org.example.model.Country;
import org.example.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("✅ Country: " + countryService.findByCode("IN"));

        Country c = new Country();
        c.setCoCode("XY");
        c.setCoName("Testland");
        countryService.addCountry(c);

        countryService.updateCountry("XY", "Updated Testland");
        System.out.println("🔍 Search: " + countryService.searchByPartialName("land"));

        countryService.deleteCountry("XY");
        System.out.println("❌ Deleted Testland");
    }
}
