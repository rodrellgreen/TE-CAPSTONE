<template>

  <div id="app">
    <div id="nav">
      <img src="src\assets\techfitness-logo.jpg">
      <a><router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; </a>
      <a><router-link v-bind:to="{ name: 'food' }">Food Diary</router-link></a>
      &nbsp;|&nbsp;
      <a><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout </router-link> </a>
      
      
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  text-align: center;
  border-bottom-width: 5px;
  border-bottom-color: crimson;
  
  
}
img {
  width: 15%;
  height: 50%;
  margin-right: 35%;
  margin-left: 0%;
}

</style>