<template>
    <h1>Add itinerary</h1>
    <ItineraryForm v-bind:itinerary="itinerary" />
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

<style scoped></style>