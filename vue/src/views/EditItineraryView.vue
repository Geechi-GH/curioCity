<template>
    <div class="title-sub">
        <h2>Please update in the following information</h2>
    </div>
    <div class="container"></div>
    <div class="selection">
        <EditItineraryForm v-bind:itinerary="itinerary" />
    </div>
</template>

<script>
import EditItineraryForm from '../components/EditItineraryForm.vue';
import ItineraryService from '../services/ItineraryService';

export default {
    components: {
        EditItineraryForm,
    },
    data() {
        return {
            itinerary: {}
        }
    },
    methods: {
        getItinerary(id) {
            ItineraryService.getItineraryById(id).then(response => {
                this.itinerary = response.data;
            });
        },
    },
    created() {
        this.getItinerary(this.$route.params.itineraryId);
    }
}
</script>

<style scoped>
.title-edit {
    font-size: 3em;
    text-align: center;
    margin-bottom: 10px;
    margin-top: 20px;
    color: #fffff0;
}

.title-sub {
    font-size: 1em;
    text-align: center;
    margin-bottom: 20px;
    margin-top: 10px;
    color: #D7B740;
    border: #708090 1px solid;
    background-color: #708090;
    border-radius: 20px;
    padding: -10px;
}

.selection {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.5em;
    padding: 10px;
    padding-bottom: 27px;
    border-top: #708090 2px solid;
    border-bottom: #708090 2px solid;
    border-radius: 15px;
    box-sizing: border-box;
    width: 20%;
    margin: 0 auto;
    color: #292929;
}
</style>