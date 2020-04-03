<template>
    <div>
        <div style="width: 100%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;">
            <el-select placeholder="请选择" style="width: 60%" v-model="title">
                <el-option  v-for="(list,i) in this.content2" :key="(i+1)" :label="list.title" :value="list.id"></el-option>
            </el-select>
            <el-button type="primary" style="margin-left: 20px" @click="aaa">搜索</el-button>
        </div>

        <div v-for="list in this.comment" style="width: 100%; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 50px;font-size: 20px">
            <div style="font-size: 25px"><img src="../../../assets/img/img.jpg" style=" width: 40px; height: 40px;border-radius: 50%;"/>{{list.name}}</div>
            <div style="margin-left: 40px;margin-top: 10px">{{list.content}}</div>
            <span v-if="list.state==0"><el-button type="primary" style="float: right;margin-right: 500px;margin-top: -50px" @click="bbb(list.comment_id)">审核</el-button></span>
            <span v-else=""><el-button type="primary" style="float: right;margin-right: 500px;margin-top: -50px" >已审核</el-button></span>
            <el-button type="danger" style="float: right;margin-right: 400px;margin-top: -50px"@click="ccc(list.comment_id)">删除</el-button>
            </div>


        </div>

</template>
<script>
    import ElButton from "../../../../node_modules/element-ui/packages/button/src/button";
    export default{
        components: {ElButton}, data(){
            return{
                title:'',
                content2:'',
                comment:''

            }
        },methods:{
            aaa(){
                this.$ajax.get('comment?articleid='+this.title).then(res=>{
                    this.comment=res.data
                })
            },
            bbb(a){
                this.$ajax.get('updatesh?id='+a+'&state=1').then(res=>{
                    if(res.status==200) {
                        this.$message.success("审核成功");
                        this.aaa();
                    }
                    else this.$message.error("审核失败")
                })
            },
            ccc(a){
                this.$ajax.get('deletecomment?id='+a).then(res=>{
                    if(res.status==200) {
                        this.$message.success("删除成功");
                        this.aaa();
                    }
                    else this.$message.error("删除失败")
                })
            }

        },mounted:function () {
            var i=localStorage.getItem('token')
            this.$ajax.get('getUser?token='+i).then(res=>{
                if(res.data[0].identity==1) {
                    this.$ajax.get('search').then(res=>{
                        this.content2=res.data;
                    })
                }
                else {
                    this.$ajax.get('searchById?author='+res.data[0].name).then(res=>{
                        this.content2=res.data;
                    })
                }

            })
        }
    }
</script>