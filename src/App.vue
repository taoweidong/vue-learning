<template>
  <div id="app">
    <!-- <img src="./assets/logo.png" /> -->
    <HelloWorld @myTest="test" />
    <!-- <HelloEasyUI /> -->
    <!-- <Login /> -->
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld";
import HelloEasyUI from "./components/HelloEasyUI";

export default {
  name: "App",
  components: {
    HelloWorld,
    HelloEasyUI
  },
  methods: {
    test(data) {
      console.log("子组件触发:" + data);
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
  margin-top: 60px;
}
</style>
