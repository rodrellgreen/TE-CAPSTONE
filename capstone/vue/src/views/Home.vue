<template>
<div class="home-background">
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link v-show:="this.profile != '' " v-bind:to="{ name: 'profile' }">Create Profile</router-link>
  </div>
</div>
</template>

<script>
export default {
  name: "home"
};
</script>
 
 {

 }