import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../../Views/Home.vue'  // HV mag weg later als ik HelloWorld wegwil
import Jaegher from "../../Views/Jaegher";
import MaakKlant from "../../Views/MaakKlant";
import LijstKlanten from "../../Views/JaegherListKlant";
import Klantupdate from "../../Views/KlantUpdate";


Vue.use(VueRouter);

  const routes = [
    {
      path: '/Klantupdate',
      name: 'Klantupdate',
      component: Klantupdate
    },
  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/Jaegher',
    name: 'Jaegher',
    component: Jaegher
  },


    {
    path: '/MaakKlant',
    name: 'MaakKlant',
    component: MaakKlant
},
    {
      path: '/JaegherListKlant',
      name: 'JaegherListKlant',
      component: LijstKlanten
    }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
