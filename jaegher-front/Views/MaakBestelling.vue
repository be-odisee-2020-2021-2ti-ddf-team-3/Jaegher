<template>
    <div id="MaakBestelling" style="margin-top: 2rem">

        <CreatePost />

    </div>
</template>


<script>
    // @ is an alias to /src
    import CreatePost from "../src/components/MaakBestelling";

    export default {
        name: 'MaakBestelling',
        components: {
            CreatePost,
        }
    }
</script>