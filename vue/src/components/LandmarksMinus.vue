<template>
    <!-- <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link"> -->
    <div>
        <h1>{{ landmark.name }}</h1>
        <button @click="landmarkFromArray()">Remove from Itinerary: {{ itinerary.name }} </button>
    </div>
    <!-- </router-link> -->
</template>

<script>
export default {
    props: {
        landmark: {
            type: Object,
            required: true
        },
        itinerary: {
            type: Object
        }
    },
    methods: {
        landmarkFromArray() {
            this.$emit('remove-landmark', this.landmark);
        }
    }
}
</script>

<style scoped></style>