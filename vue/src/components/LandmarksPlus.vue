<template>
    <div>
        <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link">
            <h1>{{ landmark.name }}</h1>
        </router-link>
        <button @click="landmarkToArray()">Add to Itinerary: {{ itinerary.title }} </button>
    </div>
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