package com.techelevator.dao;

import com.techelevator.model.Profile;

import java.util.List;

public interface ProfileDao {

    Profile getProfileById(int id);

    Profile findByUsername(String username);

    boolean updateEmail(Profile profile);

    boolean updateAge(Profile profile);

    boolean updateFeet(Profile profile);

    boolean updateInches(Profile profile);

    boolean updateCurrentWeight(Profile profile);

    boolean updateDesiredWeight(Profile profile);

    boolean deleteProfile(String username);

    Profile createProfile(Profile profile);

    int getUserIdByUsername(String username);

    int getProfileIdByUsername(String username);
}
