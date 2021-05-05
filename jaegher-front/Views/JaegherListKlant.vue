<template>
    <div id="JaegherKlanten" class="container">
        <h2 style="margin-top: 2rem">Overzicht van Klanten</h2>

        <LijstKlanten />

    </div>
</template>


<script>
    // @ is an alias to /src
    import LijstKlanten from '@/components/LijstKlanten.vue'

    export default {
        name: 'JaegherListKlant',
        components: {
            LijstKlanten
        }
    }
</script>