import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import VueI18n from 'vue-i18n';
import { messages } from './components/common/i18n';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
// import './assets/css/theme-green/index.css'; // 浅绿色主题
import './assets/css/icon.css';
import './components/common/directives';
import 'babel-polyfill';
import axios from 'axios';
import echarts from 'echarts';
Vue.prototype.$echarts = echarts

Vue.prototype.$ajax=axios
axios.defaults.timeout = 5000;
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';
axios.defaults.baseURL = 'http://localhost:8082/';
Vue.config.productionTip = false;
Vue.use(VueI18n);
Vue.use(ElementUI, {
    size: 'small'
});
const i18n = new VueI18n({
    locale: 'zh',
    messages
});

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title} | E-learning平台`;
    const role = localStorage.getItem('token');
    const identity=localStorage.getItem('identity');

    if(to.meta.require) next(); //能访问首页,搜索,课程页面等等
    else{
    if (!role && to.path !== '/login') {
        next('/login');
    } else if (to.meta.permission) {
        if(to.meta.admin) identity == 1? next() :alert('暂无权限访问');
        // 如果是管理员权限则可进入，这里只是简单的模拟管理员权限而已
        else identity == 3 ? next('/') : next();
    } else {
            next();
    }
    }


});

new Vue({
    router,
    i18n,
    render: h => h(App)
}).$mount('#app');