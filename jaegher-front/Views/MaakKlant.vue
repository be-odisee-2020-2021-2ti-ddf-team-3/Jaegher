<template>
    <div id="MaakKlant">

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