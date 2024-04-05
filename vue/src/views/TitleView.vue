<template>
    <div>
        <header class="title-container">
            <img src="../assets/logo.png" alt="Logo Image">
            <h1 class="title">Travel curation for the curious mind</h1>
        </header>
        <label for="register">New to the site? </label>

        <router-link id="register" to="/register">Register</router-link>
        <!-- <button id="register">Register</button> -->
        <label for="login"> Already have an account? </label>

        <router-link id="login" to="/login">Login</router-link>

        <!-- <button id="login">login</button> -->
        <h2 class="title">Who we are</h2>
        <p class="subtitle">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Officia placeat ipsam, iusto doloribus
            iste praesentium
            repellat vel facilis tempora corporis totam deleniti similique minima enim quod sequi itaque! Eum, vero?</p>

        <div class="slideshow-container">
            <div class="slide">
                <img src="src\assets\findley market.jpg" alt="Slide 1">
            </div>
            <div class="slide">
                <img src="src\assets\music hall.jpg" alt="Slide 2">
            </div>
            <div class="slide">
                <img src="src\assets\museum.jpg" alt="Slide 3">
            </div>
        </div>

    </div>
</template>

<script>
export default {
    name: "TitleView",
}
let slideIndex = 0;
showSlides();

function showSlides() {
    let slides = document.getElementsByClassName("slide");
    if (slides === null) {
        return; // Stop function execution if slides is null
    }

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1;
    }

    if (slides[slideIndex - 1] === undefined) {
        console.error(`Slide index out of bounds: ${slideIndex - 1}`);
        return; // Stop function execution if slide index is out of bounds
    }

    slides[slideIndex - 1].style.display = "block";

    setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>

<style scoped>
.slideshow-container {
    max-width: 100%;
    position: relative;
}

.slide {
    display: none;
}

.slide img {
    width: 100%;
    height: auto;
}

.title-container {
    background-color: beige;
    color: black;
    padding: 20px;
}

.title {
    font-size: 2em;
    font-weight: bold;
}

.subtitle {
    color: gold;
    font-size: 1.5em;
}
</style>