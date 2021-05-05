<template>
    <div id="JaegherBestelling">

        <Bestellingupdate />

    </div>
</template>


<script>
    // @ is an alias to /src
    import Bestellingupdate from '@/components/UpdateBestelling'

    export default {
        name: 'Bestellingdetailsupdate',
        components: {
            Bestellingupdate
        }
    }
</script>