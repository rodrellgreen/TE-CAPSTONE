<template>
  <div class="profile-container"> 
      <!-- Put profile picture in src="" below (currentProfile.profilePicture) -->
      <img src="../assets/defaultUserImg.png" alt="User Profile Picture">
      <h2 class="display-name">{{currentProfile.displayName}}</h2>
      <p>{{currentProfile.age}}</p>
      <p>{{currentProfile.email}}</p>
      <p>{{currentProfile.feet}}' {{currentProfile.inches}}''</p>
      <h3>Current Weight:</h3><span>{{currentProfile.currentWeight}}</span> 
      <h3>Goal Weight:</h3><span>{{currentProfile.desiredWeight}}</span>
  </div>
</template>

<script>
import ProfileService from '../services/ProfileService.js';

export default {

    data() {
        return {
            currentProfile: {}
        }
    },

    created() {
        ProfileService.getProfile().then(
            (response) => {
                this.currentProfile = response.data;
            }
        )
    }


}
</script>

