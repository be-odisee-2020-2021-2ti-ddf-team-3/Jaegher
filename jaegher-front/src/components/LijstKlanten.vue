<template>
  <div>
    <h1>Lijst van klanten</h1>
    <table border = "1px" style="padding: 10px">
      <tr>
        <th  style="padding: 10px">Vooraam:</th>
        <th  style="padding: 10px">Achternaam:</th>
        <th style="padding: 10px">Email:</th>
        <th style="padding: 10px">Addres:</th>
      </tr>
      <tr v-for = "item in list" v-bind:key="item.id">
        <td style="padding: 10px">{{item.naam}}</td>
        <td style="padding: 10px">{{item.achternaam}}</td>
        <td style="padding: 10px">{{item.email}}</td>
        <td style="padding: 10px">{{item.addres}}</td>
      </tr>
    </table>

  </div>
</template>

<script>
  import Vue from 'vue';
  import axios from 'axios'
  import VueAxios from 'vue-axios'
  Vue.use(VueAxios, axios)

export default {
  name: 'LijstKlanten',
  data(){
    return{
        list:undefined
      }
    },
  mounted() {
    Vue.axios.get('http://localhost:8080/jaegherrest/klanten')
    .then((resp) => {
      this.list = resp.data;
      console.warn(resp.data)
      }
    )
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
