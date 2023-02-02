<template>
  
  <div  id="app">
    
    <div id="navbar">
      
      <a id="logo-container"><router-link v-bind:to="{ name: 'home' }">
        <img id="logo" src="~@/assets/techfitness.jpg">
        &nbsp;
        </router-link></a>
      
       <a><router-link v-bind:to="{ name: 'trackFood' }" v-if="$store.state.token != ''">Food Diary</router-link></a>
      &nbsp;
       <a><router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link></a>
      &nbsp; 
       <a><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link></a>
      
     
    </div>
    <router-view />
  </div>
  
</template>

<script>

</script>


<style>

#app {
  
 

  font-size: 25px;
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  text-decoration-line: none;
  font-weight: 900;
  color: green;
  text-align: center;
  justify-content: center;
  

  
}
h1{
  margin: 0%;
  padding: 0%;
}


#navbar {
  overflow: hidden;
  background-color: #333;
  display: flex;
  justify-content: center;
  align-items: end;
  text-align: center;
  
  
}
#navbar a {
  float: left;
  display: flex;
  color: #f2f2f2;
  padding: 0px;
  text-decoration: none;

}

#logo {
  width: 100px;
 
}


body.login {
  background-image: url("~@/assets/overnightOats.jpg");
  height: 200vh; 
  background-size: cover;
  text-align: center;
  
}
div.home-background {
  background-image: url("~@/assets/avocadotoast.png");
  background-size: cover; 
  height: 200vh;

}
div.food-tracker {
  background-image: url("~@/assets/steak.jpg");
  height: 200vh; 
  background-color: navy;

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

#food-log {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 50%;
  align-content: center;
  
  
}

#food-log td, #food-log th {
  border: 1px solid #ddd;
  padding: 5px;
}

#food-log tr:nth-child(even){background-color: #f2f2f2;}

#food-log tr:hover {background-color: #ddd;}

#food-log th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
  
}

.card-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 50px;
    padding: 0px;
    background-color: navy;
    border-radius: 25%;

  }

 

</style>