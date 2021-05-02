
<script>

  import Vue from 'vue';
  import axios from 'axios'
  import VueAxios from 'vue-axios'
  Vue.use(VueAxios, axios)
  export default {
    name: 'LijstKlanten',
    data(){
      return{
        list:undefined,
      }
    },
    mounted() {
      this.getListKlanten()
      localStorage.clear()
    },
    methods: {

      setKlantByid(id) {
        Vue.axios.get('http://localhost:8080/jaegherrest/klantdetails/'+ id)
                .then((resp) => {
                  window.location.href=/Klantupdate/
                  console.warn(resp.data)
                  localStorage.setItem('ID', id)
                })
      },
      deleteKlantById(id) {
        Vue.axios.delete('http://localhost:8080/jaegherrest/deleteklant/'+ id)
                .then((resp) => {
                  this.getListKlanten()
                  alert("Klant is verwijderd !")
                  console.warn(resp.data)
                })
      },
      getListKlanten() {
        Vue.axios.get('http://localhost:8080/jaegherrest/klanten')
                .then((resp) => {
                          this.list = resp.data;
                          console.warn(resp.data)
                        }
                )
      }
    }
  }


</script>

<template >
  <div>
    <h1>Lijst van klanten</h1>
    <table border = "1px" style="padding: 10px; margin: 0 auto">
      <tr>
        <th style="padding: 10px">ID:</th>
        <th style="padding: 10px">Vooraam:</th>
        <th style="padding: 10px">Achternaam:</th>
        <th style="padding: 10px">Email:</th>
        <th style="padding: 10px">Addres:</th>
        <th style="padding: 10px">Acties:</th>
      </tr>
      <tr v-for = "item in list" v-bind:key="item.id">
        <td id ="userid" style="padding: 10px">{{item.id}}</td>
        <td style="padding: 10px">{{item.naam}}</td>
        <td style="padding: 10px">{{item.achternaam}}</td>
        <td style="padding: 10px">{{item.email}}</td>
        <td style="padding: 10px">{{item.addres}}</td>
        <td style="padding: 10px"><button v-bind:itemid="item.id" @click="setKlantByid(item.id)" style="background-color: #04AA6D; color: white; padding: 12px; margin: 10px 0; border: none; width: 100%; border-radius: 3px; cursor:
        pointer; font-size: 17px;">Update</button>
        <button @click="deleteKlantById(item.id)" style="background-color: #04AA6D; color: white; padding: 12px; margin: 10px 0; border: none; width: 100%; border-radius: 3px; cursor: pointer;
        font-size: 17px;">Delete</button></td>

      </tr>
    </table>

  </div>
</template>

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
