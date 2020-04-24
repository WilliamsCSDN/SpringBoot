<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 学习之路管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button type="primary" @click="editVisible1=true">+</el-button>
            </div>
            <el-table
                    :data="tableData"
                    border
                    class="table"
                    ref="multipleTable"
                    header-cell-class-name="table-header"
                    
                    :default-sort="{prop: 'id', order: 'ascending'}"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="id" label="ID" width="55" align="center" sortable></el-table-column>
                <el-table-column prop="iid" label="IID" width="80" align="center" sortable></el-table-column>
                <el-table-column prop="title" label="标题" width="250"></el-table-column>
                <el-table-column prop="content" label="内容" ></el-table-column>

                <el-table-column prop="bz" label="步骤" width="55"></el-table-column>
                <el-table-column prop="kc" label="课程/节" width="55"></el-table-column>

                <el-table-column prop="sc" label="收藏" width="65"></el-table-column>
                <el-table-column prop="author" label="作者" width="65"></el-table-column>
                <el-table-column label="操作" width="200" align="center" >
                    <template slot-scope="scope" >
                        <el-button
                                type="text"
                                icon="el-icon-edit"
                                @click="handleEdit(scope.$index, scope.row)"
                        >编辑</el-button>

                        <el-button
                                type="text"
                                icon="el-icon-delete"
                                class="red"
                                @click="handleDelete(scope.$index, scope.row)"
                        >删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <div class="pagination">
                <el-pagination
                        background
                        layout="total, prev, pager, next"
                        :total="tableData.length"
                       
                ></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="类型">
                    <!--<el-input  v-model="form.level"></el-input>-->
                    <el-select v-model="form.iid" placeholder="请选择">
                        <el-option label="前端" value="前端"></el-option>
                        <el-option label="后端" value="后端"></el-option>
                        <el-option label="移动端" value="移动端"></el-option>
                        <el-option label="计算机基础" value="计算机基础"></el-option>
                        <el-option label="大数据" value="大数据"></el-option>
                        <el-option label="测试" value="测试"></el-option>
                        <el-option label="人工智能" value="人工智能"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="标题">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="内容">
                    <el-input v-model="form.content" type="textarea"></el-input>
                </el-form-item>

                <el-form-item label="步骤"> <el-input  v-model="form.bz"></el-input></el-form-item>
                <el-form-item label="课程"> <el-input  v-model="form.kc"></el-input></el-form-item>

                <el-form-item label="收藏"> <el-input  v-model="form.sc" :disabled="true"></el-input></el-form-item>
                <el-form-item label="作者"> <el-input  v-model="form.author" :disabled="true"></el-input></el-form-item>
                <el-form-item label="图片"> <input type="file" id="saveImage" name="myphoto" accept="image/png,image/gif,image/jpeg"
           ref="new_image"></el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 添加弹出框 -->
        <el-dialog title="添加" :visible.sync="editVisible1" width="30%">
            <el-form ref="form1" :model="form1" label-width="70px">
                <el-form-item label="类型">
                    <!--<el-input  v-model="form1.level"></el-input>-->
                    <el-select v-model="form1.iid" placeholder="请选择">
                        <el-option label="前端" value="前端"></el-option>
                        <el-option label="后端" value="后端"></el-option>
                        <el-option label="移动端" value="移动端"></el-option>
                        <el-option label="计算机基础" value="计算机基础"></el-option>
                        <el-option label="大数据" value="大数据"></el-option>
                        <el-option label="测试" value="测试"></el-option>
                        <el-option label="人工智能" value="人工智能"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="标题">
                    <el-input v-model="form1.title"></el-input>
                </el-form-item>
                <el-form-item label="内容">
                    <el-input v-model="form1.content" type="textarea"></el-input>
                </el-form-item>

                <el-form-item label="步骤"> <el-input  v-model="form1.bz"></el-input></el-form-item>
                <el-form-item label="课程"> <el-input  v-model="form1.kc"></el-input></el-form-item>

                <el-form-item label="收藏"> <el-input  v-model="form1.sc" :disabled="true"></el-input></el-form-item>
                <el-form-item label="作者"> <el-input  v-model="form1.author" :disabled="true"></el-input></el-form-item>
                <el-form-item label="图片"> <input type="file" id="saveImage" name="myphoto" accept="image/png,image/gif,image/jpeg"
           ref="new_image"></el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="addUser">确 定</el-button>
            </span>
        </el-dialog>


        <el-dialog title="图片选择" :visible.sync="editVisible2">
            <div v-for="(count,index) in 16" :key="index">
                <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
                    <img :src="'/learn1/kc'+count+'.jpg'" style="width: 180px;height: 100px"/>
                    <el-radio v-model="radio" :label="count">{{count}}</el-radio>
                </el-col>
            </div>
            <el-button @click="editVisible2 = false">取 消</el-button>
            <el-button type="primary" @click="imgchange">确 定</el-button>
        </el-dialog>


    </div>
