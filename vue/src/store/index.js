import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      landmarks: [],
      categories: [],
      itineraries: []
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_LANDMARKS(state, landmarks) {
        state.landmarks = landmarks;
      },
      SET_CATEGORIES(state, categories) {
        state.categories = categories;
      },
      SET_ITINERARIES(state, itineraries) {
        state.itineraries = itineraries;
      },
      ADD_ITINERARY(state, itinerary) {
        state.itineraries.push(itinerary);
      },
    },
  });
  return store;
}
