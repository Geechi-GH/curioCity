import axios from "axios";

export default {
    getItineraries() {
        return axios.get('/itineraries');
    },
    getItineraryById(id) {
        return axios.get(`/itineraries/${id}`);
    },
    create(itinerary) {
        return axios.post('/itineraries', itinerary);
    },
    flushAndFill(itinerary, id) {
        return axios.put(`/itinerary/${id}`, itinerary);
    }
}