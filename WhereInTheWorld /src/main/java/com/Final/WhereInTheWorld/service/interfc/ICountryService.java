package com.Final.WhereInTheWorld.service.interfc;

import com.Final.WhereInTheWorld.model.Country;

public interface ICountryService {
    void updateCountry(Country country, String countryName);

    void updateCountryCityName(String cityName, String countryName);

    void deleteCountry( String countryName);
}
