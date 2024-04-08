<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <p><router-link v-bind:to="{ name: 'landmarks' }">Landmarks</router-link></p>
  </div>
</template>

<script>
export default {
};
</script>

<style scoped>
div {
  color: #ffffff;
}
</style>