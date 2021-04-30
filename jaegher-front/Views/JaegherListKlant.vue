<template>
    <div id="JaegherKlanten">

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