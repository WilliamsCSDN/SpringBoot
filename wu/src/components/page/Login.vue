<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">E-learning平台登陆</div>
            <el-tabs stretch="true" style="color: white;" type="border-card">
                <el-tab-pane label="登陆">
                    <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                        <el-form-item prop="username">
                            <el-input v-model="param.username" placeholder="username">
                                <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                            </el-input>
                        </el-form-item>
                        <el-form-item prop="password" style="margin-top: 50px">
                            <el-input
                                    type="password"
                                    placeholder="password"
                                    v-model="param.password"
                                    @keyup.enter.native="login()"
                            >
                                <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                            </el-input>
                        </el-form-item>
                        <div class="login-btn" style="margin-top: 58px">
                            <el-button type="primary" @click="login()">登录</el-button>
                        </div>
                    </el-form>
                </el-tab-pane>
                <el-tab-pane label="注册">
                    <el-form :model="param1" :rules="rules" ref="login" label-width="0px" class="ms-content">
                        <el-form-item prop="username">
                            <el-input v-model="param1.username" placeholder="username">
                                <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                            </el-input>
                        </el-form-item>
                        <el-form-item prop="password" style="margin-top: 50px">
                            <el-input
                                    type="password"
                                    placeholder="password"
                                    v-model="param1.password"
                                    @keyup.enter.native="register()"
                            >
                                <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                            </el-input>
                        </el-form-item>

                        <el-form-item>
                            <el-radio-group v-model="param1.identity">
                                <el-radio label="3">学生</el-radio>
                                <el-radio label="2">教师</el-radio>
                            </el-radio-group>
                        </el-form-item>

                        <div class="login-btn" style="margin-top:-10px">
                            <el-button type="primary" @click="register()">注册</el-button>
                        </div>
                    </el-form>
                </el-tab-pane>
            </el-tabs>

        </div>
    </div>
</template>

<script>
    import md5 from 'js-md5';
    import ElTabs from "../../../node_modules/element-ui/packages/tabs/src/tabs";
    import ElTabPane from "../../../node_modules/element-ui/packages/tabs/src/tab-pane";
export default {
    components: {ElTabPane, ElTabs}, data: function() {
        return {
            param: {
                username: 'admin',
                password: 'admin',
            },
            param1:{
                username:'16',
                password:'16',
                identity:'3',
            },
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
        };
    },
    methods: {
        login() {
            this.$refs.login.validate(valid => {
                if (valid) {
                    var inputPass = this.param.password;
                    var salt = "123456";
                    var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
                    var password = md5(str);
                    var url="getUser?username="+this.param.username+"&password="+password;
                    this.$ajax.get(url).then(res=>{
                        if(res.data!=false) {
                            localStorage.setItem("token", res.data,10)
                            
                            this.$ajax.get('getUser?token='+res.data).then(res=>{
                                localStorage.setItem("identity",res.data[0].identity)
                            })

                            this.$message.success('登录成功');
                            this.$router.go(-1);
                        }else {
                            this.$message.error('请输入正确的账号和密码');
                        }
                    })

                }
            });
        },
        register(){
            if(this.param1.username==''||this.param1.password=='') {
                this.$message.error('请输入用户名或密码')
                return true;
            }
            this.$ajax.get('findByUsername?username='+this.param1.username).then(res=>{
                if(res.data=='') {
                    var inputPass = this.param1.password;
                    var salt = "123456";
                    var str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
                    var password = md5(str);
                    var url = 'registerUser?username=' + this.param1.username + '&password=' + password + "&identity=" + this.param1.identity;
                    this.$ajax.get(url).then(res => {
                        alert(res.data);


                                var url="getUser?username="+this.param1.username+"&password="+password;
                                this.$ajax.get(url).then(res=>{
                                    if(res.data!=false) {
                                        localStorage.setItem("token", res.data)
                                        this.$ajax.get('getUser?token='+res.data).then(res=>{
                                            localStorage.setItem("identity",res.data[0].identity)
                                        })
                                        this.$router.push('/Person1');
                                        this.$message.success('请完善自己的信息!')
                                    }
                                })
                    })
                }
                else this.$message.error('用户名已注册!')
            })
        },
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    /*background-image: url(../../assets/img/login-bg.jpg);*/
    background-image: url(../../views/img/login.jpg);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: slategrey;
    border-bottom: 1px solid #ddd;
}
.ms-login {
    /*position: absolute;*/
    float: right;
margin-right: 80px;
    margin-top: 150px;
    height: 400px;
    /*top: 50%;*/
    width: 350px;
    /*margin: -190px 0 0 -175px;*/
    border-radius: 5px;
    background: white;

    overflow: hidden;
}
.ms-content {
    padding: 50px 30px;
}
.login-btn {
    text-align: center;
    margin-top: 50px;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
}
</style>