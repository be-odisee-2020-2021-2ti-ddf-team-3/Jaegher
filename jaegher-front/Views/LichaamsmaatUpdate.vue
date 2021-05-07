<template>
    <div id="Lichaamsmaten">

        <Lichaamsmaatupdate />

    </div>
</template>


<script>
    // @ is an alias to /src
    import Lichaamsmaatupdate from '@/components/UpdateLichaamsmaat'

    export default {
        name: 'Lichaamsmaten',
        components: {
            Lichaamsmaatupdate
        }
    }
</script>