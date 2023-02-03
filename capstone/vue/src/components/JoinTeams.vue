<template>
  <div>
    <h2>Available Teams</h2>
    <ul v-for="team in this.allTeams" :key="team.teamId">
      <li>
        {{ team.teamName
        }}<span v-if="isOnTeam(team.teamId)"
          ><button v-on:click="removeUserFromTeam(team.teamId)">
            Leave Team
          </button></span
        ><span v-else
          ><button v-on:click="addUserToTeam(team)">Join Team</button></span
        >
      </li>
    </ul>
  </div>
</template>

<script>
import teamService from "../services/TeamService.js";
export default {
  name: "join-teams",
  data() {
    return {
      allTeams: [],
      members: [],
      userTeams: [],
    };
  },
  created() {
    teamService.getAllAvailableTeams().then((response) => {
      this.allTeams = response.data;
    });

    teamService.getUsersTeams().then((response) => {
      this.userTeams = response.data;
    });
  },
  computed: {},
  methods: {
    addUserToTeam(team) {
      teamService.addUserToTeam(team).then((response) => {
        if (response.status == 201) {
          alert(`You have joined ${team.teamName}`);
          window.location.reload();
        }
      });
    },
    removeUserFromTeam(teamId) {
      teamService.removeUserFromTeam(teamId).then((response) => {
        if (response.status == 200) {
          alert("Removed from team");
          window.location.reload();
        }
      });
    },
    getMembersOfTeam(teamId) {
      teamService.getMembersOfTeam(teamId).then((response) => {
        this.members = response.data;
      });
    },
    isOnTeam(teamId) {
      return this.userTeams.some((team) => team.teamId == teamId);
    },
  },
};
</script>

<style>
</style>