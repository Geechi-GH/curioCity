<template>
    <div class="itinerary-card">
        <h1>{{ itinerary.title }}</h1>
        <p>{{ itinerary.dateOfTravel }}</p>
    </div>
</template>

<script>
export default {
    name: "ItinerariesSimplified",
    props: {
        itinerary: {
            type: Object,
        }
    }
}
</script>

<style></style>