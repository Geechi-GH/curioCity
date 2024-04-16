<template>
  <div id="capstone-app">
    <div id=cornerContainer>
      <div class="logo">
        <img src="./assets/CurioCityTransparent.png" alt="Logo Image">
      </div>
      <div id="nav">
        <router-link v-bind:to="{ name: 'home' }" class="link">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" class="link" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <router-view />
  </div>
</template>

<style>
#cornerContainer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-right: 20px;
  margin-left: 10px;
}

.logo {
  text-align: left;
}

.logo img {
  width: 20%;
  height: 20%;

}

#nav {
  display: flex;
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
  font-family: serif;
}

h1 {
  color: #D7b740;
}
</style>