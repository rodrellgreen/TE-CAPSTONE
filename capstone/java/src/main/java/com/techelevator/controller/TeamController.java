package com.techelevator.controller;


import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequestMapping(path="/teams")
@RestController
@CrossOrigin
public class TeamController {

    @Autowired
    TeamDao teamDao;

    @Autowired
    ProfileDao profileDao;


    @GetMapping(path = "/{teamId}/members")
        public List<String> getTeamMembersForSpecificTeam(@PathVariable int teamId){
            return teamDao.getDisplayNamesFromTeamId(teamId);
        }

        @GetMapping()
        public String getTeamForMember(Principal principal){
            int profileId= profileDao.getProfileIdByUsername(principal.getName());
            String displayName=profileDao.getDisplayNameFromProfileId(profileId);

            return teamDao.getUsersTeam(displayName);
        }

}
