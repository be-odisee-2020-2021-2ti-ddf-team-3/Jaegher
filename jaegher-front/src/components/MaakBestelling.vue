<template>
  <div>
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
              <label style="margin-bottom: 10px; display: block;" for="klantid"><font-awesome-icon icon="user" /> Klant ID:</label>
              <input style="width: 40%;margin-bottom: 20px;padding: 12px;border: 1px solid #ccc;border-radius: 3px;" type="number" id="klantid"  v-model="bestellingen.klantId">


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
  import axios from 'axios'

export default {
  name: 'CreatePost',
  data(){
    return{
      selected:'false',
      options: [
        { item: 'false', name: 'False' }],
      "bestellingen": {
        "id": '',
        "naam":'',
        "aanMaakDatum": '',
        "goedgekeurd": '',
        "klantId": ''
      },
    };


    },
  mounted() {

  },
  methods: {
  createPost()  {
    const headers = {
      withCredentials: true
    };
    console.log(this.bestellingen)
    axios.post('http://localhost:8081/jaegherrestbestellingen/createbestelling', this.bestellingen, headers)
    .then(response => {
    // success
      alert('Bestelling is goed aangemaakt !')
      window.location.href = '/Jaegherlistbestellingen/'
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
