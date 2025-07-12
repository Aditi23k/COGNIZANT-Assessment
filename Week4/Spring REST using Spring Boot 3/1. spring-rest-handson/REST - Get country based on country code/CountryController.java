package com.cognizant;

import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        CountryService service = new CountryService();
        return service.getCountry(code);

    }
}
