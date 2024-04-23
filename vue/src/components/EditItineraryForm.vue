<template>
    <form v-on:submit.prevent="edit">
        <div>
            <p>Current title: {{ itinerary.title }}</p>
            <label class="title-edit" for="title">New title :</label>
            <input class="title-box" type="text" id="title" v-model="editItinerary.title" required />
        </div>

        <div class="field">
            <p>Current travel date: {{ itinerary.dateOfTravel }}</p>
            <label class="title-travel" for="travel">New travel date :</label>
            <input class="title-travel-box" type="date" id="travel" v-model="editItinerary.dateOfTravel" required />
        </div>

        <div class="actions">
            <button class="submit-cancel" type="submit">Confirm</button>
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
            }
        }
    },
    methods: {
        edit() {
            this.editItinerary.itineraryId = this.itinerary.itineraryId
            ItineraryService.editItinerary(this.editItinerary)
                .then(response => {
                    this.$router.push({ name: 'itinerary-details', params: { itineraryId: this.itinerary.itineraryId } })
                })
                .catch(error => {
                    const response = error.response;
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
    }
}
</script>

<style scoped>
.title-edit {
    font-size: .9em;
    text-align: center;
    margin-bottom: 10px;
    margin-top: 20px;
    margin-right: 5px;
    color: #fffff0;
}

.title-box {
    font-size: .9em;
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