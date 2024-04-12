<template>
    <form v-on:submit.prevent="createItinerary">
        <div class="field">
            <label for="title">Title</label>
            <input type="text" id="title" v-model="editItinerary.title" required />
        </div>

        <div class="field">
            <label for="travel">Travel date</label>
            <input type="date" id="travel" v-model="editItinerary.dateOfTravel" required />
        </div>

        <div class="actions">
            <button type="submit">Add</button>
            <button type="button" v-on:click="this.$router.back()">Cancel</button>
        </div>
    </form>
</template>

<script>
import ItineraryService from '../services/ItineraryService';

export default {
    props: {
        itinerary: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            editItinerary: {
                title: this.itinerary.title,
                dateOfTravel: this.itinerary.dateOfTravel,
                dateCreated: this.itinerary.dateCreated
            }
        }
    },
    methods: {
        createItinerary() {
            ItineraryService.create(this.editItinerary)
                .then(response => {
                    this.$store.commit('ADD_ITINERARY', response.data)
                    this.$router.push({ name: 'home' })
                })
                .catch(error => {
                    const response = error.response;
                })
        }
    }
}
</script>

<style scoped></style>