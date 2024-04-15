<template>
    <div>
        <router-link id="landmark-name" v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }"
            class="link">
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
#landmark-name {
    display: flex;
    margin-left: 10px;
    width: fit-content;
    color: #D7B740;
}

#landmark-name:hover {
    cursor: pointer;
    color: #FFFFF0;
    -webkit-text-fill-color: #FFFFF0;
}

button {
    margin-bottom: 5px;
    margin-left: 5px;
    color: #FFFFF0;
    background-color: #292929;


}

button:hover {
    color: #d7b740;
    background-color: #292929;
    cursor: pointer;

}
</style>