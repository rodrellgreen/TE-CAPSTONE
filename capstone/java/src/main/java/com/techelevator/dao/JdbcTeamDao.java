package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.Team;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcTeamDao implements TeamDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTeamDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


    private Team mapRowToTeam(SqlRowSet results){
        Team team=new Team();
        team.setTeamId(results.getInt("team_id"));
        team.setTeamName(results.getString("team_name"));
        return team;
    }
}
