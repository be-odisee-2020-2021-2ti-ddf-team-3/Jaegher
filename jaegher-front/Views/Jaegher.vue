<template>
    <div id="Jaegher">
        <h3 style="margin-bottom: 1rem">Geef de id van een klant in aub:</h3>
        <form @submit.prevent="getIdToLookup()">
            <input type="text" placeholder="id?" v-model="idToLookup" name="idToLookup">
        </form>

        <br/>

        <div v-if=" info == 'error' ">
            Unfortunately, something went wrong<br/><br/>
        </div>
        <div v-else  >
            We hebben de entry <strong> met id </strong> {{ info.id }} gelezen van de backend:
            <ul>
                <li><strong>Gebruiker:</strong>
                    {{ info.naam }}
                    {{ info.achternaam }}
                </li>
            </ul>
        </div>
        <div v-if= " info == 'error' " >
            <strong>Error: </strong> {{ error }}
        </div>
    </div>
</template>

<script>
    import * as axios from "axios";

    export default {
        name: "Jaegher",
        data () {
            return {
                idToLookup: '',
                theUrl: '',
                info: null,
                status: null,
                error: null
            }
        },
        mounted () {
            this.idToLookup = '1'
            this.getIdToLookup()
        },
        methods: {
            getIdToLookup() {
                this.theUrl = 'http://localhost:8080/jaegherrest/klanten/?' + this.idToLookup
                axios
                    .get(this.theUrl)
                    .then(response => (this.info = response.data,
                        this.status = response.status) )
                    .catch(error => (this.info = "error",
                        this.status = error.response.status,
                        this.error = error.response.data.message ) )
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
        margin: 0 10px;
    }
    a {
        color: #42b983;
    }
</style>
