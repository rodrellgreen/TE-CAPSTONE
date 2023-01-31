package com.techelevator.controller;


import com.techelevator.dao.FoodDao;
import com.techelevator.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RequestMapping( path="/food")
@RestController
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodDao foodDao;


    @GetMapping
    public List<Food> getFoodByUsername(Principal principal){
        return foodDao.getFoodByIdAndUsername(principal.getName());
    }



}
