<template>
    <div>
        <p>YOUR LANDMARKS</p>
        <draggable v-model="landmarksToVisit" item-key="id" @end="saveItinerary">
            <template #item="{ element }">
                <LandmarksMinus :landmark="element" :itinerary="itinerary" @remove-landmark="removeLandmark">
                </LandmarksMinus>
            </template>
        </draggable>
        <p>LANDMARKS TO ADD</p>
        <section v-for="landmark in availableLandmarks" :key="landmark.id">
            <LandmarksPlus :landmark="landmark" v-bind:itinerary="itinerary" @add-landmark="addLandmark">
            </LandmarksPlus>
        </section>
    </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService';
import LandmarkService from '../services/LandmarkService';
import LandmarksPlus from '../components/LandmarksPlus.vue';
import LandmarksMinus from '../components/LandmarksMinus.vue';
import draggable from 'vuedraggable';

export default {
    components: {
        LandmarksPlus,
        LandmarksMinus,
        draggable
    },
    data() {
        return {
            landmarksToVisit: [],
            itinerary: {
                landmarksArray: [],
            }
        }
    },
    methods: {
        saveItinerary() {
            this.itinerary.landmarksArray = this.landmarksToVisit.map(landmark => landmark.id);
            ItineraryService.flushAndFill(this.itinerary, this.itinerary.itineraryId)
                .then(response => {
                    this.itinerary = response.data;
                });
        },
        getItinerary(id) {
            ItineraryService.getItineraryById(id).then(response => {
                this.itinerary = response.data;
                this.landmarksToVisit = this.itinerary.landmarksArray
                    .map(id => this.$store.state.landmarks.find(landmark => landmark.id === id));
            });
        },
        addLandmark(landmark) {
            this.landmarksToVisit.push(landmark);
            this.saveItinerary();
        },
        removeLandmark(landmark) {
            this.landmarksToVisit = this.landmarksToVisit
                .filter(lm => lm.id !== landmark.id);
            this.saveItinerary();
        }
    },
    created() {
        const landmarks = LandmarkService.getLandmarks()
            .then(response => {
                this.$store.commit('SET_LANDMARKS', response.data);
                this.getItinerary(this.$route.params.itineraryId)
            });
    },
    computed: {
        landmarksArray() {
            return this.itinerary.landmarksArray
        },
        availableLandmarks() {
            const selectedLandmarkIds = this.landmarksToVisit.map(landmark => landmark.id);
            return this.$store.state.landmarks
                .filter(lm => !selectedLandmarkIds.includes(lm.id));
        }
    }
}
</script>

<style scoped></style>