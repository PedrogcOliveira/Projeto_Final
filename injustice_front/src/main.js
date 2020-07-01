import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'


import Home from './components/home.vue'
import Sobre from './components/sobre.vue'
import Lista from './components/lista.vue'

Vue.config.productionTip = false

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/home',
      component: Home
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/sobre',
      component: Sobre
    },
    {
      path: '/lista',
      component: Lista
    }
  ]
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
