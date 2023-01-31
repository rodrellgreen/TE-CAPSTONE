<template>
<div class="home-background">
  <div class="home">
    <h1>Home</h1>
<<<<<<< HEAD
    <p v-if="$store.state.token == ''">You must be authenticated to see this
      
    </p>
    <router-link v-if="$store.state.token == ''" v-bind:to="{ name: 'login' }">Login</router-link>
=======
    <p>You must be authenticated to see this</p>
    <div class="create-profile-container">
    <router-link v-show:="this.profile != '' " v-bind:to="{ name: 'profile' }">Create Profile</router-link>
    </div>
>>>>>>> main
  </div>
</div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>

  .home-background {
    display: grid;
  }

  .create-profile-container {
    background-color: red;
    width: 20%;
    border: solid black 2px;
    border-radius: 5px;
  }
</style>