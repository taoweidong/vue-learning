webpackJsonp([1],{"37t0":function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=n("7+uW"),s=n("Xxa5"),a=n.n(s),o=n("exGp"),u=n.n(o),i=n("//Fk"),c=n.n(i),l=n("mtWM"),d=n.n(l),p=n("mw3O"),f=n.n(p);function h(t){return!t||200!==t.status&&304!==t.status&&400!==t.status?{status:-404,msg:"网络异常"}:t.data?t.data:{status:-404,msg:"获取数据为空"}}function v(t){return-404===t.status&&alert(t.msg),t}d.a.defaults.baseURL="http://127.0.0.1:8899/",d.a.interceptors.request.use(function(t){return t},function(t){return c.a.reject(t)}),d.a.interceptors.response.use(function(t){return t},function(t){return c.a.resolve(t.response)});var m=function(t,e){return d()({method:"post",url:t,data:f.a.stringify(e),timeout:1e4,headers:{"X-Requested-With":"XMLHttpRequest","Content-Type":"application/x-www-form-urlencoded; charset=UTF-8"}}).then(function(t){return h(t)}).then(function(t){return v(t)})},_={name:"HelloWorld",data:function(){return{msg:"Welcome to Your Vue.js App"}},methods:{test:function(){var t=u()(a.a.mark(function t(){var e,n;return a.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e={},t.next=3,m("/user/query",e);case 3:n=t.sent,console.log(n),n.success&&(console.log(n),this.msg=n.payload,alert("请求成功"));case 6:case"end":return t.stop()}},t,this)}));return function(){return t.apply(this,arguments)}}()}},g={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"hello"},[n("h1",[t._v(t._s(t.msg))]),t._v(" "),n("h2",[t._v("Essential Links")]),t._v(" "),n("button",{on:{click:t.test}},[t._v("点击事件测试一下")])])},staticRenderFns:[]};var y=n("VU/8")(_,g,!1,function(t){n("na9E")},"data-v-7c725ba4",null).exports,x={data:function(){return{data:[{id:"FI-SW-01",name:"Koi",sex:10,age:"P",birthday:"",address:""}]}},methods:{test:function(){var t=u()(a.a.mark(function t(){var e,n;return a.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e={},t.next=3,m("/user/query",e);case 3:n=t.sent,console.log(n),n.success&&(console.log(n),this.data=n.payload);case 6:case"end":return t.stop()}},t,this)}));return function(){return t.apply(this,arguments)}}()},created:function(){var t=u()(a.a.mark(function t(){var e,n;return a.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return e={},t.next=3,m("/user/query",e);case 3:n=t.sent,console.log(n),n.success&&(console.log(n),this.data=n.payload);case 6:case"end":return t.stop()}},t,this)}));return function(){return t.apply(this,arguments)}}()},w={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("button",{on:{click:t.test}},[t._v("获取数据")]),t._v(" "),n("DataGrid",{staticStyle:{height:"250px"},attrs:{data:t.data}},[n("GridColumn",{attrs:{field:"id",title:"ID"}}),t._v(" "),n("GridColumn",{attrs:{field:"name",title:"姓名"}}),t._v(" "),n("GridColumn",{attrs:{field:"sex",title:"性别"}}),t._v(" "),n("GridColumn",{attrs:{field:"age",title:"年龄"}}),t._v(" "),n("GridColumn",{attrs:{field:"birthday",title:"生日"}}),t._v(" "),n("GridColumn",{attrs:{field:"address",title:"地址"}})],1)],1)},staticRenderFns:[]},b={name:"App",components:{HelloWorld:y,HelloEasyUI:n("VU/8")(x,w,!1,null,null,null).exports}},G={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("HelloEasyUI")],1)},staticRenderFns:[]};var k=n("VU/8")(b,G,!1,function(t){n("wGI8")},null,null).exports,C=(n("ZphK"),n("37t0"),n("b79p"),n("q1nB")),E=n.n(C);r.a.use(E.a),r.a.config.productionTip=!1,new r.a({el:"#app",components:{App:k},template:"<App/>"})},ZphK:function(t,e){},b79p:function(t,e){},na9E:function(t,e){},wGI8:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.e640666373cb5950dd78.js.map