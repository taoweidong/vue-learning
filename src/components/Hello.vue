<template>
    <div class="hello">
        
        <h1>{{msg}}</h1>
        <p v-text="msg"></p>
        <p v-html="msg"></p>
        <h2 v-if="seen">你好，这是一个vue的双向数据绑定的示例！</h2>
        <input v-model="msg">
        <!-- 绑定事件 -->
        <button v-on:click="doThis">{{msg}}</button>
    </div>
</template>

<script>
export default {
  name: "hello",
  /* 绑定的数据 */
  data() {
    return {
      msg: "Hello World!",
      seen: true,
      todos: [
        { text: "Learn JavaScript" },
        { text: "Learn Vue" },
        { text: "Build something awesome" }
      ]
    };
  },
  /* 事件方法 */
  methods: {
    doThis: function() {
      console.log(this.msg);
    }
  },
  /* 数据监听的方法 */
  watch: {
    msg: function(val, oldVal) {
      console.log(val, oldVal);
    }
  }
};
</script>

<style>
h1 {
  color: blue;
}
</style>


