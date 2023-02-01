package com.techelevator.dao;

import com.techelevator.model.Food;

import java.util.List;

public interface FoodDao {

    int getFoodIdByUsername(String userName);

    List<Food> getFoodByIdAndUsername(String userName);

    void createFood(Food food);

    boolean updateFood(Food food);

    boolean deleteFood(Food food);

    List<Food> listAllFoods();

}