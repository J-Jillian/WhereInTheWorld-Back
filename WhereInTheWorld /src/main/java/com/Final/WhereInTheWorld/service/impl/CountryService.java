package com.Final.WhereInTheWorld.service.impl;

import com.Final.WhereInTheWorld.model.Country;
import com.Final.WhereInTheWorld.model.Visited;
import com.Final.WhereInTheWorld.model.WishListCountry;
import com.Final.WhereInTheWorld.repository.CountryRepository;
import com.Final.WhereInTheWorld.repository.VisitedRepository;
import com.Final.WhereInTheWorld.repository.WishListRepository;
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

    @Autowired
    VisitedRepository visitedRepository;

    @Autowired
    WishListRepository wishListRepository;

    @Override
    public void updateCountry(Country country, String countryName) {
        Optional<Country> countryOptional = countryRepository.findByCountryName(countryName);
        if(countryOptional.isEmpty())return;
        country.setCountryName(countryName);
        countryRepository.save(country);
    }

    @Override
    public void updateCountryCityName(String cityName, Integer countryId) {
        Optional<Country> countryOptional = countryRepository.findById(countryId);
        if(countryOptional.isEmpty()) return;
        Country country = countryOptional.get();
        country.setCityName(cityName);

        Optional<Visited> visitedOptional = visitedRepository.findByCityName(cityName);

        Visited myVisited;
        if(visitedOptional.isEmpty()){
            myVisited = new Visited();
            myVisited.setCityName(cityName);
            myVisited.setTimesVisited(1);
            myVisited.setCountry(country);
            visitedRepository.save(myVisited);
        }else{
            myVisited = visitedOptional.get();
            myVisited.setTimesVisited(myVisited.getTimesVisited() + 1);
            visitedRepository.save(myVisited);
        }

        countryRepository.save(country);
    }

    //@Transactional
    @Override
    public void deleteCountry(Integer id) {
        Optional<Country> countryOptional = countryRepository.findById(id);
        if(countryOptional.isEmpty())return;
        countryRepository.deleteById(id);
    }



}
