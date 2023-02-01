<template>
  <div class="card-container">
    <CreateProfile/>
    <EditProfile/>
    <ProfileDisplay/>
  </div>
</template>

<script>
import CreateProfile from '../components/CreateProfile.vue';
import EditProfile from '../components/EditProfile.vue';
import ProfileDisplay from '../components/ProfileDisplay.vue';

export default {

    components: {
        CreateProfile,
        EditProfile,
        ProfileDisplay
    }

}
</script>

<style>

    .card-container {
        display: flex;
    }

</style>