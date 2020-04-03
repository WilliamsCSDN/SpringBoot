<template>
    <div>
    <div>
        个人信息
    </div>
    <div class="form-box">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="form.username" disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="昵称">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <!--<el-form-item label="加密密码">-->
                <!--<el-input v-model="form.password"></el-input>-->
            <!--</el-form-item>-->

            <el-form-item label="身份">
                <!--<el-input v-model="form.usertype.name"></el-input>-->
                <el-select v-model="form.usertype.name" placeholder="请选择" disabled="true">
                    <el-option key="bbk" label="管理员" value="1"></el-option>
                    <el-option key="xtc" label="教师" value="2"></el-option>
                    <el-option key="imoo" label="学生" value="3"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="QQ">
                <el-input v-model="form.qq"></el-input>
            </el-form-item>
            <el-form-item label="手机">
                <el-input v-model="form.phone"></el-input>
            </el-form-item>
            <el-form-item label="地址">
                <el-input v-model="form.address"></el-input>
            </el-form-item>



            <el-form-item>
                <el-button type="primary" @click="onSubmit">保存</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>

    </div>
    </div>

</template>
<script>
    import md5 from 'js-md5';
    export default{
        data(){
            return{
                form: {
                    id:'',
                    username:'',
                    name: '',
                    usertype:{
                        id:'',
                        name:''
                    },
                    qq: '',
                    phone: '',
                    address: '',
                },
            }
        },methods:{
            onSubmit(){
                var url="updateUser1?id="+this.form.id+"&name="+this.form.name+"&username="+this.form.username+"&identity="
                    +this.form.usertype.id+"&qq="+this.form.qq+"&phone="+this.form.phone+"&address="+this.form.address;
                this.$ajax.get(url).then(res=>{
                    if(res.status==200)  this.$message.success('修改成功');
                    else  this.$message.success('修改失败');
                    location.reload();
                })

    }

        },mounted:function () {

            this.$ajax.get('getUser?token='+localStorage.getItem("token")).then(res=>{
                var id=res.data[0].id;
                this.$ajax.get('findById?id='+id).then(res=>{
                    this.form=res.data[0];
                })
            })
        }
    }
</script>
<style></style>