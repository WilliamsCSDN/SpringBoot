<template>
    <div>

        <div style="width: 100%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;">
            <el-select placeholder="请选择" style="width: 60%" v-model="title">
                <el-option  v-for="(list,i) in this.content2" :key="(i+1)" :label="list.title" :value="list.id"></el-option>
            </el-select>
            <el-button type="primary" style="margin-left: 20px" @click="aaa">搜索</el-button>
        </div>
        <el-button type="primary" style="width: 20%;margin-top: 10px" @click="bbb">添加步骤</el-button>
        <div v-for="(list,index) in this.content1" :key="index" style="width: 100%; border-radius: 5px; background-color: white; text-align: left; padding: 20px 20px 20px 20px; margin-top: 40px;">
            <span style="font-size: 22px"><b>Step{{list.bz}}&nbsp;&nbsp;&nbsp;{{list.name}}</b></span>
            <p>{{list.title}}</p>
            <div style="float: right;margin-right: 250px;margin-top: -20px">
                <el-button style="float: right" type="danger" @click="remove(list.id)">删除</el-button>
                <el-button style="float: right;" type="primary" @click="handleEdit(list.bz)">编辑</el-button>
            </div>
            <a :href="'lessondetail?id='+content3[list.searchid-1].id" style="color:black;height: 150px;width: 100%;display: inline-block">
                <el-col :xs="19" :sm="19" :md="19" :lg="19" :xl="12" style="font-family:SimHei;margin-top: 10px ">
                    <div style="margin-top: 40px;">{{content3[list.searchid-1].title}}</div>
                    <p style="color: #545C63;font-size: 14px;margin-top: 20px;">{{content3[list.searchid-1].content}}</p>
                    <div style="font-size: 10px; color: #979FA6;margin-top: 20px"><span>讲师： {{content3[list.searchid-1].author}} {{content3[list.searchid-1].level}}  {{content3[list.searchid-1].sc}}  试看</span><span style="margin-left: 30px">★人收藏</span></div>
                </el-col>
                <el-col :xs="19" :sm="19" :md="5" :lg="5" :xl="12" style="margin-top: 10px;margin-left: -100px"> <img :src="content3[list.searchid-1].src"/></el-col>
            </a>
        </div>


        <el-dialog title="添加步骤" :visible.sync="editVisible" width="35%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="Step:">
                    <el-input :disabled="true" v-model="form.bz"></el-input>
                </el-form-item>
                <el-form-item label="步骤名:">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="内容:">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="课程:">
                    <el-select placeholder="请选择" style="width: 100%;height: 100px" v-model="form.kc">
                        <el-option  v-for="(list,i) in this.content4" :key="(i+1)" :label="list.title" :value="list.id"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>

            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="addZ">确 定</el-button>
            </span>
        </el-dialog>
        <el-dialog title="编辑节" :visible.sync="editVisible2" width="35%">
            <el-form ref="form2" :model="form2" label-width="70px">
                <el-form-item label="Step:">
                    <el-input v-model="form2.bz" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="步骤名:">
                    <el-input v-model="form2.name"></el-input>
                </el-form-item>
                <el-form-item label="内容:">
                    <el-input v-model="form2.title"></el-input>
                </el-form-item>
                <el-form-item label="课程:">
                    <el-select placeholder="请选择" style="width: 100%;height: 100px" v-model="form2.searchid">
                        <el-option  v-for="(list,i) in this.content4" :key="(i+1)" :label="list.title" :value="i+1"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>

            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible2 = false">取 消</el-button>
                <el-button type="primary" @click="editJ">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import { fetchData } from '../../../api/index';
    import md5 from 'js-md5';
    import ElButton from "../../../../node_modules/element-ui/packages/button/src/button";
    import ElDialog from "../../../../node_modules/element-ui/packages/dialog/src/component";
    import ElCol from "element-ui/packages/col/src/col";
    import ElFormItem from "../../../../node_modules/element-ui/packages/form/src/form-item";
    import ElInput from "../../../../node_modules/element-ui/packages/input/src/input";

    var formData = new FormData() // 声明一个FormData对象
    var formData = new window.FormData() // vue 中使用 window.FormData(),否则会报 'FormData isn't definded'

    export default {
        components: {ElInput, ElFormItem, ElCol, ElDialog, ElButton}, name: 'basetable',
        data() {
            return {
                editVisible:false,
                editVisible1:false,
                editVisible2:false,
                content1:'',
                content3:'',
                content4:'',
                radio:'',
                tableData: [],
                multipleSelection: [],
                delList: [],
                pageTotal: 0,
                form: {
                    bz:'',
                    name:'',
                    title:'',
                    kc:''
                },
                form1:{
                    zj:'',
                    title:'',
                },
                form2:{
                },
                title:'',
                content2:'',
                zj:'',
                zj1:''

            };
        },
        methods: {
            // 编辑操作
            handleEdit(a) {

                this.$ajax.get('search').then(res=>{
                    this.content4=res.data
                })
                this.form2=this.content1[a-1];
                this.editVisible2 = true;
            },
            // 保存编辑
            saveEdit() {
                this.$ajax.get('updateimg?id='+this.form.id+'&src=/learn1/learn'+this.radio+'.png'+'&title='+this.form.title+' &content='+this.form.content+' &author='+this.form.author+' &level= '+this.form.level+'&sc='+this.form.sc).then(res=>{
                    if(res.status==200) {
                        this.$message.success(`修改成功`);
                        this.$ajax.get('search').then(res=>{
                            this.tableData=res.data;
                        })
                    }
                    else this.$message.error(`修改失败`);
                })
                this.editVisible = false;
            },
            imgchange(){
                if(this.editVisible1)  this.form1.src='/learn1/learn'+this.radio+'.png';
                else if(this.editVisible)this.form.src='/learn1/learn'+this.radio+'.png';
                this.editVisible2=false

            },
            append(data) {
                const newChild = { id: 9, label: 'testtest', children: [] };
                if (!data.children) {
                    this.$set(data, 'children', []);
                }
                data.children.push(newChild);
            },

            remove(a) {

                this.$ajax.get('deletelearnrouter?id='+a).then(res=> {
                    if (res.status == 200) {
                        this.$message.success("删除成功!");
                        this.$ajax.get('getrouterbyid?id='+this.title).then(res=> {
                            this.content1 = res.data;
                            for (var i = 0; i < this.content1.length; i++) {
                                this.$ajax.get('updatelearnrouter1?id=' + this.content1[i].id + '&bz=' + (i+1)).then(res => {
                                    this.$ajax.get('getrouterbyid?id='+this.title).then(res=> {
                                        this.content1 = res.data;
                                    })
                                })
                            }
                        })
                    }
                    else this.$message.error("删除错误!");
                })
            },

            aaa(){
                this.$ajax.get('getrouterbyid?id='+this.title).then(res=>{
                    this.content1=res.data;
                    this.form.bz='Step'+(res.data.length+1)
                    this.$ajax.get('search').then(res=>{
                        this.content3=res.data;
                    })
                })
            },
            bbb(){
                if(this.title==0) this.$message.error('请先选择课程或者添加课程');
                else this.editVisible=true;
                this.$ajax.get('search').then(res=>{
                    this.content4=res.data
                })
            },
            ccc(zj){
                this.$ajax.get('searchcontent?id='+this.title).then(res=>{
                    this.form1.zj = zj + "-" + (res.data[zj - 1].searchContent1.length + 1);
                    this.zj1 = zj;


                })
                this.editVisible1=true
            },
            addZ(){
                if(this.form.kc==''||this.form.title==''||this.form.bz==''||this.form.name=='') this.$message.error("请输入全部信息")
                else{
                    this.$ajax.get('insertlearnrouter?iid='+this.title+'&searchid='+this.form.kc+'&title='
                        +this.form.title+'&bz='+this.form.bz.substring(4)+'&name='+this.form.name).then(res=>{
                        if(res.status==200) {
                            this.$message.success('添加成功!');
                            this.editVisible=false;
                            this.aaa();

                        }
                        else this.$message.error('添加章失败!');
                    })

                }

            },
            editJ(){


                var url = "updatelearnrouter?id=" + this.form2.id+ "&name=" + this.form2.name+ "&searchid=" + this.form2.searchid + "&title=" + this.form2.title+ "&iid=" + this.form2.iid+ "&bz=" + this.form2.bz;
                this.$ajax.get(url).then(res => {
                        if (res.status == 200) {
                            this.$message.success("修改成功!");
                            this.aaa();

                        } else this.$message.error("修改错误!");

                })
                this.editVisible2 = false;


            },




        },mounted:function () {
            var i=localStorage.getItem('token')
            this.$ajax.get('getUser?token='+i).then(res=>{
                if(res.data[0].name==null)this.form1.author=res.data[0].username;
                else this.form1.author=res.data[0].name;
                if(res.data[0].identity==1){
                    this.$ajax.get('getlearncontent1').then(res=>{
                        this.content2=res.data;
                    })
                }
                else {
                    this.$ajax.get('getlearncontent1?author=' + res.data[0].name).then(res => {
                        this.content2 = res.data;

                    })
                }
            })


        }
    };
</script>

<style scoped>
    .handle-box {
        margin-bottom: 20px;
    }

    .handle-select {
        width: 120px;
    }

    .handle-input {
        width: 300px;
        display: inline-block;
    }
    .table {
        width: 100%;
        font-size: 14px;
    }
    .red {
        color: #ff0000;
    }
    .mr10 {
        margin-right: 10px;
    }
    .table-td-thumb {
        display: block;
        margin: auto;
        width: 40px;
        height: 40px;
    }
</style>
