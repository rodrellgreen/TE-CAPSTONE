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

    @GetMapping()
    public Profile getProfileByUsername(Principal principal){
        return profileDao.findProfileByUsername(principal.getName());
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Profile createProfile(Principal principal, @Valid @RequestBody Profile profile){
        int userID=profileDao.getUserIdByUsername(principal.getName());
        profile.setUserId(userID);

        return profileDao.createProfile(profile);
    }

    @DeleteMapping
    public void deleteProfile(Principal principal){
        boolean deleted=profileDao.deleteProfile(principal.getName());
        if(!deleted){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Profile Not Deleted");
        }
    }

    @PutMapping()
    public void updateProfile(Principal principal,  @Valid @RequestBody Profile profile){
        int profileId=profileDao.getProfileIdByUsername(principal.getName());
        int userId=profileDao.getUserIdByUsername(principal.getName());
        profile.setProfileId(profileId);
        profile.setUserId(userId);
        boolean updated=profileDao.updateProfile(profile);

       if(!updated){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Profile Not Updated");
        }
    }









}
