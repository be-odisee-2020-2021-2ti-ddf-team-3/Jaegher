<template>
  <div>
    <b-alert
            :show="dismissCountDown"
            dismissible
            fade
            variant="success"
            @dismiss-count-down="countDownChanged"
    >
      Klant is goed aangemaakt !
    </b-alert>
  <h2 style="margin-bottom: 2rem">Maak een klant aan</h2>
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
              <h3 style="margin-top: 1rem">Klant Informatie</h3>
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
  font-size: 17px;">Create Klant</button>
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

export default {
  name: 'CreatePost',
  data(){
    return{
      entry: {
        "naam":'',
        "achternaam":'',
        "email":'',
        "geboortedatum":'',
        "addres":''
      },
      errored: false,
      dismissSecs: 2,
      dismissCountDown: 0,
    };


    },
  mounted() {

  },
  methods: {
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
    console.log(this.entry)
    axios.post('http://localhost:8080/jaegherrest/createklant', this.entry, headers)
    .then(response => {
    // success
      console.log(response)
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
    }
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
