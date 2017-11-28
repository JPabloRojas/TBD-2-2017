import Vue from 'vue';
import Router from 'vue-router';
import Juegos from '@/Juegos';


Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Juegos',
      component: Juegos
    }
  ]
});
