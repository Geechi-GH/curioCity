<template>
    <div>
        <h1 class="title">Landmarks</h1>
        <input type="text" v-model="searchQuery" placeholder="Search...">
        <label class="checkboxisweekend" for="weekendButton">Weekend</label>
        <input type="checkbox" id="weekendButton" @click="isTheWeekend = !isTheWeekend">
        <input class="time" type="time" v-model="timeQuery">
        <!-- <input type="text" v-model="categoryQuery" placeholder="Category..."> -->
        <select class="Category" v-model="selectedCategory">
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
            categories: ['Public Space', 'Attraction', 'Museum', 'Landmark', 'Botanical Garden', 'Entertainment', 'Observatory'],
        };
    },
    name: "LandmarksView",
    components: {
        LandmarkSimplified,
    },
    // methods: {
    //     checkboxClicked() {
    //         this.isTheWeekend = !this.isTheWeekend;
    //     }
    // },
    computed: {
        landmarks() {
            return this.$store.state.landmarks;
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
    },
};
</script>

<style scoped>
.title {
    font-size: 5em;
    font-weight: bold;
    text-align: center;
    margin-bottom: 20px;
    color: #d7b740
}

input[type="text"],
input[type="time"],
.Category {
    width: 15%;
    padding: 10px;
    margin: 10px 0;
    border: 3px solid #708090;
    border-radius: 4px;
}

.checkboxisweekend {
    display: inline-block;
    margin: 10px 0;
    width: fit-content;
}

.time [type="checkbox"] {
    margin-right: 10px;
    width: 100%;
}

.landmark-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.landmark-list>* {
    border: 3px solid #d7b740;
    border-radius: 4px;
    padding: 10px;
    margin: 10px;
    flex: 0 0 10%;
}
</style>