<template>
    <div class="landmark-image">
        <img :src="image()" class="landmark-img" alt="Landmark Image">
        <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link">
            <h1>{{ landmark.name }}</h1>
        </router-link>
        <div class="button-container">
            <button @click="landmarkToArray()">Add to Itinerary </button>
        </div>
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
        image() {
            return (new URL(this.landmark.imagePath, import.meta.url)).href;
        },
        landmarkToArray() {
            this.$emit('add-landmark', this.landmark);
        }
    }
}
</script>

<style scoped>
body {
    background-image: linear-gradient(to bottom left, #3c3c3c, #020202);
    background-attachment: fixed;
}

div {
    display: flex;
    flex-direction: column;
    justify-content: center;
}

h1 {
    display: block;
    margin: 0 auto;
    text-align: center;
}

.landmark-image {
    position: relative;
    width: 200px;
    height: 150px;
}

.landmark-img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
    opacity: 0.45;
    z-index: -1;
}

.link:hover {
    color: #FFFFF0;
    -webkit-text-fill-color: #FFFFF0;
    text-decoration: none;
    cursor: pointer;

}

.button-container {
    flex: 1;
    /* Take up remaining space */
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
    /* Align children to the end */
}

button {
    font-size: .7em;
    margin-bottom: 5px;
    margin-left: 5px;
    color: #FFFFF0;
    background-color: #292929;
    margin: 0 auto;
    text-align: center;
}

button:hover {
    color: #d7b740;
    background-color: #292929;
    cursor: pointer;
}
</style>