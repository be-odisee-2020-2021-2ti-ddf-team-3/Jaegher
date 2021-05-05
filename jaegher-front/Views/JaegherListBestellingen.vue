<template>
    <div id="Jaegherlistbestellingen" class="container">
        <h2 style="margin-top: 2rem">Overzicht van bestellingen</h2>

        <lijstbestellingen />

    </div>
</template>


<script>
    // @ is an alias to /src
    import lijstbestellingen from "../src/components/LijstBestellingen";

    export default {
        name: 'Jaegherlistbestellingen',
        components: {
            lijstbestellingen,
        }
    }
</script>