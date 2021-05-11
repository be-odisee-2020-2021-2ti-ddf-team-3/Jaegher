<template>
  <div>
    <b-alert
            :show="dismissCountDown"
            dismissible
            fade
            variant="success"
            @dismiss-count-down="countDownChanged"
    >
      Bestelling is goed aangemaakt !
    </b-alert>
    <b-alert
            :show="dismissCountDown2"
            dismissible
            fade
            variant="danger"
            @dismiss-count-down="countDownChanged2"
    >
      Bestelling is niet gemaakt ! Probeer opnieuw met juiste gegevens...
    </b-alert>
  <h2 style="margin-bottom: 2rem">Maak een bestelling aan</h2>
  <div class="row" style="display: flex;
    flex-wrap: wrap;
    margin: 0 -16px;">
    <div class="col-75" style=" flex: 75%; padding: 0 16px;">
      <div class="container" style=" background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;">
        <form @submit.prevent="createPost()" >

          <div class="row" style="display: flex;
               flex-wrap: wrap;
               margin: 0 -16px;">
            <div class="col-50" style="padding: 0 16px;  flex: 50%;">
              <h3 style="margin-top: 1rem">Bestelling Informatie</h3>

              <label style="margin-bottom: 10px; display: block;" for="naam"><font-awesome-icon icon="user" />
                Naam</label>
              <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="text" id="naam" placeholder="John" v-model="bestellingen.naam">
              <label style="margin-bottom: 10px; display: block;" for="aanMaakDatum"><font-awesome-icon icon="calendar-alt" /> Aanmaakdatum</label>
              <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="date" id="aanMaakDatum"  placeholder="2020-05-05" v-model="bestellingen.aanMaakDatum">
              <label style="margin-bottom: 10px; display: block;" ><font-awesome-icon icon="envelope" /> Goedgekeurd?</label>
              <b-form-radio-group
                      :options="options"
                      v-model="selected"
                      class="mb-3"
                      value-field="item"
                      text-field="name"
                      disabled-field="notEnabled"
              ></b-form-radio-group>
              <label style="margin-bottom: 10px; display: block;" for="klantid"><font-awesome-icon icon="user" /> Klant:</label>
              <div style="width: 20%;  margin: 0 auto">
                <v-select v-model="selecedklant" :options="items"
                          label="email"
                          return-object
                          style="margin-bottom: 1rem">

                </v-select>
            </div>
              <div v-if="selecedklant != null">
                <label for="klantid"><font-awesome-icon icon="fingerprint" /> Selected ID:</label>
                <span id="klantid" style="color: dodgerblue"> {{getValue(selectedID)}}</span>
              </div>
              <div v-if="selecedklant != null" class="d-flex justify-content-lg-center">
                <label style="margin-left: 1rem;" for="klantid"><font-awesome-icon icon="id-card-alt" /> Klant Naam:</label>
                <span style="margin-left: 0.5rem; margin-right: 0.5rem;  color: dodgerblue">{{selectednaam}}</span>
                <span style="color: dodgerblue">{{selectedachternaam}}</span>
                <label style="margin-left: 1rem;" ><font-awesome-icon icon="envelope" /> Klant Mail:</label>
                <span style=" margin-left: 0.5rem; margin-right: 0.5rem;  color: dodgerblue">{{selectedemail}}</span>
              </div>
              <label style="margin-top: 10px; display: block;" for="selectedplan"><font-awesome-icon icon="calendar-alt" /> Planning:</label>
              <div style="width: 20%;  margin: 0 auto">
                <v-select v-model="selectedplanning" :options="itemsplanning"
                          label="id"
                          return-object
                          style="margin-bottom: 1rem">

                </v-select>
              </div>
              <div v-if="selectedplanning != null">
                <label for="selectedplan"><font-awesome-icon icon="fingerprint" /> Selected ID:</label>
                <span id="selectedplan" style="color: dodgerblue"> {{getValuePlanning(selectedIDPlanning)}}</span>
              </div>
              <div v-if="selectedplanning != null" class="d-flex justify-content-center">
                <label style=" margin-left: 1rem; margin-right: 0.5rem;"  for="selecteddatum"><font-awesome-icon icon="calendar-alt" /> Datum:</label>
                <span id="selecteddatum" style="color: dodgerblue">{{selectedDatumPlanning}}</span> <br>
                <label style="margin-left: 1rem; margin-right: 0.5rem;"  for="selectedtoestand"><font-awesome-icon icon="satellite-dish" /> Toestand:</label>
                <span id="selectedtoestand" style="color: dodgerblue">{{selectedToestandPlanning}}</span> <br>
                <label style="margin-left: 1rem; margin-right: 0.5rem;"  for="selectedchauffeur"><font-awesome-icon icon="user" /> Chauffeur:</label>
                <span id="selectedchauffeur" style="margin-top: 1rem; color: dodgerblue">{{selectedChauffeurID}}</span>
              </div>





              <button clas="btn" style="background-color: dodgerblue;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;">Create Bestelling</button>

            </div>
          </div>

        </form>
      </div>
    </div>
  </div>
  </div>
