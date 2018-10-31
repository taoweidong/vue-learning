<template>
    <div class="hello">
        
        <h1>{{msg}}</h1>
        <h2>father tell me:{{msgfromworld}}</h2>
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
      msg: "Hello World!"
    };
  },
  /* 通过props属性从父页面获取数据 */
  props: ["msgfromworld"],
  /* 事件方法 */
  methods: {
    doThis: function() {
      console.log(this.msgfromworld);
      this.$emit("child-tell-me-something", this.msg);
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


