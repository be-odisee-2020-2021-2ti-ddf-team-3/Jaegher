<template>
    <div id="MaakLichaamsmaat" style="margin-top: 2rem">

        <CreatePost />

    </div>
</template>


<script>
    // @ is an alias to /src
    import CreatePost from "../src/components/MaakLichaamsmaat";

    export default {
        name: 'MaakLichaamsmaat',
        components: {
            CreatePost,
        }
    }
</script>