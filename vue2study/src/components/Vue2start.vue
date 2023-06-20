<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div>
    <h1 v-if="show">Loading..........</h1>
    <button v-on:click="changeShow()">click</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      show: true,
    }
  },
  methods: {
    changeShow() {
      this.show = !this.show
    },
  },
}
</script>