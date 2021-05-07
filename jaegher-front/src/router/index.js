import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../../Views/Home.vue'  // HV mag weg later als ik HelloWorld wegwil
import zoekklant from "../../Views/Jaegher"
import MaakKlant from "../../Views/MaakKlant"
import MaakBestelling from "../../Views/MaakBestelling"
import lijstbestellingen from "../../Views/JaegherListBestellingen"
import LijstKlanten from "../../Views/JaegherListKlant"
import Klantupdate from "../../Views/KlantUpdate"
import Bestellingupdate from "../../Views/BestellingUpdate"
import Lichaamsmaatupdate from "../../Views/LichaamsmaatUpdate"


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
      path: '/Lichaamsmaatupdate/:id',
      name: 'Lichaamsmaatupdate',
      component: Lichaamsmaatupdate
    },
    {
    path: '/',
    name: 'Home',
    component: Home
    },
    {
    path: '/zoekklant',
    name: 'zoekklant',
    component: zoekklant
    },
    {
      path: '/MaakKlant',
      name: 'MaakKlant',
      component: MaakKlant
    },
    {
      path: '/MaakBestelling',
      name: 'MaakBestelling',
      component: MaakBestelling
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
