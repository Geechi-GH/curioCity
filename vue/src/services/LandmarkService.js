import axios from 'axios';

export default {
    getLandmarkById(id) {
        return axios.get(`/landmarks/${id}`);
    },
    getLandmarks() {
        return axios.get('/landmarks');
    },
    // Gets categories from the server to be displayed in filter dropdown
    getCategories() {
        return axios.get('/categories');
    },
    likeLandmark(landmark) {
        return axios.put('/likes', landmark);
    },
    dislikeLandmark(landmark) {
        return axios.put('/dislikes', landmark);
    }
}
