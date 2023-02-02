<template>
<div class="home-background">
  <div class="home">
    <h1>Home</h1>
    <p v-if="$store.state.token == ''">You must be authenticated to see this
      
    </p>
    <router-link v-if="$store.state.token == ''" v-bind:to="{ name: 'login' }">Login</router-link><br>
    <recent-food/>
  </div>
  
</div>
</template>

<script>
import RecentFood from '../components/RecentFood.vue'


export default {
  name: "home",
  components:{
  RecentFood
}
}
  
</script>
