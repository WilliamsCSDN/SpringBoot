<template>

<div>
        <div style="width: 100%;height: 500px;padding-top: 10px;">

            <div>
                <el-row>
                    <el-col  :xs="18" :sm="18" :md="18" :lg="24" :xl="24" style="background-color: #F3F5F6;padding-top: 20px">
                        <a style="font-size: 20px;margin-left: 15px;font-family: SimHei;text-decoration: none;color: red" href="#" >全部问答</a>
                        <div v-for="list1 in this.search2">
                            <el-col style="margin-top: 30px;margin-left: 15px">
                                <!--<a :href="'YWdetail?id='+list1.id" style="color:black;">-->
                                    <el-col :xs="19" :sm="19" :md="19" :lg="24" :xl="24" style="font-family:SimHei;margin-top: 50px ">
                                        <div style="margin-top: 10px;font-size: 20px"><b> {{list1.question}}</b><div style="float: right;margin-right: 400px"><el-button type="danger" @click="aaa(list1.id)">删除</el-button></div></div>

                                    </el-col>
                                <!--</a>-->
                                <hr style="width: 80%;box-shadow: 2px 2px 10px #000;background-color: #CCCCCC;margin-top: 100px;height: 0px"/>
                            </el-col>

                        </div>

                    </el-col>

                </el-row>

            </div>

        </div>
        <!--分页-->
        <el-col  :xs="18" :sm="18" :md="18" :lg="18" :xl="18" style="text-align: center;margin-top: 50px">
            <el-pagination
                    background
                    pageSize="5"
                    @current-change="currentchange"
                    layout="prev, pager, next"
                    :total="this.total">
            </el-pagination>
        </el-col>
        <!--底部-->

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
        created() {
            var lett = this;
            document.onkeydown = function(e) {
                var key = window.event.keyCode;
                if (key == 13) {
                    lett.search();
                }
            }
        },methods:{

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
            aaa(b){
                this.$ajax.get('deletewenda?id='+b).then(res=>{
                    if(res.status==200) this.$message.success('成功')
                    this.search1();
                })
            }



        }
        ,mounted:function () {

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
