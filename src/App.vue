<!--展示模板 -->
<template>
  <div id="app2">
    <!--  <img src="./assets/logo.png"> -->
    <!--  <router-view/> -->
    <dataTable></dataTable>
  </div>
</template>

<script>
//导入组件
import Hello from "./components/Hello";
// 测试导入第二个组件
import World from "./components/World";
import ElementUi from "./components/ElementUi";
import DataTable from "./components/DataTable";
// 脚本代码
// export default {
//   name: "app",
//   components: {
//     Hello
//   }
// };

// 脚本代码
export default {
  name: "app2",
  components: {
    DataTable
  }
};
</script>

<style>
/* 样式文件 */
#app2 {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>