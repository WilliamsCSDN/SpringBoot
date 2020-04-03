<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#324157"
            text-color="#bfcbd9"
            active-text-color="#20a0ff"
            unique-opened
            router
        >
            <template v-for="item in items">

                <template>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from '../common/bus';
export default {
    data() {
        return {
            collapse: false,
            items: [
                {
                    icon: 'el-icon-lx-home',
                    index: 'manager',
                    title: '系统首页'
                },
                {
                    icon: 'el-icon-lx-people',
                    index: 'personinformation',
                    title: '个人信息'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'usermanager',
                    title: '用户管理'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'permissionmanager',
                    title: '权限管理'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'lessonmanager',
                    title: '课程管理'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'lessondetailmanager',
                        title: '课程章节管理'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'commentmanager',
                    title: '评论管理'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'learnrmanager',
                    title: '学习之路管理'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'learnroutermanager',
                    title: '学习路线管理'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: 'ywmanager',
                    title: '社区管理'
                },

            ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        }
    },
    created() {
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
    }
};
</script>

<style scoped>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}
.sidebar > ul {
    height: 100%;
}
</style>
