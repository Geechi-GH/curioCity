<template>
  <div class="home">
    <h1 class="title">Home</h1>
    <div class="button-container">
      <router-link :to="{ name: 'landmarks' }" class="link">See Landmarks</router-link>
      <h2 class="title-sub">Your Itineraries</h2>
      <button class="btn-add" @click="$router.push({ name: 'add-itinerary' })">Add Itinerary</button>
    </div>
    <section id="itineraries">
      <router-link :to="`/itinerary/${itinerary.itineraryId}`" v-for="itinerary in itineraries" :key="itinerary.id">
        <ItinerariesSimplified class="itinerary-list" :itinerary="itinerary" />
      </router-link>
    </section>
    <h3 class="footer-title">CurioCity</h3>
    <h2 class="footer">Travel curation for the curious mind</h2>

  </div>

  <body>
    <div class="container">

      <!-- background image -->
      <img class="gfg" src="../assets/verylargecinciy.jpg" alt="fireworks">
    </div>
  </body>
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
  font-weight: lighter;
  text-align: center !important;
  margin-bottom: 15px;
  color: #fffff0;
  justify-content: center;

  font-family: "Quicksand", sans-serif;
  text-decoration-line: underline;
  text-decoration-style: unset;
}

.title-sub {
  font-size: 1.5em;
  font-weight: bold;
  text-align: center !important;
  margin-bottom: 15px;
  color: #292929;
  justify-content: center;
  font-family: serif;
}

.button-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border: #708090 2px solid;
  background-color: #708090;
  padding: 0px;
  margin-bottom: 40px;
  margin-right: -10px;
  margin-left: -10px;
}

.link {
  text-decoration: none;
  padding: 5px 10px;
  font-family: serif;
  font-weight: bold;
  color: #fffff0;
  background-color: #292929;
  border: #d7b740 1px solid;
  border-radius: 15px;
}

.btn-add {
  margin-left: 0px;
}



.link:hover {
  text-decoration: underline;
}

.btn-add:hover {
  text-decoration: underline;
}

.itinerary-list {
  text-decoration: none;
  color: #fffff0;
  padding: 5px 10px;
  font-family: serif;
  font-weight: bold;
  font-size: 1em;
  background-color: #292929;
  border: #d7b740 1px solid;
  border-radius: 15px;
  margin: 10px;
}

.itinerary-list:hover {
  background-color: #708090;
}

.btn-add {
  text-decoration: none;
  color: #fffff0;
  padding: 5px 10px;
  font-family: serif;
  font-weight: bold;
  font-size: 1em;
  background-color: #292929;
  border: #d7b740 1px solid;
  border-radius: 15px;
}

#itineraries {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
  margin-bottom: 20px;
  color: #fffff0;
  font-family: serif;
  font-weight: bold;
  font-size: 1em;
  text-align: center;
  padding: 10px;


  color: #fffff0;
  padding: 10px;
  margin: 10px;
  flex: 0 0 10%;
  color: #fffff0;
  margin-bottom: 10px;
}

.itinerary-list {
  flex-wrap: wrap;
  justify-content: space-around;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
  margin-bottom: 20px;
  margin-left: 20px;
  margin-right: 20px;
  color: #fffff0;
  font-family: serif;
  font-weight: bold;
  font-size: 1em;
  text-align: center;
  padding: 10px;
  border: 1.5px solid #708090;
  border-radius: 4px;
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

.footer-title {
  font-size: 2em;
  font-weight: bold;
  text-align: center !important;
  margin-bottom: 0px;
  color: #d7b740;
  justify-content: center;
  -webkit-text-stroke: #292929 .5px;
  font-family: serif;
  text-decoration-line: underline;
}

.footer {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 0px;
  margin-bottom: 20px;
  color: #d7b740;
  -webkit-text-stroke: #292929 .5px;

  font-weight: bold;
  font-family: serif;
  font-size: 1.5em;
  text-align: center;
  padding: 10px;
  border-top: #708090 1px solid;
  border-bottom: #708090 1px solid;
  border-radius: 20px;
  background-color: #708090;
  text-decoration-style: double;
  text-decoration-thickness: 1px;
  background-color: rgba(112, 128, 144, 0.7);


}


.gfg {
  position: absolute;

  top: 28%;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  opacity: 25%;
}
</style>