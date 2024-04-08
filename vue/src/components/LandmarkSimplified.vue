<template>
    <div>
        <h1>{{ landmark.name }}</h1>
        <p>{{ landmark.category }}</p>
    </div>
</template>

<script>
export default {
    name: "LandmarkSimplified",
    props: {
        propName: {
            landmark: Object
        },
    },
}
</script>

<style scoped>
div {
    border: 1px solid black;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: auto;
    max-width: 275px;
    padding: 10px;
    margin: 10px;
    border-radius: 5px;
    background-color: #f0f0f0;
}
</style>