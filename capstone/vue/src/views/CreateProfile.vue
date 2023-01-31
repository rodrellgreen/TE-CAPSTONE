<template>
  <div id="create-profile" class="create-profile"> 
      <form class="profile-form" @submit.prevent="createProfile">
          <h1>Create Your Profile</h1>
          <div class="flex-container">
          <label for="email" class="input label">Email Address:</label>
          <input
            type="text"
            id="email"
            class="input-box"
            placeholder="email"
            v-model="newProfile.emailAddress"
            required
            autofocus
            />
          </div>
          <div class="flex-container">
          <label for="age" class="input-label">Age:</label>
          <input
            type="number"
            id="age"
            class="input-box"
            placeholder="age"
            v-model="newProfile.age"
            required
            autofocus
            />
          </div>
          <div class="flex-container">
          <label for="height-feet" class="input-label">Height (ft):</label>
          <input
            type="number"
            id="height-feet"
            class="input-box"
            placeholder="height (ft)"
            v-model="newProfile.heightFeet"
            required
            autofocus
            />
          </div>
          <div class="flex-container">
          <label for="height-inches" class="input-label">Height (in):</label>
          <input
            type="number"
            id="height-inches"
            class="input-box"
            placeholder="height (in)"
            v-model="newProfile.heightInches"
            required
            autofocus
            />
          </div>
          <div class="flex-container">
          <label for="current-weight" class="input-label">Current Weight:</label>
          <input
            type="number"
            id="current-weight"
            class="input-box"
            placeholder="current weight"
            v-model="newProfile.currentWeight"
            required
            autofocus
            />
          </div>
          <div class="flex-container">
          <label for="desired-weight" class="input-label">Desired Weight:</label>
          <input
            type="number"
            id="desired-weight"
            class="input-box"
            placeholder="desired weight"
            v-model="newProfile.desiredWeight"
            required
            autofocus
            />
          </div>
          <div class="button-container">
          <button class="create-profile-button" type="submit">
              Create Profile
          </button>
          </div>
      </form>
  </div>
</template>

<script>
import ProfileService from '../services/ProfileService.js'

export default {

    name: "profile",

    data() {
       return {
           
        newProfile: {
            emailAddress: '',
            age: '',
            heightFeet: '',
            heightInches: '',
            currentWeight: '',
            desiredWeight: '',
        },
       }
    },

    methods: {
        createProfile(newProfile) {
            ProfileService.addProfile(newProfile).then(
                (response) => {
                    if(response.status === 201) {
                        window.alert("Success! Profile added.");
                        this.$router.push('/');
                    }
                }
            )
        }
    }

}
</script>

<style>

    #create-profile {
        background-color: #7DA27E;
        color: white;
        text-align: center;
        padding: 10px;
        margin: 10px;
        border: solid grey 2px;
        width: 460px;
        height: 620px;
        margin: auto;
        margin-top: 50px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-evenly;
        font-size: x-large;
    }

    .profile-form {
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: space-around;
        align-items: flex-start;
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

    .button-container {
        display: flex;
    }

    .create-profile-button {
        height: 32px;
        margin-left: 140px;
    }

</style>