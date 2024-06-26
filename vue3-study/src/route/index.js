import  About  from "@/components/About.vue";
import   Home  from "@/components/Home.vue";
import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/about',
        name: 'About',
        component: About
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router