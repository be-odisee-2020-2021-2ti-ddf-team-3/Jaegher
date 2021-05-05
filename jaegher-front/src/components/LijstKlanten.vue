<template>
  <div>
    <div id="LijstKlanten" class="container mt-3">

      <b-container fluid>
        <b-row>
          <b-col lg="10" class="my-1">
            <b-form-group
                    label="Filter"
                    label-for="filter-input"
                    label-cols-sm="3"
                    label-align-sm="right"
                    label-size="sm"
                    class="mb-0"
            >
              <b-input-group size="sm">
                <b-form-input
                        id="filter-input"
                        v-model="filter"
                        type="search"
                        placeholder="Type to Search"
                ></b-form-input>

                <b-input-group-append>
                  <b-button :disabled="!filter" @click="filter = ''">Clear</b-button>
                </b-input-group-append>
              </b-input-group>
            </b-form-group>
          </b-col>
        </b-row>
        <!-- User Interface controls -->
        <b-row>
          <b-col sm="6" md="1" class="my-1">
            <button class="btn" @click="CreateKlant()" ><font-awesome-icon icon="plus" /></button>
          </b-col>


        </b-row>



        <!-- Main table element -->
        <b-table style="margin-top: 2rem"
                :items="items"
                :fields="fields"
                :current-page="currentPage"
                :per-page="perPage"
                :filter="filter"
                :filter-included-fields="filterOn"
                :sort-by.sync="sortBy"
                :sort-desc.sync="sortDesc"
                :sort-direction="sortDirection"
                stacked="md"
                show-empty
                small
                @filtered="onFiltered"
        >
          <template #cell(name)="row">
            {{ row.value.first }} {{ row.value.last }}
          </template>


          <template #cell(actions)="row" id="buttonsactions">
            <b-dropdown id="dropdown-dropright" dropright text="Kies één" variant="primary" class="m-2">
              <b-dropdown-item size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1" >
                Info modal</b-dropdown-item>
              <b-dropdown-item size="sm" @click="row.toggleDetails" class="mr-1" >
                {{ row.detailsShowing ? 'Hide' : 'Show' }} Details</b-dropdown-item>
              <b-dropdown-item @click="goUpdatePage(row.item.id)" size="sm" class="mr-1" >
                Update Klant</b-dropdown-item>
              <b-dropdown-item size="sm" @click="deleteKlantById(row.item.id)">
                Delete Klant</b-dropdown-item>
            </b-dropdown>

          </template>

          <template #row-details="row">
            <b-card>
              <ul>
                <li v-for="(value, key) in row.item" :key="key">{{ key }}: {{ value }}</li>
              </ul>
            </b-card>
          </template>
        </b-table>

        <!-- Info modal -->
        <b-modal :id="infoModal.id" :title="infoModal.title" ok-only @hide="resetInfoModal">
          <pre>{{ infoModal.content }}</pre>
        </b-modal>

      </b-container>
      <b-row class="fixed-bottom">
        <b-col  sm="4" md="12" class="my-1">
          <b-pagination
                  v-model="currentPage"
                  :total-rows="totalRows"
                  :per-page="perPage"
                  align="fill"
                  size="sm"
                  class="my-0"
          ></b-pagination>


        </b-col></b-row>
    </div>
  </div>
</template>

<script>


  import Vue from 'vue';
  import axios from 'axios'
  import VueAxios from 'vue-axios'
  Vue.use(VueAxios, axios)
  export default {
    name: "LijstKlanten",
    data() {
      return {
          "klanten": {
          "id": '',
          "naam":'',
          "achternaam": '',
          "email": '',
          "geboortedatum": '',
          "addres": ''
        },
        items: [],
        fields: [
          {
            key: 'id',
            sortable: true

          },
          {
            key: 'naam',
            sortable: true

          },
          {
            key: 'achternaam',
            label: 'Achternaam',
            sortable: true
          },
          {
            key: 'email',
            label: 'Email',
            sortable: true,
          },
          {
            key: 'geboortedatum',
            label: 'Geboortedatum',
            sortable: true,
          },
          {
            key: 'addres',
            label: 'Adres',
            sortable: true,
          },
          { key: 'actions', label: 'Acties' }
        ],
        totalRows: 1,
        currentPage: 1,
        perPage: 5,
        pageOptions: [5, 10, 15, { value: 100, text: "Show a lot" }],
        sortBy: '',
        sortDesc: false,
        sortDirection: 'asc',
        filter: null,
        filterOn: [],
        infoModal: {
          id: 'info-modal',
          title: '',
          content: ''
        }
      }
    },
    computed: {

    },
    mounted() {
      this.getLijstKlanten()
      // Set the initial number of items
      this.totalRows = this.items.length
    },
    methods: {
      goUpdatePage(id) {
        console.log(id)
        this.$router.push({path: `/Klantupdate/${id}`})
      },
      getLijstKlanten() {
        this.url = 'http://localhost:8080/jaegherrest/klanten'
        axios
                .get(this.url)
                .then(response => (
                        this.items = response.data,
                                console.log(response.data),
                                this.status = response.status
                ))
                .catch(error => (
                        this.items = "fout",
                                this.status = error.response.status,
                                this.errorMsg = error.response.data.message
                ))
      },
      info(item, index, button) {
        this.infoModal.title = `Row index: ${index}`
        this.infoModal.content = JSON.stringify(item, null, 2)
        this.$root.$emit('bv::show::modal', this.infoModal.id, button)
      },
      resetInfoModal() {
        this.infoModal.title = ''
        this.infoModal.content = ''
      },
      onFiltered(filteredItems) {
        // Trigger pagination to update the number of buttons/pages due to filtering
        this.totalRows = filteredItems.length
        this.currentPage = 1
      },
      deleteKlantById(id) {
        Vue.axios.delete('http://localhost:8080/jaegherrest/deleteklant/' + id)
                .then((resp) => {
                  this.getLijstKlanten()
                  alert("Klant is verwijderd !")
                  console.warn(resp.data)
                })
      },
      CreateKlant() {
        window.location.href = "/MaakKlant"
        this.makeActive('Klanten')
      }
    }
  }
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  button:hover {
    opacity: 0.5;
  }
  .btn {
    background-color: DodgerBlue; /* Blue background */
    border: none; /* Remove borders */
    color: white; /* White text */
    padding: 12px 16px; /* Some padding */
    font-size: 16px; /* Set a font size */
    cursor: pointer; /* Mouse pointer on hover */
    border-radius: 3rem;
  }

</style>


