<template>
    <div>
        <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link">
            <h1>{{ landmark.name }}</h1>
        </router-link>
        <button @click="landmarkFromArray()">Remove from Itinerary</button>
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
        },
        index: {
            type: Number // Add index prop
        }
    },

    methods: {
        landmarkFromArray() {
            this.$emit('remove-landmark', this.landmark);
        }
    }
}
</script>

<style scoped>
h1 {
    margin-left: 10px;
}

button {
    margin-bottom: 5px;
    margin-left: 5px;
}
</style>