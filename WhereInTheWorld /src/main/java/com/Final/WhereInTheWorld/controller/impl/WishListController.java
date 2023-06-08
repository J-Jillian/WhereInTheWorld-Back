package com.Final.WhereInTheWorld.controller.impl;

import com.Final.WhereInTheWorld.controller.interf.IVisitedController;
import com.Final.WhereInTheWorld.controller.interf.IWishListController;
import com.Final.WhereInTheWorld.model.Country;
import com.Final.WhereInTheWorld.model.WishListCountry;
import com.Final.WhereInTheWorld.repository.WishListRepository;
import com.Final.WhereInTheWorld.service.impl.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WishListController  implements IWishListController {

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    WishListService wishListService;


    @GetMapping("/all/wishlist")
    @ResponseStatus(HttpStatus.OK)
    public List<WishListCountry> getWishListCountries(){
        return  wishListRepository.findAll();
    }


    @PostMapping("/wishlist")
    @ResponseStatus(HttpStatus.CREATED)
    public void setWishListCountry(@RequestBody WishListCountry wishListCountry){
        wishListRepository.save(wishListCountry);
    }
    @DeleteMapping("/wishlist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWishListCountry(@PathVariable Integer id) {
        wishListService.deleteWishCountry(id);
    }

}