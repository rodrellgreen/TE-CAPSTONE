<template>
  <v-container>
    <join-teams />
    <my-teams />
    <create-team />
  </v-container>
</template>

<script>
import CreateTeam from "../components/CreateTeam.vue";
import JoinTeams from "../components/JoinTeams.vue";
import MyTeams from "../components/MyTeams.vue";
export default {
  components: { JoinTeams, MyTeams, CreateTeam },
};
</script>

<style>
</style>