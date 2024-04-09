<template>
    <div>
        <h1>Landmarks</h1>
        <input type="text" v-model="searchQuery" placeholder="Search...">
        <label for="weekendButton">isWeekend</label>
        <input type="checkbox" id="weekendButton" @click="isTheWeekend = !isTheWeekend">
        <input type="time" v-model="timeQuery">

        <select v-model="selectedCategory">
            <option value="">All Categories</option>
            <option v-for="category in categories" :key="category" :value="category">{{ category }}</option>
        </select>
        <section class="landmark-list">
            <LandmarkSimplified v-for="landmark in filteredLandmarks" :key="landmark.id" :landmark="landmark"
                :isWeekend="isTheWeekend" />
        </section>
    </div>
</template>

<script>
import LandmarkService from '../services/LandmarkService';
import LandmarkSimplified from '../components/LandmarkSimplified.vue';

export default {
    data() {
        return {
            isTheWeekend: false,
            timeQuery: '',
            searchQuery: '',
            selectedCategory: '',

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
        categories() {
            return this.$store.state.categories;
        },
        filteredLandmarks() {
            return this.landmarks.filter(landmark => {
                return landmark.name.toLowerCase().includes(this.searchQuery.toLowerCase()) && (this.selectedCategory === '' || landmark.category.toLowerCase() === this.selectedCategory.toLowerCase()) && (this.timeQuery === '' || landmark.weekdayOpen <= this.timeQuery && landmark.weekdayClose > this.timeQuery);
            });
        },

    },
    created() {
        const landmarks = LandmarkService.getLandmarks()
            .then(response => {
                this.$store.commit('SET_LANDMARKS', response.data);
            });
        const categories = LandmarkService.getCategories()
            .then(response => {
                this.$store.commit('SET_CATEGORIES', response.data);
            })
    },
};
</script>

<style scoped></style>