<template>
    <div>
        <h1 class="section-names"> {{ itinerary.title }} Itinerary</h1>
        <p>{{ formatDate(itinerary.dateOfTravel) }}</p>
        <button
            @click="this.$router.push({ name: 'edit-itinerary', params: { itineraryId: itinerary.itineraryId } })">Edit</button>
        <hr class="full-width-lines">
        <h2>Plan Your Trip</h2>
        <p>Drag & drop landmarks to order your itinerary</p>
        <draggable v-model="landmarksToVisit" item-key="id" @end="saveItinerary">
            <template #item="{ element }">
                <LandmarksMinus class="landmarks" id="top-landmarks" :landmark="element" :itinerary="itinerary"
                    @remove-landmark="removeLandmark">
                </LandmarksMinus>
            </template>
        </draggable>

        <hr class="full-width-lines">
        <h3 class="subtitle-landmarks">Landmarks</h3>

        <div class="flex-container">
            <section v-for="landmark in availableLandmarks" :key="landmark.id">
                <LandmarksPlus class="landmarks" id="bottom-landmarks" :landmark="landmark" v-bind:itinerary="itinerary"
                    @add-landmark="addLandmark">
                </LandmarksPlus>
            </section>
            <button @click="deleteItinerary(this.itinerary.itineraryId)">Delete</button>
        </div>
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
        },

        deleteItinerary(itineraryId) {
            ItineraryService.deleteItinerary(itineraryId).then(response => {
                this.itinerary = response.data;
                this.$router.push({ name: 'home' });
            });
        },
        formatDate(date) {
            const dateObj = new Date(date);
            const formattedDate = dateObj.toLocaleDateString('en-US', {
                year: 'numeric',
                month: '2-digit',
                day: '2-digit'
            });
            return formattedDate;
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
        },
        image() {
            return (new URL(this.landmark.imagePath, import.meta.url)).href;
        }
    }
}
</script>

<style scoped>
.section-names {
    font-size: 2em;
    text-align: center;
    color: #D7B740;
}

.subtitle-landmarks {
    font-size: 1.5em;
    text-align: center;
    color: #FFFFF0;
    text-shadow: -1px -1px 0 #708090, 1px -1px 0 #708090, -1px 1px 0 #708090, 1px 1px 0 #708090;
}

.full-width-line {
    border: none;
    border-top: 1px solid #ddd;
    width: 100%;
    margin: 20px 0;
}

h2 {
    text-align: center;
    color: #FFFFF0;
    text-shadow: -1px -1px 0 #708090, 1px -1px 0 #708090, -1px 1px 0 #708090, 1px 1px 0 #708090;
}

p {
    text-align: center;
    color: #708090;
}

.flex-container {
    display: flex;
    flex-wrap: wrap;
    /* justify-content: space-between; */
    width: calc(100% + 20px);
    /* Adjust for border and margin */
    margin: 0 -10px;
    /* Adjust for negative margin */
    margin-left: 5px;
}

#top-landmarks {
    background-color: rgba(112, 128, 144, 0.5);
}

.landmarks {
    border: 2px solid #708090;
    margin: 5px;
    border-radius: 10px;
    text-shadow: -1px -1px 0 #292929, 1px -1px 0 #292929, -1px 1px 0 #292929, 1px 1px 0 #292929;
}

#top-landmarks {
    cursor: grab;
}

#bottom-landmarks:hover {
    opacity: .9;
}

#top-landmarks:hover {
    background-color: #292929;
}

#bottom-landmarks {
    flex-basis: calc(33.33% - 20px);
    flex-grow: 1;
    margin: 5px;
    margin-left: 5px;
    margin-bottom: 20px;
    box-sizing: border-box;
    padding: 10px;
}
</style>