<template>
  <div style="margin-top: 1rem">
    <b-alert
            :show="dismissCountDown"
            dismissible
            fade
            variant="success"
            @dismiss-count-down="countDownChanged"
    >
      Klant is goed geupdate !
    </b-alert>
    <b-alert
            :show="dismissCountDown2"
            dismissible
            fade
            variant="danger"
            @dismiss-count-down="countDownChanged2"
    >
      Klant is niet geupdate ! Probeer opnieuw met juiste gegevens...
    </b-alert>
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
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="id" v-model="entry.id" placeholder="id" readonly>

                <label style="margin-bottom: 10px; display: block;" for="naam"><font-awesome-icon icon="user" />
                  Voornaam</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="naam" v-model="entry.naam" placeholder="John">
                <label style="margin-bottom: 10px; display: block;" for="achternaam"><font-awesome-icon icon="user" /> Last Name</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="achternaam" v-model="entry.achternaam" placeholder="M. Doe">
                <label style="margin-bottom: 10px; display: block;" for="email"><font-awesome-icon icon="envelope" /> Email</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="email" v-model="entry.email" name="email" placeholder="john@example.com">
                <label style="margin-bottom: 10px; display: block;" for="geboortedatum"><font-awesome-icon icon="calendar-alt" /> Geboortedatum</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="date" id="geboortedatum" v-model="entry.geboortedatum"  placeholder="10-10-2000">
                <label style="margin-bottom: 10px; display: block;" for="addres"><font-awesome-icon icon="address-card" /> Address</label>
                <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="addres" v-model="entry.addres"  placeholder="542 W. 15th Street">



                <button clas="btn" style="background-color: dodgerblue;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;">Update Klant</button>
<!--                <button clas="btn" style="background-color: dodgerblue;-->
<!--  color: white;-->
<!--  padding: 12px;-->
<!--  margin: 10px 0;-->
<!--  border: none;-->
<!--  width: 100%;-->
<!--  border-radius: 3px;-->
<!--  cursor: pointer;-->
<!--  font-size: 17px;">Update Lichaamsmaat</button>-->
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
        entry: {
          "id":'',
          "naam":'',
          "achternaam":'',
          "email":'',
          "geboortedatum":'',
          "addres":''
        },
        errored: false,
        dismissSecs: 2,
        dismissCountDown: 0,
        dismissSecs2: 3,
        dismissCountDown2: 0,
      };


    },
    created() {
      this.getKlantByid(this.$route.params.id)
    },
    methods: {
      countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
      showAlert() {
        this.dismissCountDown = this.dismissSecs
      },
      countDownChanged2(dismissCountDown2) {
        this.dismissCountDown2 = dismissCountDown2
      },
      showAlert2() {
        this.dismissCountDown2 = this.dismissSecs2
      },
      UpdatePost()  {
        const headers = {
          withCredentials: true,

        };
        console.log(this.entry)
        axios.post('http://localhost:8080/jaegherrest/updateklant/ ', this.entry, headers)
                .then(response => {
                  // success
                  console.log(response),
                  this.showAlert(),
                  setInterval(() => {
                    window.location.href = '/JaegherListKlant/'
                  }, 2000);
                  // alert('Klant is goed geupdate !')

                }) .catch(response => {
          //error
          console.log(response),
                  this.showAlert2()
         })
      },
      getKlantByid(id) {
        Vue.axios.get('http://localhost:8080/jaegherrest/klantdetails/'+ id)
                .then((resp) => {
                  console.warn(resp.data)
                  this.entry.id = resp.data.id
                  this.entry.naam = resp.data.naam
                  this.entry.achternaam = resp.data.achternaam
                  this.entry.email = resp.data.email
                  this.entry.geboortedatum = resp.data.geboortedatum
                  this.entry.addres = resp.data.addres
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
</style>
