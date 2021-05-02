<template>
    <div id="JaegherKlanten">

        <Klantupdate />

    </div>
</template>


<script>
    // @ is an alias to /src
    import Klantupdate from '@/components/UpdateKlant.vue'

    export default {
        name: 'Klantdetailsupdate',
        components: {
            Klantupdate
        }
    }
</script>