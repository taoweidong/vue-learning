<template>
  <div>
    <button @click="test">获取数据</button>
    <DataGrid :data="data" style="height:750px">
      <GridColumn field="id" title="ID"></GridColumn>
      <GridColumn field="name" title="姓名"></GridColumn>
      <GridColumn field="sex" title="性别"></GridColumn>
      <GridColumn field="age" title="年龄"></GridColumn>
      <GridColumn field="birthday" title="生日"></GridColumn>
      <GridColumn field="address" title="地址"></GridColumn>
    </DataGrid>
  </div>
</template>
<script>
//在你要发请求的地方引入
import httpUtil from "../utils/HttpUtil";

export default {
  data() {
    return {
      data: [
        {
          id: "FI-SW-01",
          name: "Koi",
          sex: 10.0,
          age: "P",
          birthday: "",
          address: ""
        }
      ]
    };
  },
  methods: {
    test: async function() {
      let params = {};
      const res = await httpUtil.post("/user/query", params);
      console.log(res);
      if (res.success) {
        console.log(res);
        this.data = res.payload;
      }
    }
  },
  created: async function() {
    let params = {};
    const res = await httpUtil.post("/user/query", params);
    console.log(res);
    if (res.success) {
      console.log(res);
      this.data = res.payload;
    }
  }
};
</script>
