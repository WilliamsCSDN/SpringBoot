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
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="user" href="#"  style="display:none" @click="gg">欢迎你！{{user}}</a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="person" href="#"  style="display:none" @click="exit">退出</a></li></el-col>
            </ul>
            <div class="content1">
                <div>
                <div style="font-size: 30px"> {{content.title}}</div>

                <span><img src="../../../assets/img/img.jpg" style=" width: 40px; height: 40px;border-radius: 50%;"/>{{content.author}}</span>&nbsp&nbsp&nbsp&nbsp&nbsp<span style="font-size: 25px">难度</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{content.level}}</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <span><span style="font-size: 25px">学习人数</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{content.sc}}</span>
                </div>
                <div style="float: right;margin-right: 200px;margin-top: -80px"><el-button type="danger" style="height: 50px;width: 200px" @click="jr">加入学习</el-button></div>
            </div>

        </div>

        <el-tabs stretch="true" style="padding-top: 200px" v-model="activeName">
            <el-tab-pane label="课程章节" class="content2" name=1>
                <div style="width: 50%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;">简介:{{content.content}}</div>
                <div v-for="list in this.content1" style="width: 51%;margin: 0 auto; border-radius: 5px; background-color: #E5EAF0; text-align: left; padding: 20px 20px 20px 20px; margin-top: 20px;">
                    <span style="font-size: 22px"><b>第{{list.zj}}章&nbsp&nbsp&nbsp{{list.title}}</b></span>
                    <div v-for="list1 in list.searchContent1" style="width: 100%;margin-top: 20px;">
                        <a :href="list1.url"><div style="text-align: left;margin-left: 0px;width: 750px;height: 50px;padding-left: 20px;padding-top: 10px  ">
                        <span><i class="el-icon-lx-crown"></i> {{list1.zjj}}&nbsp&nbsp&nbsp{{list1.title}} </span>
                            <el-button style="float: right">开始学习</el-button>
                    </div></a>
                    </div>
                </div>

            </el-tab-pane>
            <el-tab-pane label="用户评论" name=2 class="content3">
                <div v-for="list in this.comment" v-if="list.state==1" style="width: 50%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;font-size: 20px">

                    <div style="font-size: 25px"><img src="../../../assets/img/img.jpg" style=" width: 40px; height: 40px;border-radius: 50%;"/>{{list.name}}</div>
                    <div style="float: right;margin-top: -30px;font-size:15px;color: #99A1A6;">{{list.createtime}}</div>
                    <a href="javascript:void(0);" @click="a(list.comment_id)" :id="'a'+list.comment_id"><i class="el-icon-lx-like" style="float: right"></i></a>
                    <a href="javascript:void(0);" @click="b(list.comment_id)" :id="'a'+list.comment_id+list.comment_id" style="display: none;"><i class="el-icon-lx-likefill" style="float: right"></i></a>
                    <div style="margin-left: 40px;margin-top: 10px">{{list.content}}</div>
                    <div style="margin-top: 10px;margin-left: 100px;" v-for="list1 in list.commentReplyList">
                        <!--<span v-if="(list.name==list1.replyname)&(list1.replyname!=list1.name)"><a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.comment_id)"> {{list1.replyname}}回复{{list1.name}}:{{list1.content}}</a></span>-->
                        <!--<span v-else=""> <a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.comment_id)"> {{list1.replyname}}:{{list1.content}}</a></span>-->
                        <span v-if="(list.name==list1.name)"><a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.comment_id)"> {{list1.replyname}}:{{list1.content}} </a></span>
                        <span v-else=""> <a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.comment_id)">{{list1.replyname}}回复{{list1.name}}:{{list1.content}}</a></span>
                   </div>
                    <a href="javascript:void(0);" @click="c(list.comment_id)" :id="'b'+list.comment_id"><i class="el-icon-lx-comment" style="float: right"></i></a>

                    <div style="display: none;" :id="'ac'+list.comment_id">
                        <el-input type="textarea" style="margin-top: 10px" v-model="content3" :placeholder=placeholer1></el-input>
                        <el-button class="editor-btn" type="primary" @click="submit1(list.comment_id,list.name)" style="margin-top: 10px">提交</el-button>
                    </div>
                </div>
                <div v-else=""></div>
                <div style="width: 55% ;margin: 0 auto;margin-top: 50px;padding-top: 10px">
                    <span style="font-size: 25px;background-color: yellowgreen">评论区</span>
                    <quill-editor ref="myTextEditor" v-model="content2" :options="editorOption" style="margin-top: 25px"></quill-editor>
                    <el-button class="editor-btn" type="primary" @click="submit" style="margin-top: 25px">提交</el-button>
                </div>
            </el-tab-pane>
        </el-tabs>

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
                idname:'',
                identity:'',
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
            xxx(){
                var i=localStorage.getItem('token')
//        alert(i)
                if(i!=null){
                    this.$ajax.get('getUser?token='+i).then(res=>{
                        this.idname=res.data[0].id;
                        this.identity=res.data[0].identity;
                        if(res.data[0].name==null)this.user=res.data[0].username;
                        else this.user=res.data[0].name;
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
                if(this.user!=""){
                var a=this.content2.replace("<p>", "").replace("</p>","").replace("<br>","").replace("<p>", "").replace("</p>","");
                var url="insertcomment?articleid="+this.$route.query.id+"&name="+this.user+"&content="+a+"&state=0";
                this.$ajax.get(url).then(res=>{
                    if(res.status===200){
                        this.$message.success("添加成功(请等待老师审核)");
                        this.content2=''
                    } 
                    else this.$message.error("添加失败");
                })
                }else{this.$router.push('/login')}

            },
            submit1(a,b){
                if(this.user!="") {
                    if (this.placeholer1 == "请输入内容") {
                        var url = "insertcomment1?comment_id=" + a + "&name=" + b + "&replyname=" + this.user + "&content=" + this.content3 + "&prase_count=10";
                        this.$ajax.get(url).then(res => {
                            if (res.status === 200) alert("添加成功");
                            else alert("添加失败");
                        })
                    } else {
                        var url = "insertcomment1?comment_id=" + a + "&name=" + this.placeholer1.substring(2) + "&replyname=" + this.user + "&content=" + this.content3 + "&prase_count=10";
                        this.$ajax.get(url).then(res => {
                            if (res.status === 200) alert("添加成功");
                            else alert("添加失败");
                        })
                    }
                    location.reload();
                }else{this.$router.push('/login')}

            },
            reply(a,b){
                if(this.user==a){}
                else{
                    this.placeholer1="回复"+a;
                    for(var i=1;i<=100;i++){
                        var e=document.getElementById('ac'+i);
                        if(e!=null) e.style.setProperty("display","none");
                        if(i==b){
                            var d=document.getElementById('ac'+b);
                            d.style.setProperty("display","inline");
                        }
                    }
                }


            },
            jr(){
                this.$ajax.get('getuserk?id='+this.idname).then(res=>{
                    if(res.data[0]!=null) {
                        for (var i = 0; i < res.data[0].search.length; i++) {
                            if (res.data[0].search[i].id == this.$route.query.id) {
                                this.$message.error('你已经加入了!');
                                return false;
                            }
                        }
                        this.$ajax.get('insertkc?id=' + this.idname + '&kc=' + this.$route.query.id).then(res => {
                                this.$ajax.get('updateSearch1?id='+this.$route.query.id).then(res=>{
                                                this.$ajax.get('searchById?id='+this.$route.query.id).then(res=>{
                this.content=res.data[0]
            
                                    if (res.status == 200) this.$message.success('加入成功!');
                                else this.$message.error('加入失败!');
                                })
                            })
                        })
                    }else{
                        this.$ajax.get('insertkc?id=' + this.idname + '&kc=' + this.$route.query.id).then(res => {
                                this.$ajax.get('updateSearch1?id='+this.$route.query.id).then(res=>{
                                                this.$ajax.get('searchById?id='+this.$route.query.id).then(res=>{
                this.content=res.data[0]
           
                                  if (res.status == 200) this.$message.success('加入成功!');
                                  else this.$message.error('加入失败!');
                                })
                                 })
                            })
                    }
                })
            },
            gg(){
                if(this.identity==1||this.identity==2) this.$router.push('manager')
                else{}
            }


        },
        mounted:function () {
            this.$ajax.get('searchById?id='+this.$route.query.id).then(res=>{
                this.content=res.data[0]
            })
            this.$ajax.get('searchcontent?id='+this.$route.query.id).then(res=>{
                this.content1=res.data
            })
            this.$ajax.get('comment?articleid='+this.$route.query.id).then(res=>{
                for(var i=0;i<res.data.length;i++)
                    res.data[i].createtime=res.data[i].createtime.substring(0,10)
                this.comment=res.data

            })
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