<template>
  <div id="app">
  <div>
    <b-nav tabs align="center" pills v-bind:class="active" v-on:click.prevent>

      <b-nav-item class="home btnsmenu" v-on:click="makeActive('home')" to="/home">Home</b-nav-item>
      <b-nav-item class="zoekklant btnsmenu" v-on:click="makeActive('zoekklant')" to="/">Zoek een klant</b-nav-item>
      <b-nav-item-dropdown
              id="my-nav-dropdown"
              text="Klanten"
              toggle-class="nav-link-custom"
              right class="Klanten"
      >
        <b-dropdown-item to="/JaegherListKlant" v-on:click="makeActive('Klanten')">Lijst Klanten</b-dropdown-item>
        <b-dropdown-item to="/MaakKlant" v-on:click="makeActive('Klanten')">Maak een klant</b-dropdown-item>
      </b-nav-item-dropdown>
      <b-nav-item-dropdown
              id="my-nav-dropdown"
              text="Bestellingen"
              toggle-class="nav-link-custom"
              right class="Bestellingen"
      >
        <b-dropdown-item to="/Jaegherlistbestellingen" v-on:click="makeActive('Bestellingen')">Lijst Bestellingen</b-dropdown-item>
        <b-dropdown-item v-on:click="makeActive('Bestellingen')">Maak een bestelling</b-dropdown-item>
      </b-nav-item-dropdown>
    </b-nav>
  </div>

    <router-view/>

  </div>


</template>

<script>

  import Vue from 'vue';
  import axios from 'axios'
  import VueAxios from 'vue-axios'
  Vue.use(VueAxios, axios)
  export default {
    data() {
      return {
        active: "home"
      }
    },

    // Functions we will be using.
    methods: {
      makeActive: function(item) {
        // When a model is changed, the view will be automatically updated.
        this.active = item;
      }
    },
    computed: {

    }

  }

</script>


<style>
  ul.home .home,
  ul.zoekklant .zoekklant,
  ul.Klanten .Klanten,
  ul.Bestellingen .Bestellingen {
    background-color: #8CC6FF;
  }
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }

  #nav a {
    font-weight: bold;
    color: #2c3e50;
  }

  #nav a.router-link-exact-active {
    color: #42b983;
  }
</style>
