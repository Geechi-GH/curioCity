<template>
    <body>
        <img v-bind:src="image" v-bind:alt="landmark.name" />
        <div>
            <h1>{{ landmark.name }}</h1>
            <p>Category: {{ landmark.category }}</p>
            <section class="hours">
                <div id="weekday">
                    <h2>Weekday Hours</h2>
                    <p>Opens: {{ formatTime(landmark.weekdayOpen) }}</p>
                    <p>Closes: {{ formatTime(landmark.weekdayClose) }}</p>
                </div>
                <div id="weekend">
                    <h2>Weekend Hours</h2>
                    <p>Opens: {{ formatTime(landmark.weekendOpen) }}</p>
                    <p>Closes: {{ formatTime(landmark.weekendClose) }}</p>
                </div>
            </section>
        </div>
    </body>
    <p>Description: {{ landmark.description }}</p>
</template>

<script>
export default {
    name: "LandmarkDetails",
    props: {
        landmark: {
            type: Object,
            required: true
        },
    },
    computed: {
        image() {
            return (new URL(this.landmark.imagePath, import.meta.url)).href;
        }
    },
    methods: {
        formatTime(timeString) {
            // Parse the time string into hours, minutes, and seconds
            const [hours, minutes] = timeString.split(':').map(Number);
            // Create a Date object to handle conversion to AM/PM format
            const date = new Date();
            date.setHours(hours);
            date.setMinutes(minutes);
            // Get hours and minutes in 12-hour format
            let formattedHours = date.getHours() % 12;
            formattedHours = formattedHours === 0 ? 12 : formattedHours; // Convert 0 to 12
            const formattedMinutes = (date.getMinutes() < 10 ? '0' : '') + date.getMinutes(); // Add leading zero if needed
            // Determine whether it's AM or PM
            const amOrPm = date.getHours() < 12 ? 'AM' : 'PM';
            // Return the formatted time string
            return `${formattedHours}:${formattedMinutes} ${amOrPm}`;
        }
    }
}
</script>

<style scoped>
img {
    height: 50vh;
    width: 50vh;
    object-fit: cover;
}

body {
    display: flex;
    flex-direction: row;
}

div {
    align-self: flex-start;
    padding-left: 30px;
}

h1 {
    margin-top: 0;
    font-size: 3rem;
}

.hours {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
        "weekday weekend"
    ;
}

#weekday {
    grid-area: weekday;
    border: white 1px solid;
    padding: 10px;

}

#weekend {
    grid-area: weekend;
    border: white 1px solid;
    padding: 10px;
}

p {
    font-size: 1.25rem;
}
</style>