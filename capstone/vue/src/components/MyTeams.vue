<template>
  <div>
    <h2>My Teams</h2>
    <ul>
      <li v-for="team in myTeams" :key="team.teamId">
        <router-link :to="{ name: 'team', params: { teamIndex: team.teamId } }">
          {{ team.teamName }}</router-link
        >
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
  methods: {},
};
</script>

<style>
</style>





