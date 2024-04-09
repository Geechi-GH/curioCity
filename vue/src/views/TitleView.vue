<template>
    <div class="title-view">
        <header class="title-container">
            <img id="logo" src="../assets/CurioCity.png" alt="Logo Image">
            <h1 class="title">Travel curation for the curious mind</h1>
        </header>
        <label for="register">New to the site?</label>

        <router-link class="link" id="register" to="/register"> Register </router-link>
        <!-- <button id="register">Register</button> -->
        <label for="login"> Already have an account? </label>

        <router-link class="link" id="login" to="/login"> Login </router-link>

        <!-- <button id="login">login</button> -->
        <h2 class="title">Who we are</h2>
        <p class="subtitle">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Officia placeat ipsam, iusto doloribus
            iste praesentium
            repellat vel facilis tempora corporis totam deleniti similique minima enim quod sequi itaque! Eum, vero?</p>
        <section class="imagesHolder">
            <img id="marketImg" src="../assets/Findley Market.jpg" alt="">
            <img id="musicImg" src="../assets/Music Hall.jpg" alt="">
            <img id="museumImg" src="../assets/Museum.jpg" alt="">
        </section>



        <div class="slideshow-container">
            <div class="slide">
                <img src="../assets/Findley Market.jpg" alt="Slide 1">
            </div>
            <div class="slide">
                <img src="../assets/Music Hall.jpg" alt="Slide 2">
            </div>
            <div class="slide">
                <img src="../assets/Museum.jpg" alt="Slide 3">
            </div>
        </div>

    </div>
</template>

<script>
export default {
    name: "TitleView",
}
// let slideIndex = 0;
// showSlides();

// function showSlides() {
//     let slides = document.getElementsByClassName("slide");
//     if (slides === null) {
//         return; // Stop function execution if slides is null
//     }

//     for (let i = 0; i < slides.length; i++) {
//         slides[i].style.display = "none";
//     }

//     slideIndex++;
//     if (slideIndex > slides.length) {
//         slideIndex = 1;
//     }

//     // if (slides[slideIndex - 1] === undefined) {
//     //     console.error(`Slide index out of bounds: ${slideIndex - 1}`);
//     //     return; // Stop function execution if slide index is out of bounds
//     // }

//     slides[slideIndex - 1].style.display = "block";

//     setTimeout(showSlides, 2000); // Change image every 2 seconds
// }
</script>

<style scoped>
/* Color Palette */
.imagesHolder {
    display: flex;
    justify-content: center;
    justify-content: space-evenly;


}


:root {
    --gold: #D7B740;
    --jet-black: #292929;
    --slate-gray: #708090;
    --ivory: #FFFFF0;
    --bronze: #CD7F32;
}



h1.title {
    display: flex;
    justify-content: center;
    /* Horizontally center the text */
    align-items: center;
    /* Vertically center the text */

}

#logo {
    width: 30%;
    margin-bottom: 20px;
}

/* Layout and Whitespace */
body {
    background-image: linear-gradient(to bottom left, #3c3c3c, #020202);
    background-attachment: fixed;
}

.link {
    color: #708090;
    background-color: #D7B740;
    border-radius: 5%;
    padding: 1px;
    padding-left: 5px;
    padding-right: 5px;
    margin: 5px;
    margin-top: 20px;
}

p {
    color: white;
}

.slideshow-container {
    display: flex;
    justify-content: center;
    max-width: 100%;
    position: relative;
}

.slide {
    display: none;
    width: 25%;
}

.slide img {
    width: 100%;
}

/* Font Styles */
.title-view {
    font-family: 'Helvetica', sans-serif;
    text-align: center;
}

h1,
h2,
h3 {
    font-family: 'Georgia', serif;
}

h2 {
    color: #CD7F32;
}

.text-center {
    text-align: center;
}

img {
    margin-bottom: -75px;
}

h1 {
    color: #CD7F32;
}

.form-input-group {
    margin-bottom: 1rem;
    color: #FFFFF0;
}

.title-container {
    margin-top: 60px;
    padding-left: 10px;
    padding-right: 10px;
    font-family: Helvetica, Arial, sans-serif;
    color: #FFFFF0;
}

label {
    margin-right: 0.5rem;
    color: #FFFFF0;
}

.login-link {
    text-decoration: none;
    color: #708090;
}
</style>