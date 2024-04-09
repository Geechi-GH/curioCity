<template>
    <div>
        <h1>Landmarks</h1>
        <input type="text" v-model="searchQuery" placeholder="Search...">
        <!-- <input type="text" v-model="categoryQuery" placeholder="Category..."> -->
        <select v-model="selectedCategory">
            <option value="">All Categories</option>
            <option v-for="category in categories" :key="category" :value="category">{{ category }}</option>
        </select>
        <section class="landmark-list">
            <LandmarkSimplified v-for="landmark in filteredLandmarks" :key="landmark.id" :landmark="landmark" />
        </section>
    </div>
</template>

<script>
import LandmarkService from '../services/LandmarkService';
import LandmarkSimplified from '../components/LandmarkSimplified.vue';

export default {
    data() {
        return {
            searchQuery: '',
            selectedCategory: '',
            categories: ['Public Space', 'Attraction', 'Museum', 'Landmark', 'Botanical Garden', 'Entertainment', 'Observatory'],
        };
    },
    name: "LandmarksView",
    components: {
        LandmarkSimplified,
    },
    computed: {
        landmarks() {
            return this.$store.state.landmarks;
        },
        filteredLandmarks() {
            return this.landmarks.filter(landmark => {
                return landmark.name.toLowerCase().includes(this.searchQuery.toLowerCase()) && (this.selectedCategory === '' || landmark.category.toLowerCase() === this.selectedCategory.toLowerCase());
            });
        },
    },
    created() {
        const landmarks = LandmarkService.getLandmarks()
            .then(response => {
                this.$store.commit('SET_LANDMARKS', response.data);
            });
    },
};
</script>

<style scoped>


</style>