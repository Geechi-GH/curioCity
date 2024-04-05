import axios from 'axios';

export default {

    getLandmark() {
        return axios.get('/landmarks/:landmarkId');
    }
}
