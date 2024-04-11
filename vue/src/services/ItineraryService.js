import axios from "axios";

export default {
    getItineraries() {
        return axios.get('/itineraries');
    },

    create(itinerary) {
        return axios.post('/itineraries', itinerary);
    }
}