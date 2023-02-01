package com.techelevator.dao;

import com.techelevator.model.Food;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFoodDao implements FoodDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcFoodDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int getUserIdByUsername(String username){
        int userId=0;
        String sql="SELECT user_id FROM users u " +
                "WHERE username=?";
        try{
            userId=jdbcTemplate.queryForObject(sql,Integer.class,username);
        }catch(DataAccessException e){
            System.out.println("Error");
        }
        return userId;
    }

    @Override
    public int getFoodIdByUsername(String userName) {
        int id = 0;
        String sql = "SELECT food_id FROM food " +
                "JOIN users ON users.user_id = food.user_id" +
                " WHERE users.username =?;";
        try {
            id = jdbcTemplate.queryForObject(sql, Integer.class, userName);
        } catch (DataAccessException e) {
            System.out.println("Error");
    }

        return id;
    }

    @Override
    public List<Food> getFoodByIdAndUsername(String userName) {
        List<Food> food = new ArrayList<>();
        String sql="SELECT * FROM food where user_id = ?";
        int id = getUserIdByUsername(userName);
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()){
            food.add(mapRowToFood(results));
        }
        return food;
    }

    @Override
    public void createFood(Food food) {
        String sql = "Insert INTO food (food_name, user_id, date_entered, calories, carbs, protein" +
                ", fats, fiber, serving_size) VALUES (?,?,?,?,?,?,?,?,?) " +
                "RETURNING food_id";

        Integer foodId = jdbcTemplate.queryForObject(sql, Integer.class,food.getType(),food.getUserId(),food.getDate(), food.getCalories(), food.getCarbs(), food.getProtein(), food.getFats(), food.getFiber(), food.getServingSize());

    }

    @Override
    public boolean updateFood(Food food) {
        boolean success = false;

        String sql = "UPDATE food SET food_name = ?, calories = ?, carbs = ?, protein = ?, fats = ?, fiber = ?, serving_size = ?, date_entered = ? WHERE food_id = ?";

        int linesUpdated = jdbcTemplate.update(sql, food.getType(), food.getCalories(), food.getCarbs(), food.getProtein(), food.getFats(), food.getFiber(), food.getServingSize(), food.getDate(), food.getFoodId() );
        if (linesUpdated == 1){
            success = true;
        }
        return success;
    }

    @Override
    public boolean deleteFood(int id) {
        boolean success = false;
        String sql = "DELETE FROM food WHERE food_id = ?";

        int linesUpdated = jdbcTemplate.update(sql,id);

        if (linesUpdated == 1){
            success = true;
        }
        return success;
    }

    @Override
    public List<Food> listAllFoods() {
        List<Food> food = new ArrayList<>();
        String sql = "SELECT * FROM food";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            food.add(mapRowToFood(results));
        }
        return food;
    }

    private Food mapRowToFood(SqlRowSet results) {
        Food food = new Food();
        food.setFoodId(results.getInt("food_id"));
        food.setUserId(results.getInt("user_id"));
        food.setType(results.getString("food_name"));
        food.setCalories(results.getDouble("calories"));
        food.setCarbs(results.getDouble("carbs"));
        food.setProtein(results.getDouble("protein"));
        food.setFats(results.getDouble("fats"));
        food.setFiber(results.getDouble("fiber"));
        food.setServingSize(results.getDouble("serving_size"));
        food.setDate(results.getDate("date_entered"));
        return food;
    }
}
