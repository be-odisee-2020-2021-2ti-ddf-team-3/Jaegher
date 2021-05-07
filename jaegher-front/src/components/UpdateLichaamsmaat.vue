<template>
  <div style="margin-top: 3rem">
    <b-alert
            :show="dismissCountDown"
            dismissible
            fade
            variant="success"
            @dismiss-count-down="countDownChanged"
    >
      Lichaamsmaat is goed geupdate !
    </b-alert>
    <div class="row" style="display: flex;
    flex-wrap: wrap;
    margin: 0 -16px;">
      <div class="col-75" style=" flex: 75%; padding: 0 16px;">
        <div class="container" style=" background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;">
          <form @submit.prevent="UpdatePost(),showAlert()">

            <div class="row" style="display: flex;
               flex-wrap: wrap;
               margin: 0 -16px;">
              <div class="col-50" style="padding: 0 16px;  flex: 50%;">
                <h3 style="margin-bottom: 1rem">Wijzig Informatie</h3>
                <label style="margin-bottom: 10px; display: block;" for="LinkerBeen"><font-awesome-icon icon="user" />
                  LinkerBeen</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="LinkerBeen" v-model="lichaamsmaten.linkerBeen">
                <label style="margin-bottom: 10px; display: block;" for="rechterBeen"><font-awesome-icon icon="calendar-alt" /> RechterBeen</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="rechterBeen" v-model="lichaamsmaten.rechterBeen">
                <label style="margin-bottom: 10px; display: block;" for="Bekkenkanteling"><font-awesome-icon icon="user" />
                  Bekkenkanteling</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="Bekkenkanteling" v-model="lichaamsmaten.bekkenkanteling">
                <label style="margin-bottom: 10px; display: block;" for="Gewicht"><font-awesome-icon icon="calendar-alt" /> Gewicht</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="Gewicht" v-model="lichaamsmaten.gewicht">
                <label style="margin-bottom: 10px; display: block;" for="Grootte"><font-awesome-icon icon="user" />
                  Grootte</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="Grootte" v-model="lichaamsmaten.groote">
                <label style="margin-bottom: 10px; display: block;" for="LinkerArm"><font-awesome-icon icon="calendar-alt" /> LinkerArm</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="LinkerArm" v-model="lichaamsmaten.linkerArm">
                <label style="margin-bottom: 10px; display: block;" for="RechterArm"><font-awesome-icon icon="calendar-alt" /> RechterArm</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="RechterArm" v-model="lichaamsmaten.rechterArm">

                <div class="d-flex justify-content-center">
                <label style="margin-top: 1rem; margin-left: 1rem; margin-right: 0.5rem;" for="klantid"><font-awesome-icon icon="user" /> Klant ID:</label>
                  <span id="klantid" style="margin-top: 1rem; color: dodgerblue">{{this.klanten.id}}</span>
                  <label style="margin-top: 1rem; margin-left: 1rem;" for="klantid"><font-awesome-icon icon="user" /> Klant Naam:</label>
                  <span style="margin-top: 1rem; margin-left: 0.5rem; margin-right: 0.5rem;  color: dodgerblue">{{this.klanten.naam}}</span>
                  <span style="margin-top: 1rem;  color: dodgerblue">{{this.klanten.achternaam}}</span>
                </div>

                <button clas="btn" id="updatebestelling" style="background-color: dodgerblue;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;">Update Lichaamsmaat</button>
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
        "lichaamsmaten": {
          "linkerBeen":'',
          "rechterBeen": '',
          "bekkenkanteling": '',
          "gewicht": '',
          "groote":'',
          "linkerArm": '',
          "rechterArm": '',
          "klantId": ''
        },
        "klanten": {
          "id": '',
          "naam":'',
          "achternaam":'',
          "email": '',
          "geboortedatum": '',
          "addres": ''
        },
        dismissSecs: 2,
        dismissCountDown: 0

      };


    },
    created() {
      this.getLichaamsmaatByKlantid(this.$route.params.id)

    },
    methods: {
      countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
      showAlert() {
        this.dismissCountDown = this.dismissSecs
      },
      UpdatePost()  {
        const headers = {
          withCredentials: true,

        };
        console.log(this.lichaamsmaten)
        axios.post('http://localhost:8082/jaegherrestlichaamsmaat/updatelichaamsmaat/ ', this.lichaamsmaten, headers)
                .then(response => {
                  // success
                  console.log(response)
                  // alert('Bestelling is goed geupdate !'),
                  setInterval(() => {
                    window.location.href = '/JaegherListKlant/'
                  }, 2000);

                }, response => {
                  //error
                  if(response.status === 422 || response.status === 500) {
                    this.errored = true
                    console.log('Fout !')

                  }
         })
      },
      getLichaamsmaatByKlantid(id) {
        Vue.axios.get('http://localhost:8082/jaegherrestlichaamsmaat/lichaamsmaatdetails/'+ id)
                .then((resp) => {
                  this.lichaamsmaten = resp.data,
                  console.warn(resp.data),
                  this.getKlantByID(this.lichaamsmaten.klantId)
          })
      },
  getKlantByID(id){
      console.log(id)
      Vue.axios.get('http://localhost:8080/jaegherrest/klantdetails/'+ id)
              .then((resp) => {
                this.klanten = resp.data,
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
