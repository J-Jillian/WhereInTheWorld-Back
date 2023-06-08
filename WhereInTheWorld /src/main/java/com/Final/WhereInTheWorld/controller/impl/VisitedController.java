package com.Final.WhereInTheWorld.controller.impl;

import com.Final.WhereInTheWorld.controller.DTO.CountryCityDTO;
import com.Final.WhereInTheWorld.controller.interf.IVisitedController;
import com.Final.WhereInTheWorld.model.Country;
import com.Final.WhereInTheWorld.model.Visited;
import com.Final.WhereInTheWorld.repository.CountryRepository;
import com.Final.WhereInTheWorld.repository.VisitedRepository;
import com.Final.WhereInTheWorld.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VisitedController implements IVisitedController {
    @Autowired
    VisitedRepository visitedRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CountryService countryService;

    //✅
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getAllVisitedCountries(){
        return  countryRepository.findAll();
    }

    //✅
    @PostMapping("/visited/{visitedCountry}")
    @ResponseStatus(HttpStatus.OK)
    public void setVisited(@PathVariable String visitedCountry){
        Optional<Country> countryOptional = countryRepository.findByCountryName(visitedCountry);
        Country myCountry;
        if (countryOptional.isPresent()) {
            myCountry = countryOptional.get();
        } else {
            myCountry = new Country();
            myCountry.setCountryName(visitedCountry);
        }
        myCountry.setCountryPopulation(visitedCountry);

        countryRepository.save(myCountry);
    }

/*    @PostMapping("/visited")
    @ResponseStatus(HttpStatus.CREATED)
    public void setVisited(@RequestBody Country visitedCountry){
        countryRepository.save(visitedCountry);
    }*/

    @PatchMapping("/visited/{countryName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVisitedCountryCity(@RequestBody CountryCityDTO countryCityDTO, @PathVariable String countryName){
        countryService.updateCountryCityName(countryCityDTO.getCityName(), countryName);

    }

    @DeleteMapping("/visited/{countryName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable String countryName) {
        countryService.deleteCountry(countryName);
    }

   /* @PostMapping("/visited/{visitedCountry}/{visitedCity}")
    @ResponseStatus(HttpStatus.OK)
    public void setVisited(@PathVariable String visitedCountry, @PathVariable String visitedCity){

        Optional<Country> countryOptional = countryRepository.findByCountryName(visitedCountry);

        Country myCountry;
        if(countryOptional.isEmpty()){
            myCountry = new Country();
            myCountry.setCountryName(visitedCountry);
            countryRepository.save(myCountry);
        }else{
            myCountry = countryOptional.get();
        }

        // Añadir la visita
        Optional<Visited> visitedOptional = visitedRepository.findByCityName(visitedCity);

        Visited myVisited;
        if(visitedOptional.isEmpty()){
            myVisited = new Visited();
            myVisited.setCityName(visitedCity);
            myVisited.setTimesVisited(1);
            myVisited.setCountry(myCountry);
            visitedRepository.save(myVisited);
        }else{
            myVisited = visitedOptional.get();
            myVisited.setTimesVisited(myVisited.getTimesVisited() + 1);
            visitedRepository.save(myVisited);
        }
    }*/

}
