import axios from 'axios';

export default {

    getLandmarkById(id) {
        return axios.get(`/landmarks/${id}`);
    },
    getLandmarks() {
        return axios.get('/landmarks');
    }
}
