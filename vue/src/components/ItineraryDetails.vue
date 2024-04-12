<template>
    <div>
        <section>
            <p>{{ itinerary.landmarksArray }}</p>
        </section>
    </div>
</template>

<script>
export default {
    name: "ItineraryDetails",
    props: {
        itinerary: {
            type: Object
        }
    }
}
</script>

<style scoped></style>