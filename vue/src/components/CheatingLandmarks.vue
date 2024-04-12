<template>
    <!-- <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link"> -->
    <div>
        <h1>{{ landmark.name }}</h1>
        <button @click="landmarkToArray()">Add to Itinerary: {{ itinerary.title }} </button>
    </div>
    <!-- </router-link> -->
</template>

<script>
export default {
    name: "CheatingLandmarks",
    props: {
        landmark: {
            type: Object,
            required: true
        },
        isWeekend: {
            type: Boolean,
        },
        itinerary: {
            type: Object
        }
    },

    computed: {

    },
    methods: {
        landmarkToArray() {
            this.$emit('add-landmark', this.landmark);
        }
    }
}
</script>

<style scoped></style>