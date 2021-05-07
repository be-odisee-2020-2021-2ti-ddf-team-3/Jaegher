<template>
  <div>
    <b-alert
            :show="dismissCountDown"
            dismissible
            fade
            variant="success"
            @dismiss-count-down="countDownChanged"
    >
      Lichaamsmaat is goed aangemaakt !
    </b-alert>
  <h2 style="margin-bottom: 2rem">Maak een lichaamsmaat aan</h2>
  <div class="row" style="display: flex;
    flex-wrap: wrap;
    margin: 0 -16px;">
    <div class="col-75" style=" flex: 75%; padding: 0 16px;">
      <div class="container" style=" background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;">
        <form @submit.prevent="createPost(),showAlert()" >

          <div class="row" style="display: flex;
               flex-wrap: wrap;
               margin: 0 -16px;">
            <div class="col-50" style="padding: 0 16px;  flex: 50%;">
              <h3 style="margin-top: 1rem">Lichaamsmaat Informatie</h3>

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

              <label style="margin-bottom: 10px; display: block;" for="klantid"><font-awesome-icon icon="user" /> Klant:</label>
              <div style="width: 20%;  margin: 0 auto">
                <v-select v-model="selecedklant" :options="items"
                          label="naam"
                          return-object
                          style="margin-bottom: 1rem">

                </v-select>
                <span id="klantid">Selected ID: {{getValue(selectedID)}}</span>
              </div>





              <button clas="btn" @click="showAlert" style="background-color: dodgerblue;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;">Create Lichaamsmaat</button>

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
      selecedklant:'',
      "lichaamsmaten": {
        "klantId": '',
        "linkerBeen":'',
        "rechterBeen": '',
        "bekkenkanteling": '',
        "gewicht": '',
        "groote":'',
        "linkerArm": '',
        "rechterArm": ''

      },
      item:null,
      items: [],
      dismissSecs: 2,
      dismissCountDown: 0,
    };


    },
  mounted() {
    this.getLijstKlanten()
  },
  computed: {
    selectedID: function () {
      return this.selecedklant.id
    },


  },
  methods: {
    getValue: function(value){
      return value,
      this.lichaamsmaten.klantId = value
    },
    countDownChanged(dismissCountDown) {
      this.dismissCountDown = dismissCountDown
    },
    showAlert() {
      this.dismissCountDown = this.dismissSecs
    },

  createPost()  {
    const headers = {
      withCredentials: true
    };
    console.log(this.lichaamsmaten)
    axios.post('http://localhost:8082/jaegherrestlichaamsmaat/createlichaamsmaat', this.lichaamsmaten, headers)
    .then(response => {
    // success
    // alert('Bestelling is goed aangemaakt !')
      setInterval(() => {
        window.location.href = '/JaegherListKlant/'
      }, 2000);

    console.log(response)
    }, response => {
    //error
    if(response.status === 422 || response.status === 500) {
      this.errored = true
      console.log('Fout !')

    }
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
                              this.errorMsg = error.response.data.message
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
