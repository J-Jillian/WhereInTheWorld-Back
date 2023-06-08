package com.Final.WhereInTheWorld.service.impl;

import com.Final.WhereInTheWorld.model.Country;
import com.Final.WhereInTheWorld.repository.CountryRepository;
import com.Final.WhereInTheWorld.service.interfc.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {

    @Autowired
    CountryRepository countryRepository;
    @Override
    public void updateCountry(Country country, String countryName) {
        Optional<Country> countryOptional = countryRepository.findByCountryName(countryName);
        if(countryOptional.isEmpty())return;
        country.setCountryName(countryName);
        countryRepository.save(country);
    }

    @Override
    public void updateCountryCityName(String cityName, String countryName) {
        Optional<Country> countryOptional = countryRepository.findByCountryName(countryName);
        if(countryOptional.isEmpty()) return;
        Country country = countryOptional.get();
        country.setCityName(cityName);
        countryRepository.save(country);
    }

    //@Transactional
    @Override
    public void deleteCountry(String countryName) {
        Optional<Country> countryOptional = countryRepository.findByCountryName(countryName);
        if(countryOptional.isEmpty())return;
        countryRepository.deleteByCountryName(countryName);
    }



}
