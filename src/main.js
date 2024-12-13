import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/tailwind.css'

createApp(App)
  .use(router)
  .use(store)
  .mount('#app')

// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import MarketList from '@/views/MarketList.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: MarketList
  }
]

export default createRouter({
  history: createWebHistory(),
  routes
})
