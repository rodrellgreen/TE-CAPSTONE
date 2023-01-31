package com.techelevator.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Profile {


    @Min(0)
    private int profileId;
    @Min(0)
    private int userId;
    @NotEmpty
    private String email;
    @Min(18)
    private int age;
    @Min(3)
    private int feet;
    @Min(0)
    private int inches;
    @Min(50)
    private double currentWeight;
    @Min(80)
    private double desiredWeight;
    private String profilePicture;
    @NotEmpty
    private String displayName;


    public Profile() {
    }

    public Profile(int profileId, int userId, String email, int age, int feet, int inches, double currentWeight, double desiredWeight, String profilePicture, String displayName) {
        this.profileId = profileId;
        this.userId = userId;
        this.email = email;
        this.age = age;
        this.feet = feet;
        this.inches = inches;
        this.currentWeight = currentWeight;
        this.desiredWeight = desiredWeight;
        this.profilePicture=profilePicture;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getDesiredWeight() {
        return desiredWeight;
    }

    public void setDesiredWeight(double desiredWeight) {
        this.desiredWeight = desiredWeight;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", feet=" + feet +
                ", inches=" + inches +
                ", currentWeight=" + currentWeight +
                ", desiredWeight=" + desiredWeight +
                ", profilePicture='" + profilePicture + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
