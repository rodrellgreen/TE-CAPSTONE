<template>
  <div class="card-container">
    <CreateProfile v-if="this.currentProfile.displayName == ''"/>
    <EditProfile v-if="edit"/>
    <button v-if="!this.currentProfile.displayName == '' && !edit" class="edit-btn" v-on:click="edit = !edit">Edit Profile</button>
    <button v-if="!this.currentProfile.displayName == '' && edit" class="cancel-btn" v-on:click="edit = !edit">Cancel</button>
    <ProfileDisplay v-if="!this.currentProfile.displayName == '' && !edit"/>
  </div>
</template>

<script>
import CreateProfile from '../components/CreateProfile.vue';
import EditProfile from '../components/EditProfile.vue';
import ProfileDisplay from '../components/ProfileDisplay.vue';
import ProfileService from '../services/ProfileService.js';

export default {

  data() {
    return {

      edit: false,

      currentProfile: {}

    }
  },

  components: {
      CreateProfile,
      EditProfile,
      ProfileDisplay
  },

  created() {
    ProfileService.getProfile().then(
        (response) => {
            this.currentProfile = response.data;
        }
      );
  },

  methods: {
    displayEditProfile() {

    }
  }

}
</script>

<style>
  .card-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 20px;
  }
</style>