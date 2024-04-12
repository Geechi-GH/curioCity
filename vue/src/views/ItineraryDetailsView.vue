<template>
    <div>
        <draggable v-model="landmarksToVisit" item-key="id" @end="saveItinerary">
            <template #item="{ element }">
                <LandmarksMinus :landmark="element" :itinerary="itinerary" @remove-landmark="removeLandmark">
                </LandmarksMinus>
            </template>
        </draggable>

        <p>_________YOUR LANDMARKS___________</p>
        <!-- <section v-for="landmark in populateLandmarks" :key="landmark.id">
            <LandmarksMinus :landmark="landmark" v-if="itinerary.landmarksArray.includes(landmark.id)"
                v-bind:itinerary="itinerary" @remove-landmark="removeLandmark">
            </LandmarksMinus>
        </section> -->
        <p>_________LANDMARKS TO ADD___________</p>
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
            myArray: [
                { id: 1, name: "test" },
                { id: 2, name: "test2" }
            ],
            landmarksToVisit: [],
            itinerary: {
                landmarksArray: [],
            }
        }
    },
    methods: {
        saveItinerary() {
            console.log("saving...")
            this.itinerary.landmarksArray = this.landmarksToVisit.map(landmark => landmark.id);
            console.log(this.itinerary.landmarksArray);

            console.log(this.landmarksToVisit);
            ItineraryService.flushAndFill(this.itinerary, this.itinerary.itineraryId)
                .then(response => {
                    console.log(response.data);
                    this.itinerary = response.data;
                    // this.landmarksToVisit = this.$store.state.landmarks
                    //     .filter(lm => this.itinerary.landmarksArray.includes(lm.id));
                });
        },
        getItinerary(id) {
            ItineraryService.getItineraryById(id).then(response => {
                this.itinerary = response.data;
                // this.itinerary.landmarksArray = response.data.landmarksArray;
                this.landmarksToVisit = this.itinerary.landmarksArray
                    .map(id => this.$store.state.landmarks.find(landmark => landmark.id === id));
            })
        },
        addLandmark(landmark) {
            // this.itinerary.landmarksArray.push(landmark.id);
            this.landmarksToVisit.push(landmark);
            this.saveItinerary()
            // i don't think this is needed
            // ItineraryService.getItineraryById(this.itinerary.itineraryId).then(response => {
            //     this.itinerary.landmarksArray = response.data.landmarksArray
            // })
        },
        removeLandmark(landmark) {
            this.landmarksToVisit = this.landmarksToVisit
                .filter(lm => lm.id !== landmark.id);
            this.saveItinerary();
            // this.itinerary.landmarksArray = this.itinerary.landmarksArray
            //     .filter(id => id !== landmark.id);

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
        populateLandmarks() {
            return this.$store.state.landmarks
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