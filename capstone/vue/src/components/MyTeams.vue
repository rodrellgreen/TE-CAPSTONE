<template>
  <div>
    <h2>My Teams</h2>
    <ul>
      <li v-for="team in myTeams" :key="team.teamId" @click="showDetails(team)">
        {{ team.teamName }}
      </li>
    </ul>
  </div>
</template>

<script>
import teamService from "../services/TeamService.js";
export default {
  name: "my-teams",
  data() {
    return {
      myTeams: [],
    };
  },
  created() {
    teamService.getUsersTeams().then((response) => {
      this.myTeams = response.data;
    });
  },
  methods: {
    showDetails(team) {
      this.$router.push({
        name: "team",
        params: { id: team.teamId },
      });
    },
  },
};
</script>

<style>
</style>