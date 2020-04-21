<script src="../../common/bus.js"></script>
<template>
    <div>
        <!--导航-->
        <div class="new_header1">
            <div>
                <ul class="nav1">
                    <el-col :xs="2" :sm="2" :md="2" :lg="2" :xl="2" > <li><a href="/">首页 </a></li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='lesson?a='>免费课程</router-link></a></li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='LearnR'>学习路线</router-link></a></li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='YW'>社区</router-link></a></li></el-col>
                    <el-col :xs="6" :sm="6"  :md="6" :lg="9" :xl="9"><li>
                        <el-autocomplete  :fetch-suggestions="querySearchAsync" placeholder="请输入内容" v-model="input" style="width: 70%;margin-top: -30px">
                        </el-autocomplete>
                        <a href="#" @click="search">搜索</a>
                    </li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='Person1'>个人中心</router-link></a></li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="log" href="#"><router-link to="login">登陆</router-link></a></li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="reg" href="#"><router-link to="login">注册</router-link></a></li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="user" href="#"  style="display:none" @click="gg">{{user}}</a></li></el-col>
                    <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="person" href="#"  style="display:none"  @click="exit">退出</a></li></el-col>
                </ul>
            </div>
        </div>

        <div style="width: 100%;height: 500px;padding-top: 150px;">
            <div class="aaa">
                <span style="color:white">个人中心</span>
            </div>
        </div>

<!--个人中心-->
        <el-row style="width: 1100px;margin: 0 auto;margin-top: -400px;height: 500px">
            <el-col :span="6" >
                <el-menu
                        :default-active="this.$route.path" router
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose"
                        style="height: 500px;"
                >


                    <el-menu-item :index="'/Person1'" style="height: 80px">
                        <i class="el-icon-location"></i>
                        <span slot="title">个人中心</span>
                    </el-menu-item>
                    <el-menu-item :index="'/Person2'" style="height: 80px">
                        <i class="el-icon-menu"></i>
                        <span slot="title">我的学习路线</span>
                    </el-menu-item>
                    <el-menu-item :index="'Person3'" style="height: 80px">
                        <i class="el-icon-document"></i>
                        <span slot="title">我的课程</span>
                    </el-menu-item>
                    <el-menu-item :index="'Person4'" style="height: 80px">
                        <i class="el-icon-document"></i>
                        <span slot="title">我的提问</span>
                    </el-menu-item>
                </el-menu>
            </el-col>
            <el-col span="18">
                <router-view></router-view>
            </el-col>
        </el-row>
        <!--底部-->
        <div class="footer"  style="float: left;">
            <div class="footer1">
                <a href="#">企业合作</a>
                <a href="#">人才招聘</a>
                <a href="#">联系我们</a>
                <a href="#">讲师招募</a>
                <a href="#">帮助中心</a>
                <a href="#">意见反馈</a>
                <a href="#">代码托管</a>
                <a href="#">友情链接</a>

            </div>
            <div class="footer2">
                © 2019 imooc.com  京ICP备 12003892号-11 京公网安备11010802030151号 北京奥鹏文化传媒有限公司 营业执照
               </div>

        </div>
    </div>

</template>
<script>
    import ElRow from 'element-ui/packages/row/src/row'
    import ElContainer from '../../../../node_modules/element-ui/packages/container/src/main'
    import ElCol from 'element-ui/packages/col/src/col'
    import ElTabs from '../../../../node_modules/element-ui/packages/tabs/src/tabs'
    import ElTabPane from '../../../../node_modules/element-ui/packages/tabs/src/tab-pane'
    import ElForm from '../../../../node_modules/element-ui/packages/form/src/form'
    import ElFormItem from '../../../../node_modules/element-ui/packages/form/src/form-item'
    import ElInput from '../../../../node_modules/element-ui/packages/input/src/input'
    import ElButton from '../../../../node_modules/element-ui/packages/button/src/button'
    import md5 from 'js-md5';

    export default{
        components: {ElButton, ElInput, ElFormItem, ElForm, ElTabPane, ElTabs, ElCol, ElContainer, ElRow}, data(){
            return{
                user:'',
                suggestion:[{ "value": "Vue" },
                    { "value": "Java"},
                    { "value": "Python" }],
                input:'',
                tabPosition: 'left',
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
                    identity:'',
                },

            }
        },
        created() {
            var lett = this;
            document.onkeydown = function(e) {
                var key = window.event.keyCode;
                if (key == 13) {
                    lett.search();
                }
            }
        },methods:{
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },

            select(){
                var a = this.input;
                this.$router.push({path: '/lesson', query: {a: this.input}});
            },
            querySearchAsync(queryString, cb){
                var restaurants = this.suggestion;
                var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants;
                clearTimeout(this.timeout);
                this.timeout = setTimeout(() => {
                    cb(results);
                }, 3000 * Math.random());
            },
            createStateFilter(queryString) {
                return (input) => {
                    return (input.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
                };
            },
            search(){
                this.$router.push({path:'lesson',query:{a:this.input}})
            },

            exit(){
                this.$ajax.get('remove?token='+localStorage.getItem('token')).then(res=>{
                    alert('后台删除token成功！')
                })
                localStorage.removeItem('token');
                var a=document.getElementById("user");
                a.style.setProperty('display','none')
                var e=document.getElementById("log")
                e.style.setProperty('display','inline');
                var b=document.getElementById("reg")
                b.style.setProperty('display','inline');
                var c=document.getElementById("person");
                c.style.setProperty('display','none')
            },
            xxx(){
                var i=localStorage.getItem('token')
//        alert(i)
                if(i!=null){
                    this.$ajax.get('getUser?token='+i).then(res=>{
                        this.identity=res.data[0].identity;
                        if(res.data[0].name==null)this.user="欢迎你!"+res.data[0].username;
                        else this.user="欢迎你!"+res.data[0].name;
                        var a=document.getElementById("user");
                        a.style.setProperty('display','inline')
                        var e=document.getElementById("log")
                        e.style.setProperty('display','none');
                        var b=document.getElementById("reg")
                        b.style.setProperty('display','none');
                        var c=document.getElementById("person");
                        c.style.setProperty('display','inline')
                    })
                }
            },
            gg(){
                if(this.identity==1||this.identity==2) this.$router.push('manager')
                else{}
            }

        }
        ,mounted:function () {
            this.xxx();
            this.$ajax.get('getUser?token='+localStorage.getItem("token")).then(res=>{
                var id=res.data[0].id;
                this.$ajax.get('findById?id='+id).then(res=>{
                    this.form=res.data[0];
                })
            })
        }
    }
</script>

<style>
    .new_header1{
        width: 100%;
        height: 40px;
        background-color: black;
        text-align: center;
        padding-top: 20px;
    }
    .nav1{
        list-style: none;
        height: 70px;
    }
    .nav1 li{
        font-size: 14px;
        font-family: SimHei;
    }
    .nav1 li a{text-decoration: none;color: white;height: 40px;display: inline-block}

    .footer{ width: 100%;height: 150px;color: #99A1A6;}
    .footer a{
        text-decoration: none;
        color: #99A1A6;
        padding-left: 50px;
    }
    .footer1{margin: 0 auto;width: 1000px;margin-top: 50px;text-align: center;}
    .footer2{margin: 0 auto;width: 1000px;margin-top: 30px;text-align: center}
    .aaa{
        width: 100%;
        margin: 0 auto;
        text-align: center;
        font-size: 25px;
        margin-top: -150px;
        padding-top: 50px;
        background-image: url(../../../views/66.png);
        background-size: 100%;
        height: 100px;
        margin-bottom: 10px;
    }

</style>
