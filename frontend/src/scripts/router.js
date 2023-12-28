import {createRouter, createWebHistory} from 'vue-router' // 라우터 임포트
import Home from "@/pages/Home.vue"
import Login from "@/pages/Login.vue"
import Cart from "@/pages/Cart.vue"
import Order from "@/pages/Order.vue";

const routes = [
    {path: '/', component: Home}, // '/' 해당 경로로 접속 시 Home 컴포넌트로 접속
    {path: '/login', component: Login},
    {path: '/Cart', component: Cart},
    {path: '/order', component: Order},
    
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router