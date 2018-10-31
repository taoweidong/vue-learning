# hello-vue

## 基础项目安装
> 使用命令行创建vue:
> Vue.js 提供一个官方命令行工具，可用于快速搭建大型单页应用。该工具提供开箱即用的构建工具配置，带来现代化的前端开发流程。只需一分钟即可启动带热重载、保存时静态检查以及可用于生产环境的构建配置的项目：

```
# 全局安装 vue-cli
$ npm install --global vue-cli
# 创建一个基于 webpack 模板的新项目
$ vue init webpack my-project
# 安装依赖，走你
$ cd my-project
$ npm install
$ npm run dev
```

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report

# run unit tests
npm run unit

# run e2e tests
npm run e2e

# run all tests
npm test
```

# 2018年10月29日
>  项目结构
- build 	项目构建(webpack)相关代码
- config 	配置目录，包括端口号等。我们初学可以使用默认的。
- node_modules 	npm 加载的项目依赖模块
- src 这里是我们要开发的目录，基本上要做的事情都在这个目录里。里面包含了几个目录及文件：
    - assets: 放置一些图片，如logo等。
    - components: 目录里面放了一个组件文件，可以不用。
    - App.vue: 项目入口文件，我们也可以直接将组件写这里，而不使用 components 目录。
    - main.js: 项目的核心文件。
- static 	静态资源目录，如图片、字体等。
- test 	初始测试目录，可删除
- .xxxx文件 	这些是一些配置文件，包括语法配置，git配置等。
- index.html 	首页入口文件，你可以添加一些 meta 信息或统计代码啥的。
- package.json 	项目配置文件。
- README.md 	项目的说明文档，markdown 格式