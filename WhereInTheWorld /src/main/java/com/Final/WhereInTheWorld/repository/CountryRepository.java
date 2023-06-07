package com.Final.WhereInTheWorld.repository;

import com.Final.WhereInTheWorld.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findByCountryName(String countryName);
}
