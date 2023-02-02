<template>
<div class="home-background">
  <div class="home">
    <h1>Home</h1>
    <p v-if="$store.state.token == ''">You must be authenticated to see this
      
    </p>
    <router-link v-if="$store.state.token == ''" v-bind:to="{ name: 'login' }">Login</router-link><br>
    <calorie-counter/>
    <recent-food/>
  </div>
  
</div>
</template>

<script>
import RecentFood from '../components/RecentFood.vue'
import CalorieCounter from '../components/CalorieCounter.vue'

export default {
  name: "home",
  components:{
  RecentFood,
  CalorieCounter
}
}
  
</script>
