<template>
    <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link">
        <img v-bind:src="image" v-bind:alt="landmark.name" />
        <div>
            <h1>{{ landmark.name }}</h1>
            <p>{{ landmark.category }}</p>
            <p v-if="!isWeekend"> Weekday Opening Hour: {{ landmark.weekdayOpen == '00:00:00' && landmark.weekdayClose ===
                '00:00:00' ?
                'Closed' :
                landmark.weekdayOpen }}</p>
            <p v-if="!isWeekend"> Weekday Closing Hour: {{ landmark.weekdayOpen === '00:00:00' && landmark.weekdayClose
                ===
                '00:00:00' ? '' :
                landmark.weekdayClose }}</p>
            <br>
            <p v-if="isWeekend"> Weekend Opening Hour: {{ landmark.weekendOpen == '00:00:00' && landmark.weekendClose ===
                '00:00:00' ?
                'Closed' :
                landmark.weekendOpen }}</p>
            <p v-if="isWeekend"> Weekend Closing Hour: {{ landmark.weekendOpen === '00:00:00' && landmark.weekendClose ===
                '00:00:00' ? '' :
                landmark.weekendClose }}</p>

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
        isWeekend: {
            type: Boolean,
        }
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
    object-position: center;
    object-fit: contain;
}
</style>