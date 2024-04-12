import axios from "axios";

export default {
    getItineraries() {
        return axios.get('/itineraries');
    },
    create(itinerary) {
        return axios.post('/itineraries', itinerary);
    },
    addingLandmarkToItinerary(itinerary, id) {
        return axios.post(`/itinerary/${id}`, itinerary);
    },
    getItineraryById(id) {
        return axios.get(`/itineraries/${id}`);
    }
}