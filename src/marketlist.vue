<template>
  <div>
    <h1>Dallas Farmers Market Finder</h1>
    <div>
      <input v-model="day" placeholder="Filter by Day" />
      <button @click="filterByDay">Search</button>
    </div>
    <ul>
      <li v-for="market in markets" :key="market.id">
        <strong>{{ market.name }}</strong> - {{ market.location }} ({{ market.hours }})
      </li>
    </ul>
  </div>
</template>

<script>
import apiClient from "./api";

export default {
  data() {
    return {
      markets: [],
      day: "",
    };
  },
  methods: {
    fetchMarkets() {
      apiClient.get("/").then((response) => {
        this.markets = response.data;
      });
    },
    filterByDay() {
      apiClient.get(`/day/${this.day}`).then((response) => {
        this.markets = response.data;
      });
    },
  },
  created() {
    this.fetchMarkets();
  },
};
</script>
