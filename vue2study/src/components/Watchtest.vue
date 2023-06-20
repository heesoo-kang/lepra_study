<!-- eslint-disable vue/multi-word-component-names -->

<template>
    <div>
      <input type="text" v-model="name" />
      <input type="text" v-model="age" />
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        name: 'man',
        age: '30',
      }
    },
    watch: {
        name: {
        handler: function (newVal, oldVal) {
            
          console.log('new:old  ',newVal,' :  ', oldVal)
        },
        deep: true,
        immediate: true,
      },
      age(val) {
        console.log('age: ', val)
      },
    },
  }
  </script>