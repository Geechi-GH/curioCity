<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link v-bind:to="{ name: 'landmarks' }" class="link">Landmarks</router-link>

    <ItinerariesSimplified v-for="itinerary in itineraries" v-bind:key="itinerary.id" v-bind:itinerary="itinerary" />
    <button class="btn-add" v-on:click="this.$router.push({ name: 'add-itinerary' })">Add Itinerary</button>
  </div>
  <div>

  </div>
</template>

<script>
import ItineraryService from "../services/ItineraryService";
import ItinerariesSimplified from "../components/ItinerariesSimplified.vue";

export default {
  name: "HomeView",
  components: {
    ItinerariesSimplified,
  },

  computed: {
    itineraries() {
      return this.$store.state.itineraries;
    }
  },

  created() {
    const itineraries = ItineraryService.getItineraries()
      .then(response => {
        this.$store.commit('SET_ITINERARIES', response.data);
      });
  }
};
</script>

<style scoped></style>