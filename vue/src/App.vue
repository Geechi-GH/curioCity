<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" class="link">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" class="link" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
.link {
  text-decoration: none;
  color: #708090;
}

body {
  background-image: linear-gradient(to bottom left, #3c3c3c, #020202);
  background-attachment: fixed;
  color: white;
  font-family: Helvetica, Arial, sans-serif;
}

h1 {
  color: #CD7F32;
}
</style>