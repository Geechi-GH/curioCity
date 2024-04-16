<template>
    <form v-on:submit.prevent="createItinerary">
        <div class="field">
            <label class="title" for="title">Title :</label>
            <input class="title-box" type="text" id="title" v-model="editItinerary.title" required />
        </div>

        <div class="field">
            <label class="title-travel" for="travel">Travel date :</label>
            <input class="title-travel-box" type="date" id="travel" v-model="editItinerary.dateOfTravel" required />
        </div>

        <div class="actions">
            <button class="submit-cancel" type="submit">Add</button>
            <button class="submit-cancel" type="button" v-on:click="this.$router.back()">Cancel</button>
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
                    this.$router.push({ name: 'itinerary-details', params: { itineraryId: response.data.itineraryId } })
                })
                .catch(error => {
                    const response = error.response;
                });
        }
    }
}
</script>

<style scoped>
.title {
    font-size: .9em;
    text-align: center;
    margin-bottom: 10px;
    margin-top: 20px;
    margin-right: 5px;
    color: #708090;
}

.title-box {
    font-size: .9em;
    font-size: .75em;
    text-align: center;
    margin-bottom: 10px;
    margin-top: 20px;
    margin-right: 5px;
    color: #708090;
    background-color: #fffff0;
    border: #708090 2px solid;
}

.title-box:focus {
    outline: none;
    border: #D7B740 2px solid;
}

.title-travel {
    font-size: .9em;
    text-align: center;
    margin-bottom: 10px;
    margin-top: 20px;
    margin-right: 5px;
    color: #fffff0;
}

.title-travel-box:focus {
    outline: none;
    border: #D7B740 2px solid;
}

.title-travel-box {
    font-size: .75em;
    text-align: center;
    margin-bottom: 10px;
    margin-top: 20px;
    margin-right: 5px;
    color: #708090;
    background-color: #fffff0;
    border: #708090 2px solid;

}

.submit-cancel:hover {
    background-color: #708090;
}

p {
    color: #fffff0;
}
</style>