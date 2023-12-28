import 'bootstrap/dist/css/bootstrap.min.css';
import router from './scripts/router.js';
import { createApp } from 'vue'
import App from './App.vue'
import store from './scripts/store.js';




const app = createApp(App);
app.use(store); // Vuex Store 등록
app.use(router);
app.mount('#app');