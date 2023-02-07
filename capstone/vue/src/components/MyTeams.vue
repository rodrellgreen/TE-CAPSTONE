<template>
  <v-container>
    <v-container class="myTeams">
      <h2 class="text-center">My Teams</h2>

      <v-list>
        <v-list-item v-for="team in myTeams" :key="team.teamId">
          <v-list-item-content>
            <router-link
              :to="{ name: 'team', params: { teamIndex: team.teamId } }"
            >
              {{ team.teamName }}</router-link
            >
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-container>
  </v-container>
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





