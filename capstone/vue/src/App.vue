<template>
  
  <div  id="app">
    <div class="header"><img src="~@/assets/banner.png" ></div>
    <div id="navbar">
      <a></a>
      <a id="logo-container"><router-link v-bind:to="{ name: 'home' }">
        <img id="logo" src="~@/assets/tef.jpg">
        &nbsp;&nbsp;
        </router-link></a>
      
      <a><router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link></a>
      &nbsp;&nbsp;
       <a><router-link v-bind:to="{ name: 'trackFood' }" v-if="$store.state.token != ''">Food</router-link></a>
      &nbsp;&nbsp;
       <a><router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''">Profile</router-link></a>
      &nbsp; &nbsp;
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
  color: #174C4F;
  text-align: center;
  justify-content: center; 
}
h1{
  display: flexbox;
  margin: 0%;
  padding: 0%;
  
}
body{
  display: flexbox;
  justify-content: center;
  text-align: center;

}


#navbar {
  overflow: hidden;
  background-color:#174C4F;
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
  display: flex;
  width: 25%;
  text-align: center;
 
}

.header {
  background-color: #F1F1F1;
  text-align: center;
  padding: 20px;


}
img{
  display: flex;
  
  width: 100%;
}


body.login{
  background-image: url("~@/assets/overnightOats.jpg");
  height: 200vh; 
  background-size: cover;
  text-align: center;
 
  
  
}
div.home{
  width: 200vh;
}
div.home-background {
  background-image: url("~@/assets/omelete.jpg");
  height: 200vh; 
  display: flex;
 

}
div.food-tracker {
  background-image: url("~@/assets/steak.jpg");
  height: 200vh; 
 

}



 /** Login Styling Below */

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

 /** Food Tables/Logs Styling Below */
#food-log {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 35%;
 
  
  
}

#food-log td, #food-log th {
  border: 1px solid #ddd;
  padding: 3px;
}

#food-log tr:nth-child(even){background-color: #f2f2f2;}

#food-log tr:hover {background-color: #ddd;}

#food-log th {
  padding-top: 12px;
  padding-bottom: 12px;
 
  background-color: #04AA6D;
  color: white;
  
}

.card-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 50px;
    padding: 0px;
   
    border-radius: 25%;

  }

  /** Form Styling Below */
  
    #form-container {
        background-color: #174C4F;
        color: white;
        text-align: center;
        padding: 10px;
        margin: 10px;
        border: solid grey 2px;
        border-radius: 10px;
        width: 460px;
        height: 620px;
        margin: auto;
        margin-top: 50px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-evenly;
        font-size: large;
    }

    .form-form {
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: flex-end;
    }

    .input-label {
        margin-right: 10px;
    }

    label {
        margin-right: 6px;
    }

    .input-box {
      margin-left: 10px;  
      height: 25px;
    }

    .cancel-btn {
      width: 95px;
    }

    button {
        height: 32px;
        margin-left: auto;
        margin-right: auto;
    }

 .sr-only {
    margin: 5px;
  }

  .form-control {
    margin: 5px;
    height: 20px;
  }

  button {
    margin-left: auto;
    margin-right: auto;
  }

  .router-link {
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 5%;
  }


 

</style>