package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
@Component
public class JdbcProfileDao implements ProfileDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int getProfileIdByUsername(String username){
        int profileId=0;
        String sql="SELECT profile_id FROM profile p" +
                "JOIN users u ON p.user_id=u.user_id "+
                "WHERE username=?";
        try{
            profileId=jdbcTemplate.queryForObject(sql,Integer.class,username);
        }catch(DataAccessException e){
            System.out.println("Error");
        }
        return profileId;
    }

    @Override
    public int getUserIdByUsername(String username){
        int userId=0;
        String sql="SELECT user_id FROM users u" +
                "JOIN profile p ON p.user_id=u.user_id "+
                "WHERE username=?";
        try{
            userId=jdbcTemplate.queryForObject(sql,Integer.class,username);
        }catch(DataAccessException e){
            System.out.println("Error");
        }
        return userId;
    }

    @Override
    public Profile getProfileById(int id) {
        String sql="SELECT * FROM profile WHERE profile_id=?;";
        SqlRowSet results=jdbcTemplate.queryForRowSet(sql,id);
        Profile profile=new Profile();
        if(results.next()){
            profile=mapRowToProfile(results);
        }
        return profile;
    }

    @Override
    public Profile findByUsername(String username) {
        String sql="SELECT * FROM profile p" +
                "JOIN users u ON p.user_id=u.user_id "+
                "WHERE username=?";
        SqlRowSet results=jdbcTemplate.queryForRowSet(sql,username);
        Profile profile=new Profile();
        if(results.next()){
            profile=mapRowToProfile(results);
        }
        return profile;
    }

    @Override
    public boolean updateEmail(Profile profile) {
        boolean success=false;
        String sql="UPDATE profile SET email=? WHERE profile_id=?;";
        int linesUpdated=jdbcTemplate.update(sql,profile.getEmail(),profile.getProfileId());
        if(linesUpdated==1) {
            success = true;
        }
        return success;
    }
    @Override
    public boolean updateAge(Profile profile) {
        boolean success=false;
        String sql="UPDATE profile SET age=? WHERE profile_id=?;";
        int linesUpdated=jdbcTemplate.update(sql,profile.getAge(),profile.getProfileId());
        if(linesUpdated==1) {
            success = true;
        }
        return success;
    }
    @Override
    public boolean updateFeet(Profile profile) {
        boolean success=false;
        String sql="UPDATE profile SET height_feet=? WHERE profile_id=?;";
        int linesUpdated=jdbcTemplate.update(sql,profile.getFeet(),profile.getProfileId());
        if(linesUpdated==1) {
            success = true;
        }
        return success;
    }
    @Override
    public boolean updateInches(Profile profile) {
        boolean success=false;
        String sql="UPDATE profile SET height_inches=? WHERE profile_id=?;";
        int linesUpdated=jdbcTemplate.update(sql,profile.getInches(),profile.getProfileId());
        if(linesUpdated==1) {
            success = true;
        }
        return success;
    }
    @Override
    public boolean updateCurrentWeight(Profile profile) {
        boolean success=false;
        String sql="UPDATE profile SET current_weight=? WHERE profile_id=?;";
        int linesUpdated=jdbcTemplate.update(sql,profile.getCurrentWeight(),profile.getProfileId());
        if(linesUpdated==1) {
            success = true;
        }
        return success;
    }
    @Override
    public boolean updateDesiredWeight(Profile profile) {
        boolean success=false;
        String sql="UPDATE profile SET desired_weight=? WHERE profile_id=?;";
        int linesUpdated=jdbcTemplate.update(sql,profile.getDesiredWeight(),profile.getProfileId());
        if(linesUpdated==1) {
            success = true;
        }
        return success;
    }

    @Override
    public boolean deleteProfile(String username) {
        boolean success=false;
        String sql="DELETE FROM profile p " +
                "JOIN users u ON p.user_id=u.user_id "+
                "WHERE username=?";
        int linesUpdated=jdbcTemplate.update(sql,username);
        if(linesUpdated==1){
            success=true;
        }
        return success;
    }

    @Override
    public Profile createProfile(Profile profile, String username) {
        String sql="INSERT INTO profile (user_id, email, age, height_feet, height_inches, " +
                "current_weight, desired_weight) VALUES (?,?,?,?,?,?,?) RETURNING profile_id";
        
        Integer profileId=jdbcTemplate.queryForObject(sql,Integer.class,profile.getUserId(),profile.getEmail(),profile.getAge(),
        profile.getFeet(),profile.getInches(),profile.getCurrentWeight(),profile.getDesiredWeight());

        return getProfileById(profileId);
    }


    private Profile mapRowToProfile(SqlRowSet results){
        Profile profile=new Profile();
        profile.setProfileId(results.getInt("profile_id"));
        profile.setUserId(results.getInt("user_id"));
        profile.setEmail(results.getString("email"));
        profile.setAge(results.getInt("age"));
        profile.setFeet(results.getInt("height_feet"));
        profile.setInches((results.getInt("height_inches")));
        profile.setCurrentWeight(results.getDouble("current_weight"));
        profile.setDesiredWeight(results.getDouble("desired_weight"));
        return profile;
    }
}
