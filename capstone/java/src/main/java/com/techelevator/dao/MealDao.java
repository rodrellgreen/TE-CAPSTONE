package com.techelevator.dao;

import com.techelevator.model.Meal;

import java.util.List;

public interface MealDao {

    void createMeal(int userId, String mealType);

    void addFoodsToMeal(int mealId, int foodId);

    List<Meal> getMeals(int userId);

    boolean updateMealType(Meal meal);

    boolean updateMealFood(int mealId, int foodId);

    void deleteMeal(int mealId);
    
}
