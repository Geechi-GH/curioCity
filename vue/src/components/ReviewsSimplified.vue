<template>
    <div>
        <h1>{{ review.title }}</h1>
        <h2>{{ review.name }}</h2>
        <p>{{ review.review }}</p>
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

<style scoped></style>