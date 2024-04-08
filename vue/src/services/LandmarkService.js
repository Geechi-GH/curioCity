import axios from 'axios';

export default {

    getLandmarkById() {
        return axios.get('/landmarks/:landmarkId');
    },
    getLandmarks() {
        return axios.get('/landmarks');
    }
}
