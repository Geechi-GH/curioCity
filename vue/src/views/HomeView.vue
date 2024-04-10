<template>
  <div class="home">
    <h1 class="title">Home</h1>
    <p>You must be authenticated to see this</p>
    <router-link v-bind:to="{ name: 'landmarks' }" class="link">Landmarks</router-link>
<<<<<<< HEAD

    <ItinerariesSimplified v-for="itinerary in itineraries" v-bind:key="itinerary.id" v-bind:itinerary="itinerary" />
=======
    <section id="itineraries">
      <ItinerariesSimplified class="itinerary-list" v-for="itinerary in itineraries" v-bind:key="itinerary.id"
        v-bind:itinerary="itinerary" />
    </section>
>>>>>>> 965f980493e5f8cdd2d4fa55076ff304e7896450
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

<style scoped>
.title {
  font-size: 5em;
  font-weight: bold;
  text-align: center !important;
  margin-bottom: 5px;
  color: #d7b740;
  justify-content: center;
  -webkit-text-stroke: #292929 1px;

  text-decoration-line: underline;
  text-decoration-style: unset;
}




#itineraries {
  display: flex;
  flex-direction: row;
  align-items: center;
  flex-wrap: wrap;

}

.itinerary-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  justify-content: center;
}

.itinerary-list>* {
  border: 3px solid #708090;
  border-radius: 4px;
  padding: 10px;
  margin: 10px;
  flex: 0 0 10%;
  color: #fffff0;
}

.itinerary-list>*:hover {
  background-color: #708090;
  /* Change this to the color you want when hovered */
  color: #d7b740;
  /* Change this to the text color you want when hovered */
}
</style>