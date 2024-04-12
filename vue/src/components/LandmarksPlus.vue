<template>
    <!-- <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link"> -->
    <div>
        <h1>{{ landmark.name }}</h1>
        <button @click="landmarkToArray()">Add to Itinerary: {{ itinerary.name }} </button>
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
        landmarkToArray() {
            this.$emit('add-landmark', this.landmark);
        }
    }
}
</script>

<style scoped></style>