</template>




<script>

  import "vue-select/dist/vue-select.css";

  import axios from 'axios'
  //import Vue from "vue";
  import Vue from "vue";
  import vSelect from "vue-select";



  Vue.component("v-select", vSelect);
export default {

  name: 'CreatePost',
  data(){
    return{
      selected:'false',
      options: [
        { item: 'false', name: 'False' }],
      selecedklant: null,
      selectedplanning: null,
      "bestellingen": {
        "id": '',
        "naam":'',
        "aanMaakDatum": '',
        "goedgekeurd": '',
        "klantId": '',
        "planningId":''
      },
      "planningen": {
        "id": '',
        "datum":'',
        "toestand": '',
        "chauffeur": ''
      },
      items: [],
      itemsplanning: [],
      dismissSecs: 2,
      dismissCountDown: 0,
      dismissSecs2: 3,
      dismissCountDown2: 0,
      error: null,
      error2: null
    };


    },
  mounted() {
    this.getLijstKlanten(),
    this.getLijstPlanningen()

  },
  computed: {
    selectedID: function () {
      return this.selecedklant.id
    },
    selectednaam: function () {
      return this.selecedklant.naam
    },
    selectedachternaam: function () {
      return this.selecedklant.achternaam
    },
    selectedemail: function () {
      return this.selecedklant.email
    },
    selectedIDPlanning: function () {
      return this.selectedplanning.id
    },
    selectedDatumPlanning: function () {
      return this.selectedplanning.datum
    },
    selectedToestandPlanning: function () {
      return this.selectedplanning.toestand
    },
    selectedChauffeurID: function () {
      return this.selectedplanning.chauffeur
    },



  },
  methods: {
    getValue: function(value){
      return value,
      this.bestellingen.klantId = value
    },
    getValuePlanning: function(value){
      return value,
      this.bestellingen.planningId = value
    },
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

  createPost()  {
    const headers = {
      withCredentials: true
    };
    console.log(this.bestellingen)
    axios.post('http://localhost:8081/jaegherrestbestellingen/createbestelling', this.bestellingen, headers)
    .then(response => {
    // success
    // alert('Bestelling is goed aangemaakt !')
      this.showAlert(),
      setInterval(() => {
        window.location.href = '/Jaegherlistbestellingen/'
      }, 2000);

    console.log(response)
    })
      .catch(response => {
      //error
      this.error = 'Error',
      console.log(response),
      this.showAlert2()
      })
  },


    getLijstKlanten() {
      this.url = 'http://localhost:8080/jaegherrest/klanten'
      axios
              .get(this.url)
              .then(response => (
                      this.items = response.data

                             ))
              .catch(error => (
                      this.items = "fout",
                              this.status = error.response.status,
                              this.error2 = 'Error'
              ))
    },
    getLijstPlanningen() {
      this.url = 'http://localhost:8083/quatraplanningrest/plannings'
      axios
              .get(this.url)
              .then(response => (
                      this.itemsplanning = response.data,
                      console.log(response.data)
              ))
              .catch(error => (
                      this.itemsplanning = "fout",
                              this.status = error.response.status
              ))
    },

  }
}


</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style scoped>
  .icon-container {
    margin-bottom: 20px;
    padding: 7px 0;
    font-size: 24px;
  }

  .btn:hover {
    background-color: #45a049;
  }

  </style>
