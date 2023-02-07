<template>
  <v-app id="app">
    <v-container class="header"><img src="~@/assets/banner.png" /></v-container>
    <v-container id="navbar">
      <a></a>
      <a id="logo-container"
        ><router-link v-bind:to="{ name: 'home' }">
          <img id="logo" src="~@/assets/tef.jpg" />
          &nbsp;&nbsp;
        </router-link></a
      >
      <a
        ><router-link
          v-bind:to="{ name: 'home' }"
          v-if="$store.state.token != ''"
          >Home</router-link
        ></a
      >
      &nbsp;&nbsp;
      <a
        ><router-link
          v-bind:to="{ name: 'trackFood' }"
          v-if="$store.state.token != ''"
          >Food</router-link
        ></a
      >
      &nbsp;&nbsp;
      <a
        ><router-link
          v-bind:to="{ name: 'profile' }"
          v-if="$store.state.token != ''"
          >Profile</router-link
        ></a
      >

      <a
        ><router-link
          v-bind:to="{ name: 'community' }"
          v-if="profile.publicPrivate === true && $store.state.token != ''"
          >&nbsp; &nbsp;Community
        </router-link></a
      >
      &nbsp; &nbsp;
      <a
        ><router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        ></a
      >
    </v-container>
    <router-view />
  </v-app>
</template>

<script>
import profileService from "./services/ProfileService.js";
export default {
  name: "my-teams",
  data() {
    return {
      profile: {},
    };
  },
  created() {
    profileService.getProfile().then((response) => {
      this.profile = response.data;
    });
  },
  methods: {},
};
</script>


<style>

.graphComponent{
  float: left;
  width: 40%;
}
.progressComponent{
  float: right;
  width: 40%;
}
#app {
  font-size: 1 0 1rem;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-decoration-line: none;
  font-weight: 900;
  color: #174c4f;
  text-align: center;
  justify-content: center;
  display: flex;
  
  /* can be treated like a fallback */
  background-color: rgb(97, 96, 96);

  /* will be "on top", if browser supports it */
  background-image: linear-gradient(rgb(97, 96, 96), whitesmoke);

  /* these will reset other properties, like background-position, but it does know what you mean */
  background: rgb(97, 96, 96);
  background: linear-gradient(rgb(97, 96, 96), whitesmoke);


}


h1 {
  display: flexbox;
  margin: 0%;
  padding: 0%;
}
v-container {
  display: flexbox;
}

.profilePic{
  width: 25%;
  display: block;
  margin: 0 auto;
  border-radius: 25px;
  
}

.profile-container{
  display: flex;
  align-items: center;
  flex-direction: column;
  margin-left: auto;
  margin-right: auto;
  justify-content: center;
}

#navbar {
  
  background-color: #174c4f;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  text-align: right;
  justify-content: start;
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
  margin-right: 50vh;
  
  
}

.header {
  background-color: #f1f1f1;
  text-align: center;
  padding: 20px;
}
img {
  display: flex;
  
  width: 100%;
}

v-container.login {
  background-image: url("~@/assets/overnightOats.jpg");
  height: 200vh;
  background-size: cover;
  text-align: center;
}
v-container.home {
  width: 200vh;
}
v-container.home-background {
  background-image: url("~@/assets/omelete.jpg");
  background-size: cover;
  background-repeat: repeat;
  height: 200vh;
}
v-container.food-tracker {
  background-image: url("~@/assets/steak.jpg");
  background-size: cover;
  height: 200vh;

}

.quickMeals{
  text-decoration: none;
  color: whitesmoke;
}

/** Login Styling Below */

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
#foodLogTable {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  height: 100%;
  display: flex;
  padding: 0%;
  margin: 0%;
  border: 1px solid #ddd;
  border: solid black 2px;
  border-radius: 10px;
  flex-direction: column;
}

#streak {
  border: solid black 2px;
  border-radius: 10px;
  background-color: #174c4f;
  color: whitesmoke;
  width: 100%;
}


tr {
  background-color: #f2f2f2;
}

.tableHeader {
  vertical-align: middle;

  background-color: #174c4f;
  color: white;
}
.tableCaption{
  font: 2rem;
}

 th {


  background-color: #174c4f;
  color: white;
}

.card-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 50px;
  padding: 0px;

  border-radius: 25%;
}

#foodDiary {
  width: 100%;
  padding: 1%;
  display: flex;
  flex-direction: column;
  max-height: 500px;
}

/** Form Styling Below */

.mealType {
  font-size: 1rem;
}
.form-container {
  background: #174c4f;
  color: whitesmoke;
   border: solid black 2px;
  border-radius: 10px;
  padding: 0%;
  width: 50%;
  display: flex;
  flex-direction: column;
}
.flex-container {
 display: flex;
  padding: 2px;
  text-align: center;
  align-content: center;
  justify-content: center;
}

#quick-add {
  justify-content: right;
  display: flex;
}

.input-label {
  display: flex;
  font-size: 2rem;
}

label {
  margin-right: auto;
  display: flex;
  size: 2rem;

}
input{
  justify-content: center;
  display: flex;
  size: 1rem;
}

.input-box {
  background-color: whitesmoke;
  display: flex;
}

.cancel-btn {
  width: 95px;
}

v-btn {
  height: 32px;
  margin-left: auto;
  margin-right: auto;
}

.sr-only {
  margin: 5px;
}

.form-control {
  margin: 1%;
  height: 5%;
}

v-btn {
  margin-left: auto;
  margin-right: auto;
}

.router-link {
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 5%;
}
</style>