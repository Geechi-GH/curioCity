<template>
    <img src="../assets/Fountain Square.jpg" alt="Fountain Square.jpg" class="landmark-image" />
    <div>
        <h1>{{ landmark.name }}</h1>
        <p>{{ landmark.category }}</p>
        <p>{{ landmark.description }}</p>
    </div>
</template>

<script>
export default {
    name: "LandmarkDetails",
    props: {
        landmark: {
            type: Object,
            required: true
        },
    },
}
</script>

<style scoped>
img {
    height: 30vh;
    width: 30vh;
    object-fit: cover;
}
</style>