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
        <label id="register-label" for="register">New to the site?</label>
        <router-link class="link" id="register" to="/register"> Register </router-link>
        <!-- <button id="register">Register</button> -->
      </div>
      <h1 class="intro">Travel curation for the curious mind</h1>
      <div class="slideshow">
        <!-- <img :src="currentImage" alt="Slideshow Image"> -->
        <img v-for="(image, index) in images" :key="index" :src="image" alt="Slideshow" v-show="index === currentIndex">
      </div>
    </header>
    <!-- <button id="login">login</button> -->
    <h2 class="about-title">Who we are</h2>
    <div class="about-info-container">
      <p class="about-info"> Welcome to CurioCity, your ultimate destination for
        crafting unforgettable city
        adventures! At
        CurioCity, we're passionate about exploring the hidden gems and iconic landmarks that make every city unique.
        Whether you're a seasoned traveler or a curious explorer, our platform empowers you to create personalized
        itineraries tailored to your interests and preferences.<br>
        <br>
        With CurioCity, embark on a journey of discovery as you uncover captivating landmarks, vibrant neighborhoods, and
        local treasures. From historic monuments to trendy hotspots, our curated collection of destinations ensures that
        every moment of your trip is filled with excitement and wonder.
        <br>
        Join us in celebrating the essence of each city, one landmark at a time. Start planning your next urban escapade
        with CurioCity and let the adventure begin
      </p>
    </div>
  </div>
</template>


<script>
import artMuseum from "../assets/Updated photos/art museum.png";
import bridge from "../assets/Updated photos/bridge.png";
import cincinnatiZoo from "../assets/Updated photos/cincinnati zoo.png";
import edenPark from "../assets/Updated photos/eden park.png";
import fountainSquare from "../assets/Updated photos/fountain square.png";
import kron from "../assets/Updated photos/kron.png";
import museum from "../assets/Updated photos/museum.png";
import musicHall from "../assets/Updated photos/music hall.png";
import observatory from "../assets/Updated photos/observatory.png";
import taftMuseum from "../assets/Updated photos/taft museum.png";
import redsSkyline from "../assets/Updated photos/RedsCincySky.png";
export default {
  name: "TitleView",
  data() {
    return {
      // List of image paths
      images: [
        artMuseum,
        bridge,
        cincinnatiZoo,
        edenPark,
        fountainSquare,
        kron,
        museum,
        musicHall,
        observatory,
        taftMuseum,
        redsSkyline
      ],
      // Index of the current image being displayed
      currentIndex: 0,
    };
  },
  computed: {
    // Get the path of the current image
    currentImage() {
      return this.images[this.currentIndex];
    },
  },
  methods: {
    // Move to the next image
    nextImage() {
      this.currentIndex = (this.currentIndex + 1) % this.images.length;
    },
    // Automatically advance to the next image after a delay
    startSlideshow() {
      this.slideshowInterval = setInterval(() => {
        this.nextImage();
      }, 3000); // Change the delay (in milliseconds) as needed
    },
    // Stop the slideshow when component is destroyed
    stopSlideshow() {
      clearInterval(this.slideshowInterval);
    },
  },
  mounted() {
    this.startSlideshow();
  },
  destroyed() {
    this.stopSlideshow();
  },
};
</script>

<style scoped>
/* Color Palette */

.slideshow {
  max-width: 100%;
  height: auto;
  overflow: hidden;
  display: flex;
  justify-content: center;
}

.slideshow img {
  width: 50%;
  height: auto;
  display: block;
  transition: opacity 0.5s ease;
  border: 3px solid #D7B740;

}

.title-container::after {
  content: "";
  position: absolute;
  top: 50%;
  /* Start from just below the intro heading */
  left: 0;
  width: 100%;
  height: 100%;
  /* Extend to the bottom of the page */
  background-image: url('../assets/updated photos/sunsetcincy.png');
  background-size: cover;
  opacity: 0.5;
  /* Adjust the opacity as needed */
  z-index: -1;
  /* Ensure it's behind other content */
}

#cincysundown {
  width: 100%;
  height: auto;
  object-fit: cover;
}


/* Add CSS animations for smooth transition between images */
.slideshow img.ng-enter,
.slideshow img.ng-leave {
  position: absolute;
}

.slideshow img.ng-enter {
  opacity: 0;
}

.slideshow img.ng-enter-active,
.slideshow img.ng-leave-active {
  opacity: 1;
}

:root {
  --gold: #D7B740;
  --jet-black: #292929;
  --slate-gray: #708090;
  --ivory: #FFFFF0;
  --bronze: #CD7F32;
}

#logo {
  width: 40%;
  margin-bottom: -50px;
  margin-top: -75px;
}

.login-link {
  font-size: 3em;
  font-weight: bold;
  font-family: serif;
  /* -webkit-text-stroke: #292929 2px;  */
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
  margin-left: -10px;
  margin-right: -10px;
  -webkit-text-fill-color: #020202;
  font-size: 2em;
  font-weight: bold;
  font-family: serif;
  -webkit-text-stroke: #292929 px;
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

#register {
  font-weight: bold;
  font-family: serif;
  /* -webkit-text-stroke: #292929 2px;  */
  /* margin-bottom: 5px;  */
  /* margin-top: -50px;  */
  color: #D7B740;
  display: inline-block;
  width: 53px;
  text-decoration: underline;
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
  width: 50%;
  margin: 0 auto;
  padding-bottom: 12px;
}

.about-info-container {
  width: 100%;
  /* Set the container to full width */
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