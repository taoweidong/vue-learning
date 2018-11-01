<!--展示模板 -->
<template>
	<div id="app2">
    <!--  <img src="./assets/logo.png"> -->
		<!--  <router-view/> -->
		<world></world>
	</div>

  
</template>

<script>
//导入组件
import Hello from "./components/Hello";
// 测试导入第二个组件
import World from "./components/World";
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
    World
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