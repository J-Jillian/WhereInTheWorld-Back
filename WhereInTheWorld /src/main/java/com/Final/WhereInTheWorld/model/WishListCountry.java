package com.Final.WhereInTheWorld.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WishListCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String countryName;
    private String countryPopulation;
    private String countryRegion;
    private String countryCapital;
    private String flags;
    private String cityName;

    }

