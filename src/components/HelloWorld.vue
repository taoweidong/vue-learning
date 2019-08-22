<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2 ref="myH3">Essential Links</h2>
    <button @click="test">点击事件测试一下</button>
    <button @click="getTest">测试refs</button>

    <login ref="myLogin" />
  </div>
</template>

<script>
//在你要发请求的地方引入
import httpUtil from "../utils/HttpUtil";

// 定义一个组件
var login = {
  template: "<h1>登录组件测试---{{hhh}}</h1>",
  data() {
    return {
      hhh: "登录组件内的信息"
    };
  },
  methods: {
    sayHello() {
      console.log("Say Hello......");
    }
  }
};

export default {
  name: "HelloWorld",
  data() {
    return {
      msg: "Welcome to Your Vue.js App"
    };
  },
  components: {
    login
  },
  methods: {
    getTest() {
      console.log(this.$refs);
      // alert(this.$refs.myH3.innerHTML);
      console.log(this.$refs.myLogin.hhh);
      console.log(this.$refs.myLogin.sayHello());
    },
    test: async function() {
      this.$emit("myTest", "HHHHHHHHHHHHH");

      let params = {};
      const res = await httpUtil.post("/user/query", params);
      console.log(res);
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
