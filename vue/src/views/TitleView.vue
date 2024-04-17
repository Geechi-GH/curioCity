<template>
  <div class="title-view">
    <header class="title-container">
      <h1 class="intro">Travel curation for the curious mind</h1>
      <div class="slideshow">
        <img v-for="(image, index) in images" :key="index" :src="image" alt="Slideshow" v-show="index === currentIndex">
      </div>
    </header>
    <h2 class="about-title">Who we are</h2>
    <div class="about-info-container">
      <p class="about-info"> Embark on personalized city adventures with CurioCity! Explore hidden gems, iconic landmarks,
        vibrant neighborhoods, and local treasures tailored to your interests. Plan your unforgettable urban escapade now!
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
  unmounted() {
    this.stopSlideshow();
  },
};
</script>

<style scoped>
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
  top: 25%;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('../assets/updated photos/sunsetcincy.png');
  background-size: cover;
  background-position: center;
  opacity: 0.5;
  z-index: -1;
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
  margin-left: -30px;
  margin-right: -30px;
  font-size: 2em;
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
  color: #D7B740;
  display: inline-block;
  width: 53px;
  text-decoration: underline;
}

.intro {
  font-size: 3em;
  font-weight: lighter;
  margin-bottom: 5px;
  margin-top: 10px;
  margin-left: -20px;
  margin-right: -20px;
  padding-top: 30px;
  color: #fffff0;
  border-top: #708090 10px solid;
}

.about-title {
  font-size: 2em;
  text-align: center;
  margin-bottom: 5px;
  margin-top: 20px;
  color: #D7B740;
  text-decoration: underline;
  text-decoration-color: #708090;
}

.about-info {
  font-size: 1.5em;
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
  text-align: center;
  color: #FFFFF0;
}

.title-container {
  margin-top: 0px;
  padding-left: 0px;
  padding-right: 0px;
  color: #FFFFF0;
}
</style>