<template>
  <div id="app">
    <div class="header"><img src="~@/assets/banner.png" /></div>
    <div id="navbar">
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
      &nbsp; &nbsp;
      <a
        ><router-link
          v-bind:to="{ name: 'community' }"
          v-if="profile.publicPrivate === true && $store.state.token != ''"
          >Community</router-link
        ></a
      >
      &nbsp; &nbsp;
      <a
        ><router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        ></a
      >
    </div>
    <router-view />
  </div>
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
#app {
  font-size: 25px;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-decoration-line: none;
  font-weight: 900;
  color: #174c4f;
  text-align: center;
  justify-content: center;
}
h1 {
  display: flexbox;
  margin: 0%;
  padding: 0%;
}
body {
  display: flexbox;
  justify-content: center;
  text-align: center;
}

#navbar {
  overflow: hidden;
  background-color: #174c4f;
  display: flex;
  justify-content: center;
  align-items: flex-end;
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
  background-color: #f1f1f1;
  text-align: center;
  padding: 20px;
}
img {
  display: flex;

  width: 100%;
}

body.login {
  background-image: url("~@/assets/overnightOats.jpg");
  height: 200vh;
  background-size: cover;
  text-align: center;
}
div.home {
  width: 200vh;
}
div.home-background {
  background-image: url("~@/assets/omelete.jpg");
  background-size: cover;
  background-repeat: repeat;
  height: 200vh;
}
div.food-tracker {
  background-image: url("~@/assets/steak.jpg");
  background-size: cover;
  height: 200vh;
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
#food-log {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 35%;
}

#food-log td,
#food-log th {
  border: 1px solid #ddd;
  padding: 3px;
}

#food-log tr {
  background-color: #f2f2f2;
}

.tableHeader {
  vertical-align: middle;

  background-color: #174c4f;
  color: white;
}

#food-log th {
  padding-top: 12px;
  padding-bottom: 12px;

  background-color: #174c4f;
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

.mealType {
  font-size: 12px;
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

.form-container {
  background-color: #174c4f;
  color: white;
  text-align: center;

  border: solid grey 2px;
  border-radius: 10px;
  width: 460px;
  height: 620px;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;

  display: flex;

  font-size: large;
}

.form-form {
  height: 200px;
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
  background-color: whitesmoke;
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