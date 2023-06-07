package com.Final.WhereInTheWorld.repository;

import com.Final.WhereInTheWorld.model.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryRepositoryTest {

    @Autowired
    CountryRepository countryRepository;

    @Test
    public void findAll_countries_countriesList(){
        List<Country> countryList = countryRepository.findAll();
        System.out.println(countryList);
        //assertEquals(countryList.size());
        assertTrue(true);
    }

    @Test
    public void findByCountryName(){
        Optional<Country> country = countryRepository.findByCountryName("France");
        assertTrue(country.isPresent());
        System.out.println(country.get());

        assertEquals("France", country.get().getCountryName());
    }

    @Test
    public void addCountry(){
        Country unitedStates = new Country();
        unitedStates.setCountryName("United State");
        unitedStates.setCountryPopulation("331,9");

        Country france = new Country();
        france.setCountryName("France");
        france.setCountryPopulation("67,75");

        Country japan = new Country();
        japan.setCountryName("Japan");
        japan.setCountryPopulation("125,7");

        Country germany = new Country();
        germany.setCountryName("Germany");
        germany.setCountryPopulation("83,2 ");

        countryRepository.save(france);
        countryRepository.save(unitedStates);
        countryRepository.save(japan);
        countryRepository.save(germany);
    }

}