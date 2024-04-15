<template>
  <div id="register" class="text-center">
    <img src="../assets/CurioCity.png" alt="Logo Image">
    <form v-on:submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button class="register-button" type="submit">Create Account</button>
      <p><router-link v-bind:to="{ name: 'login' }" class="login-link">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
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
  },
};
</script>

<style scoped>
body {
  background-image: linear-gradient(to bottom left, #3c3c3c, #020202);
  background-attachment: fixed;
}

.text-center {
  text-align: center;
}

img {
  margin-bottom: -75px;
}

h1 {
  color: #CD7F32;
}

.form-input-group {
  margin-bottom: 1rem;
  color: #FFFFF0;
}

form {
  margin-top: 60px;
  padding-left: 10px;
  padding-right: 10px;
  font-family: Helvetica, Arial, sans-serif;
  color: #FFFFF0;
}

label {
  margin-right: 0.5rem;
  color: #FFFFF0;
}

#username:focus {
  outline: none;
  border: 3px solid #D7B740;
}

#username {
  border: 2px solid #708090;
}

#password:focus {
  outline: none;
  border: 3px solid #D7B740;
}

#password {
  border: 2px solid #708090;
}

#confirmPassword:focus {
  outline: none;
  border: 3px solid #D7B740;
}

#confirmPassword {
  border: 2px solid #708090;
}

.login-link {
  text-decoration: none;
  color: #708090;
}

.register-button:hover {
  background-color: #708090;
}

.login-link:hover {
  color: #D7B740;
  text-decoration: underline;
  text-decoration-color: #D7B740;
}
</style>