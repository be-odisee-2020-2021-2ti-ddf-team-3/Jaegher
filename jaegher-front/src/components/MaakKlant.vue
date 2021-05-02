<template>
  <div>
  <h2>Maak een klant aan</h2>
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
              <h3>Klant Informatie</h3>
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



              <button clas="btn" style="background-color: #04AA6D;
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
      errored: false
    };


    },
  mounted() {
    localStorage.clear()
  },
  methods: {
  createPost()  {
    const headers = {
      withCredentials: true
    };
    console.log(this.entry)
    axios.post('http://localhost:8080/jaegherrest/createklant', this.entry, headers)
    .then(response => {
    // success
      alert('Klant is goed aangemaakt !')
      window.location.href = '/JaegherListKlant/'
    console.log(response)
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
