<template>
  <div id="app">
    <Vue2start></Vue2start>
    <watchtest></watchtest>
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import Vue2start from './components/Vue2start.vue';
import Watchtest from './components/Watchtest.vue';

export default {
  name: 'App',
  components: {

    Vue2start,
    Watchtest
}
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
