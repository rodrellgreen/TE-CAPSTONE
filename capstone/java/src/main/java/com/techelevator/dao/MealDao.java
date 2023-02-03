package com.techelevator.dao;

import com.techelevator.model.Meal;

import java.util.List;

public interface MealDao {

    void createMeal(Meal meal);

    List<Meal> getMeals(String userName);

    boolean updateMeal(Meal meal);

    boolean deleteMeal(int mealId);
    
}
