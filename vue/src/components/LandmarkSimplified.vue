<template>
    <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link">
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
}
</script>

<style scoped></style>