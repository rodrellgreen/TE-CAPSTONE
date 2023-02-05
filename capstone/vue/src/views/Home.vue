<template>
<div class="home-background">
  <div class="home">
    <h1>Home</h1>
    <p v-if="$store.state.token == ''">You must be authenticated to see this
      
    </p>
    <router-link v-if="$store.state.token == ''" v-bind:to="{ name: 'login' }">Login</router-link><br>
    <weekly-graph/>
    <streak-tracker/>
    <calorie-counter/>
    <recent-food/>
  </div>
  
</div>
</template>

<script>
import RecentFood from '../components/RecentFood.vue'
import CalorieCounter from '../components/CalorieCounter.vue'
import StreakTracker from '../components/StreakTracker.vue'
import WeeklyGraph from '../components/WeeklyGraph.vue'

export default {
  name: "home",
  components:{
  RecentFood,
  CalorieCounter,
  StreakTracker,
  WeeklyGraph

}
}
  
</script>
