<template>
  <div id="login">
    <img src="../assets/CurioCity.png" alt="Logo Image">
    <form v-on:submit.prevent="login">
      <h1>Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="login-container">
        <div class="form-input-group">
          <label for="username">Username:</label>
          <input class="username-box" type="text" id="username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <label for="password">Password:</label>
          <input class="password-box" type="password" id="password" v-model="user.password" required />
        </div>
        <button class="login-button" type="submit">Sign in</button>
        <p>
          <router-link v-bind:to="{ name: 'register' }" class="register-link">Need an account? Sign up.</router-link>
        </p>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/home");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
body {
  background-image: linear-gradient(to bottom left, #3c3c3c, #020202);
  background-attachment: fixed;
}

.login-container {
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
  -webkit-animation-name: fadeIn;
  animation-name: fadeIn;
  -webkit-animation-duration: 1s;
  animation-duration: .5s;
  -webkit-animation-timing-function: ease-in-out;
  animation-timing-function: ease-in-out;
}

#login {
  text-align: center;
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

.login-button:hover {
  background-color: #708090;
}

img {
  margin-bottom: -75px;
}

.form-input-group {
  margin-bottom: 1rem;
  color: #FFFFF0;
}

form {
  margin-top: 60px;
  padding-left: 10px;
  padding-right: 10px;
  color: #FFFFF0;
}

label {
  margin-right: 0.5rem;
  color: #FFFFF0;
}

.register-link:hover {
  color: #D7B740;
  text-decoration: underline;
  text-decoration-color: #D7B740;
}

.register-link {
  text-decoration: none;
  color: #708090;
}
</style>