<template>
    <div class="review-container">
        <h1 class="title">{{ review.title }}</h1>
        <h2 class="name">{{ review.name }}</h2>
        <p class="review">{{ review.review }}</p>
    </div>
</template>

<script>


export default {
    name: "ReviewsSimplified",
    props: {
        review: {
            type: Object
        }
    }
}
</script>

<style scoped>
.review-container {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    flex-direction: column;
    justify-content: center;
    border: 1px solid #708090;
    background-color: rgba(112, 128, 144, 0.1);
    border-radius: 4px;
    padding: 10px;
    margin: 10px auto;
    max-width: 25%;

}

.title {
    font-size: 1.5em;
    font-weight: bold;
    border-top: #708090 1px solid;
    border-bottom: #708090 1px solid;
    padding: 5px;
    margin-bottom: -5px;

}

.name {
    font-size: 1em;
    font-weight: bold;
    margin-bottom: 5px;
    color: #d7b740;
    border-bottom: #708090 1px solid;
    margin-bottom: 15px;

}

.review {
    font-size: 1em;
    margin-bottom: 5px;
    border: #708090 1px solid;
    background-color: #708090;
    background-color: rgba(112, 128, 144, 0.3);
    border-radius: 5px;
    padding: 5px;
    color: #fffff0;
    -webkit-text-stroke: #292929 .3px;
}
</style>