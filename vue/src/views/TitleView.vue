<template>
    <div class="title-view">
        <header class="title-container">
            <img id="logo" src="../assets/CurioCity.png" alt="Logo Image">
            <div class="login">
                <label for="login"> Welcome to CurioCity! </label>
            </div>
            <div>
                <router-link class="login-link" to="/login"> Login </router-link>
            </div>
            <div class="register">
                <label for="register">New to the site?</label>
                <router-link class="link" id="register" to="/register"> Register </router-link>
                <!-- <button id="register">Register</button> -->
            </div>
            <h1 class="intro">Travel curation for the curious mind</h1>
            <div>
                <img id="cincysundown" src="../assets/cincysundown.jpg" alt="">
            </div>
        </header>
        <!-- <button id="login">login</button> -->
        <h2 class="about-title">Who we are</h2>
        <p class="about-info">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Officia placeat ipsam, iusto
            doloribus
            iste praesentium
            repellat vel facilis tempora corporis totam deleniti similique minima enim quod sequi itaque! Eum, vero?</p>
        <section class="imagesHolder">

            <img id="redstadium" src="../assets/redsstadium.jpg" alt="">

        </section>
    </div>
</template>

<script>
export default {
    name: "TitleView",
}
</script>

<style scoped>
/* Color Palette */
.imagesHolder {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
}

:root {
    --gold: #D7B740;
    --jet-black: #292929;
    --slate-gray: #708090;
    --ivory: #FFFFF0;
    --bronze: #CD7F32;
}

#logo {
    width: 60%;
    margin-bottom: -50px;
    margin-top: -75px;
}

.login-link {
    font-size: 3em;
    font-weight: bold;
    font-family: serif;
    -webkit-text-stroke: #292929 1px;
    text-align: center;
    margin-bottom: 5px;
    margin-top: -50px;
    color: #D7B740;
    border-bottom: #708090 3px solid;
}

.login-link:hover {
    color: #FFFFF0;
}

.login {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 20px;
    background-color: #708090;
    -webkit-text-fill-color: #020202;
    font-size: 2em;
    font-weight: bold;
    font-family: serif;
    -webkit-text-stroke: #292929 1px;
    text-align: center;
    margin-bottom: 5px;
    margin-top: 0px;
    color: #020202;
}

.register {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}


.intro {
    font-size: 3em;
    font-weight: bold;
    font-family: serif;
    -webkit-text-stroke: #292929 1px;
    text-align: center;
    margin-bottom: 5px;
    margin-top: 20px;
    color: #fffff0;
    border-top: #708090 3px solid;
    border-radius: 20px;
}

.about-title {
    font-size: 2em;
    font-weight: bold;
    font-family: serif;
    -webkit-text-stroke: #292929 1px;
    text-align: center;
    margin-bottom: 5px;
    margin-top: 20px;
    color: #D7B740;
    text-decoration: underline;
    text-decoration-color: #708090;
}

.about-info {
    font-size: 1.5em;
    font-family: serif;
    text-align: center;
    margin-bottom: 20px;
    margin-top: 20px;
    color: #fffff0;
    border-bottom: #708090 3px solid;
    border-radius: 20px;
}

/* Layout and Whitespace */
body {
    background-image: linear-gradient(to bottom left, #3c3c3c, #020202);
    background-attachment: fixed;
}

.link {
    color: #D7B740;
    border-radius: 5%;
    padding: 1px;
    padding-left: 5px;
    padding-right: 5px;
    margin: 5px;
    margin-top: 0px;
}

.link:hover {
    color: #FFFFF0;
}

p {
    color: white;
}

/* Font Styles */
.title-view {
    font-family: 'Helvetica', sans-serif;
    text-align: center;
    color: #FFFFF0;
}

.title-container {
    margin-top: 0px;
    padding-left: 0px;
    padding-right: 0px;
    font-family: Helvetica, Arial, sans-serif;
    color: #FFFFF0;
}
</style>