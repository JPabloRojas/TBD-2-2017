import Vue from 'vue';
import VueRouter from 'vue-router';
import Index from './Index.vue';
import Actors from './Actors.vue';
import Ranking from './Ranking.vue';
import Mapa from './Mapa.vue';
import Nodos from './Nodos.vue';
import Valoracion from './Valoracion.vue';
import Usuarios from './Usuarios.vue';
import Login from './Login.vue';
import Juegos from './Juegos.vue';
import VueResource from 'vue-resource';
require("./style.scss");

import App from './App.vue';
Vue.use(VueRouter);
Vue.use(VueResource);
const routes = [
  { path: '/index', alias: '/', component: Index},
  { path:'/actors', component: Actors},
  { path:'/ranking', component: Ranking},
  { path:'/valoracion', component: Valoracion},
  { path:'/nodos', component: Nodos},
  { path:'/usuarios', component: Usuarios},
  { path:'/mapa', component: Mapa},
  { path:'/login', component: Login},
  { path:'/juegos', component: Juegos}

]

// Create the router instance and pass the `routes` option
const router = new VueRouter({
  routes
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
