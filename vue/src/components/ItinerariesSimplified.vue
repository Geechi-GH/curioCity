<template>
    <div class="itinerary-card">
        <h1 class="title">{{ itinerary.title }}</h1>
        <p class="date">{{ itinerary.dateOfTravel }}</p>
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

<style>
.title {
    font-size: 1.5em;
    text-align: center !important;
    margin-bottom: 15px;
    color: #fffff0;
    justify-content: center;
    text-decoration: none;
    text-decoration-line: underline;
    text-decoration-style: unset;
    text-decoration-color: #292929;
}

.date {
    font-size: 1em;
    text-align: center !important;
    margin-bottom: 15px;
    color: #d7b740;
    justify-content: center;
    font-family: serif;
    text-decoration: none;
    text-decoration-line: underline;
    text-decoration-style: unset;
    text-decoration-color: #292929;
}
</style>