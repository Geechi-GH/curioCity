<template>
  <div id="capstone-app">
    <div id="cornerContainer">
      <img src="./assets/CurioCityTransparent.png" alt="Logo Image">
      <h1 id="page-title">{{ pageTitle }}</h1>
      <div id="nav">
        <router-link v-if="!user" v-bind:to="{ name: 'register' }" class="link">Register</router-link>
        <router-link v-else v-bind:to="{ name: 'home' }" class="link">Home</router-link>
        &nbsp;|&nbsp;
        <router-link v-if="!user" v-bind:to="{ name: 'login' }" class="link">Login</router-link>
        <router-link v-else v-bind:to="{ name: 'logout' }" class="link">Logout</router-link>
      </div>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      pageTitle: "CurioCity",
    };
  },
  created() {
    // Update the pageTitle based on the route
    this.$router.beforeEach((to, from, next) => {
      if (to.name === 'home') {
        this.pageTitle = 'Home';
      } else if (to.name === 'landmarks') {
        this.pageTitle = 'Landmarks';
      } else if (to.name === 'add-itinerary') {
        this.pageTitle = 'Add Itinerary';
      } else if (to.name === 'edit-itinerary') {
        this.pageTitle = 'Update Itinerary';
      } else {
        this.pageTitle = 'CurioCity';
      }
      next();
    });
  },
  computed: {
    user() {
      return !!this.$store.state.token;
    },
  }
}
</script>

<style>
#cornerContainer {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

img {
  width: 200px;
}

#nav {
  /* display: flex; */
  text-align: center;
  margin-left: 5%;
}

.link {
  text-decoration: none;
  color: #D7b740;
}

body {
  background-image: linear-gradient(to bottom left, #3c3c3c, #020202);
  background-attachment: fixed;
  color: white;
  font-family: "Quicksand", sans-serif;
}

h1 {
  color: #fffff0;
  font-weight: lighter;
}

h2 {
  font-weight: lighter;
}

h3 {
  font-weight: lighter;
}

#page-title {
  font-size: 5em;
}
</style>