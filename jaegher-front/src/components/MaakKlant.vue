<template>
  <div>
    <h1>Maak een klant aan</h1>
  <form @submit.prevent="createPost()">
    <div>
      <label for="naam">Naam:</label>
      <input type="text" id="naam" v-model="formData.naam" />
    </div>
    <div>
      <label for="achternaam">Achternaam:</label>
      <input type="text" id="achternaam" v-model="formData.achternaam" />
    </div>
    <div>
      <label for="email">Email:</label>
      <input type="email" id="email" v-model="formData.email" />
    </div>
    <div>
      <label for="geboortedatum">Geboortedatum:</label>
      <input type="text" id="geboortedatum" v-model="formData.geboortedatum" />
    </div>
    <div>
      <label for="adres">Adres:</label>
      <input type="text" id="adres" v-model="formData.adres" />
    </div>
    <button>Create Klant</button>

  </form>

  </div>
</template>

<script>
  import axios from 'axios'

export default {
  name: 'CreatePost',
  data(){
    return{
      formData: {
        naam:'',
        achternaam:'',
        email:'',
        geboortedatum:'',
        adres:''
      },
    }


    },
  methods: {
  createPost()  {
    axios.post('http://localhost:8080/jaegherrest/createklant', this.formData)
    .then(response => console.log(response))
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
