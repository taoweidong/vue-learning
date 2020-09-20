<template>
  <div id="app">
    <!-- <img src="./assets/logo.png" /> -->
    <!-- <HelloWorld @myTest="test" /> -->
    <!-- <HelloEasyUI /> -->
    <router-view v-if="isRouterAlive"></router-view>
    <!-- <Login /> -->
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld";
import HelloEasyUI from "./components/HelloEasyUI";

export default {
  name: "App",
  provide() {
    return {
      reload: this.reload
    };
  },
  data() {
    return {
      isRouterAlive: true
    };
  },
  components: {
    HelloWorld,
    HelloEasyUI
  },
  methods: {
    test(data) {
      console.log("子组件触发:" + data);
    },
    reload() {
      this.isRouterAlive = false;
      this.$nextTick(function() {
        this.isRouterAlive = true;
      });
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 10px;
}
</style>
