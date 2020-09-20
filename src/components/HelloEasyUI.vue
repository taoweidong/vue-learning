<template>
  <div>
    <h2>功能测试</h2>
    <div style="margin-bottom:10px">
      <TextBox
        placeholder="请输入姓名"
        v-model="name"
        style="width:300px;height:30px"
      >
        <Addon>
          <LinkButton
            iconCls="icon-search"
            @click="queryName"
            :btnStyle="{
              borderRadius: 0,
              borderWidth: '0 0 0 1px',
              width: '70px',
              height: '30px'
            }"
            >Search</LinkButton
          >
        </Addon>
      </TextBox>
      <LinkButton :disabled="false" @click="testClick">更新数据</LinkButton>
    </div>
    <DataGrid
      style="height:750px"
      :pagination="true"
      :lazy="true"
      :data="data"
      :total="total"
      :loading="loading"
      :pageNumber="pageNumber"
      :pageSize="pageSize"
      :selectionMode="selectionMode"
      @selectionChange="selection = $event"
      @pageChange="onPageChange($event)"
    >
      <GridColumn align="center" cellCss="datagrid-td-rownumber" width="30">
        <template slot="body" slot-scope="scope">
          {{ scope.rowIndex + 1 }}
        </template>
      </GridColumn>
      <GridColumn field="id" title="ID"></GridColumn>
      <GridColumn field="name" title="姓名" align="center"></GridColumn>
      <GridColumn field="sex" title="性别" align="center"></GridColumn>
      <GridColumn field="age" title="年龄" align="center"></GridColumn>
      <GridColumn field="birthday" title="生日" align="center"></GridColumn>
      <GridColumn field="address" title="地址" align="left"></GridColumn>
      <GridColumn field="status" title="状态" align="center">
        <template slot="body" slot-scope="scope">
          <div>{{ refreshStatus(scope.row.status) }}</div>
        </template>
      </GridColumn>
      <GridColumn field="remark" title="备注" align="center"></GridColumn>
      <GridColumn
        field="updateTime"
        title="更新时间"
        align="center"
      ></GridColumn>
    </DataGrid>

    <Dialog
      ref="d1"
      :title="'状态更新'"
      :dialogStyle="{ width: '400px', height: '300px' }"
      :modal="true"
      :draggable="true"
      @close="myClose"
      :closed="closedModel"
    >
      <div style="margin:20px">
        <div style="margin-bottom:20px">
          <Label for="status" align="left">状态</Label>
          <ComboBox
            inputId="status"
            name="status"
            :data="statusCombox"
            v-model="status"
          ></ComboBox>
        </div>
        <div style="margin-top:20px;margin-bottom:20px">
          <Label for="remark" align="left">备注</Label>
          <TextBox
            inputId="remark"
            :multiline="true"
            style="width:50%;height:60px"
            name="remark"
            v-model="remark"
          ></TextBox>
        </div>

        <div style="margin-bottom:20px">
          <LinkButton :disabled="false" @click="submitForm()">提交</LinkButton>
        </div>
      </div>
    </Dialog>
  </div>
</template>

<script>
//在你要发请求的地方引入
import httpUtil from "../utils/HttpUtil";
export default {
  data() {
    return {
      total: 0,
      pageNumber: 1,
      pageSize: 20,
      data: [
        {
          id: "",
          name: "",
          sex: 0,
          age: "",
          birthday: "",
          status: "",
          remark: "",
          address: "",
          updateTime: ""
        }
      ],
      statusCombox: [
        { value: 1, text: "正常" },
        { value: 2, text: "退学" },
        { value: 3, text: "休学" },
        { value: 4, text: "异常" },
        { value: 5, text: "保密" }
      ],
      loading: false,
      selectionMode: "multiple",
      selection: null,
      status: "1",
      remark: "",
      closedModel: true,
      name: ""
    };
  },
  inject: ["reload"],
  created() {
    this.loadPage(this.pageNumber, this.pageSize);
  },
  computed: {
    selectionInfo() {
      if (!this.selection) {
        return null;
      }

      let arr = this.selection.map(function(row) {
        return row;
      });

      console.log("8888888888" + JSON.stringify(arr));
      if (arr.length == 0) {
        return null;
      } else {
        return arr;
      }
    }
  },
  methods: {
    queryName() {
      this.loadPage(this.pageNumber, this.pageSize);
    },
    refreshStatus(status) {
      for (let index = 0; index < this.statusCombox.length; index++) {
        if (this.statusCombox[index].value == status) {
          return this.statusCombox[index].text;
        }
      }
      return "";
    },
    myClose() {
      console.log("触发关闭事件");
    },
    testClick() {
      if (this.selection == null || this.selectionInfo == null) {
        this.$messager.alert({
          title: "Warning",
          icon: "warning",
          msg: "请选择待更新的数据!"
        });
        this.closedModel = true;
      } else {
        this.closedModel = false;
        // 打开对话框
        this.$refs.d1.open();
      }
    },
    submitForm() {
      console.log(this.remark);
      if (this.remark == "") {
        alert("备注信息不能为空!");
        return;
      }

      let params = {};
      params.selectionInfo = this.selectionInfo;
      params.status = this.status;
      params.remark = this.remark;

      httpUtil.post_json("/user/update", params).then(res => {
        if (res.success) {
          console.log(JSON.stringify(res));

          this.loadPage(this.pageNumber, this.pageSize);

          this.reload();
        }
      });

      this.selection = null;
      this.$refs.d1.close();
      console.log("清理计算属性的值：" + this.selectionInfo);
    },
    onPageChange(event) {
      this.loadPage(event.pageNumber, event.pageSize);
    },
    loadPage(pageNumber, pageSize) {
      this.loading = true;
      setTimeout(() => {
        let params = {};
        params.pageNumber = pageNumber;
        params.pageSize = pageSize;
        params.name = this.name;

        let resultMap = {};
        httpUtil.post("/user/query", params).then(res => {
          // console.log(res);
          if (res.success) {
            // console.log(JSON.stringify(res));
            this.total = res.payload.total;
            this.pageNumber = pageNumber;
            this.data = res.payload.records;
            this.loading = false;
          }
        });
      }, 1000);
    }
  }
};
</script>
