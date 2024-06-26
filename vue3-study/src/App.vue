<script setup>
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <div>
    <router-link to="/">首页</router-link>
    <router-link to="/about">关于我的</router-link>
  </div>

  <router-view></router-view>
</template>

<style scoped>

</style>
