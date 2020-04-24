<template>
    <div>
        <div v-for="list1 in this.search2">
            <el-col style="margin-top: 30px;margin-left: 15px">
                <a :href="'YWdetail?id='+list1.id" style="color:black;">
                    <el-col :xs="19" :sm="19" :md="19" :lg="24" :xl="24" style="font-family:SimHei;margin-top: 50px ">
                        <div style="margin-top: 10px;font-size: 20px"><b> {{list1.question}}</b></div>
                        <div style="float: right;margin-right: 400px">
                        <el-button type="danger" @click="aaa(list1.id)">删除</el-button>
                        </div>
                        <!--<p style="color: #545C63;font-size: 14px;margin-top: 20px;">{{list.content}}</p>-->
                        <!--<div style="font-size: 10px; color: #979FA6;margin-top: 20px"><span>{{list.bz}}步骤 · {{list.kc}}门课</span><span style="margin-left: 30px">★{{list.sc}}人收藏</span></div>-->
                    </el-col>
                </a>

            </el-col>

        </div>
    </div>
</template>
<script>
    export default{
        data(){
            return{
                search2:'',
            }
        },methods:{
            delete1(a){
                this.$ajax.get('deletekc?id='+this.iid+'&kc='+a).then(res=>{
                    if(res.status==200) {
                        this.$message.success('删除成功!')
                        this.aa();
                    }
                    else this.$message.error('删除失败!')
                })
            },
            aa(){
                var i=localStorage.getItem('token')
                this.$ajax.get('getUser?token='+i).then(res=>{

                    this.$ajax
                        .get('wenda1?author='+res.data[0].name)
                        .then(ress => {
                            this.search2=ress.data
                        })
                })
            },
            aaa(b){
                this.$ajax.get('deletewenda').then(res=>{
                    if(res.status==200) this.$message.success('成功')
                    this.search1();
                })
            }
        },mounted:function () {
            this.aa();
        }
    }
</script>