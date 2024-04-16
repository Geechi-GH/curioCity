<template>
    <div>
        <landmark-details v-bind:landmark="landmark" v-on:update-likes="likeLandmark"
            v-on:dislike-landmark="dislikeLandmark" v-bind:likeStatus="likeStatus" />
        <div class="review-container" v-for="review in reviews" :key="review.reviewId">
            <reviews-simplified v-bind:review="review" />
        </div>
    </div>
</template>

<script>
import LandmarkService from '../services/LandmarkService';
import LandmarkDetails from '../components/LandmarkDetails.vue';
import ReviewService from '../services/ReviewService';
import ReviewsSimplified from '../components/ReviewsSimplified.vue';

export default {
    components: {
        LandmarkDetails,
        ReviewsSimplified
    },
    data() {
        return {
            LandRatDTO: {},
            landmark: {},
            reviews: [],
            likeStatus: 0
        }
    },
    methods: {
        getLandmark(id) {
            LandmarkService.getLandmarkById(id).then(response => {
                this.LandRatDTO = response.data;
                this.landmark = this.LandRatDTO.landmark;
                this.likeStatus = this.LandRatDTO.likeStatus;
            });
        },
        getTheReviews() {
            ReviewService.getReviews(this.$route.params.landmarkId).then(response => {
                this.reviews = response.data;
            })
        },
        likeLandmark() {
            LandmarkService.likeLandmark(this.landmark).then(response => {
                this.LandRatDTO = response.data;
                this.landmark = this.LandRatDTO.landmark;
                this.likeStatus = this.LandRatDTO.likeStatus;
            })
        },
        dislikeLandmark() {
            LandmarkService.dislikeLandmark(this.landmark).then(response => {
                this.LandRatDTO = response.data;
                this.landmark = this.LandRatDTO.landmark;
                this.likeStatus = this.LandRatDTO.likeStatus;
            })
        }
    },

    created() {
        this.getLandmark(this.$route.params.landmarkId);
        this.getTheReviews();

    }
}
</script>

<style scoped></style>