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
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="user" href="#"  style="display:none" @click="gg">{{user}}</a></li></el-col>
                <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="person" href="#"  style="display:none" @click="exit">退出</a></li></el-col>
            </ul>
            <div class="content1">
                <div>
                <div style="font-size: 30px"> {{content.learnContent[0].title}}</div>
                <span><img src="../../../assets/img/img.jpg" style=" width: 40px; height: 40px;border-radius: 50%;"/>{{content.learnContent[0].author}}</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <span><span style="font-size: 25px"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{content.learnContent[0].bz}}步骤</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <span><span style="font-size: 25px"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{content.learnContent[0].kc}}门课</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                <span><span style="font-size: 25px"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{{content.learnContent[0].sc}}收藏</span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                </div>
                <div style="float: right;margin-right: 200px;margin-top: -80px"><el-button type="danger" style="height: 50px;width: 200px" @click="jr">加入学习</el-button></div>
            </div>

        </div>

        <el-tabs stretch="true" style="padding-top: 200px" v-model="activeName">
            <el-tab-pane label="课程安排" class="content2" name=1 style="background-color: #E5EAF0">
                <p style="margin-top: 50px">&nbsp</p>
                <div style="width: 50%; margin: 0 auto; border-radius: 5px;background-color: white; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;">简介:{{content.learnContent[0].content}}</div>
                <div v-for="list in this.content1" style="width: 51%;margin: 0 auto; border-radius: 5px; background-color: white; text-align: left; padding: 20px 20px 20px 20px; margin-top: 20px;">
                    <span style="font-size: 22px"><b>Step{{list.bz}}&nbsp&nbsp&nbsp{{list.name}}</b></span>
                    <p>{{list.title}}</p>
                    <!--<div v-for="list1 in list.searchContent1" style="width: 100%;margin-top: 20px;">-->
                        <!--<a :href="list1.url"><div style="text-align: left;margin-left: 0px;width: 750px;height: 50px;padding-left: 20px;padding-top: 10px  ">-->
                            <!--<span><i class="el-icon-lx-crown"></i> {{list1.zjj}}&nbsp&nbsp&nbsp{{list1.title}} </span>-->
                            <!--<el-button style="float: right">开始学习</el-button>-->
                        <!--</div></a>-->
                    <!--</div>-->

                    <a :href="'lessondetail?id='+content3[list.searchid-1].id" style="color:black;height: 150px;width: 100%;display: inline-block">
                        <el-col :xs="19" :sm="19" :md="19" :lg="19" :xl="12" style="font-family:SimHei;margin-top: 10px ">
                            <div style="margin-top: 40px;">{{content3[list.searchid-1].title}}</div>
                            <p style="color: #545C63;font-size: 14px;margin-top: 20px;">{{content3[list.searchid-1].content}}</p>
                            <div style="font-size: 10px; color: #979FA6;margin-top: 20px"><span>讲师： {{content3[list.searchid-1].author}} {{content3[list.searchid-1].level}}  {{content3[list.searchid-1].sc}}  试看</span><span style="margin-left: 30px">★人收藏</span></div>
                        </el-col>
                        <el-col :xs="19" :sm="19" :md="5" :lg="5" :xl="12" style="margin-top: 10px"> <img :src="'http://localhost:8082/3?a='+content3[list.searchid-1].src"/></el-col>
                    </a>
                </div>
                <p style="text-align: center;padding-top: 25px;padding-bottom: 25px">*说明：路线内每门课程都具有完整独立的学习价值，因此一部分知识点可能重合，选择前请知晓！</p>

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
                aaa:'',
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
            gg(){
                if(this.identity==1||this.identity==2) this.$router.push('manager')
                else{}
            },
            xxx(){
                var i=localStorage.getItem('token')
//        alert(i)
                if(i!=null){
                    this.$ajax.get('getUser?token='+i).then(res=>{
                        this.idname=res.data[0].id;
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
            jr(){
                this.$ajax.get('getuserr?id='+this.idname).then(res=>{
                    if(res.data[0]!=null) {
                        for (var i = 0; i < res.data[0].learnContent.length; i++) {
                            if (res.data[0].learnContent[i].id == this.$route.query.id) {
                                this.$message.error('你已经加入了!');
                                return false;
                            }
                        }
                        this.$ajax.get('insertrouter?id=' + this.idname + '&learnrouter=' + this.$route.query.id).then(res => {
                            this.$ajax.get('updateLearnContent1?id='+this.$route.query.id).then(res=>{
                                 this.$ajax.get('getlearncontent?id='+this.$route.query.id).then(res=>{
                                    this.content=res.data[0];
                                  if (res.status == 200) this.$message.success('加入成功!');
                                  else this.$message.error('加入失败!');
                            })
})
                        })
                    }else{
                        this.$ajax.get('insertrouter?id=' + this.idname + '&learnrouter=' + this.$route.query.id).then(res => {
                            this.$ajax.get('updateLearnContent1?id='+this.$route.query.id).then(res=>{
                                                                 this.$ajax.get('getlearncontent?id='+this.$route.query.id).then(res=>{
                                    this.content=res.data[0];
                                if (res.status == 200) this.$message.success('加入成功!');
                                else this.$message.error('加入失败!');
                            })
                            })
                        })
                    }
                })
            }

        },
        mounted:function () {
            this.$ajax.get('getlearncontent?id='+this.$route.query.id).then(res=>{
                this.xxx();
                this.content=res.data[0];
                this.$ajax.get('getrouterbyid?id='+this.$route.query.id).then(res=>{
                    this.content1=res.data;
                    this.$ajax.get('search').then(res=>{
                        this.content3=res.data;
                    })
                })
            })
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