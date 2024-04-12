<template>
    <div>
        <p>YOUR LANDMARKS</p>
        <section v-for="landmark in populateLandmarks" :key="landmark.id">
            <LandmarksMinus :landmark="landmark" v-if="itinerary.landmarksArray.includes(landmark.id)"
                v-bind:itinerary="itinerary" @remove-landmark="removeLandmark">
            </LandmarksMinus>
        </section>
        <p>LANDMARKS TO ADD</p>
        <section v-for="landmark in populateLandmarks" :key="landmark.id">
            <LandmarksPlus :landmark="landmark" v-if="!itinerary.landmarksArray.includes(landmark.id)"
                v-bind:itinerary="itinerary" @add-landmark="addLandmark">
            </LandmarksPlus>
        </section>
    </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService';
import LandmarkService from '../services/LandmarkService';
import LandmarksPlus from '../components/LandmarksPlus.vue';
import LandmarksMinus from '../components/LandmarksMinus.vue';
export default {
    components: {
        LandmarksPlus,
        LandmarksMinus
    },
    data() {
        return {
            itinerary: {
                landmarksArray: [],
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
        removeLandmark(landmark) {
            this.itinerary.landmarksArray.splice(this.itinerary.landmarksArray.indexOf(landmark.id), 1);
            ItineraryService.flushAndFill(this.itinerary, this.itinerary.itineraryId)
                .then(response => {
                    this.itinerary = response.data;
                });
            ItineraryService.getItineraryById(this.itinerary.itineraryId).then(response => {
                this.itinerary.landmarksArray = response.data.landmarksArray
            })
        }
    },
    created() {
        const landmarks = LandmarkService.getLandmarks()
            .then(response => {
                this.$store.commit('SET_LANDMARKS', response.data);
            });
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