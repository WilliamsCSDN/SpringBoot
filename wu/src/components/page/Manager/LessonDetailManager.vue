<template>
    <div>

        <div style="width: 100%; margin: 0 auto; border-radius: 5px;background-color: #E5EAF0; text-align: left; padding: 30px 30px 30px 30px; margin-top: 20px;">
            <el-select placeholder="请选择" style="width: 60%" v-model="title">
                <el-option  v-for="(list,i) in this.content2" :key="(i+1)" :label="list.title" :value="list.id"></el-option>
            </el-select>
            <el-button type="primary" style="margin-left: 20px" @click="aaa">搜索</el-button>
        </div>
        <el-button type="primary" style="width: 20%;margin-top: 10px" @click="bbb">添加章节</el-button>
        <div v-for="(list,index) in this.content1" :key="index" style="width: 100%;margin: 0 auto; border-radius: 5px; background-color: #E5EAF0; text-align: left; padding: 20px 20px 20px 20px; margin-top: 20px;">
            <span style="font-size: 22px"><b>第{{list.zj}}章&nbsp;&nbsp;&nbsp;{{list.title}}</b></span>
            <el-button type="primary" style="float: right;margin-right: 550px" @click="ccc(list.zj)">+</el-button>
            <div v-for="(list1,index) in list.searchContent1" :key="index" style="width: 100%;margin-top: 20px;">
                <div style="text-align: left;margin-left: 0px;width: 750px;height: 50px;padding-left: 20px;padding-top: 10px;  ">
                    <span><i class="el-icon-lx-crown"></i> {{list1.zjj}}&nbsp;&nbsp;&nbsp;{{list1.title}} </span>

                    <el-button style="float: right" type="danger" @click="remove(list1.id,list.iid,list.zj)">删除</el-button>
                    <el-button style="float: right;" type="primary" @click="handleEdit(list.zj,list1.zjj)">编辑</el-button>
                </div>
            </div>
        </div>


        <el-dialog title="添加章" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="章节:">
                    <el-input :disabled="true" v-model="form.zj"></el-input>
                </el-form-item>
                <el-form-item label="章名:">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
            </el-form>

            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="addZ">确 定</el-button>
            </span>
        </el-dialog>
        <el-dialog title="添加节" :visible.sync="editVisible1" width="30%">
            <el-form ref="form1" :model="form1" label-width="70px">
                <el-form-item label="章节:">
                    <el-input :disabled="true" v-model="form1.zj"></el-input>
                </el-form-item>
                <el-form-item label="章名:">
                    <el-input v-model="form1.title"></el-input>
                </el-form-item>
                <el-form-item label="选择文件">
                    <input class="file" type="file" title="请选择文件" value="请选择文件" />
                </el-form-item>
            </el-form>




                <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="addJ">确 定</el-button>
            </span>
        </el-dialog>
        <el-dialog title="编辑节" :visible.sync="editVisible2" width="30%">
            <el-form ref="form3" :model="form3" label-width="70px">
                <el-form-item label="章ID:">
                    <el-input v-model="form3.id" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="章名:">
                    <el-input v-model="form3.title"></el-input>
                </el-form-item>
            </el-form>

            <el-form ref="form2" :model="form2" label-width="70px">
                <el-form-item label="节ID:">
                    <el-input v-model="form2.id" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="节:">
                    <el-input :disabled="true" v-model="form2.zjj"></el-input>
                </el-form-item>
                <el-form-item label="节名:">
                    <el-input v-model="form2.title"></el-input>
                </el-form-item>
                <el-form-item label="选择文件">
                    <input class="file" type="file" title="请选择文件" value="请选择文件" />
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
                radio:'',
                tableData: [],
                multipleSelection: [],
                delList: [],
                pageTotal: 0,
                form: {
                    zj:'',
                    title:'',
                },
                form1:{
                    zj:'',
                    title:'',
                },
                form2:{
                    idd:'',
                    id:'',
                    zj:'',
                    title:'',
                    title1:'',
                },
                form3:{
                    id:'',
                    title:'',
                },
                title:'',
                content2:'',
                zj:'',
                zj1:''

            };
        },
        methods: {
            // 编辑操作
            handleEdit(a,b) {
//                this.idx = index;
//                this.form = row;


                this.form2=this.content1[a-1].searchContent1[(b.substring(2))-1];
                this.form3=this.content1[a-1];
//                alert(a+b);
//                console.log(this.content1);
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

            remove(a,b,c) {

                this.$ajax.get('deletezj1?id='+a+'&iid='+b+'&zj='+c).then(res=>{
                    if (res.status == 200) {
                        this.$ajax.get('searchcontent?id='+this.title).then(res=> {
                            this.content1 = res.data;
                        })
                        this.$message.success("删除成功!");


                    }
                    else this.$message.error("删除错误!");
                })
            },

            aaa(){
                this.$ajax.get('searchcontent?id='+this.title).then(res=>{
                    this.content1=res.data;
                    this.zj=res.data.length+1
                    this.form.zj="第"+this.zj+"章";

                })
            },
            bbb(){
                this.$ajax.get('searchcontent?id='+this.title).then(res=>{
                    this.zj=res.data.length+1
                    this.form.zj="第"+this.zj+"章";

                });
                if(this.title==0) this.$message.error('请先选择课程或者添加课程');
                else this.editVisible=true;
            },
            ccc(zj){
                this.$ajax.get('searchcontent?id='+this.title).then(res=>{
                     this.form1.zj = zj + "-" + (res.data[zj - 1].searchContent1.length + 1);
                    this.zj1 = zj;


                })
                this.editVisible1=true
            },
            addZ(){

                this.$ajax.get('insertzj?iid='+this.title+'&zj='+this.zj+'&title='+this.form.title).then(res=>{
                    if(res.status==200) {
                        this.$message.success('添加章成功!');

                        var url = "insertzj1?iid=" + this.title + "&zj=" + this.form.zj.substring(1,2) + "&zjj=" + this.form.zj.substring(1,2)+"-1" + "&title=" +
                            "请编辑" + "&url=freecourse?id=" + this.title + "%26zj=" + this.form.zj.substring(1,2)+"-1"+ "%26title=" + "请编辑"
                        this.$ajax.get(url).then(res => {
                            if (res.status == 200) {
                                this.$message.success("添加成功!");
                                this.aaa();

                            }
                            else this.$message.error("添加错误!");
                        })

                        this.editVisible=false;

                    }
                    else this.$message.error('添加章失败!');
                })


            },
            addJ(){
                formData.delete("file");
                formData.delete("zj");
                formData.delete("title");
                    formData.append('file', document.querySelector('input[type=file]').files[0]) // 'file' 这个名字要和后台获取文件的名字一样;
                    formData.append('zj', this.form1.zj)
                    formData.append('title', this.title)
                    //'userfile'是formData这个对象的键名
                    this.$ajax({
                        url: '2',   //****: 你的ip地址
                        data: formData,
                        method: 'post',
                        headers: {
                            'Content-Type': 'multipart/form-data',
                            // 'Access-Control-Allow-Origin': 'http://127.0.0.1:8080'
                            //这里是为了解决跨域问题，但是博主并没有用这种方式解决。后面会给出解决方案
                        }
                    }).then((res) => {
                        // console.log(res.data);
                    })

                    var url = "insertzj1?iid=" + this.title + "&zj=" + this.zj1 + "&zjj=" + this.form1.zj + "&title=" +
                        this.form1.title + "&url=freecourse?id=" + this.title + "%26zj=" + this.form1.zj + "%26title=" + this.form1.title
//                alert(url)
                    this.$ajax.get(url).then(res => {
                        if (res.status == 200) {
                            this.$message.success("添加成功!");
                            this.aaa();

                        }
                        else this.$message.error("添加错误!");
                    })
                    this.editVisible1 = false;


            },
            editJ(){

                formData.delete("file");
                formData.delete("zj");
                formData.delete("title");
                formData.append('file', document.querySelector('input[type=file]').files[0]) // 'file' 这个名字要和后台获取文件的名字一样;
                formData.append('zj', this.form2.zjj)
                formData.append('title', this.title)
                //'userfile'是formData这个对象的键名
                this.$ajax({
                    url: '2',   //****: 你的ip地址
                    data: formData,
                    method: 'post',
                    headers: {
                        'Content-Type': 'multipart/form-data',
                        // 'Access-Control-Allow-Origin': 'http://127.0.0.1:8080'
                        //这里是为了解决跨域问题，但是博主并没有用这种方式解决。后面会给出解决方案
                    }
                }).then((res) => {
                    // console.log(res.data);
                })

                var url = "updatezj?id=" + this.form3.id + "&title=" + this.form3.title;
                this.$ajax.get(url).then(res => {
                    if (res.status == 200) {
                        this.$ajax.get("updatezj1?id="+this.form2.id+"&title="+this.form2.title
                            + "&url=freecourse?id=" + this.title + "%26zj=" + this.form2.zjj + "%26title=" + this.form2.title)
                        if (res.status == 200) {
                            this.$message.success("修改成功!");
                        } else this.$message.error("修改错误!");
                    }
                    else return false;
                })
                this.editVisible2 = false;
//                this.aaa();
            },




        },mounted:function () {

            var i=localStorage.getItem('token')
            this.$ajax.get('getUser?token='+i).then(res=>{
                if(res.data[0].identity==1) {
                    this.$ajax.get('search').then(res=>{
                        this.content2=res.data;
                    })
                }
                else {
                    this.$ajax.get('searchById?author='+res.data[0].name).then(res=>{
                        this.content2=res.data;
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
