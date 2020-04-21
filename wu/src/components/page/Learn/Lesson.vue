<template>
  <div>
    <!--<div style="background-color: gold;height: 10px"></div>-->
    <!--<div style="background-color: pink;height: 10px;"></div>-->

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
      <div style="height: 59px;padding-top: 20px;width: 100%;background-color: white">
        <el-autocomplete  :fetch-suggestions="querySearchAsync"  placeholder="请输入内容" v-model="input" style="width: 50%">
        </el-autocomplete>
        <el-button @click="search">搜索</el-button>
      </div>
    </div>

      <div id="nav2">
        <div>
           <ul style="list-style:none">
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(0)">全部</a></el-tag></li></el-col>
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(1)">前沿/区块链/人工智能</a></el-tag></li></el-col>
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(2)">前端/小程序/JS</a></el-tag></li></el-col>
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(3)">后端/JAVA/Python</a></el-tag></li></el-col>
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(4)">移动/Android/IOS</a></el-tag></li></el-col>
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(5)">云计算/大数据/容器</a></el-tag></li></el-col>
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(6)">运维/测试/数据库</a></el-tag></li></el-col>
           <el-col :xs="3" :sm="3"  :md="3" :lg="3" :xl="3"><li><el-tag><a href="#" @click="dd(7)">UI设计/3D动画/游戏</a></el-tag></li></el-col>
            </ul>
        </div>
       </div>


    <div style="width: 100%;height: 500px;padding-top: 150px">
  <div style="width: 1100px;margin: 0 auto">
  <el-row>
    <el-col  :xs="18" :sm="18" :md="18" :lg="18" :xl="18" style="background-color: #F3F5F6;padding-top: 20px">
      <a style="font-size: 20px;margin-left: 15px;font-family: SimHei;text-decoration: none;color: red" href="#">全部结果</a>

      <el-col style="margin-top: 30px;margin-left: 15px" v-for="list in this.search2">
        <a :href="'lessondetail?id='+list.id" style="color:black;">
          <el-col :xs="5" :sm="5" :md="5" :lg="5" :xl="5"> <img :src="'http://localhost:8082/3?a='+list.src"/></el-col>
          <el-col :xs="19" :sm="19" :md="19" :lg="19" :xl="19" style="font-family:SimHei;margin-top: 10px ">
            <div style="margin-top: 10px;font-size: 20px"><b> {{list.title}}</b></div>
            <p style="color: #545C63;font-size: 14px;margin-top: 20px;width: 90%">{{list.content}}</p>
            <div style="font-size: 10px; color: #979FA6;margin-top: 20px"><span>讲师： {{list.author}} {{list.level}}  {{list.sc}}  试看</span><span style="margin-left: 30px">★人收藏</span></div>
          </el-col>
        </a>
      </el-col>

    </el-col>
    <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6" style="padding-top: 15px;">
      <el-col style="font-size: 20px;margin-left: 25px;font-family: SimHei;text-decoration: none;">热搜关键词</el-col>
      <el-col style="margin-top: 20px;margin-left: 25px;">
        <a style="text-decoration: none;color:black;background-color: #F3F5F6;margin-left: 5px" href="lesson?a=Vue">Vue</a>
       <a style="text-decoration: none;color:black;background-color: #F3F5F6;margin-left: 5px" href="lesson?a=Python">Python</a>
        <a style="text-decoration: none;color:black;background-color: #F3F5F6;margin-left: 5px" href="lesson?a=Java">Java</a>
        <a style="text-decoration: none;color:black;background-color: #F3F5F6;margin-left: 5px" href="lesson?a=flutter"> flutter</a>
        <a style="text-decoration: none;color:black;background-color: #F3F5F6;margin-left: 5px" href="lesson?a=springboot"> springboot</a>
      </el-col>
      <!--<img src="../../views/img/learn1/search.png" style="margin-left: 15px;margin-top: 50px">-->
      <div style="margin-left:15px;height: 682px;width: 344px;background-color:#F3F5F6;margin-top: 80px;padding-left: 20px">
        <a href="learnrouter?id=1"><img src="../../../views/img/learn1/search1.png"></a>
        <div style="margin-top: 20px;margin-left: 10px"><b>快速就业</b></div>
        <!--1-->
        <a href="learnrouter?id=2" style="color:black"><div style="height: 70px;width: 301px;background-color: white;margin-top: 20px;padding-top: 15px;padding-left: 20px">
          <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6"><img src="../../../views/img/learn1/search2.png"></el-col>
          <el-col :xs="6" :sm="6" :md="6" :lg="18" :xl="18">
            <b><p>Web前端工城狮</p></b>
            <p style="font-size: 10px;margin-top: 5px">踏入IT行业从此开始</p>
          </el-col>

        </div></a>
        <!--2-->
        <a href="learnrouter?id=3" style="color:black"><div style="height: 70px;width: 301px;background-color: white;margin-top: 20px;padding-top: 15px;padding-left: 20px">
          <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6"><img src="../../../views/img/learn1/search3.png"></el-col>
          <el-col :xs="6" :sm="6" :md="6" :lg="18" :xl="18">
            <b><p>Java攻城狮</p></b>
            <p style="font-size: 10px;margin-top: 5px">全球3大编程语言之一</p>
          </el-col>

        </div></a>
        <!--3-->
        <a href="learnrouter?id=4" style="color:black"><div style="height: 70px;width: 301px;background-color: white;margin-top: 20px;padding-top: 15px;padding-left: 20px">
          <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6"><img src="../../../views/img/learn1/search4.png"></el-col>
          <el-col :xs="6" :sm="6" :md="6" :lg="18" :xl="18">
            <b><p>Android攻城狮</p></b>
            <p style="font-size: 10px;margin-top: 5px">5G物联网通万物</p>
          </el-col>

        </div></a>
        <!--4-->
        <a href="learnrouter?id=5" style="color:black"><div style="height: 70px;width: 301px;background-color: white;margin-top: 20px;padding-top: 15px;padding-left: 20px">
          <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6"><img src="../../../views/img/learn1/search5.png"></el-col>
          <el-col :xs="6" :sm="6" :md="6" :lg="18" :xl="18">
            <b><p>PHP攻城狮</p></b>
            <p style="font-size: 10px;margin-top: 5px">打通前后端一步到位</p>
          </el-col>

        </div></a>
        <!--5-->
        <a href="learnrouter?id=6" style="color:black"><div style="height: 70px;width: 301px;background-color: white;margin-top: 20px;padding-top: 15px;padding-left: 20px">
          <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6"><img src="../../../views/img/learn1/search6.png"></el-col>
          <el-col :xs="6" :sm="6" :md="6" :lg="18" :xl="18">
            <b><p>Python攻城狮</p></b>
            <p style="font-size: 10px;margin-top: 5px">爬虫大数据抢占先机</p>
          </el-col>

        </div></a>
      </div>
    </el-col>
  </el-row>

  </div>

