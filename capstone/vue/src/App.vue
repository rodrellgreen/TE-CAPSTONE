<template>

  <div  id="app">
    <div  id="nav">
      
      <a> <router-link v-bind:to="{ name: 'home' }"><img src="~@/assets/techfitness.jpg">Home</router-link>&nbsp;|&nbsp; </a>
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
  background-color: #00ADEE;

  
}

img {
  width: 25%;
  justify-content: center;
  margin-right: 100%;
  margin-bottom: 0%;
  margin-left: 0%;
  
}

body.login {
  background-image: url("~@/assets/overnightOats.jpg");
  height: 100vh; 
}
div.home-background {
  background-image: url("~@/assets/omelete.jpg");
  height: 100vh; 
}

input {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.flex-outer li,
.flex-inner {
  display: flex;
  justify-content: center;
  
  align-items: center;
}

.flex-outer > li > input {
  flex: 1 0 1rem;
  
  max-width: 220px;
}

</style>