package com.techelevator.controller;

import com.techelevator.dao.MealDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequestMapping(path = "/meals")
@RestController
@CrossOrigin
public class MealController {

    @Autowired
    MealDao mealDao;

    @Autowired
    UserDao userDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createMeal(Principal principal, String mealType) {
        String userName = principal.getName();
        int userId = userDao.findIdByUsername(userName);
        mealDao.createMeal(userId, mealType);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public void addFoodToMeal(@PathVariable int foodId, @RequestBody Meal meal) {
        mealDao.addFoodsToMeal(meal.getMealId(), foodId);
    }

    @GetMapping()
    public List<Meal> getMeals(Principal principal) {
        String userName = principal.getName();
        int userId = userDao.findIdByUsername(userName);
        return mealDao.getMeals(userId);
    }

    @PutMapping()
    public boolean updateMealType(@RequestBody Meal meal) {
        return mealDao.updateMealType(meal);
    }

    @PutMapping("/{id}")
    public boolean updateMealFood(@PathVariable int foodId, @RequestBody Meal meal) {
        int mealId = meal.getMealId();
        return mealDao.updateMealFood(mealId, foodId);
    }

    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable int mealId) {
        mealDao.deleteMeal(mealId);
    }

}
