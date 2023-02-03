<template>
  <div>
    <join-teams />
    <my-teams />
    <create-team />
  </div>
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