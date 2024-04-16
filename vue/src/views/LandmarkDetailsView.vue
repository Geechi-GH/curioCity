<template>
    <div>
        <landmark-details v-bind:landmark="landmark" v-on:update-likes="likeLandmark"
            v-on:dislike-landmark="dislikeLandmark" v-bind:likeStatus="likeStatus" />

        <!-- WORKING HERE----------------------------------------------------------------- -->
        <div class="form-container">
            <!-- <button @click="showForm = !showForm" v-show="showForm === false" v-if="this.reviews.contains(this.$store.state.user.id)">Add New Review</button> -->
            <button @click="showForm = !showForm" v-if="showAddReviewButton && !showForm">Add New Review</button>
            <!-- v-show="this.reviews.map(review => review.userId).includes(this.$store.state.user.id)">Add New Review</button> -->

            <form v-on:submit="addNewReview" v-show="showForm === true" id="frmAddNewReview">
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
                    <textarea type="textarea" rows="5" cols="50" id="review" name="review"
                        v-model="review.review">   </textarea>
                </div>
                <button type="submit" class="btn save">Save Review</button>
                <button type="button" class="btn cancel" v-on:click="resetForm()">Cancel</button>
            </form>
        </div>
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
            review: {}
        }
    },
    computed: {
        updateReviews() {
            return this.reviews;
        },
        showAddReviewButton() {
            return !this.reviews.map(review => review.userId).includes(this.$store.state.user.id);
        }
    },
    methods: {
        addNewReview() {
            this.review.userId = this.$store.state.user.id;
            this.review.landmarkId = this.$route.params.landmarkId;
            console.log(this.review)
            ReviewService.createReview(this.review).then(response => {
                this.reviews.unshift(response.data);
            })
            //ADD CODE TO ADD NEW REVIEW
            this.resetForm()
        },
        resetForm() {
            this.review = {},
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

<style scoped>
.form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    /* Optional: Centers vertically within the viewport */
}
</style>