<template>
  <div>
    <form id="addTeam" @submit="createTeam()" action="">
      <h2>Create Your Own Team</h2>
      <label for="teamName">Enter Your Team Name: </label>
      <input id="teamName" type="text" v-model="newTeam.teamName" required />
    </form>
  </div>
</template>

<script>
import teamService from "../services/TeamService.js";
export default {
  name: "create-team",
  data() {
    return {
      newTeam: {},
    };
  },

  methods: {
    createTeam() {
      teamService.createATeam(this.newTeam).then((response) => {
        if (response.status == 201) {
          alert("New Team Created!");
          window.location.reload();
        }
      });
    },
  },
};
</script>

<style>
</style>