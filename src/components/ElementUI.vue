<template>
  <div class="app">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="80px">Aside</el-aside>
        <el-container>
          <el-main>Main</el-main>
          <el-footer>Footer</el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "app",
  /* 绑定的数据 */
  data() {
    return {
      msg: "Element-UI练习"
    };
  }
};
</script>

<style>
h1 {
  color: blue;
}
</style>


