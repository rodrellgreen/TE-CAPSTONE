package com.techelevator.controller;


import com.techelevator.dao.FoodDao;
import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Food;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RequestMapping( path="/food")
@RestController
@CrossOrigin
public class FoodController {

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private ProfileDao profileDao;

//    public class Example {
//        // Find your Account Sid and Token at twilio.com/user/account
//        public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
//        public static final String AUTH_TOKEN = "your_auth_token";
//
//        public static void main(String[] args) {
//            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//
//            Message message = Message.creator(new PhoneNumber("+15558675309"),
//                    new PhoneNumber("+15017250604"),
//                    "This is the ship that made the Kessel Run in fourteen parsecs?").create();
//
//            System.out.println(message.getSid());
//        }
//    }
    @GetMapping(path="/spam-jake")
    public void test() {
        String account_sid = "AC202a198c3c233ca429ba015a14cd5485";
        String auth_token = "cc7cc507dc5cc63670185ff2f3060bbd";

        Twilio.init(account_sid, auth_token );

        Message message = Message.creator(new PhoneNumber("+13307143204"),
                    new PhoneNumber("+18887911936"),
                    "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
    }


    @GetMapping()
    public List<Food> getAllFoodByUsername(Principal principal){
        return foodDao.getFoodByIdAndUsername(principal.getName());
    }

    @GetMapping(path="/{id}")
    public Food getSpecificFood(@PathVariable int id){
        return foodDao.getSpecificFood(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFood(Principal principal,@RequestBody Food food){
        int userId= profileDao.getUserIdByUsername(principal.getName());
        food.setUserId(userId);
        foodDao.createFood(food);
    }

    @PutMapping(path="/{id}")
    public void updateFood(Principal principal, @RequestBody Food food, @PathVariable int id){
        int userId= profileDao.getUserIdByUsername(principal.getName());
        food.setUserId(userId);
        food.setFoodId(id);
        boolean updated= foodDao.updateFood(food);
        if(!updated){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Food not updated");
        }
    }
    @DeleteMapping(path="/{id}")
    public void deleteFood(@PathVariable int id){
        boolean deleted= foodDao.deleteFood(id);
        if(!deleted){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Food not deleted");
        }
    }

    @GetMapping(path="/quickAdd")
    public List<Food> getQuickAddFoods(Principal principal) {
        return foodDao.getQuickAddFoods(principal.getName());
    }

    @GetMapping(path="/today")
    public List<Food> getTodaysFoodByDateAndUserName(Principal principal){
        return foodDao.getTodaysFood(principal.getName());
    }

}
