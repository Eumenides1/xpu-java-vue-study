<template>
  <div class="person">
    <h2>水位：{{ height }}</h2>
    <h2>温度：{{ temp }}</h2>
    <button @click="addHeight">点我水位+10</button>
    <button @click="addTemp">点我温度+10</button>
  </div>
</template>

<script setup>

import { ref, watch, watchEffect } from 'vue';
let height = ref(70)
let temp = ref(50)

const stopWatch = watchEffect(()=>{
  console.log(temp.value);
  console.log(height.value);
})

console.log(stopWatch);

function addHeight(){
  height.value += 10
}

function addTemp(){
  temp.value += 10
}
</script>

<style scoped>

</style>
