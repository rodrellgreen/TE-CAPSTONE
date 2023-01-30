<template>
  <div id="create-profile" class="create-profile"> 
      <form class="profile-form" @submit.prevent="createProfile">
          <h1>Create Your Profile</h1>
          <label for="email" class="input label">Email Address:</label>
          <input
            type="text"
            id="email"
            class="input box"
            placeholder="email"
            v-model="newProfile.emailAddress"
            required
            autofocus
            />
          <label for="age" class="input label">Age:</label>
          <input
            type="number"
            id="age"
            class="input box"
            placeholder="age"
            v-model="newProfile.age"
            required
            autofocus
            />
          <label for="height-feet" class="input label">Height (ft):</label>
          <input
            type="number"
            id="height-feet"
            class="input box"
            placeholder="height (ft)"
            v-model="newProfile.heightFeet"
            required
            autofocus
            />
          <label for="height-inches" class="input label">Height (in):</label>
          <input
            type="number"
            id="height-inches"
            class="input box"
            placeholder="height (in)"
            v-model="newProfile.heightInches"
            required
            autofocus
            />
          <label for="current-weight" class="input label">Current Weight:</label>
          <input
            type="number"
            id="current-weight"
            class="input box"
            placeholder="current weight"
            v-model="newProfile.currentWeight"
            required
            autofocus
            />
          <label for="desired-weight" class="input label">Desired Weight:</label>
          <input
            type="number"
            id="desired-weight"
            class="input box"
            placeholder="desired weight"
            v-model="newProfile.desiredWeight"
            required
            autofocus
            />
          <button class="create-profile-button" type="submit">
              Create Profile
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
        text-align: center;
        padding: 10px;
        margin: 10px;
        border: solid black 2px
    }

    .profile-form {
        display: flex;
        flex-direction: column;
    }

    .input-box {
        width: 50px;
    }

    .create-profile-button {
        margin: 10px
    }

</style>