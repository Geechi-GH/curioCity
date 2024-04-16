<template>
    <h1 class="title">Add Itinerary</h1>
    <div class="title-sub">
        <h2>Please fill in the following information</h2>
    </div>
    <div class="container"></div>
    <div class="selection">
        <ItineraryForm v-bind:itinerary="itinerary" />
    </div>
</template>

<script>
import ItineraryForm from "../components/ItineraryForm.vue";

export default {
    components: {
        ItineraryForm,
    },
    data() {
        return {
            itinerary: {
                title: '',
                dateOfTravel: '',
                dateCreated: new Date(),
            }
        }
    }
}
</script>

<style scoped>
.title {
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