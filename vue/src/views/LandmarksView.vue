<template>
    <div>
        <h1>Landmarks</h1>
        <input type="search">
        <section class="landmark-list">
            <LandmarkSimplified v-for="landmark in landmarks" :key="landmark.id" :landmark="landmark" />
        </section>
    </div>
</template>

<script>
import LandmarkService from '../services/LandmarkService';
import LandmarkSimplified from '../components/LandmarkSimplified.vue';

export default {
    name: "LandmarksView",
    components: {
        LandmarkSimplified,
    },
    computed: {
        landmarks() {
            return this.$store.state.landmarks;
        }
    },
    created() {
        const landmarks = LandmarkService.getLandmarks()
            .then(response => {
                this.$store.commit('SET_LANDMARKS', response.data);
            });
    },
};
</script>

<style scoped></style>