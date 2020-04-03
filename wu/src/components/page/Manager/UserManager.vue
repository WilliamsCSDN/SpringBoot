<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 用户管理
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button type="primary" @click="ccc">+</el-button>
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
                <el-table-column prop="username" label="用户名"></el-table-column>
                <el-table-column prop="name" label="昵称"></el-table-column>
                <el-table-column prop="usertype.name" label="身份"></el-table-column>
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
                <el-form-item label="用户名">
                    <el-input v-model="form.username"></el-input>
                </el-form-item>
                <el-form-item label="昵称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>

                <el-form-item label="密码"> <el-input  v-model="form.password"></el-input></el-form-item>

                <el-form-item label="身份">
                    <!--<el-input  v-model="form.usertype.name"></el-input>-->
                    <el-select v-model="form.usertype.name" placeholder="请选择">
                        <el-option key="1" label="管理员" value="1"></el-option>
                        <el-option key="2" label="教师" value="2"></el-option>
                        <el-option key="3" label="学生" value="3"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="QQ"> <el-input  v-model="form.qq"></el-input></el-form-item>
                <el-form-item label="手机"> <el-input  v-model="form.phone"></el-input></el-form-item>
                <el-form-item label="地址"> <el-input  v-model="form.address"></el-input></el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="updateUser">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 添加弹出框 -->
        <el-dialog title="添加" :visible.sync="editVisible1" width="30%">
            <el-form ref="form" :model="form1" label-width="70px">
                <el-form-item label="用户名">
                    <el-input v-model="form1.username"></el-input>
                </el-form-item>
                <el-form-item label="昵称">
                    <el-input v-model="form1.name"></el-input>
                </el-form-item>

                <el-form-item label="明文密码"> <el-input  v-model="form1.password"></el-input></el-form-item>

                <el-form-item label="身份">
                    <!--<el-input  v-model="form.usertype.name"></el-input>-->
                    <el-select v-model="form1.usertype.name" placeholder="请选择">
                        <el-option key="1" label="管理员" value="1"></el-option>
                        <el-option key="2" label="教师" value="2"></el-option>
                        <el-option key="3" label="学生" value="3"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="QQ"> <el-input  v-model="form1.qq"></el-input></el-form-item>
                <el-form-item label="手机"> <el-input  v-model="form1.phone"></el-input></el-form-item>
                <el-form-item label="地址"> <el-input  v-model="form1.address"></el-input></el-form-item>

            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="addUser">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<script>
    import { fetchData } from '../../../api/index';
    import md5 from 'js-md5';
    export default {
        name: 'basetable',
        data() {
            return {
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                editVisible1: false,
                editVisible2:false,
                pageTotal: 0,
                form: {
                    usertype:{name:''}
                },
                form1:{
                    id:'',
                    name:'',
                    username:'',
                    password:'',
                    qq:'',
                    address:'',
                    phone:'',
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
                        this.$ajax.get('deleteById?id='+this.form.id).then(res=>{
                            if(res.status==200)  {
                                this.$message.success('删除成功');
                                this.$ajax.get('getAllUser').then(res=>{
                                    this.tableData=res.data;
                                })
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
            //修改操作
            handleEdit1(index, row) {
                this.idx = index;
                this.form2 = row;
                this.editVisible2 = true;
            },
            // 保存编辑
            saveEdit() {
                this.editVisible = false;
                this.$message.success(`修改第 ${this.idx + 1} 行成功`);
                this.$set(this.tableData, this.idx, this.form);
            },
            updateUser(){
                if(this.form.password==''){
                    alert("请输入密码")
                    return false;
                }
                if(this.form.usertype.name=="管理员") this.form.usertype.name=1;
                else if(this.form.usertype.name=="教师") this.form.usertype.name=2;
                else if(this.form.usertype.name=="学生") this.form.usertype.name=3;
                var inputPass = this.form.password;
                var salt = "123456";
                var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
                var password = md5(str);
                var url='updateUser?id='+this.form.id+'&name='+this.form.name+'&username='+this.form.username
                    +'&qq='+this.form.qq+'&address='+this.form.address+'&identity='+this.form.usertype.name+'&phone='+this.form.phone+'&password='+password
                this.$ajax.get(url).then(res=>{
                    if(res.status==200) {
                        this.$message.success("修改成功");
                        this.$ajax.get('getAllUser').then(res=>{
                            this.tableData=res.data;
                        })
                    }

                    else this.$message.error("修改失败");
                })
                this.editVisible=false;
            },
            addUser(){
                if(this.form1.name==''||this.form1.username==''||this.form1.qq==''||this.form1.address==''||this.form1.usertype.name==''||this.form1.phone==''||this.form1.password=='')
                {
                    this.$message.error("请输入全部信息")
                }else{
                    var inputPass = this.form1.password;
                    var salt = "123456";
                    var str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
                    var password = md5(str);
                    var url='addUser?name='+this.form1.name+'&username='+this.form1.username+'&qq='
                        +this.form1.qq+'&address='+this.form1.address+'&identity='+this.form1.usertype.name+'&phone='+this.form1.phone+'&password='+password
                    this.$ajax.get(url).then(res=>{
                        if(res.status==200) {
                            this.$message.success("添加成功");
                            this.$ajax.get('getAllUser').then(res=>{
                                this.tableData=res.data;
                            })
                        }
                        else this.$message.error("添加失败")
                    })
                    this.editVisible1=false;
                }



            },ccc(){
                this.editVisible1=true;
                this.form1.id=''
                this.form1.name=''
                this.form1.username=''
                this.form1.password=''
                this.form1.qq=''
                this.form1.address=''
                this.form1.phone=''
                this.form1.usertype.name=''


            }

        },mounted:function () {
                        this.$ajax.get('getAllUser').then(res=>{
                            this.tableData=res.data;
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
