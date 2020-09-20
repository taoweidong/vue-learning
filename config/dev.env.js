'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  API_BASE_URL: '"/api"'  // 本地测试
  // API_BASE_URL: '"https://easy-mock.com/mock/5d4feb0a63f29568b479c152/api"'
})
