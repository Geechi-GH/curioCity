<template>
    <router-link v-bind:to="{ name: 'landmark-details', params: { landmarkId: landmark.id } }" class="link">
        <img v-bind:src="image" v-bind:alt="landmark.name" />
        <div>
            <h1>{{ landmark.name }}</h1>
            <p>{{ landmark.category }}</p>
            <p v-if="!isWeekend"> Weekdays: {{ convertedTimeRange }}</p>
            <p v-if="isWeekend"> Weekends: {{ convertedTimeRange }}</p>
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
    methods: {
        convertTimeFormat(time) {
            const date = new Date();
            const [hours, minutes] = time.split(':').map(Number);
            date.setHours(hours);
            date.setMinutes(minutes);

            const formattedHours = date.getHours() % 12 || 12;
            const amPm = date.getHours() < 12 ? 'am' : 'pm';

            return `${formattedHours}${amPm}`;
        },
        formatTimeRange(startTime, endTime) {
            const formattedStartTime = this.convertTimeFormat(startTime);
            const formattedEndTime = this.convertTimeFormat(endTime);

            return `${formattedStartTime} - ${formattedEndTime}`;
        }
    },
    computed: {
        image() {
            return (new URL(this.landmark.imagePath, import.meta.url)).href;
        },
        convertedTimeRange() {
            return this.formatTimeRange(this.landmark.weekdayOpen, this.landmark.weekdayClose);
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
    border: 1px solid #708090;
    border-radius: 4px;
}
</style>