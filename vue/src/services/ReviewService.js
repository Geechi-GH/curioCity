import axios from 'axios';

export default {
    getReviews(landmarkId) {
        return axios.get(`/reviews/${landmarkId}`);
    }
}
