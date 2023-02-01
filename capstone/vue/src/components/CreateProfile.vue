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
            v-model="newProfile.email"
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
            v-model="newProfile.feet"
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
            v-model="newProfile.inches"
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
          <div class="flex-container">
          <label for="displayName" class="input-label">DisplayName:</label>
          <input
            type="text"
            id="displayName"
            class="input-box"
            placeholder="display name"
            v-model="newProfile.displayName"
            required
            autofocus
            />
          </div>
          <div class="flex-container">
          <label for="profilePic" class="input-label">Add Profile Picture:</label>
          <input
            type="text"
            id="profilePic"
            class="input-box"
            placeholder="profile picture url"
            v-model="newProfile.profilePicture"
            autofocus
            />
          </div>
          <button class="create-profile-button" type="submit">
              Create Profile
          </button>
          <button class="cancel-btn" v-on:click.prevent="sendHome">
              Cancel
          </button>
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
            email: '',
            age: null,
            feet: null,
            inches: null,
            currentWeight: null,
            desiredWeight: null,
            displayName: '',
            profilePicture: ''
        },
       }
    },

    methods: {
      createProfile() {
          ProfileService.addProfile(this.newProfile).then(
              (response) => {
                  if(response.status === 201) {
                    // add to store??
                    alert("Success! Profile added.");
                    this.$router.push('/');
                  }
            } 
          );
      },

      sendHome() {
        this.newProfile.email = '';
        this.newProfile.age = null;
        this.newProfile.feet = null;
        this.newProfile.inches = null;
        this.newProfile.currentWeight = null;
        this.newProfile.desiredWeight = null;
        this.newProfile.displayName = '';
        this.newProfile.profilePicture = '';
        this.$router.push('/');
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

    .profile-form {
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

</style>