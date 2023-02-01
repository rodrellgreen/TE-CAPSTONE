<template>
<div class="home-background">
  <div class="home">
    <h1>Home</h1>
    <p v-if="$store.state.token == ''">You must be authenticated to see this
      
    </p>
    <router-link v-if="$store.state.token == ''" v-bind:to="{ name: 'login' }">Login</router-link><br>
    <router-link v-bind:to="{ name: 'profile'}">Profile</router-link>
  </div>
  <div>
      <recent-food/>
  </div>
</div>
</template>

<script>
import RecentFood from '../components/FoodTrackerForm.vue'


export default {
  name: "home",
  components:{
  RecentFood
}
}
  
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