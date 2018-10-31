<template>
    <div class="world">
        
        <h1 v-html="msg"></h1>
        <h2>child to tell me: {{childworlds}}</h2>
        <input v-model="newItem" @keyup.enter="addNew">
        <ul>
            <li v-for="item in items" v-bind:class="{finished: item.isFinished}"
            v-on:click="toggleFinish(item)">
                {{item.label}}
            </li>
        </ul>
        <components-a msgfromworld="you die!!!" v-on:child-tell-me-something="listenToMyBody"></components-a>
    </div>
</template>

<script>
import Store from "../store";
import componentsA from "./componentsA";

console.log(Store);
export default {
  name: "world",
  /* 绑定的数据 */
  data() {
    return {
      msg: "TodoList",
      items: Store.fetch(),
      liClass: "liClass",
      newItem: "",
      childworlds: ""
    };
  },
  components: { componentsA },
  watch: {
    items: {
      handler: function(items) {
        Store.save(items);
      },
      deep: true
    }
  },
  methods: {
    toggleFinish: function(item) {
      item.isFinished = !item.isFinished;
    },
    addNew: function() {
      // console.log(this.newItem);
      this.items.push({
        label: this.newItem,
        isFinished: false
      });
      this.newItem = "";
    },
    listenToMyBody: function(msgChild) {
      this.childworlds = msgChild;
    }
  }
};
</script>

<style>
/* 样式文件 */

html {
  height: 100%;
}

body {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}

#world {
  color: #2c3e50;
  margin-top: 10px;
  max-width: 600px;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  text-align: center;
}

.finished {
  text-decoration: underline;
}
</style>


