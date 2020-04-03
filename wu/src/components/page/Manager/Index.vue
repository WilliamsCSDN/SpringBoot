<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-card shadow="hover" class="mgb20" style="height:252px;">
                    <div class="user-info">
                        <img src="../../../assets/img/img.jpg" class="user-avator" alt />
                        <div class="user-info-cont">
                            <div class="user-info-name">{{user}}</div>
                            <div>{{role}}</div>
                        </div>
                    </div>
                    <div class="user-info-list">
                        登录时间：
                        <span>{{nowtime}}</span>
                    </div>
                    <div class="user-info-list">
                        登录地点：
                        <span>深圳</span>
                    </div>
                </el-card>
                <el-card shadow="hover" style="height:252px;">
                    <div slot="header" class="clearfix">
                        <span>语言详情</span>
                    </div>Vue
                    <el-progress :percentage="71.3" color="#42b983"></el-progress>Java
                    <el-progress :percentage="64.1" color="#f1e05a"></el-progress>CSS
                    <el-progress :percentage="13.7"></el-progress>HTML
                    <el-progress :percentage="5.9" color="#f56c6c"></el-progress>
                </el-card>
            </el-col>
            <el-col :span="16">
                <el-row :gutter="20" class="mgb20">
                    <el-col :span="8">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-1">
                                <i class="el-icon-lx-people grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">{{usernum}}</div>
                                    <div>用户人数</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="8">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-2">
                                <i class="el-icon-lx-notice grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">321</div>
                                    <div>系统消息</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                    <el-col :span="8">
                        <el-card shadow="hover" :body-style="{padding: '0px'}">
                            <div class="grid-content grid-con-3">
                                <i class="el-icon-lx-goods grid-con-icon"></i>
                                <div class="grid-cont-right">
                                    <div class="grid-num">{{lessonnum}}</div>
                                    <div>课程数量</div>
                                </div>
                            </div>
                        </el-card>
                    </el-col>
                </el-row>
                <el-card shadow="hover" style="height:403px;">
                    <div slot="header" class="clearfix">
                        <span>最新课程</span>
                    </div>
                    <el-table :show-header="false" :data="lessonList" style="width:100%;">

                        <el-table-column>
                            <template slot-scope="scope">
                                <div
                                    class="todo-item"

                                >{{scope.row.title}}</div>
                            </template>
                        </el-table-column>

                    </el-table>
                </el-card>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="12">
                <el-card shadow="hover">
                    <!--<schart ref="bar" class="schart" canvasId="bar" :options="options"></schart>-->
                    <div id="myChart" :style="{width: '500px', height: '275px'}"></div>
                </el-card>
            </el-col>
            <el-col :span="12">
                <el-card shadow="hover">
                    <schart ref="line" class="schart" canvasId="line" :options="options2"></schart>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>


<script>
import Schart from 'vue-schart';
import bus from '../../common/bus';
export default {
    name: 'dashboard',
    data() {
        return {
            user: '',
            role:'',
            nowtime:'',

            options: {

            },
            options2: {
                type: 'line',
                title: {
                    text: '课程'
                },
                labels: ['6月', '7月', '8月', '9月', '10月'],
                datasets: [
                    {
                        label: '用户',
                        data: [234, 278, 270, 190, 230]
                    },
                    {
                        label: '课程',
                        data: [164, 178, 150, 135, 160]
                    },
                    {
                        label: '教师',
                        data: [74, 118, 200, 235, 90]
                    }
                ]
            },
            usernum:'',
            infonum:'',
            lessonnum:'',
            lessonList:'',
            numm:['','',''],
            option:{},

        };
    },
    components: {
        Schart
    },
    methods: {
        changeDate() {
            const now = new Date().getTime();
            this.data.forEach((item, index) => {
                const date = new Date(now - (6 - index) * 86400000);
                item.name = `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()}`;
            });
        },
        drawLine(){
            let myChart = this.$echarts.init(document.getElementById('myChart'))
            this.option={
                color: ['#3398DB'],
                title:{
                    text:'用户管理'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: ''        // 默认为直线，可选为：'line' | 'shadow'
                    },
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        data: ['管理员', '教师', '用户'],
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '直接访问',
                        type: 'bar',
                        barWidth: '30%',
                        data: this.numm
                    }
                ]
            }
            this.$ajax.get('getAllUser').then(res=>{
                this.usernum=res.data.length;
                for(var i=0;i<this.usernum;i++) {
                    if (res.data[i].identity == 1)
                        this.numm[0]++;
                    else if (res.data[i].identity == 2)
                        this.numm[1]++;
                    else this.numm[2]++;
                }
                myChart.setOption(this.option);
            })

        }
    },
    mounted:function () {
        var a=new Date();
        this.nowtime=(a.getFullYear()+'-'+(a.getMonth()+1)+'-'+a.getDate());
        this.drawLine();
            var i=localStorage.getItem('token')
        this.$ajax.get('getUser?token='+i).then(res=>{
            if(res.data[0].name==null)this.user="欢迎你!"+res.data[0].username;
            else this.user="欢迎你!"+res.data[0].name;
            if(res.data[0].identity=='1')this.role='超级管理员';
            else if(res.data[0].identity=='2') this.role='教师';
            else this.role='学生';
            })

        this.$ajax.get('search').then(res=>{
            this.lessonnum=res.data.length
            this.$ajax.get('search1?start='+(this.lessonnum-6)+'&num=6').then(res=>{
                 this.lessonList=res.data
             })
        })

    }

};
</script>


<style scoped>
.el-row {
    margin-bottom: 20px;
}

.grid-content {
    display: flex;
    align-items: center;
    height: 100px;
}

.grid-cont-right {
    flex: 1;
    text-align: center;
    font-size: 14px;
    color: #999;
}

.grid-num {
    font-size: 30px;
    font-weight: bold;
}

.grid-con-icon {
    font-size: 50px;
    width: 100px;
    height: 100px;
    text-align: center;
    line-height: 100px;
    color: #fff;
}

.grid-con-1 .grid-con-icon {
    background: rgb(45, 140, 240);
}

.grid-con-1 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-2 .grid-con-icon {
    background: rgb(100, 213, 114);
}

.grid-con-2 .grid-num {
    color: rgb(45, 140, 240);
}

.grid-con-3 .grid-con-icon {
    background: rgb(242, 94, 67);
}

.grid-con-3 .grid-num {
    color: rgb(242, 94, 67);
}

.user-info {
    display: flex;
    align-items: center;
    padding-bottom: 20px;
    border-bottom: 2px solid #ccc;
    margin-bottom: 20px;
}

.user-avator {
    width: 120px;
    height: 120px;
    border-radius: 50%;
}

.user-info-cont {
    padding-left: 50px;
    flex: 1;
    font-size: 14px;
    color: #999;
}

.user-info-cont div:first-child {
    font-size: 30px;
    color: #222;
}

.user-info-list {
    font-size: 14px;
    color: #999;
    line-height: 25px;
}

.user-info-list span {
    margin-left: 70px;
}

.mgb20 {
    margin-bottom: 20px;
}

.todo-item {
    font-size: 14px;
}

.todo-item-del {
    text-decoration: line-through;
    color: #999;
}

.schart {
    width: 100%;
    height: 300px;
}
</style>
