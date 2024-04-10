<template>
    <div>
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

<style scoped>
h1 {
    margin-top: 0;
    font-size: 1.5rem;
}

div {

    height: 20vh;
    width: 25vh;
    object-position: center;
    object-fit: contain;
    border: 1px solid #708090;
    border-radius: 4px;
    margin: 10px;


}
</style>