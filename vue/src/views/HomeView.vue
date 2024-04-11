<template>
  <div class="home">
    <h1 class="title">Home</h1>
    <p>You must be authenticated to see this</p>
    <div class="button-container">
    <router-link :to="{ name: 'landmarks' }" class="link">See Landmarks</router-link> 
    <button class="btn-add" @click="$router.push({ name: 'add-itinerary' })">Add Itinerary</button>
    </div>
    <section id="itineraries">
      <ItinerariesSimplified class="itinerary-list" v-for="itinerary in itineraries" :key="itinerary.id"
        :itinerary="itinerary" />
    </section>
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
  color: #fffff0;
  justify-content: center;
  -webkit-text-stroke: #292929 1px;
  font-family: serif;
  text-decoration-line: underline;
  text-decoration-style: unset;
}

.button-container {
  display: flex; 
  justify-content: space-between;
  align-items: center;
  margin-right: 10px;
  margin-left: 10px;
}

.link {
  text-decoration: none;
  border: 2px solid #d7b740;
  padding: 5px 10px;
  font-family: serif;
  font-weight: bold;
  color: #d7b740;
}

.link:hover {
  text-decoration: underline;
}

.btn-add {
  text-decoration: none;
  color: #292929;
  border: 2px solid #d7b740;
  padding: 5px 10px;
  font-family: serif;
  font-weight: bold;
  font-size: 1em;
}


#itineraries {
  display: flex;
  flex-direction: row;
  align-items: center;
  flex-wrap: wrap;
  justify-content: space-between;
  border: 1px solid #d7b740;
  margin-top: 1%;S;


}

.itinerary-list {
  flex-wrap: wrap;
  justify-content: space-around;
  justify-content: center;
  align-items: center;
}


.itinerary-list>* {
  display: flex;
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