<template>
  <div id="edit-profile" class="edit-profile"> 
      <form class="profile-form" @submit.prevent="editProfile">
          <h1>Edit Your Profile</h1>
          <div class="flex-container">
          <label for="email" class="input label">Email Address:</label>
          <input
            type="text"
            id="email"
            class="input-box" 
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
          <button class="edit-profile-button" type="submit">
              Submit
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

    created() {
      ProfileService.getProfile().then(
        (response) => {
            this.newProfile = response.data;
        }
      );
    },

    methods: {
      editProfile() {
          ProfileService.editProfile(this.newProfile).then(
              (response) => {
                  if(response.status === 200) {
                    alert("Success! Profile changed.");
                    this.$router.push('/');
                  }
            } 
          );
      },
    }
}
</script>

<style>

    #edit-profile {
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