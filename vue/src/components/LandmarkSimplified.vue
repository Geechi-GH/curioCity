<template>
    <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link">
        <img v-bind:src="image" v-bind:alt="landmark.name" />
        <div>
            <h1>{{ landmark.name }}</h1>
            <p>{{ landmark.category }}</p>
        </div>
    </router-link>
</template>

<script>
export default {
    name: "LandmarkSimplified",
    props: {
        landmark: {
            type: Object,
            required: true
        },
    },
    computed: {
        image() {
            return (new URL(this.landmark.imagePath, import.meta.url)).href;
        }
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