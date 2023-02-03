<template>
  <div>
    <ul v-for="team in this.$store.state.allTeams" :key="team.teamId">
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
      this.$store.commit("ALL_TEAMS", this.allTeams);
    });

    teamService.getUsersTeams().then((response) => {
      this.userTeams = response.data;
      this.$store.commit("USER_TEAMS", this.userTeams);
    });
  },
  computed: {},
  methods: {
    addUserToTeam(team) {
      teamService.addUserToTeam(team).then((response) => {
        if (response.status == 201) {
          alert(`You have joined ${team.teamName}`);
          this.$router.push("/community");
        }
      });
    },
    removeUserFromTeam(teamId) {
      teamService.removeUserFromTeam(teamId).then((response) => {
        if (response.status == 200) {
          alert("Removed from team");
          this.$router.push("/community");
        }
      });
    },
    getMembersOfTeam(teamId) {
      teamService.getMembersOfTeam(teamId).then((response) => {
        this.members = response.data;
      });
    },
    isOnTeam(teamId) {
      return this.$store.state.userTeams.some((team) => team.teamId == teamId);
    },
  },
};
</script>

<style>
</style>