package com.techelevator.model;

import java.util.List;

public class Meal {

    private int mealId;
    private int userId;
    private String mealType;
    private List<Food> foods;

    public Meal(int userId, String mealType, List<Food> foods) {
        this.userId = userId;
        this.mealType = mealType;
        this.foods = foods;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
