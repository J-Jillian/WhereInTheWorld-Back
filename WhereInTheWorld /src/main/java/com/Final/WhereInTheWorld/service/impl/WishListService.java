package com.Final.WhereInTheWorld.service.impl;

import com.Final.WhereInTheWorld.model.Country;
import com.Final.WhereInTheWorld.model.WishListCountry;
import com.Final.WhereInTheWorld.repository.WishListRepository;
import com.Final.WhereInTheWorld.service.interfc.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishListService implements IWishListService {

@Autowired
    WishListRepository wishListRepository;
    public void deleteWishCountry(Integer id) {
        Optional<WishListCountry> wishListCountryOptional = wishListRepository.findById(id);
        if(wishListCountryOptional.isEmpty())return;
        wishListRepository.deleteById(id);
    }

}
