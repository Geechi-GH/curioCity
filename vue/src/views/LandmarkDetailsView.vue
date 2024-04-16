<template>
    <div>
        <landmark-details v-bind:landmark="landmark" v-on:update-likes="likeLandmark"
            v-on:dislike-landmark="dislikeLandmark" v-bind:likeStatus="likeStatus" />

        <!-- WORKING HERE----------------------------------------------------------------- -->
        <button @click="showForm = !showForm">Add New Review</button>

        <form v-on:submit.prevent="addNewReview" v-show="showForm === true" id="frmAddNewReview">
            <div class="field">
                <label for="Name">Your Name:</label>
                <input type="text" id="Name" name="Name" v-model="review.name" />

            </div>
            <div class="field">
                <label for="reviewTitle">Review Title:</label>
                <input type="text" id="reviewTitle" name="reviewTitle" v-model="review.title" />
            </div>
            <div class="field">
                <label for="review">Review:</label>
                <input type="textarea" id="review" name="review" v-model="review.review" />
            </div>
            <button type="submit" class="btn save">Save User</button>
            <button type="button" class="btn cancel" v-on:click="resetForm()">Cancel</button>
        </form>
        <!-- WORKING HERE----------------------------------------------------------------- -->

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
            showForm: false,
            LandRatDTO: {},
            landmark: {},
            reviews: [],
            likeStatus: 0,
            review: {
                name: '',
                title: '',
                review: ''
            }
        }
    },
    methods: {
        addNewReview() {
            ReviewService.createReview(this.review).then(response => {
                this.reviews.push(response.data);
            })
            //ADD CODE TO ADD NEW REVIEW
            this.resetForm()
        },
        resetForm() {
            this.review = {
                name: '',
                title: '',
                review: ''
            },
                this.showForm = false;
        },

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