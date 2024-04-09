<template>
    <input type="text" v-model="searchQuery" placeholder="Search..." @input="handleSearch" />
</template>
  
<script>
import { debounce } from 'lodash';

export default {
    data() {
        return {
            searchQuery: '',
        };
    },
    methods: {
        handleSearch: debounce(function () {
            this.$store.dispatch('updateSearchQuery', this.searchQuery);
        }, 500),
    },
};
</script>