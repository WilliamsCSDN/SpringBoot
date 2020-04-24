<template>
    <div>
        <el-row style="margin-left: 45px">
            <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24" style="margin-top: 30px"  v-for="(list,index) in this.hotsearch" :key="index">
                <!--<a :href="'/lessondetail?title='+list.learnContent[0].title" style="color:black;">-->
                <el-col :xs="5" :sm="5" :md="5" :lg="5" :xl="5">
                    <a :href="'/lessondetail?id='+list.id" style="color:black;">
                    <img :src="'http://localhost:8082/3?a='+list.src" style="width: 140px;height: 150px" />
                    </a>
                </el-col>

                    <!--<el-col :xs="4" :sm="4" :md="4" :lg="7" :xl="7"> <img src='../../views/img/learn1/learn1.png' style="width: 140px;height: 150px" /></el-col>-->
                <el-col :xs="19" :sm="19" :md="19" :lg="19" :xl="19">
                        <div style="margin-top: 10px;font-size: 20px;height: 40px;"><b> {{list.title}}</b></div>
                        <p style="color: #545C63;font-size: 14px;margin-top: 15px;height: 40px;">{{list.content}}</p>
                        <div style="font-size: 10px; color: #979FA6;margin-top: 15px"><span>作者:{{list.author}} 难度:{{list.level}}</span><span style="margin-left: 30px;"><el-button type="danger" @click="delete1(list.id)">删除</el-button></span></div>
                </el-col>

            </el-col>
        </el-row>
    </div>
</template>
<script>
    export default{
        data(){
            return{
                hotsearch:'',
                iid:''
            }
        },methods:{
            delete1(a){
                this.$ajax.get('deletekc?id='+this.iid+'&kc='+a).then(res=>{
                    this.$ajax.get('updateSearch2?id='+a).then(res=>{
                        if(res.status==200) {
                        this.$message.success('删除成功!')
                           this.$router.go(0)
                    }
                    else this.$message.error('删除失败!')
                    })
                })
            },
            aa(){
                var i=localStorage.getItem('token')
                this.$ajax.get('getUser?token='+i).then(res=>{
                    this.iid=res.data[0].id
                    this.$ajax
                        .get('getuserk?id='+res.data[0].id)
                        .then(ress => {
                            this.hotsearch=ress.data[0].search
                        })
                })
            }
        },mounted:function () {
                this.aa();
        }
    }
</script>