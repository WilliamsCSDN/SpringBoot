<template>
    <div>
        <el-row style="margin-left: 45px">
            <el-col :xs="24" :sm="24" :md="12" :lg="8" :xl="8" style="margin-top: 30px"  v-for="list in this.hotlearn">
                <!--<a :href="'/lessondetail?title='+list.learnContent[0].title" style="color:black;">-->
                <a :href="'/learnrouter?id='+list.id" style="color:black;">
                    <img :src="'http://localhost:8082/3?a='+list.src" style="width: 80%" />
                </a>

                    <!--<img src="../../views/img/kc1.png" style="width: 80%" />-->

                    <div style="margin-top: 10px;font-size: 20px;width: 80%;height: 40px"><b> {{list.title}}</b></div>
                    <p style="color: #545C63;font-size: 14px;margin-top: 15px;width: 80%;height: 50px">{{list.content}}</p>
                    <!--<div style="font-size: 10px; color: #979FA6;margin-top: 15px"><span>{{list.bz}}步骤 · {{list.kc}}门课</span><span style="margin-left: 30px">★{{list.sc}}人收藏</span></div>-->
                    <div style="font-size: 10px; color: #979FA6;margin-top: 15px"><span>{{list.bz}}步骤 · {{list.kc}}门课</span><span style="margin-left: 30px;"><el-button type="danger" @click="delete1(list.id)">删除</el-button></span></div>

            </el-col>
        </el-row>
    </div>
</template>
<script>
    import ElButton from "../../../../node_modules/element-ui/packages/button/src/button";
    export default{
        components: {ElButton}, data(){
            return{
                hotlearn:[],
                iid:'',

            }
        },methods:{
                delete1(a){
                    this.$ajax.get('deleterouter?id=' + this.iid + '&learnrouter=' + a).then(res => {
                        this.$ajax.get('updateLearnContent2?id='+a).then(res=>{
                       if (res.status == 200) {
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
                    this.iid=res.data[0].id;
                    this.$ajax
                        .get('getuserr?id='+res.data[0].id)
                        .then(ress => {
                            this.hotlearn=ress.data[0].learnContent
                            console.log(this.hotlearn)
                        })
                })
            }
        },mounted:function () {
          this.aa();
        }
    }
</script>