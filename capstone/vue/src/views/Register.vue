<template>
  <div id="register" class="text-center">
    <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
    <form class="form-register" @submit.prevent="register">
      
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="flex-container">
      <label for="username" class="sr-only">Username:</label>
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

  #register {
    background-color: #7DA27E;
    color: white;
    font-size: large;
    border-radius: 10px;
    margin: auto;
    margin-top: 8%;
    height: 500px;
    width: 500px;
    display: flex;
    align-items: center;
    border: solid grey 2px;
    flex-direction: column;
  }

  .form-register {
    margin: auto;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    justify-content: space-around;
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
