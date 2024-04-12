<template>
    <div>
        <ItineraryDetails v-bind:itinerary="itinerary"></ItineraryDetails>
        <CheatingLandmarks v-for="landmark in populateLandmarks" :key="landmark.id" :landmark="landmark"
            v-bind:itinerary="itinerary" @add-landmark="addLandmark">
        </CheatingLandmarks>
    </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService';
import CheatingLandmarks from '../components/CheatingLandmarks.vue';
import ItineraryDetails from '../components/ItineraryDetails.vue';
import LandmarkService from '../services/LandmarkService';
export default {
    components: {
        CheatingLandmarks,
        ItineraryDetails
    },
    data() {
        return {
            itinerary: {

                landmarksArray: []
            }
        }
    },
    methods: {
        getItinerary(id) {
            ItineraryService.getItineraryById(id).then(response => {
                this.itinerary = response.data;
                this.itinerary.landmarksArray = response.data.landmarksArray;
            })

        },
        addLandmark(landmark) {
            this.itinerary.landmarksArray.push(landmark.id);
            ItineraryService.addingLandmarkToItinerary(this.itinerary, this.itinerary.itineraryId)
                .then(response => {
                    this.itinerary = response.data;
                });
            ItineraryService.getItineraryById(this.itinerary.itineraryId).then(response => {
                this.itinerary.landmarksArray = response.data.landmarksArray
            })


        },

    },
    created() {
        const landmarks = LandmarkService.getLandmarks()
            .then(response => {
                this.$store.commit('SET_LANDMARKS', response.data);
            });

        // const itinerary = ItineraryService.getItineraryById(this.$route.params.id).then(response => {
        //     this.itinerary = response.data;
        // })
        this.getItinerary(this.$route.params.itineraryId)
    },
    computed: {
        landmarksArray() {
            return this.itinerary.landmarksArray
        },
        populateLandmarks() {
            return this.$store.state.landmarks
        }
    }
}

</script>

<style scoped></style>