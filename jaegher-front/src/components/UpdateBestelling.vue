<template>
  <div>
    <div class="row" style="display: flex;
    flex-wrap: wrap;
    margin: 0 -16px;">
      <div class="col-75" style=" flex: 75%; padding: 0 16px;">
        <div class="container" style=" background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;">
          <form @submit.prevent="UpdatePost()">

            <div class="row" style="display: flex;
               flex-wrap: wrap;
               margin: 0 -16px;">
              <div class="col-50" style="padding: 0 16px;  flex: 50%;">
                <h3 style="margin-bottom: 1rem">Wijzig Informatie</h3>
                <label style="margin-bottom: 10px; display: block;"><font-awesome-icon icon="user" />
                 ID:</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="id" v-model="bestellingen.id" placeholder="id" readonly>

                <label style="margin-bottom: 10px; display: block;" for="naam"><font-awesome-icon icon="user" />
                  Naam</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="naam" v-model="bestellingen.naam" placeholder="John">
                <label style="margin-bottom: 10px; display: block;" for="aanMaakDatum"><font-awesome-icon icon="calendar-alt" /> Aanmaakdatum</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="date" id="aanMaakDatum" v-model="bestellingen.aanMaakDatum" placeholder="2020-05-05">
                <label style="margin-bottom: 10px; display: block;" for="goedgekeurd"><font-awesome-icon icon="envelope" /> Goedgekeurd?</label>
                <b-form-radio-group
                        v-model="bestellingen.goedgekeurd"
                        :options="options"
                        class="mb-3"
                        value-field="item"
                        text-field="name"
                        disabled-field="notEnabled"
                ></b-form-radio-group>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="goedgekeurd" v-model="bestellingen.goedgekeurd" name="goedgekeurd" placeholder="true">
                <label style="margin-bottom: 10px; display: block;" for="klantid"><font-awesome-icon icon="user" /> Klant ID:</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="number" id="klantid" v-model="bestellingen.klantId" >


                <button clas="btn" id="updateklant" style="background-color: #04AA6D;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;">Update Klant</button>
              </div>
            </div>

          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import axios from 'axios'
  import Vue from "vue";

  export default {
    name: 'UpdatePost',

    data(){
      return{
        selected:'',
        options: [
          { item: 'true', name: 'True' },
          { item: 'false', name: 'False' }],
        "bestellingen": {
          "id": '',
          "naam":'',
          "aanMaakDatum": '',
          "goedgekeurd": '',
          "klantId": '',
        }
      };


    },
    created() {
      this.getBestellingByid(this.$route.params.id)
    },
    methods: {
      UpdatePost()  {
        const headers = {
          withCredentials: true,

        };
        console.log(this.bestellingen)
        axios.post('http://localhost:8081/jaegherrestbestellingen/updatebestelling/ ', this.bestellingen, headers)
                .then(response => {
                  // success
                  alert('Klant is goed geupdate !')
                  window.location.href = '/Jaegherlistbestellingen/'
                  console.log(response)
                }, response => {
                  //error
                  if(response.status === 422 || response.status === 500) {
                    this.errored = true
                    console.log('Fout !')

                  }
         })
      },
      getBestellingByid(id) {
        Vue.axios.get('http://localhost:8081/jaegherrestbestellingen/bestellingdetails/'+ id)
                .then((resp) => {
                  this.bestellingen.id = resp.data.id,
                  this.bestellingen.naam = resp.data.naam,
                  this.bestellingen.aanMaakDatum = resp.data.aanMaakDatum,
                  this.bestellingen.goedgekeurd = resp.data.goedgekeurd,
                  this.bestellingen.klantId = resp.data.klantId,
                  console.warn(resp.data)

          })
      }
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
#updateklant:hover {
  opacity: 0.5;
}
</style>
