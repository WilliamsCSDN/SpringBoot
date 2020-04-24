<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 课程管理
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
                    @selection-change="handleSelectionChange"
                    :default-sort="{prop: 'id', order: 'ascending'}"
            >
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="id" label="ID" width="55" align="center" sortable></el-table-column>
                <el-table-column prop="title" label="标题"></el-table-column>
                <el-table-column prop="content" label="内容"></el-table-column>
                <el-table-column prop="author" label="作者" width="55"></el-table-column>
                <el-table-column prop="level" label="难度" width="55"></el-table-column>
                <el-table-column prop="sc" label="收藏" width="65"></el-table-column>
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
                        @current-change="handlePageChange"
                ></el-pagination>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="form" label-width="70px">
                <el-form-item label="标题">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="内容">
                    <el-input v-model="form.content" type="textarea"></el-input>
                </el-form-item>

                <el-form-item label="作者"> <el-input  v-model="form.author"></el-input></el-form-item>

                <el-form-item label="难度">
                    <!--<el-input  v-model="form.level"></el-input>-->
                    <el-select v-model="form.level" placeholder="请选择">
                        <el-option label="初级" value="初级"></el-option>
                        <el-option label="中级" value="中级"></el-option>
                        <el-option label="高级" value="高级"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="类型">
                    <!--<el-input  v-model="form.url"></el-input>-->
                    <el-select v-model="form.url" placeholder="请选择">
                        <el-option label="前沿/区块链/人工智能" value="1"></el-option>
                        <el-option label="前端/小程序/JS" value="2"></el-option>
                        <el-option label="后端/JAVA/Python" value="3"></el-option>
                        <el-option label="移动/Android/IOS" value="4"></el-option>
                        <el-option label="云计算/大数据/容器" value="5"></el-option>
                        <el-option label="运维/测试/数据库" value="6"></el-option>
                        <el-option label="UI设计/3D动画/游戏" value="7"></el-option>

                    </el-select>
                </el-form-item>
                <el-form-item label="收藏"> <el-input  v-model="form.sc" disabled="true"></el-input></el-form-item>
                <el-form-item label="图片"><input type="file" id="saveImage" name="myphoto" accept="image/png,image/gif,image/jpeg"
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
                <el-form-item label="标题">
                    <el-input v-model="form1.title"></el-input>
                </el-form-item>
                <el-form-item label="内容">
                    <el-input v-model="form1.content" type="textarea"></el-input>
                </el-form-item>

                <el-form-item label="作者"> <el-input  v-model="form1.author" disabled="true"></el-input></el-form-item>

                <el-form-item label="难度">
                    <!--<el-input  v-model="form1.level"></el-input>-->
                    <el-select v-model="form1.level" placeholder="请选择">
                        <el-option key="1" label="初级" value="初级"></el-option>
                        <el-option key="2" label="中级" value="中级"></el-option>
                        <el-option key="3" label="高级" value="高级"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="类型">
                    <el-select v-model="form1.url" placeholder="请选择">
                        <el-option label="前沿/区块链/人工智能" value="1"></el-option>
                        <el-option label="前端/小程序/JS" value="2"></el-option>
                        <el-option label="后端/JAVA/Python" value="3"></el-option>
                        <el-option label="移动/Android/IOS" value="4"></el-option>
                        <el-option label="云计算/大数据/容器" value="5"></el-option>
                        <el-option label="运维/测试/数据库" value="6"></el-option>
                        <el-option label="UI设计/3D动画/游戏" value="7"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="收藏"> <el-input  v-model="form1.sc" disabled="true"></el-input></el-form-item>
                <el-form-item label="图片"> <input type="file" id="saveImage" name="myphoto" accept="image/png,image/gif,image/jpeg"
           ref="new_image"></el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="addUser">确 定</el-button>
            </span>
        </el-dialog>


        <el-dialog title="图片选择" :visible.sync="editVisible2">
            <div v-for="count in 12">
                <el-col :xs="6" :sm="6" :md="6" :lg="6" :xl="6">
                <img :src="'/learn1/learn'+count+'.png'" />
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
                    title:'',
                    content:'',
                    author:'',
                    level:'初级',
                    sc:'0',
                    src:'',
                    url:''
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
                        this.$ajax.get('deletelesson?id='+this.form.id).then(res=>{
                            if(res.status==200)  {
                                this.$message.success('删除成功');
                                this.ad();

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
                if(this.radio!='') var url='updateimg?id='+this.form.id+'&src=learn'+this.form.id+'.png'+'&title='+this.form.title+' &content='+this.form.content+' &author='+this.form.author+' &level='+this.form.level+'&sc='+this.form.sc;
                else var url='updateimg?id='+this.form.id+'&src=learn'+this.form.id+'.png'+'&title='+this.form.title+' &content='+this.form.content+' &author='+this.form.author+' &level='+this.form.level+'&sc='+this.form.sc+'&url='+this.form.url;
                this.$ajax.get(url).then(res=>{
                    if(res.status==200) {

 let self = this;
    if (self.$refs.new_image.files.length !== 0) {
        var formData = new FormData()
        formData.append('image_data', self.$refs.new_image.files[0]);
        formData.append('a', "learn"+this.form.id+".png");
        //单个文件进行上传
        self.$ajax.post('/4', formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }).then(response => {
 
        })
    }

                        this.ad();
                        this.$message.success(`修改成功`);
                    }
                    else this.$message.error(`修改失败`);
                    this.radio='';
                })
                this.editVisible = false;
            },

            addUser(){
                if(this.form1.title==''||this.form1.content==''||this.form1.author==''||this.form1.level==''||this.form1.sc==''){
                    this.$message.error("请输入全部信息")
                }else{
                    this.$ajax.get('/selectBestId').then(res=>{
                        var aaa=res.data
                    var url='insertlesson?title='+this.form1.title+'&content='+this.form1.content+'&author='+this.form1.author+'&level='+this.form1.level+'&sc='+this.form1.sc+'&src=learn'+(res.data+1)+'.png'+'&url='+this.form1.url
                    this.$ajax.get(url).then(res=>{
                        if(res.status==200) {

 let self = this;
    if (self.$refs.new_image.files.length !== 0) {
        var formData = new FormData()
        formData.append('image_data', self.$refs.new_image.files[0]);
        formData.append('a', "learn"+(aaa+1)+".png");
        //单个文件进行上传
        self.$ajax.post('/4', formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        }).then(response => {
 
        })
    }

                            this.$message.success(`添加成功`);
                            this.ad();

                        }
                        else this.$message.error(`添加失败`);
                        this.radio='';
                    })

                    this.editVisible1=false
                    })

                }
            },
            imgchange(){
                if(this.editVisible1)  this.form1.src='/learn1/learn'+this.radio+'.png';
               else if(this.editVisible)this.form.src='/learn1/learn'+this.radio+'.png';
                this.editVisible2=false

            },
            ad(){
                 if(localStorage.getItem('identity')==1) {
                    this.$ajax.get('search').then(res=>{
                    this.tableData=res.data;
                    })
                    }
                else {
                    this.$ajax.get('searchById?author='+this.form1.author).then(res=>{
                        this.tableData=res.data;
                    })
                }
            }

        },mounted:function () {
            var i=localStorage.getItem('token')
            this.$ajax.get('getUser?token='+i).then(res=>{
                this.form1.author=res.data[0].name
                if(res.data[0].identity==1) {
                    this.$ajax.get('search').then(res=>{
                    this.tableData=res.data;
                    })
                    }
                else {
                    this.$ajax.get('searchById?author='+res.data[0].name).then(res=>{
                        this.tableData=res.data;
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
