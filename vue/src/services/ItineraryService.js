import axios from "axios";

export default {
    getItineraries() {
        return axios.get('/itineraries');
    }
}