<template>
    <body>
        <div>
            <div id="title-image-container">
                <img id="image" v-bind:src="image" v-bind:alt="landmark.name" />
                <h1 id="title">{{ landmark.name }}</h1>
            </div>
            <p id="category">Category: {{ landmark.category }}</p>
            <p id="description">Description: {{ landmark.description }}</p>
            <section>
                <div id="weekday">
                    <h2>Weekday Hours</h2>
                </div>
                <div id="weekdayhours">
                    <p>Opens: {{ formatTime(landmark.weekdayOpen) }}</p>
                    <p>Closes: {{ formatTime(landmark.weekdayClose) }}</p>
                </div>
                <div id="weekend">
                    <h2>Weekend Hours</h2>
                </div>
                <div id="weekendhours">
                    <p>Opens: {{ formatTime(landmark.weekendOpen) }}</p>
                    <p>Closes: {{ formatTime(landmark.weekendClose) }}</p>
                </div>
                <div>
                    <p id="likes" v-on:click="likeLandmark(landmark)">Likes: {{ updatedLikeCount }}</p>
                    <p id="dislikes" v-on:click="dislikeLandmark(landmark)">Dislikes: {{ updatedDislikeCount }}</p>
                </div>
            </section>
        </div>
    </body>
</template>

<script>
import LandmarkService from '../services/LandmarkService';
export default {
    name: "LandmarkDetails",
    props: {
        landmark: {
            type: Object,
            required: true,
        },

    },
    computed: {
        image() {
            return (new URL(this.landmark.imagePath, import.meta.url)).href;
        },
        computed: {
            updatedLikeCount() {
                return this.landmark.likeCount;
            },
            updatedDislikeCount() {
                return this.landmark.dislikeCount;
            }
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
        },
        likeLandmark(landmark) {
            LandmarkService.likeLandmark(landmark)
        },
        dislikeLandmark(landmark) {
            LandmarkService.dislikeLandmark(landmark)
        }
    }
}
</script>

<style scoped>
#title-image-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

#image {
    height: 60%;
    width: 60%;
    object-fit: contain;
    border: 1px solid #708090;
    border-radius: 4px;
}

#title {
    display: block;
    justify-content: center;
    align-items: center;
    font-size: 3em;
    font-weight: bold;
    font-family: serif;
    -webkit-text-stroke: #292929 1px;
    text-align: center;
    margin-bottom: 5px;
    margin-top: 0px;
    color: #fffff0;
}

#category {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1 em;
    font-weight: bold;
    font-family: serif;
    text-align: center;
    margin-bottom: 20px;
    margin-top: 5px;
    color: #d7b740;
    padding-bottom: 5px;
    padding-top: 5px;
    background-color: #708090;

    border-radius: 15px;
    text-decoration: #292929 underline;
    text-decoration-style: solid;

}

#description {
    display: flex;
    justify-content: left;
    align-items: center;
    font-size: 1.5em;
    font-family: serif;
    text-align: center;
    margin-bottom: 5px;
    margin-top: 0px;
    color: #fffff0;
    border-bottom: 3px solid #708090;
}


#weekday {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    font-size: smaller;
    text-decoration: underline #708090;
    border-top: #708090 3px solid;
    color: #d7b740;
}

#weekdayhours {
    display: flex;
    flex-direction: column;
    align-self: center;
    justify-content: center;
    align-items: center;
}

#weekend {
    display: flex;
    flex-direction: row;
    align-items: center;
    align-self: center;
    font-size: smaller;
    text-decoration: underline #708090;
    justify-content: center;
    color: #d7b740;
}

#weekend #weekday {
    display: flex;
    flex-direction: row;
    align-items: center;
    align-self: center;
    font-size: smaller;
    justify-content: center;

}

#weekendhours {
    display: flex;
    flex-direction: column;
    align-self: center;
    justify-content: center;
    align-items: center;
}
</style>