</template>

<script>
    import { fetchData } from '../../../api/index';
    import md5 from 'js-md5';
    import ElButton from "../../../../node_modules/element-ui/packages/button/src/button";
    import ElDialog from "../../../../node_modules/element-ui/packages/dialog/src/component";
    import ElCol from "element-ui/packages/col/src/col";
    import ElRadio from "../../../../node_modules/element-ui/packages/radio/src/radio";
    export default {
        components: {ElRadio, ElCol, ElDialog, ElButton}, name: 'basetable',
        data() {
            return {
                radio:'',
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                editVisible1: false,
                editVisible2: false,
                pageTotal: 0,
                form: {},
                form1:{
                    id:'',
                    iid:'前端',
                    title:'',
                    content:'',
                    bz:'',
                    kc:'',
                    sc:'0',
                    src:'',
                    author:''
                },
                form2:{
                    usertype:{name:''}
                },

                idx: -1,
                id: -1
            };
        },
        methods: {
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                })
                    .then(() => {
                        this.form=row;
                        this.$ajax.get('deletelearncontent?id='+this.form.id).then(res=>{
                            if(res.status==200)  {
                                this.$message.success('删除成功');
                                this.xx();
                            }
                            else aler("删除失败!")
                        })


                    })
                    .catch(() => {});
            },
            // 编辑操作
            handleEdit(index, row) {
                this.idx = index;
                this.form = row;
                this.editVisible = true;
            },
            // 保存编辑
            saveEdit() {
                var a;
                if(this.form.iid=="前端") a=1;
                else if(this.form.iid=="后台") a=2;
                else if(this.form.iid=="移动端") a=3;
                else if(this.form.iid=="计算机基础") a=4;
                else if(this.form.iid=="大数据") a=5;
                else if(this.form.iid=="测试") a=6;
                else a=7;

                if(this.radio!='') var url='updatelearncontent?id='+this.form.id+'&src=kc'+this.form.id+'.jpg'+'.jpg'+'&title='+this.form.title+' &content='+this.form.content+' &bz='+this.form.bz+' &kc='+this.form.kc+'&sc='+this.form.sc+'&iid='+a+'&author='+this.form.author;
                else var url='updatelearncontent?id='+this.form.id+'&src=kc'+this.form.id+'.jpg'+'&title='+this.form.title+' &content='+this.form.content+' &bz='+this.form.bz+' &kc='+this.form.kc+'&sc='+this.form.sc+'&iid='+a+'&author='+this.form.author;
                this.$ajax.get(url).then(res=>{
                    if(res.status==200) {

                         let self = this;
    if (self.$refs.new_image.files.length !== 0) {
        var formData = new FormData()
        formData.append('image_data', self.$refs.new_image.files[0]);
        formData.append('a', "kc"+this.form.id+".jpg");
        //单个文件进行上传
        self.$ajax.post('/4', formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }).then(response => {
 
        })
    }

                     this.xx();
                        this.$message.success(`修改成功`);
                    }
                    else this.$message.error(`修改失败`);
                })
                this.radio='';
                this.editVisible = false;
            },

            addUser(){

                if(this.form1.title==''||this.form1.content==''||this.form1.bz==''||this.form1.kc==''||this.form1.sc==''||this.form1.iid==''||this.form1.author==''){
                    this.$message.error("请输入全部信息")
                }else {
                    var a;
                    if (this.form1.iid == "前端") a = 1;
                    else if (this.form1.iid == "后台") a = 2;
                    else if (this.form1.iid == "移动端") a = 3;
                    else if (this.form1.iid == "计算机基础") a = 4;
                    else if (this.form1.iid == "大数据") a = 5;
                    else if (this.form1.iid == "测试") a = 6;
                    else if (this.form1.iid == "人工智能") a = 7;
                    
                   this.$ajax.get('/selectBestId1').then(res=>{
                       var aaa=res.data+1

                       var url = 'insertlearncontent?title=' + this.form1.title + '&content=' + this.form1.content + '&bz=' +  this.form1.bz + '&kc=' + this.form1.kc + '&sc=' + this.form1.sc + '&src=kc' + aaa+'.jpg'+ '&iid=' + a + '&author=' + this.form1.author
                    this.$ajax.get(url).then(res => {
                        if (res.status == 200) {

                         let self = this;
    if (self.$refs.new_image.files.length !== 0) {
        var formData = new FormData()
        formData.append('image_data', self.$refs.new_image.files[0]);
        formData.append('a', "kc"+aaa+".jpg");
        //单个文件进行上传
        self.$ajax.post('/4', formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }).then(response => {
 
        })
    }

                            this.$message.success(`添加成功`);
                            this.xx();

                        }
                        else this.$message.error(`添加失败`);
                    })
                    
                    this.editVisible1 = false;
                    this.radio = '';
                    this.form1 = '';
                   })



                }
            },
            imgchange(){
                if(this.editVisible1)  this.form1.src='/learn1/kc'+this.radio+'.jpg';
                else if(this.editVisible)this.form.src='/learn1/kc'+this.radio+'.jpg';
                this.editVisible2=false

            },
            xx(){
                if(localStorage.getItem('identity')==1){
                    this.$ajax.get('getlearncontent1').then(res=>{
                        this.tableData=res.data;
                        for(var i=0;i<res.data.length;i++){
                            if(res.data[i].iid==1) this.tableData[i].iid="前端";
                            else if(res.data[i].iid==2) this.tableData[i].iid="后台";
                            else if(res.data[i].iid==3) this.tableData[i].iid="移动端";
                            else if(res.data[i].iid==4) this.tableData[i].iid="计算机基础";
                            else if(res.data[i].iid==5) this.tableData[i].iid="大数据";
                            else if(res.data[i].iid==6) this.tableData[i].iid="测试";
                            else this.tableData[i].iid="人工智能";
                        }
                    })
                }
                else {
                    this.$ajax.get('getlearncontent1?author=' + this.form1.author).then(res => {
                        this.tableData = res.data;
                        for (var i = 0; i < res.data.length; i++) {
                            if (res.data[i].iid == 1) this.tableData[i].iid = "前端";
                            else if (res.data[i].iid == 2) this.tableData[i].iid = "后台";
                            else if (res.data[i].iid == 3) this.tableData[i].iid = "移动端";
                            else if (res.data[i].iid == 4) this.tableData[i].iid = "计算机基础";
                            else if (res.data[i].iid == 5) this.tableData[i].iid = "大数据";
                            else if (res.data[i].iid == 6) this.tableData[i].iid = "测试";
                            else this.tableData[i].iid = "人工智能";
                        }
                    })
                }
            },
            xxx(){
                var i=localStorage.getItem('token')
                this.$ajax.get('getUser?token='+i).then(res=>{
                    if(res.data[0].name==null)this.form1.author=res.data[0].username;
                    else this.form1.author=res.data[0].name;
                    if(res.data[0].identity==1){
                        this.$ajax.get('getlearncontent1').then(res=>{
                            this.tableData=res.data;
                            for(var i=0;i<res.data.length;i++){
                                if(res.data[i].iid==1) this.tableData[i].iid="前端";
                                else if(res.data[i].iid==2) this.tableData[i].iid="后台";
                                else if(res.data[i].iid==3) this.tableData[i].iid="移动端";
                                else if(res.data[i].iid==4) this.tableData[i].iid="计算机基础";
                                else if(res.data[i].iid==5) this.tableData[i].iid="大数据";
                                else if(res.data[i].iid==6) this.tableData[i].iid="测试";
                                else this.tableData[i].iid="人工智能";
                            }
                        })
                    }
                    else {
                        this.$ajax.get('getlearncontent1?author=' + res.data[0].name).then(res => {
                            this.tableData = res.data;
                            for (var i = 0; i < res.data.length; i++) {
                                if (res.data[i].iid == 1) this.tableData[i].iid = "前端";
                                else if (res.data[i].iid == 2) this.tableData[i].iid = "后台";
                                else if (res.data[i].iid == 3) this.tableData[i].iid = "移动端";
                                else if (res.data[i].iid == 4) this.tableData[i].iid = "计算机基础";
                                else if (res.data[i].iid == 5) this.tableData[i].iid = "大数据";
                                else if (res.data[i].iid == 6) this.tableData[i].iid = "测试";
                                else this.tableData[i].iid = "人工智能";
                            }
                        })
                    }
                })
            }

        },mounted:function () {
                this.xxx();
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
