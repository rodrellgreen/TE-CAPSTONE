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

    @Override
    public void createTeam(Team team) {
        String sql="INSERT INTO teams (team_name) VALUES (?) RETURNING team_id;";
        Integer id=jdbcTemplate.queryForObject(sql,Integer.class, team.getTeamName());
    }

    @Override
    public Team getTeam(int id) {
        String sql="SELECT * FROM teams WHERE team_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        Team team=new Team();
        if(results.next()){
            team=mapRowToTeam(results);
        }
        return team;
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teamsList=new ArrayList<>();
        String sql="SELECT * FROM teams";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            teamsList.add(mapRowToTeam(results));
        }
        return teamsList;

    }

    @Override
    public boolean updateTeam(Team team) {
        boolean success=false;
        String sql="UPDATE teams SET team_name=? WHERE team_id=?";
        int linesUpdated= jdbcTemplate.update(sql,team.getTeamName(), team.getTeamId());
        if(linesUpdated==1){
            success=true;
        }
        return success;
    }

    @Override
    public boolean deleteTeam(int id) {
        boolean success=false;
        String sql="DELETE FROM teams WHERE team_id=?;";
        int linesUpdated= jdbcTemplate.update(sql,id);
        if(linesUpdated==1){
            success=true;
        }
        return success;
    }

    @Override
    public int getTeamIdByTeamName(String name) {
        String sql="SELECT team_id FROM teams WHERE team_name=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,name);

    }

    @Override
    public boolean updateUsersOnTeam(String teamName, String displayName) {
        String sql="UPDATE users_teams SET team_id=? WHERE user_id=?";
        boolean success=false;
        int teamId=getTeamIdByTeamName(teamName);
        int userId=getUserIdFromDisplayName(displayName);
        int linesUpdated= jdbcTemplate.update(sql,teamId,userId);
        if(linesUpdated==1){
            success=true;
        }
        return success;
    }

    @Override
    public int getUserIdFromDisplayName(String displayName) {
        String sql="SELECT user_id FROM profile WHERE display_name =?";
        Integer id=jdbcTemplate.queryForObject(sql,Integer.class,displayName);
        return id;
    }

    @Override
    public void addUserToTeam(String teamName,String displayName) {
        String sql="INSERT INTO users_teams (team_id,user_id)";
        int teamId=getTeamIdByTeamName(teamName);
        int userId=getUserIdFromDisplayName(displayName);
        jdbcTemplate.update(sql,teamId,userId);
    }


    @Override
    public List<String> getDisplayNamesFromTeam(String teamName) {

        int teamId=getTeamIdByTeamName(teamName);
        String sql="SELECT display_name FROM profile p "+
                "JOIN users_teams ut ON ut.user_id=p.user_id "+
                "WHERE ut.team_id=?";
        return jdbcTemplate.queryForList(sql,String.class,teamId);

    }


    private Team mapRowToTeam(SqlRowSet results){
        Team team=new Team();
        team.setTeamId(results.getInt("team_id"));
        team.setTeamName(results.getString("team_name"));
        return team;
    }


}



