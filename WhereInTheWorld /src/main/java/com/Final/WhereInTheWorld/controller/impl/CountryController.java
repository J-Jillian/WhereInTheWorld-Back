package com.Final.WhereInTheWorld.controller.impl;

import com.Final.WhereInTheWorld.controller.interf.ICountryController;
import com.Final.WhereInTheWorld.model.Country;
import com.Final.WhereInTheWorld.repository.CountryRepository;
import com.Final.WhereInTheWorld.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CountryController implements ICountryController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryService countryService;

    //✅
    @GetMapping("/all")
    public List<Country> getAllCountries(){
        return  countryRepository.findAll();
    }

    //✅
    @GetMapping("/country/country-name")
    public Country getCountryByCountryName(@RequestParam(name = "country-name") String countryName){
        Optional<Country> countryOptional = countryRepository.findByCountryName(countryName);
        return countryOptional.get();
    }

    /*@PostMapping("/country")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCountry(@RequestBody Country country){
        countryRepository.save(country);
    }

    @PutMapping("/country/update-country")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCountry(@RequestBody Country country, @PathVariable String countryName){
        countryService.updateCountry(country, countryName);
    }*/

}
