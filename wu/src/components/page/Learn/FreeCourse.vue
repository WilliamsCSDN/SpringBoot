<template>
  <div>
    <!--导航-->
    <div style="width: 100%;height: 70px;font-size: 30px;padding-top: 10px">
      <div class="el-icon-lx-back" style="float: left; padding: 0 10px;cursor: pointer;line-height: 70px;color: black" @click="aaa"></div>
      <span style="float: left; padding: 0 10px;cursor: pointer;line-height: 70px;color: black"><b>{{title}}</b></span>
      <div style="float: right;padding: 0 10px;cursor: pointer;line-height: 70px;color: black"><a href="#" @click="gg" style="color: black;">欢迎你!{{user}}</a></div>
   </div>
    <!--视频显示-->
  <div style="text-align:center;background-color: black;">
<video controls="controls" id="videoPlayer" style="height: 500px;margin-top: 20px;margin-bottom: 50px" autoplay>
  <source :src="'http://localhost:8082/1?id='+this.$route.query.id+'&zj='+this.$route.query.zj" type="video/mp4" >
  <!--<source src="../../views/1.mp4" type="video/mp4">-->.
</video>
  </div>
    <!--用户评论-->
<el-tabs :stretch="true" style="padding-top:10px">
    <el-tab-pane label="用户评论" class="content3">
      <div v-for="(list,index) in this.comment" :key="index" style="width: 50%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;font-size: 20px">
        <div style="font-size: 25px"><img src="../../../assets/img/img.jpg" style=" width: 40px; height: 40px;border-radius: 50%;"/>{{list.name}}</div>
        <a href="javascript:void(0);" @click="a(list.comment_id)" :id="'a'+list.comment_id"><i class="el-icon-lx-like" style="float: right"></i></a>
        <a href="javascript:void(0);" @click="b(list.comment_id)" :id="'a'+list.comment_id+list.comment_id" style="display: none;"><i class="el-icon-lx-likefill" style="float: right"></i></a>
        <div style="margin-left: 40px;margin-top: 10px">{{list.content}}</div>
        <div style="margin-top: 10px;margin-left: 100px;" v-for="(list1,index) in list.commentReplyList" :key="index">
          <span v-if="list.name==list1.replyname"><a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.comment_id)"> {{list1.replyname}}回复{{list1.name}}:{{list1.content}}</a></span>
          <span v-else=""> <a href="javascript:void(0);" style="color: black;" @click="reply(list1.replyname,list.comment_id)"> {{list1.replyname}}:{{list1.content}}</a></span>
        </div>
        <a href="javascript:void(0);" @click="c(list.comment_id)" :id="'b'+list.comment_id"><i class="el-icon-lx-comment" style="float: right"></i></a>


        <div style="display: none;" :id="'ac'+list.comment_id">

          <el-input type="textarea" style="margin-top: 10px" v-model="content3" :placeholder=placeholer1></el-input>
          <el-button class="editor-btn" type="primary" @click="submit1(list.comment_id,list.name)" style="margin-top: 10px">提交</el-button>

        </div>

      </div>
      <div style="width: 55% ;margin: 0 auto;margin-top: 50px;padding-top: 10px">
        <span style="font-size: 25px;background-color: yellowgreen">评论区&nbsp;&nbsp;&nbsp;(目前仅支持文字)</span>
        <quill-editor ref="myTextEditor" v-model="content2"  style="margin-top: 25px"></quill-editor>
        <el-button class="editor-btn" type="primary" @click="submit" style="margin-top: 25px">提交</el-button>
      </div>


    </el-tab-pane>
</el-tabs>

<!--footer-->
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
    import Video from 'video.js'
    import 'video.js/dist/video-js.css'
    import ElTabs from "../../../../node_modules/element-ui/packages/tabs/src/tabs";
    import 'quill/dist/quill.core.css';
    import 'quill/dist/quill.snow.css';
    import 'quill/dist/quill.bubble.css';
    import { quillEditor } from 'vue-quill-editor';
  export default {
      components: {ElTabs, Video,quillEditor}, data() {
      return {
          placeholer1:'请输入内容',
          user:'',
        restaurants: [],
        state: '',
        timeout:  null,
          title:'',
          comment:'',
          content2:'',
          content3:'',
          identity:''



      };
    },
    methods: {
          aaa(){
              this.$router.go(-1)
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
            var d=document.getElementById('ac'+cc);
            if(d.style.display=="inline") {
                var f=document.getElementById('ac'+cc);
                f.style.setProperty("display","none")
                return;
            }
            for(var i=1;i<=100;i++){
                var e=document.getElementById('ac'+i);
                e.style.setProperty("display","none");
                if(i==cc){
                    d.style.setProperty("display","inline");
                }
            }


        },
        submit(){
            if(this.user!=""){
                var a=this.content2.replace("<p>", "").replace("</p>","").replace("<br>","").replace("<p>", "").replace("</p>","");
                var url="insertcomment?articleid="+this.$route.query.id+"&name="+this.user+"&content="+a+"&state=0";
                this.$ajax.get(url).then(res=>{
                    if(res.status===200) alert("添加成功");
                    else alert("添加失败");
                })
                location.reload();
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
                    var url = "insertcomment1?comment_id=" + a + "&name=" + this.user + "&replyname=" + this.placeholer1.substring(2) + "&content=" + this.content3 + "&prase_count=10";
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
                e.style.setProperty("display","none");
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
    mounted() {
//        alert('id:'+this.$route.query.id+'zj:'+this.$route.query.zj)

//        setTimeout(()=>{
//            alert(document.getElementById('videoPlayer').duration);
//        },800)
        this.$ajax.get('comment?articleid='+this.$route.query.id).then(res=>{
            this.comment=res.data
        })
        this.title=this.$route.query.title;
        this.$ajax.get('getUser?token='+localStorage.getItem('token')).then(res=>{
            this.identity=res.data[0].identity
            if(res.data[0].name==null)this.user=res.data[0].username;
            else this.user=res.data[0].name;
        })




    }
  };
</script>
<style>
  .footer{ width: 100%;height: 100px;color: #99A1A6;}
  .footer a{
    text-decoration: none;
    color: #99A1A6;
    padding-left: 50px;
  }
  .footer1{margin: 0 auto;width: 1000px;margin-top: 50px;text-align: center;padding-top: 20px}
  .footer2{margin: 0 auto;width: 1000px;margin-top: 30px;text-align: center}
</style>