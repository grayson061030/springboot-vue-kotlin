import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import VueLogger from 'vuejs-logger'

Vue.config.productionTip = false

const options = {
  isEnabled: true,
  logLevel: 'debug',
  stringifyArguments: false,
  showLogLevel: true,
  showMethodName: false,
  separator: '|',
  showConsoleColors: true
}

Vue.use(VueLogger, options)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
