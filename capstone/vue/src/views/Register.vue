<template>
  <div id="form-container" class="form-container">
    
    <form class="form-form" @submit.prevent="register">
      <h1 >Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="flex-container">
      <label for="username" class="input label">Username:</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      <div class="flex-container">
      <label for="password" class="sr-only">Password:</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      </div>
      <div class="flex-container">
      <label for="confirmPassword">Confirm Password:</label>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      </div>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      <button class="cancel-btn" v-on:click.prevent="sendHome">Cancel</button>
      
      <router-link class="router-link" :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
    sendHome() {
      this.user.username = '';
      this.user.password = '';
      this.user.confirmPassword = '';
      this.$router.push('/');
    }
  },
};
</script>

<style>
/** Check App.vue for styles */
</style>
