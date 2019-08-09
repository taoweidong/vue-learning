<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <button @click="test">点击事件测试一下</button>
  </div>
</template>

<script>
//在你要发请求的地方引入
import httpUtil from "../utils/HttpUtil";

export default {
  name: "HelloWorld",
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
  },
  methods: {
    test: async function() {
      let params = {};
      const res = await httpUtil.post("/user/query", params);
      console.log(res)
      if (res.success) {
        console.log(res);
        this.msg = res.payload;
        alert("请求成功");
      }
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
