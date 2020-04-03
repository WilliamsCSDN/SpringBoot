<template>
    <section class="main">
        <div class="container">

            <div class="drag-box">
                <div class="drag-box-item">
                    <div class="item-title">管理员</div>
                    <draggable v-model="admin" @remove="removeHandle" :options="dragOptions">
                        <transition-group tag="div" id="admin" class="item-ul">
                            <div v-for="item in admin" class="drag-list" :key="item.id">
                                {{item.permission}}
                            </div>
                        </transition-group>
                    </draggable>
                </div>
                <div class="drag-box-item">
                    <div class="item-title">教师</div>
                    <draggable v-model="teacher" @remove="removeHandle" :options="dragOptions">
                        <transition-group tag="div" id="teacher" class="item-ul">
                            <div v-for="item in teacher" class="drag-list" :key="item.id">
                                {{item.permission}}
                            </div>
                        </transition-group>
                    </draggable>
                </div>
                <div class="drag-box-item">
                    <div class="item-title">学生</div>
                    <draggable v-model="student" @remove="removeHandle" :options="dragOptions">
                        <transition-group tag="div" id="student" class="item-ul">
                            <div v-for="item in student" class="drag-list" :key="item.id">
                                {{item.permission}}
                            </div>
                        </transition-group>
                    </draggable>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
    import draggable from 'vuedraggable'
    export default {
        name: 'draglist',
        data() {
            return {
                dragOptions:{
                    animation: 120,
                    scroll: true,
                    group: 'sortlist',
                    ghostClass: 'ghost-style'
                },
                admin: [],
                teacher: [],
                student:[]
            }
        },
        components:{
            draggable
        },
        methods: {
            removeHandle(event){
                console.log(event);
                this.$message.success(`从 ${event.from.id} 移动到 ${event.to.id} `);
            }
        },mounted:function () {
            this.$ajax.get('getpermission?iid=1').then(res=>{
                this.admin=res.data;
            })
            this.$ajax.get('getpermission?iid=2').then(res=>{
                this.teacher=res.data;
            })
            this.$ajax.get('getpermission?iid=3').then(res=>{
                this.student=res.data;
            })
        }
    }

</script>

<style scoped>
    .drag-box{
        display: flex;
        user-select: none;
    }
    .drag-box-item {
        flex: 1;
        max-width: 330px;
        min-width: 300px;
        background-color: #eff1f5;
        margin-right: 16px;
        border-radius: 6px;
        border: 1px #e1e4e8 solid;
    }
    .item-title{
        padding: 8px 8px 8px 12px;
        font-size: 14px;
        line-height: 1.5;
        color: #24292e;
        font-weight: 600;
    }
    .item-ul{
        padding: 0 8px 8px;
        height: 500px;
        overflow-y: scroll;
    }
    .item-ul::-webkit-scrollbar{
        width: 0;
    }
    .drag-list {
        border: 1px #e1e4e8 solid;
        padding: 10px;
        margin: 5px 0 10px;
        list-style: none;
        background-color: #fff;
        border-radius: 6px;
        cursor: pointer;
        -webkit-transition: border .3s ease-in;
        transition: border .3s ease-in;
    }
    .drag-list:hover {
        border: 1px solid #20a0ff;
    }
    .drag-title {
        font-weight: 400;
        line-height: 25px;
        margin: 10px 0;
        font-size: 22px;
        color: #1f2f3d;
    }
    .ghost-style{
        display: block;
        color: transparent;
        border-style: dashed
    }
</style>
