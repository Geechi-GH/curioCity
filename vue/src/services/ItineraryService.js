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
    addingLandmarkToItinerary(itinerary, id) {
        return axios.post(`/itinerary/${id}`, itinerary);
    },
    removingLandmarkFromItinerary(itinerary, id) {
        return axios.delete(`/itinerary/${id}`, itinerary);
    }
}