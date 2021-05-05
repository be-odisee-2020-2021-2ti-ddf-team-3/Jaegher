import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../../Views/Home.vue'  // HV mag weg later als ik HelloWorld wegwil
import Jaegher from "../../Views/Jaegher"
import MaakKlant from "../../Views/MaakKlant"
import lijstbestellingen from "../../Views/JaegherListBestellingen"
import LijstKlanten from "../../Views/JaegherListKlant"
import Klantupdate from "../../Views/KlantUpdate"
import Bestellingupdate from "../../Views/BestellingUpdate"

import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Import Bootstrap- an BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

Vue.use(VueRouter);

  const routes = [

    {
      path: '/Klantupdate/:id',
      name: 'Klantupdate',
      component: Klantupdate
    },
    {
      path: '/Bestellingupdate/:id',
      name: 'Bestellingupdate',
      component: Bestellingupdate
    },

  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/',
    name: 'Jaegher',
    component: Jaegher
  },


    {
      path: '/MaakKlant',
      name: 'MaakKlant',
      component: MaakKlant
    },


    {
      path: '/Jaegherlistbestellingen',
      name: 'Jaegherlistbestellingen',
      component: lijstbestellingen
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
