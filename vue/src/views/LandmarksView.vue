<template>
    <div>
        <div class="search-bar">
            <input type="text" v-model="searchQuery" placeholder="Search...">
            <label class="checkboxisweekend" for="weekendButton">Weekend</label>
            <input class="checkboxisweekend" type="checkbox" id="weekendButton" @click="isTheWeekend = !isTheWeekend">
            <input class="time" type="time" v-model="timeQuery">
            <select class="CategoryCS" v-model="selectedCategory">
                <option value="">All Categories</option>
                <option v-for="category in categories" :key="category" :value="category">{{ category }}</option>
            </select>
            <select class="Ratings" v-model="selectedRatingCategory">
                <option value="">All Ratings</option>
                <option value="positive">Positive Rated Landmarks</option>
                <option value="negative">Negative Rated Landmarks</option>
            </select>
        </div>
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
            selectedRatingCategory: '',
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
                return landmark.name.toLowerCase().includes(this.searchQuery.toLowerCase()) &&
                    (this.selectedCategory === '' || landmark.category.toLowerCase() === this.selectedCategory.toLowerCase()) &&
                    (this.timeQuery === '' || landmark.weekdayOpen <= this.timeQuery && landmark.weekdayClose > this.timeQuery) &&
                    (this.selectedRatingCategory === '' ||
                        (this.selectedRatingCategory === 'positive' && landmark.likeCount > landmark.dislikeCount) ||
                        (this.selectedRatingCategory === 'negative' && landmark.dislikeCount > landmark.likeCount));
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
            });
    },
};
</script>

<style scoped>
.title {
    font-size: 5em;
    text-align: center;
    margin-bottom: 5px;
    margin-top: 0px;
    color: #fffff0;
}

.search-bar {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 20px;
    background-color: #708090;
    border-radius: 15px;
}

.search-bar .time {
    display: inline-block;
    width: 4%;
    padding: 10px;
    margin-right: 10px;
    border: 1px solid #d7b740;
    border-radius: 15px;
    background-color: #292929;
    color: #fffff0;
}

.search-bar input {
    display: block;
    width: 25%;
    padding: 10px;
    margin-right: 10px;
    border: 1px solid #d7b740;
    border-radius: 15px;
    background-color: #292929;
    color: #fffff0;
}

.search-bar .checkboxisweekend {
    display: inline-block;
    width: 3%;
    padding: 10px;
    margin-right: 10px;
    border-radius: 4px;
}

.CategoryCS {
    width: 15%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #d7b740;
    border-radius: 15px;
    background-color: #292929;
    color: #fffff0;
}

.Ratings {
    width: 10%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #d7b740;
    border-radius: 15px;
    background-color: #292929;
    color: #fffff0;
}

.checkboxisweekend {
    display: inline-block;
    margin: 10px 0;
    width: fit-content;
    text-shadow: #292929 0 0 2px;
}

.landmark-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.landmark-list>* {
    border: 3px solid #708090;
    border-radius: 4px;
    padding: 10px;
    margin: 10px;
    flex: 0 0 10%;
    color: #fffff0;
}

.landmark-list>*:hover {
    background-color: rgba(112, 128, 144, 0.5);
}
</style>