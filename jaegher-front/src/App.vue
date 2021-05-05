<template>
  <div id="app">
  <div>
    <b-nav tabs align="center" pills>
      <b-nav-item active href="/home">Home</b-nav-item>
      <b-nav-item href="/">Zoek een klant</b-nav-item>
      <b-nav-item-dropdown
              id="my-nav-dropdown"
              text="Klanten"
              toggle-class="nav-link-custom"
              right
      >
        <b-dropdown-item to="/JaegherListKlant">Lijst Klanten</b-dropdown-item>
        <b-dropdown-item to="/MaakKlant">Maak een klant</b-dropdown-item>
      </b-nav-item-dropdown>
      <b-nav-item-dropdown
              id="my-nav-dropdown"
              text="Bestellingen"
              toggle-class="nav-link-custom"
              right
      >
        <b-dropdown-item href="/Jaegherlistbestellingen">Lijst Bestellingen</b-dropdown-item>
        <b-dropdown-item>Maak een bestelling</b-dropdown-item>
      </b-nav-item-dropdown>
    </b-nav>
  </div>


    <router-view/>

  </div>


</template>


<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }

  #nav {
    padding: 30px;
  }

  #nav a {
    font-weight: bold;
    color: #2c3e50;
  }

  #nav a.router-link-exact-active {
    color: #42b983;
  }
</style>
