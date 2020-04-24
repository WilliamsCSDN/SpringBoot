<template>
    <div>
        <div class="form-box">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="用户名">
                    <el-input v-model="form.username" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="昵称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <!--<el-form-item label="加密密码">-->
                <!--<el-input v-model="form.password"></el-input>-->
                <!--</el-form-item>-->

                <el-form-item label="身份">
                    <!--<el-input v-model="form.usertype.name"></el-input>-->
                    <el-select v-model="form.usertype.name" placeholder="请选择" :disabled="true">
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
                    <el-button type="danger" style="margin-left: 100px" @click="updatepassword">修改密码</el-button>
                </el-form-item>
            </el-form>

        </div>
        <el-dialog title="修改密码" :visible.sync="editVisible" width="30%">
            <el-form ref="form1" :model="form1" label-width="70px">
                <el-form-item label="旧密码">
                    <el-input v-model="form1.oldpassword" type="password"></el-input>
                </el-form-item>
                <el-form-item label="新密码">
                    <el-input v-model="form1.password" type="password"></el-input>
                </el-form-item>

                <el-form-item label="确认密码"> <el-input  v-model="form1.onecepassword" type="password"></el-input></el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>

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
                editVisible:false,
                form1:{}
            }
        },methods:{
            onSubmit(){
                var url="updateUser1?id="+this.form.id+"&name="+this.form.name+"&username="+this.form.username+"&identity="+this.form.usertype.id+"&qq="+this.form.qq+"&phone="+this.form.phone+"&address="+this.form.address;
                this.$ajax.get(url).then(res=>{
                    if(res.status==200)  this.$message.success('修改成功');
                    else  this.$message.success('修改失败');
                    location.reload();
                })

            },
            updatepassword(){
               this.editVisible=true
            },
            saveEdit(){

                var inputPass = this.form1.password;
                var salt = "123456";
                var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
                var password = md5(str);

                var inputPass = this.form1.oldpassword;
                var salt = "123456";
                var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
                var oldpassword = md5(str);
                if(this.form1.password!=this.form1.onecepassword) {
                    this.$message.error('两次密码不一致');
                    return false;
                }
                this.$ajax.get('getUser?token='+localStorage.getItem("token")).then(res=> {
                    var username=res.data[0].username;
                    this.$ajax.get('findByName?username='+username+'&password='+oldpassword).then(res=>{
                        if(res.data!=''){
                            this.$ajax.get('updatePassword?username='+ username+'&oldpassword='+oldpassword+'&password='+password).then(res=>{
                                if(res.status==200){
                                    this.$message.success('修改成功!');
                                    this.$router.push({path:'login'});
                                    this.$ajax.get('remove?token='+localStorage.getItem('token')).then(res=>{
                                        alert('后台删除token成功！')
                                    })
                                    localStorage.removeItem('token');
                                }
                                else this.$message.error('修改失败!')
                                this.editVisible=false
                            })
                        }else this.$message.error('原密码不正确!')

                    })
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