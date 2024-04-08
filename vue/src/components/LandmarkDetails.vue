<template>
    <div>
        <!-- <img v-bind:src="landmark.imageUrl" v-bind:alt="landmark.name + ' image'" /> -->
        <h1>{{ landmark.name }}</h1>
        <p>{{ landmark.category }}</p>
        <p>{{ landmark.description }}</p>
    </div>
</template>

<script>
export default {
    name: "LandmarkDetails",
    props: {
        landmark: Object
    }
}
</script>

<style scoped></style>