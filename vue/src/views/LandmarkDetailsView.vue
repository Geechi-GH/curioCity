<template>
    <div>
        <LandmarkDetails v-bind:landmark="landmark" />
    </div>
</template>

<script>
import LandmarkService from '../services/LandmarkService';
import LandmarkDetails from '../components/LandmarkDetails.vue';

export default {
    name: "LandmarkDetailsView",
    components: {
        LandmarkDetails
    },
    data() {
        return {
            landmark: {}
        }
    },
    methods: {
        getLandmark(landmarkId) {
            LandmarkService.getLandmarkById(landmarkId).then((response) => {
                this.landmark = response.data;
            })
        }
    },
    created() {
        this.getLandmarkById(this.$route.params.landmarkId);
    }
}
</script>

<style scoped></style>