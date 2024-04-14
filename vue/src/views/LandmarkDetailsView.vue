<template>
    <div>
        <landmark-details v-bind:landmark="landmark" />
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
        }
    },
    created() {
        this.getLandmark(this.$route.params.landmarkId);
    }
}
</script>

<style scoped></style>