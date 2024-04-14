<template>
    <div>
        <landmark-details v-bind:landmark="landmark" v-on:update-likes="likeLandmark"
            v-on:dislike-landmark="dislikeLandmark" />
    </div>
</template>

<script>
import LandmarkService from '../services/LandmarkService';
import LandmarkDetails from '../components/LandmarkDetails.vue';

export default {
    components: {
        LandmarkDetails
    },
    data() {
        return {
            landmark: {}
        }
    },
    methods: {
        getLandmark(id) {
            LandmarkService.getLandmarkById(id).then(response => {
                this.landmark = response.data;
            });
        },
        likeLandmark() {
            LandmarkService.likeLandmark(this.landmark).then(response => {
                this.landmark = response.data;
            })
        },
        dislikeLandmark() {
            LandmarkService.dislikeLandmark(this.landmark).then(response => {
                this.landmark = response.data;
            })
        }
    },

    created() {
        this.getLandmark(this.$route.params.landmarkId);
    }
}
</script>

<style scoped></style>