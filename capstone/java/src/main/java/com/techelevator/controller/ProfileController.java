package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping(path="/profile")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
@RestController
public class ProfileController {
    @Autowired
    private ProfileDao profileDao;

    @GetMapping(path="/users")
    public Profile getProfileByUserId(Principal principal){
        return profileDao.findByUsername(principal.getName());
    }

    @PostMapping()
    public Profile createProfile(@Valid @RequestBody Profile profile){
        return null;
    }

    @DeleteMapping
    public void deleteProfile(Principal principal){
        boolean deleted=profileDao.deleteProfile(principal.getName());
        if(!deleted){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Profile Not Deleted");
        }
    }
    @PutMapping()
    public void updateProfile(Principal principal, @Valid @RequestBody Profile profile){
        int id=profileDao.getProfileIdByUsername(principal.getName());
        profile.setProfileId(id);
        boolean updated=profileDao.updateEmail(profile);
        boolean updated2=profileDao.updateAge(profile);
        boolean updated3=profileDao.updateFeet(profile);
        boolean updated4=profileDao.updateInches(profile);
        boolean updated5=profileDao.updateCurrentWeight(profile);
        boolean updated6=profileDao.updateDesiredWeight(profile);

        if(!updated||!updated2||!updated3||!updated4||!updated5||!updated6){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Profile Not Updated");
        }
    }









}
