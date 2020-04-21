import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    mode:'history',
    routes: [
        {
            path: '/',
            // component:()=>import('../components/page/Index.vue'),
            component:resolve=>(require(['../components/page/Index.vue'],resolve)),
            meta: { title: '首页',require:true }
        },
        {
            path:'/freecourse',
            // component:()=>import('../components/page/FreeCourse.vue'),
            component:resolve=>(require(['../components/page/Learn/FreeCourse.vue'],resolve)),
            meta: { title: '免费课程',require:false }
        },
        {
            path:'/lesson',
            // component:()=>import('../components/page/Lesson.vue'),
            component:resolve=>(require(['../components/page/Learn/Lesson.vue'],resolve)),
            meta: { title: '搜索课程',require:true }
        },
        {
            path:'/lessondetail',
            // component:()=>import('../components/page/LessonDetail.vue'),
            component:resolve=>(require(['../components/page/Learn/LessonDetail.vue'],resolve)),
            meta: { title: '课程详情',require:true }
        },{
            path:'/learnrouter',
            // component:()=>import('../components/page/LearnRouter.vue'),
            component:resolve=>(require(['../components/page/Learnr/LearnRouter.vue'],resolve)),
            meta: { title: '学习路线',require:false }
        },
        {
            path:'/LearnR',
            // component:()=>import('../components/page/LearnR.vue'),
            component:resolve=>(require(['../components/page/Learnr/LearnR.vue'],resolve)),
            meta: { title: '学习之路',require:true }
        },
        {
            path:'/YW',
            // component:()=>import('../components/page/YW.vue'),
            component:resolve=>(require(['../components/page/YW/YW.vue'],resolve)),
            meta: { title: '社区',require:true }
        },
        {
            path:'/YWdetail',
            // component:()=>import('../components/page/YWdetail.vue'),
            component:resolve=>(require(['../components/page/YW/YWdetail.vue'],resolve)),
            meta: { title: '社区回答',require:false }
        },
        {
            path:'/Person1',
            // component:()=>import('../components/page/Person.vue'),
            component:resolve=>(require(['../components/page/Person/Person.vue'],resolve)),
            meta: { title: '个人中心',require:false },
            children:[{
                path:'/Person1',
                // component:()=>import('../components/page/Person1.vue'),
                component:resolve=>(require(['../components/page/Person/Person1.vue'],resolve)),
                meta: { title: '个人中心',require:false },
            },
                {
                    path:'/Person2',
                    // component:()=>import('../components/page/Person2.vue'),
                    component:resolve=>(require(['../components/page/Person/Person2.vue'],resolve)),
                    meta: { title: '个人中心',require:false },
                },
                {
                    path:'/Person3',
                    // component:()=>import('../components/page/Person3.vue'),
                    component:resolve=>(require(['../components/page/Person/Person3.vue'],resolve)),
                    meta: { title: '个人中心',require:false },
                },
                {
                    path:'/Person4',
                    // component:()=>import('../components/page/Person3.vue'),
                    component:resolve=>(require(['../components/page/Person/Person4.vue'],resolve)),
                    meta: { title: '个人中心',require:false },
                }]
        },
        {
            path: '/',
            component: () => import(/* webpackChunkName: "home" */ '../components/common/Home.vue'),
            meta: { title: '' },
            children: [
                {
                    path: '/manager',
                    component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Manager/Index.vue'),
                    meta: { title: '系统首页',require:false,permission:true }
                },{
                    path: '/personinformation',
                    component: () => import(/* webpackChunkName: "dashboard" */ '../components/page/Manager/PersonInformation.vue'),
                    meta: { title: '个人信息',require:false,permission:true }

                },
                {
                    path: '/usermanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/UserManager.vue'),
                    meta: { title: '用户管理',require:false,permission:true,admin:true}
                }
                ,
                {
                    path: '/permissionmanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/PermissionManager.vue'),
                    meta: { title: '权限管理',require:false,permission:true }
                }
                ,
                {
                    path: '/lessonmanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/LessonManager.vue'),
                    meta: { title: '课程管理',require:false,permission:true}
                }
                ,
                {
                    path: '/lessondetailmanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/LessonDetailManager.vue'),
                    meta: { title: '课程章节管理',require:false,permission:true}
                },
                {
                    path: '/commentmanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/CommentManager.vue'),
                    meta: { title: '评论管理',require:false,permission:true}

                },
                {
                    path: '/learnrmanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/LearnRManager.vue'),
                    meta: { title: '学习之路管理',require:false,permission:true,admin:true}

                },
                {
                    path: '/learnroutermanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/LearnRouterManager.vue'),
                    meta: { title: '学习路线管理',require:false,permission:true,admin:true}

                },
                {
                    path: '/ywmanager',
                    component: () => import(/* webpackChunkName: "403" */ '../components/page/Manager/YWManager.vue'),
                    meta: { title: '社区管理',require:false,permission:true,admin:true}

                },

            ]
        },
        {
            path: '/login',
            component: () => import(/* webpackChunkName: "login" */ '../components/page/Login.vue'),
            meta: { title: '登录',require:true }
        }

    ]
});
