package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.TeamDao;
import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @PreAuthorize("isAuthenticated()")
    @RestController
    @CrossOrigin
    @RequestMapping(path="/teams")
    public class TeamController {

        @Autowired
        TeamDao teamDao;

        @Autowired
        UserDao userDao;

        @Autowired
        ProfileDao profileDao;


        @GetMapping(path = "/{teamName}/members")
        public List<String> getTeamMembersForSpecificTeam(@PathVariable String teamName){
            return teamDao.getDisplayNamesFromTeam(teamName);
        }
    }

