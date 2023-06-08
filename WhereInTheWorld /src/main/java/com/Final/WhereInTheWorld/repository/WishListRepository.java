package com.Final.WhereInTheWorld.repository;

import com.Final.WhereInTheWorld.model.Country;
import com.Final.WhereInTheWorld.model.Visited;
import com.Final.WhereInTheWorld.model.WishListCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishListCountry, Integer> {
    Optional<WishListCountry> findByCountryName(String countryName);

}
