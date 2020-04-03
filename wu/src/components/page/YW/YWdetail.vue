<template>
    <div>
        <div class="new_header">
            <ul class="nav">
                <el-col :xs="2" :sm="2" :md="2" :lg="2" :xl="2" > <li><a href="/">首页 </a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='lesson?a='>免费课程</router-link></a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='LearnR'>学习路线</router-link></a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='YW'>社区</router-link></a></li></el-col>
                <el-col :xs="6" :sm="6"  :md="6" :lg="9" :xl="2"><li>
                    <el-autocomplete  :fetch-suggestions="querySearchAsync" placeholder="请输入内容" v-model="input" style="width: 70%;margin-top: -30px">
                    </el-autocomplete>
                    <a href="#" @click="search">搜索</a>
                </li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a href="http://www.baidu.com"><router-link to='Person1'>个人中心</router-link></a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="log" href="#"><router-link to="login">登陆</router-link></a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="reg" href="#"><router-link to="login">注册</router-link></a></li></el-col>
                <!--<el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="user" href="#"  style="display:none" @click="gg">{{user}}</a></li></el-col>-->
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="user" href="#" style="display:none"  @click="gg">{{user}}</a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="person" href="#"  style="display:none" @click="exit">退出</a></li></el-col>
            </ul>
            <div class="content1">
                <div style="font-size: 30px"> {{comment[0].question}}</div>
                <div style="font-size: 25px;margin-top: 10px">作者:{{comment[0].author}}</div>
            </div>

        </div>



               <div style="margin-top: 200px">
                   <div style="width: 50%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;font-size: 20px">
                       {{comment[0].content}}
                   </div>
                <div v-for="list in this.comment[0].wenDaComment"  style="width: 50%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;font-size: 20px">

                    <div style="font-size: 25px"><img src="../../../assets/img/img.jpg" style=" width: 40px; height: 40px;border-radius: 50%;"/>{{list.name}}</div>
                    <a href="javascript:void(0);" @click="a(list.id)" :id="'a'+list.id"><i class="el-icon-lx-like" style="float: right"></i></a>
                    <a href="javascript:void(0);" @click="b(list.id)" :id="'a'+list.id+list.id" style="display: none;"><i class="el-icon-lx-likefill" style="float: right"></i></a>
                    <div style="margin-left: 40px;margin-top: 10px">{{list.content}}</div>
                    <div style="margin-top: 10px;margin-left: 100px;" v-for="list1 in list.wenDaReply">
                        <span v-if="(list.name!=list1.name)&(list1.replyname!=list1.name)"><a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.id)"> {{list1.replyname}}回复{{list1.name}}:{{list1.content}}</a></span>
                        <span v-else=""> <a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.id)"> {{list1.replyname}}:{{list1.content}}</a></span>
                    </div>
                    <a href="javascript:void(0);" @click="c(list.id)" :id="'b'+list.id"><i class="el-icon-lx-comment" style="float: right"></i></a>

                    <div style="display: none;" :id="'ac'+list.id">
                        <el-input type="textarea" style="margin-top: 10px" v-model="content3" :placeholder=placeholer1></el-input>
                        <el-button class="editor-btn" type="primary" @click="submit1(list.id,list.name)" style="margin-top: 10px">提交</el-button>
                    </div>

                </div>
               </div>
                <div style="width: 55% ;margin: 0 auto;margin-top: 50px;padding-top: 10px">
                    <span style="font-size: 25px;background-color: yellowgreen">评论区&nbsp&nbsp&nbsp(目前仅支持文字)</span>
                    <quill-editor ref="myTextEditor" v-model="content2" :options="editorOption" style="margin-top: 25px"></quill-editor>
                    <el-button class="editor-btn" type="primary" @click="submit" style="margin-top: 25px">提交</el-button>
                </div>




        <div class="footer">
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
    import 'quill/dist/quill.core.css';
    import 'quill/dist/quill.snow.css';
    import 'quill/dist/quill.bubble.css';
    import { quillEditor } from 'vue-quill-editor';

    export default {
        components: {ElButton, ElInput, ElFormItem, ElForm, ElTabPane, ElTabs, ElCol, ElContainer, ElRow,quillEditor}, data () {
            return {
                placeholer1:'请输入内容',
                content4:'',
                content3:'',
                content2: '',
                editorOption: {
                    placeholder: 'Hello World'
                },
                user:'',
                input:'',
                suggestion:[{ "value": "Vue" },
                    { "value": "Java"},
                    { "value": "Python" }],
                content:'',
                content1:'',
                comment:'',
                activeName:'1',
                identity:'',
                user1:'',
                ccc:''
            }
        }
        ,methods: {
            onEditorFocus(){},
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
            search(){
                this.$router.push({path:'lesson',query:{a:this.input}})
            },
            search1(){
                this.$ajax.get('wenda?id='+this.$route.query.id).then(res=>{
                    this.comment=res.data
                })
            },
            xxx(){
                var i=localStorage.getItem('token')
                if(i!=null){
                    this.$ajax.get('getUser?token='+i).then(res=>{
                        this.identity=res.data[0].identity;
                        if(res.data[0].name==null)this.user="欢迎你!"+res.data[0].username;
                        else this.user="欢迎你!"+res.data[0].name;
                        this.user1=res.data[0].name;
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
            a(cc){
                var a1=document.getElementById('a'+cc);
                var a2=document.getElementById('a'+cc+cc);
                a1.style.setProperty("display","none")
                a2.style.setProperty("display","inline")
            },
            b(cc){
                var a1=document.getElementById('a'+cc);
                var a2=document.getElementById('a'+cc+cc);
                a1.style.setProperty("display","inline")
                a2.style.setProperty("display","none")
            },
            c(cc){
                this.placeholer1='请输入内容';
                var d=document.getElementById('ac'+cc);
                if(d.style.display=="inline"){
                    d.style.setProperty("display","none");
                    return false;
                }
                var e;
                for(var i=1;i<=100;i++){
                    e=document.getElementById('ac'+i);
                    if(e!=null) e.style.setProperty("display","none");
                }


                d.style.setProperty("display","inline");
//                d.style.display=="inline";



            },
            d(cc){
                var b1=document.getElementById('b'+cc);
                b1.style.setProperty("display","inline");
                var b2=document.getElementById('b'+cc+cc);
                b2.style.setProperty("display","none");
                var d=document.getElementById('ac'+cc);
                d.style.setProperty("display","none")
            },
            submit(){
                if(this.user1!=""){
                    var a=this.content2.replace("<p>", "").replace("</p>","").replace("<br>","").replace("<p>", "").replace("</p>","");
                    var url="insertwenda?iid="+this.$route.query.id+"&name="+this.user1+"&content="+a;
                    this.$ajax.get(url).then(res=>{
                        if(res.status===200) alert("添加成功");
                        else alert("添加失败");
                    })
                    location.reload();
                }else{this.$router.push('/login')}

            },
            submit1(a,b){
                if(this.user1!="") {
                    if (this.placeholer1 == "请输入内容") {
                        var url = "insertwenda1?id=" + a + "&name=" + b + "&replyname=" + this.user1 + "&content=" + this.content3;
                        this.$ajax.get(url).then(res => {
                            if (res.status === 200) alert("添加成功");
                            else alert("添加失败");
                        })
                    } else {
                        var url = "insertwenda1?id=" + a + "&name=" + this.placeholer1.substring(2) + "&replyname=" + this.user1 + "&content=" + this.content3;
                        this.$ajax.get(url).then(res => {
                            if (res.status === 200) alert("添加成功");
                            else alert("添加失败");
                        })
                    }
                    location.reload();
                }else{this.$router.push('/login')}

            },
            reply(a,b){
                this.placeholer1="回复"+a;
                for(var i=1;i<=100;i++){
                    var e=document.getElementById('ac'+i);
                    if(e!=null) e.style.setProperty("display","none");
                    if(i==b){
                        var d=document.getElementById('ac'+b);
                        d.style.setProperty("display","inline");
                    }
                }

            },
            gg(){
                if(this.identity==1||this.identity==2) this.$router.push('manager')
                else{}
            }

        },
        mounted:function () {
            this.search1();
            this.xxx();
        }
    }
</script>
<style>
    .new_header{
        width: 100%;
        height: 40px;
        background-color: black;
        text-align: center;
        padding-top: 20px;
    }
    .nav{
        list-style: none;
        height: 70px;
    }
    .nav li{
        font-size: 14px;
        font-family: SimHei;
    }
    .nav li a{text-decoration: none;color: white;height: 40px;display: inline-block}
    .user-avator {
        margin-left: 20px;
    }
    .user-avator img {
        display: block;
        width: 40px;
        height: 40px;
        border-radius: 50%;
    }
    .content1{
        background-image: url(../../../views/66.png);
        background-size: 100%;
        width: 100%;
        color: white;
        margin-top: -30px;
        padding-top: 50px;
        height: 100px;
    }
    .footer{ width: 100%;height: 100px;color: #99A1A6;}
    .footer a{
        text-decoration: none;
        color: #99A1A6;
        padding-left: 50px;
    }
    .footer1{margin: 0 auto;width: 1000px;margin-top: 50px;text-align: center;padding-top: 20px}
    .footer2{margin: 0 auto;width: 1000px;margin-top: 30px;text-align: center}
    .content2 div div a{color: black;}
    .content2 div div a div:hover{background-color:#FFF3F3 ;}
    .content3{

    }
</style>