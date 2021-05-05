<template>
    <div id="MaakKlant" style="margin-top: 2rem">

        <CreatePost />

    </div>
</template>


<script>
    // @ is an alias to /src
    import CreatePost from "../src/components/MaakKlant";

    export default {
        name: 'MaakKlant',
        components: {
            CreatePost,
        }
    }
</script>