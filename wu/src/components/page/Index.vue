<template  style="margin: 0;padding: 0;">
  <div>
    <!--导航栏-->
  <div class="new_header">
    <ul class="nav">
      <el-col :xs="2" :sm="2" :md="2" :lg="2" :xl="2" > <li><a href="/">首页 </a></li></el-col>
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a><router-link to='lesson?a='>免费课程</router-link></a></li></el-col>
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a><router-link to='LearnR'>学习路线</router-link></a></li></el-col>
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a><router-link to='YW'>社区</router-link></a></li></el-col>
      <el-col :xs="6" :sm="6"  :md="6" :lg="9" :xl="9"><li>
        <el-autocomplete  :fetch-suggestions="querySearchAsync" placeholder="请输入内容" v-model="input" style="width: 70%;margin-top: -30px">
        </el-autocomplete>
        <a href="#" @click="search1">搜索</a>
      </li></el-col>
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a @click="person" href="#">个人中心</a></li></el-col>
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="log" href="#"><router-link to="login">登陆</router-link></a></li></el-col>
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="reg" href="#"><router-link to="login">注册</router-link></a></li></el-col>
      <!--<el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><router-link to='dashboard'><a id="user" href="#"  style="display:none">{{user}}</a></router-link></li></el-col>-->
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="user" href="#"  style="display:none" @click="gg">{{user}}</a></li></el-col>
      <el-col :xs="2" :sm="2"  :md="2" :lg="2" :xl="2"> <li><a id="person" href="#"  style="display:none" @click="exit">退出</a></li></el-col>
    </ul>
  </div>

    <!--中间轮播+菜单-->
    <div style="background-image: linear-gradient(to top, white,#5F7DEB); height: 500px;padding-top: 80px;width: 100%;">
    <div class="header1">
      <div style="float:left;  height: 384px;width: 216px;background-color: #2B333B">
        <ul>
          <li @mouseenter="enter('1')" @mouseleave="leave('1')">前沿/区块链/人工智能</li>
          <li @mouseenter="enter('2')" @mouseleave="leave('2')">前端/小程序/JS</li>
          <li @mouseenter="enter('3')" @mouseleave="leave('3')">后端/JAVA/Python</li>
          <li @mouseenter="enter('4')" @mouseleave="leave('4')">移动/Android/IOS</li>
          <li @mouseenter="enter('5')" @mouseleave="leave('5')">云计算/大数据/容器</li>
          <li @mouseenter="enter('6')" @mouseleave="leave('6')">运维/测试/数据库</li>
          <li @mouseenter="enter('7')" @mouseleave="leave('7')">UI设计/3D动画/游戏</li>
        </ul>
      </div>
      <div id="content1" @mouseenter="enter('1')" @mouseleave="leave('1')" style="">
        <div style="height: 224px;margin-left: 0px">
          <div style="margin-top: 20px"><b><span>{{this.con[0].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in con[0].content">{{list.name}}</a>
          </div>
        </div>
        <div><img src="../../views/img/menu1.png"/></div>
      </div>
      <div id="content2" @mouseenter="enter('2')" @mouseleave="leave('2')"  style="float: left">
        <div style="height: 224px;margin-left: 0px">
          <div style="margin-top: 20px"><b><span>{{this.con[1].name}}</span></b></div>
          <div style="margin-top: 20px;">
            <a :href="lesson=list.href" v-for="list in con[1].content.slice(0,8)">{{list.name}}</a>
          </div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in con[1].content.slice(8,con[1].content.length)">{{list.name}}</a>
          </div>
        </div>
        <div><img src="../../views/img/menu2.png"/></div>
      </div>
      <div id="content3" @mouseenter="enter('3')" @mouseleave="leave('3')"  style="float: left">
        <div style="height: 224px;margin-left: 0px">


          <div style="margin-top: 20px"><b><span>{{this.con[2].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a href="#" v-for="list in con[2].content.slice(0,8)">{{list.name}}</a>
          </div>
          <div style="margin-top: 20px">
            <a href="#" v-for="list in con[2].content.slice(8,con[2].content.length)">{{list.name}}</a>
          </div>
        </div>
        <div><img src="../../views/img/menu3.png"/></div>
      </div>
      <div id="content4" @mouseenter="enter('4')" @mouseleave="leave('4')"  style="float: left">
        <div style="height: 224px;margin-left: 0px">
          <div style="margin-top: 20px"><b><span>{{this.con[3].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[3].content">{{list.name}}</a>
          </div>
        </div>
        <div><img src="../../views/img/menu4.png"/></div>
      </div>
      <div id="content5" @mouseenter="enter('5')" @mouseleave="leave('5')"  style="float: left">
        <div style="height: 224px;margin-left: 0px">
          <div style="margin-top: 20px"><b><span>{{this.con[4].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[4].content">{{list.name}}</a>
          </div>
          <div style="margin-top: 20px"><b><span>{{this.con[5].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[5].content">{{list.name}}</a>
          </div>
        </div>
        <div><img src="../../views/img/menu5.png"/></div>
      </div>
      <div id="content6" @mouseenter="enter('6')" @mouseleave="leave('6')"  style="float: left">
        <div style="height: 224px;margin-left: 0px">
          <div style="margin-top: 20px"><b><span>{{this.con[6].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[6].content.slice(0,8)">{{list.name}}</a>
          </div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[6].content.slice(8,this.con[6].content.length)">{{list.name}}</a>
          </div>
          <div style="margin-top: 20px"><b><span>{{this.con[7].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[7].content">{{list.name}}</a>
          </div>


        </div>
        <div><img src="../../views/img/menu6.png"/></div></div>
      <div id="content7" @mouseenter="enter('7')" @mouseleave="leave('7')"  style="float: left">
        <div style="height: 224px;margin-left: 0px">
          <div style="margin-top: 20px"><b><span>{{this.con[8].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[8].content">{{list.name}}</a>
          </div>
          <div style="margin-top: 20px"><b><span>{{this.con[9].name}}</span></b></div>
          <div style="margin-top: 20px">
            <a :href="lesson=list.href" v-for="list in this.con[9].content">{{list.name}}</a>
          </div>
        </div>
        <div><img src="../../views/img/menu7.png"/></div>
      </div>

      <div  style="float: left;margin-left: 216px;margin-top: -384px;"><img src="../../views/img/lunbo.png" style="height: 384px"></div>
    </div>
    </div>

<!--学习线路-->
    <div style="width: 100%">

      <b><div style="margin-left: 215px">学习线路</div></b>
      <el-tabs  class="learn" stretch=true v-model="activeName" @tab-click="handleClick" style="margin: 0 auto;width: 1100px">
        <el-tab-pane label="热门" name=1>
          <el-row style="margin-left: 45px">
            <el-col :xs="12" :sm="12" :md="12" :lg="8" :xl="8" style="margin-top: 30px"  v-for="list in this.hotlearn">
              <!--<a :href="'/lessondetail?title='+list.learnContent[0].title" style="color:black;">-->
              <a :href="'/learnrouter?id='+list.learnContent[0].id" style="color:black;">
                <img :src="'http://localhost:8082/3?a='+list.learnContent[0].src" style="width: 80%;height: 160px;" />

                <!--<img src="../../views/img/kc1.png" style="width: 80%" />-->

                  <div style="margin-top: 10px;font-size: 20px;width: 80%;height: 40px"><b> {{list.learnContent[0].title}}</b></div>
                  <p style="color: #545C63;font-size: 14px;margin-top: 15px;width: 80%;">{{list.learnContent[0].content}}</p>
                  <div style="font-size: 10px; color: #979FA6;margin-top: 15px"><span>{{list.learnContent[0].bz}}步骤 · {{list.learnContent[0].kc}}门课</span><span style="margin-left: 30px">★{{list.learnContent[0].sc}}人收藏</span></div>

              </a>
            </el-col>
          </el-row>
        </el-tab-pane>

        <el-tab-pane :label="list.name" :name="list.id" v-for="list in this.learn">
          <el-row style="margin-left: 45px">
            <el-col :xs="24" :sm="24" :md="12" :lg="8" :xl="8" style="margin-top: 30px" v-for="(list1,index) in list.learnContent">
              <a :href="'/learnrouter?id='+list1.id" style="color:black;">
                <img :src="'http://localhost:8082/3?a='+list1.src"  style="width:80%;height: 160px;"/>

                  <div style="margin-top: 10px;font-size: 20px;width: 80%;height: 40px"><b> {{list1.title}}</b></div>
                  <p style="color: #545C63;font-size: 14px;margin-top: 15px;width: 80%;">{{list1.content}}</p>
                  <div style="font-size: 10px; color: #979FA6;margin-top: 15px"><span>{{list1.bz}}步骤 · {{list1.kc}}门课</span><span style="margin-left: 30px">★{{list1.sc}}人收藏</span></div>

              </a>
            </el-col>
          </el-row>

        </el-tab-pane>
      </el-tabs>


    </div>

    <!--热门课程-->
    <div style="width: 100%;margin-top: 100px">

      <b><div style="margin-left: 215px">热门课程</div></b>
    <el-tabs  class="learn" stretch=true v-model="activeName1" @tab-click="handleClick" style="margin: 0 auto;width: 1100px">
      <el-tab-pane label="热门" name=1>
        <el-row>
        <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12" style="margin-top: 30px"  v-for="list in this.hotsearch">
          <!--<a :href="'/lessondetail?title='+list.learnContent[0].title" style="color:black;">-->
          <a :href="'/lessondetail?id='+list.id" style="color:black;">
            <el-col :xs="4" :sm="4" :md="4" :lg="7" :xl="7"> <img :src="'http://localhost:8082/3?a='+list.src" style="width: 140px;height: 150px" /></el-col>
            <!--<el-col :xs="4" :sm="4" :md="4" :lg="7" :xl="7"> <img src='../../views/img/learn1/learn1.png' style="width: 140px;height: 150px" /></el-col>-->
            <el-col :xs="20" :sm="20" :md="20" :lg="17" :xl="17" style="font-family:SimHei ">
            <div style="margin-top: 10px;font-size: 20px;height: 40px;"><b> {{list.title}}</b></div>
            <p style="color: #545C63;font-size: 14px;margin-top: 15px;height: 40px;">{{list.content}}</p>
            <div style="font-size: 10px; color: #979FA6;margin-top: 15px"><span>作者:{{list.author}} 难度:{{list.level}}</span><span style="margin-left: 30px">★{{list.sc}}人收藏</span></div>
          </el-col>
          </a>
        </el-col>
      </el-row>


      </el-tab-pane>



      <el-tab-pane label="推荐课程" name="2">
        <el-row>
          <el-col :xs="24" :sm="24" :md="24" :lg="12" :xl="12" style="margin-top: 30px" v-for="list in search" v-if="list.id<=6">
            <a :href="'/learnrouter?id='+list.id" style="color:black;">
            <el-col :xs="4" :sm="4" :md="4" :lg="7" :xl="7"> <img :src="'http://localhost:8082/3?a='+list.src"  style="height: 150px"/></el-col>
            <el-col :xs="20" :sm="20" :md="20" :lg="17" :xl="17" style="font-family:SimHei ">
              <div style="margin-top: 10px;font-size: 20px;height: 40px;"><b> {{list.title}}</b></div>
              <p style="color: #545C63;font-size: 14px;margin-top: 15px;height: 40px;">{{list.content}}</p>
              <div style="font-size: 10px; color: #979FA6;margin-top: 15px"><span>作者:{{list.author}} 难度:{{list.level}}</span><span style="margin-left: 30px">★{{list.sc}}人收藏</span></div>
            </el-col>
            </a>
          </el-col>
        </el-row>

      </el-tab-pane>

    </el-tabs>
    </div>



    <hr style="width: 99.9%;box-shadow: 2px 2px 10px #000;margin-top: 50px;height: 0px"/>
    <!--底部-->
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
  import ElContainer from '../../../node_modules/element-ui/packages/container/src/main'
  import ElCol from 'element-ui/packages/col/src/col'
  import ElTabs from '../../../node_modules/element-ui/packages/tabs/src/tabs'
  import ElTabPane from '../../../node_modules/element-ui/packages/tabs/src/tab-pane'
  import ElForm from '../../../node_modules/element-ui/packages/form/src/form'
  import ElFormItem from '../../../node_modules/element-ui/packages/form/src/form-item'
  import ElInput from '../../../node_modules/element-ui/packages/input/src/input'
  import ElButton from '../../../node_modules/element-ui/packages/button/src/button'
  import md5 from 'js-md5';

  export default {
    components: {ElButton, ElInput, ElFormItem, ElForm, ElTabPane, ElTabs, ElCol, ElContainer, ElRow}, data () {
      return {
          user:'',
        dialogTableVisible:false,
        activeName:'1',
        activeName1:'1',
        con:'',
        learn:'',
        search:'',
        hotlearn:'',
        hotsearch:'',
        identity:'',
        input:'',
        form:{
          username:'',
          password:''
        },
        form1:{
          username:'',
          password:''
        },
        suggestion:[{ "value": "Vue" },
          { "value": "Java"},
          { "value": "Python" }]
      }
    },
    created() {
      var lett = this;
      document.onkeydown = function(e) {
        var key = window.event.keyCode;
        if (key == 13) {
          lett.search1();
        }
      }

    }
    ,methods: {
      enter(a){
        var content = document.getElementById("content" + a);
        content.style.display = 'block';
      },
      leave(a){
        var content = document.getElementById("content" + a);
        content.style.display = 'none';
      },
      enter1(){
        var content = document.getElementById("low");
        content.style.display = 'block';
      },
      leave1(){
        var content = document.getElementById("low");
        content.style.display = 'none';
      },
      get1(){
        this.$ajax
          .get('getheader1')
          .then(res => {
            this.con = res.data
              this.get2();
          })
      },
      get2(){
        this.$ajax
          .get('getlearncontent')
          .then(res => {
            this.learn = res.data
              this.get3();
          })
      },
      get3(){
        this.$ajax
          .get('gethot')
          .then(res => {
            this.hotlearn = res.data
              this.xxx();
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
      search1(){
        this.$router.push({path:'lesson',query:{a:this.input}})
      },
       xxx(){
          this.$ajax.get('getHotsearch').then(res=>{
              this.hotsearch=res.data;
              this.$ajax.get('search').then(res=>{
                  this.search=res.data;
              })
          })

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
          person(){
            if(this.user!=null) this.$router.push({path: '/Person1'});
          }

    },
    mounted:function () {
        this.get1();
    }
  }
</script>
<style>

  .new_header{
    width: 100%;
    height: 60px;
    /*box-shadow: 0 2px 30px rgba(51, 51, 51, .25);*/
    /*margin-left: -5px;*/
    position: fixed;
    background-color: white;
    z-index: 999;
    text-align: center;

  }
  .nav{
    list-style: none;
    height: 70px;
    margin-top: 20px;
  }
  .nav li{

    font-size: 16px;
    font-family: SimHei;
  }
  .nav li a{text-decoration: none;color: black;height: 40px;display: inline-block}

.header1 {
  width: 1154px;
  height: 384px;
  margin: 0 auto;
  font-family: SimHei;
}
  .header1 div ul {
    list-style: none;
    color: #A8ACAF;
  }
 .header1 div ul li{
   width: 200px;
   height: 42px;
   padding-left: 20px;
   padding-top: 10px;
 }
  .header1 div ul li:hover{
    background-color: #6B6F78;
  }
  #content1,#content2,#content3,#content4,#content5,#content6,#content7 {
    display: none;
    font-family: SimHei;
    background-color: white;
    height: 384px;
    width: 769px;
    float: left;
    position: relative;
    z-index: 998;


  }

  #content1 div,#content2 div,#content3 div,#content4 div,#content5 div,#content6 div,#content7 div{
    margin-left: 37px;
  }
  #content1 a,#content2 a,#content3 a,#content4 a,#content5 a,#content6 a,#content7 a{
    text-decoration: none;
    color: black;
    margin-left: 10px;
  }
  .learn img:hover{
    transform:translateY(-2px)
  }
  .footer{ width: 100%;height: 100px;color: #99A1A6;}
  .footer a{
    text-decoration: none;
    color: #99A1A6;
    padding-left: 50px;
  }
  .footer1{margin: 0 auto;width: 1000px;margin-top: 50px;text-align: center;}
  .footer2{margin: 0 auto;width: 1000px;margin-top: 30px;text-align: center}

</style>
