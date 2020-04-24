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
                        <a href="#" @click="search">搜索</a>
                        </el-autocomplete>
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
                <span style="color:white">社区</span>
            </div>
            <div style="float: right;margin-right: 200px;margin-top: -110px"><el-button type="danger" style="height: 50px;width: 200px" @click="question">提问</el-button></div>
            <div style="width: 1100px;margin: 0 auto">
                <el-row>
                    <el-col  :xs="18" :sm="18" :md="18" :lg="24" :xl="24" style="background-color: #F3F5F6;padding-top: 20px">
                        <a style="font-size: 20px;margin-left: 15px;font-family: SimHei;text-decoration: none;color: red" href="#" >全部问答</a>
                        <div v-for="list1 in this.search2">
                            <el-col style="margin-top: 30px;margin-left: 15px">
                                <a :href="'YWdetail?id='+list1.id" style="color:black;">
                                    <el-col :xs="19" :sm="19" :md="19" :lg="24" :xl="24" style="font-family:SimHei;margin-top: 50px ">
                                    
                                        <div style="margin-top: 10px;font-size: 20px"><b> 总评论：{{list1.countwenda}}&nbsp&nbsp&nbsp{{list1.question}}</b></div>
                                        <p style="margin-left: 880px;margin-top: -20px"><b>作者:{{list1.author}}</b></p>
                                        <!--<p style="color: #545C63;font-size: 14px;margin-top: 20px;">{{list.content}}</p>-->
                                        <!--<div style="font-size: 10px; color: #979FA6;margin-top: 20px"><span>{{list.bz}}步骤 · {{list.kc}}门课</span><span style="margin-left: 30px">★{{list.sc}}人收藏</span></div>-->
                                    </el-col>
                                </a>
                                <hr style="width: 90%;box-shadow: 2px 2px 10px #000;background-color: #CCCCCC;margin-top: 100px;height: 0px"/>
                            </el-col>

                        </div>

                    </el-col>

                </el-row>

            </div>

        </div>
        <!--分页-->
        <el-col  :xs="18" :sm="18" :md="18" :lg="24" :xl="18" style="text-align: center;margin-top: 50px">
            <el-pagination
                    background
                    pageSize="5"
                    @current-change="currentchange"
                    layout="prev, pager, next"
                    :total="this.total">
            </el-pagination>
        </el-col>
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
        <el-dialog title="提问" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="作者">
                    <el-input disabled="true" v-model="form.author"></el-input>
                </el-form-item>
                <el-form-item label="问题">
                    <el-input v-model="form.question" placeholder="请一句话说明你的问题(以问号结束)"></el-input>
                </el-form-item>
                <el-form-item label="问题补充" >
                    <el-input v-model="form.content" placeholder="问题补充(选填)"></el-input>
                </el-form-item>
            </el-form>

            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="add">确 定</el-button>
            </span>
        </el-dialog>
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
    import ElDialog from "../../../../node_modules/element-ui/packages/dialog/src/component";

    export default{
        components: {ElDialog, ElButton, ElInput, ElFormItem, ElForm, ElTabPane, ElTabs, ElCol, ElContainer, ElRow}, data(){
            return{
                editVisible:false,
                hotselect:'',
                suggestion:[{ "value": "Vue" },
                    { "value": "Java"},
                    { "value": "Python" }],
                input:'',
                search2:'',
                total:'',
                form:{
                    author:'',
                    question:'',
                    content:''

                },
                identity:'',
                dialogTableVisible:false,
                activeName1:'1'
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
//                window.location.reload()
            },
            search1(){
                this.$ajax.get("wenda1").then(res => {
                    this.total=res.data.length;
                })
                this.$ajax.get("wenda1?start=0&num=5").then(res => {
                    this.search2 = res.data;
                })
            },
            currentchange(cpage){
                var url="wenda1?start="+(cpage-1)*5+"&num=5";
                this.$ajax.get(url).then(res => {
                    this.search2 = res.data;
                })
                scroll(0,0)
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
                        this.form.author=res.data[0].name;
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
            },
            question(){
                this.editVisible=true;
            },
            add(){
                this.$ajax.get('insertwenda2?question='+this.form.question+'&content='+this.form.content+'&author='+this.form.author).then(res=>{
                    if(res.status==200) this.$message.success('添加成功!')
                    else this.$message.error('添加失败!')

                })
                this.editVisible=false;
            }

        }
        ,mounted:function () {
//      document.body.innerHTML = document.body.innerHTML.replace(/Python/ig,"<span style='color: red;'>$&</span>");
            this.xxx();
            this.search1();



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