</div>
<!--分页-->
    <el-col  :xs="18" :sm="18" :md="18" :lg="20" :xl="20" style="text-align: center;margin-top: 50px">
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
        hotselect:'',
        suggestion:[{ "value": "Vue" },
          { "value": "Java"},
          { "value": "Python" }],
        input:'',
        search2:'',
        total:'',
        form:{
          username:'',
          password:''
        },
        form1:{
          username:'',
          password:''
        },
          identity:'',
        dialogTableVisible:false,
        activeName1:'1'
      }
    },
    methods:{
      enter(a){
        var content = document.getElementById("content" + a);
        content.style.display = 'block';
      },
      leave(a){
        var content = document.getElementById("content" + a);
        content.style.display = 'none';
      },
      get1(){
        this.$ajax
          .get('getheader1')
          .then(res => {
            this.con = res.data
          })
      },
      get2(){
        this.$ajax
          .get('getlearncontent')
          .then(res => {
            this.learn = res.data
          })
      },
      get3(){
        this.$ajax
          .get('gethot')
          .then(res => {
            this.hotlearn = res.data

          })
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
        window.location.reload()
      },
      search1(a){
//        alert(a);
        this.$ajax.get("/search?a="+a).then(res => {
          this.total=res.data.length;
        })
          this.$ajax.get("/search?a=" + a+"&start=0&num=5").then(res => {
            console.log(res.data)
            this.search2 = res.data;
          })
      },
      currentchange(cpage){
        var url="/search?a=" +this.input+"&start="+(cpage-1)*5+"&num=5";
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
          dd(a){
            if(a==0){
                    this.search1('');
            }else{
               this.$ajax.get('search2?url='+a).then(res=>{
              this.search2=res.data
              this.total=res.data.length
              this.input=''
            })
            }

          }

    }
    ,mounted:function () {
//      document.body.innerHTML = document.body.innerHTML.replace(/Python/ig,"<span style='color: red;'>$&</span>");
      this.xxx();



        if(this.$route.query.b!=null) this.dd(this.$route.query.b)
        else{
        this.input=this.$route.query.a
        this.search1(this.$route.query.a);
        }






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
  #nav2{width: 100%;height: 50px;padding-top: 150px;margin:0 auto;margin-bottom:-120px}
  #nav2 li{height:50px;color:black;text-align:center;margin-left:10px}
  
  
</style>
