<template>
    <el-container style="height:100%;" direction="vertrcal">
        <!-- header -->
        <!-- main -->
        <el-main class="el-main-2" >
            <div class="header-2">
                <p class="menu-1" style="font-size:18pt;position: relative;top: -15px;left:17px;"><i class="iconfont">&#xe651;</i>应用蜜罐</p>
            </div>
            <hr style="margin-bottom:0;"/>
            <div class="main-1" >
                <el-tabs
                        class="tabs-1"
                        :tab-position="top"
                        type="card"
                        @tab-click="handleClick"

                >
                    <!-- 节点配置 -->

                    <el-tab-pane label="应用蜜罐信息"  >

                        <div class="tab-1">
                            <div class="tab-1-1">
                                <p class="IP" style="position: relative;top:0px">IP地址:
                                    <el-input v-model="potdata_ip" style="width:187px"></el-input>
                                    <el-button class="button4" style="background:#E95513;color:#ffffff;"  @click="getPotList">
                                        查询主机</el-button>
                                </p>
                            </div>
                            <div class="tab-1-2">
                                <el-table
                                        :header-cell-style="{background:'#E95513',padding:0,color:'#FFFFFF'}"
                                        class="table1"
                                        row-style="30px"
                                        cell-style="padding:0"
                                        id="table11"
                                        :data="potdata.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                                        style="width: 100%">
                                    <el-table-column
                                            prop="id"
                                            label="序号"
                                            width="150">
                                    </el-table-column>
                                    <el-table-column
                                            prop="ip"
                                            label="IP地址"
                                            width="250">
                                    </el-table-column>
                                    <el-table-column
                                            prop="type"
                                            label="主机类型"
                                            width="250">
                                    </el-table-column>
                                    <el-table-column
                                            prop="disk"
                                            label="硬盘"
                                            width="220">
                                    </el-table-column>
                                    <el-table-column
                                            prop="cpu"
                                            label="CPU"
                                            width="250">
                                    </el-table-column>
                                    <el-table-column
                                            prop="memory"
                                            label="内存"
                                            width="200">
                                    </el-table-column>
                                    <el-table-column
                                            prop="operater"
                                            label="操作"
                                    >
                                        <template slot-scope="scope">
                                            <!--暂时连接到百度-->
                                            <!--<el-button-->
                                                    <!--type="text"-->
                                                    <!--size="mini"-->

                                                    <!--@click="dialog = true">查看详情 蜜罐管理</el-button>-->
                                            <el-button
                                                    type="text"
                                                    size="mini"

                                            ><a href="https://www.baidu.com" style="color: #E95513;text-decoration: none">查看详情 蜜罐管理</a></el-button>
                                            <el-dialog title="查看更多" :visible.sync="dialog">
                                                <el-table
                                                        :header-cell-style="{background:'#E95513',padding:0,color:'#FFFFFF'}"
                                                        class="table1"
                                                        id="table1"
                                                        :data="potdata"
                                                        style="width: 100%"><!--表的名字-->
                                                    <!-- 选择框   -->

                                                </el-table>
                                                <div slot="footer" class="dialog-footer">
                                                    <el-button class="button3" dialog = false>取 消</el-button>
                                                    <el-button class="button2" @click="dialog = false">确 定</el-button>
                                                </div>
                                            </el-dialog>


                                        </template>
                                    </el-table-column>
                                </el-table>


                            </div>
                        </div><!--table-1-2-->
                        <div class="p-page" style="font-size: 12px;padding-left: 34px"><span style="">显示第{{(currentPage-1) * pagesize +1}}
                      到第{{((currentPage * pagesize)<(potdata.length))?currentPage * pagesize:potdata.length}}条记录，
                      总共{{potdata.length}}条记录</span>
                            <span style="position: relative;left: 33px;font-size: 12px;">每页显示</span>
                            <el-select v-model="pagesize" slot="prepend" placeholder="" id="pagesize" style="width: 65px;height: 30px;border-radius: 0px;font-size: 12px;left: 35px;position: relative;">
                                <el-option label="10" value="10"></el-option>
                                <el-option label="20" value="20"></el-option>
                            </el-select>
                            <span style="margin-left:2px;position: relative;left: 32px;">条信息<span style="margin-left: 20px">转到<el-input  v-model="jumper" style="width: 50px;height: 30px;margin-left: 2px;margin-right: 4px"></el-input>页</span><el-button class="button2" style="font-size: 12px;" @click="handleCurrentChange(jumper)">跳转</el-button></span>

                        </div>
                        <div style="float:right;margin-top:15px;margin-right: 30px;">
                            <!-- *********************************分页按钮 -->
                            <el-pagination
                                    background="#E95513"
                                    prev-text="上一页"
                                    next-text="下一页"
                                    jumper-text="转到"
                                    @size-change="handleSizeChange"
                                    @current-change="handleCurrentChange"
                                    :current-page="currentPage"
                                    :page-sizes="[10, 20]"
                                    :page-size="pagesize"
                                    :total="potdata.length"
                                    layout="slot,prev, pager, next,total" >
                                <!-- <slot name="as">dddd</slot> -->
                            </el-pagination>
                        </div>




                    </el-tab-pane>

                </el-tabs>
            </div> <!--main-1-->


        </el-main>
        <!-- footer -->
    </el-container>
</template>
<style scoped>
    @font-face {
        font-family: 'iconfont';  /* project id 796633 */
        src: url('//at.alicdn.com/t/font_796633_b3c1isjjwu.eot');
        src: url('//at.alicdn.com/t/font_796633_b3c1isjjwu.eot?#iefix') format('embedded-opentype'),
        url('//at.alicdn.com/t/font_796633_b3c1isjjwu.woff') format('woff'),
        url('//at.alicdn.com/t/font_796633_b3c1isjjwu.ttf') format('truetype'),
        url('//at.alicdn.com/t/font_796633_b3c1isjjwu.svg#iconfont') format('svg');
    }
    .iconfont{
        font-family:"iconfont" !important;
        font-size:36px;font-style:normal;
        -webkit-font-smoothing: antialiased;
        -webkit-text-stroke-width: 0px;
        color:#5EBF18;
    ;}
    /* *********************************************mian start*****************/
    /* 绿色字体 */

    .p-page{
        padding-top: 15px;
        color:#666666;
        float:left;
        font-size: 12pt;}
    .p-2{
        position: relative;

        font-size: 18pt;
        font-weight: bold;
        left: 20px;
        font-family: '微软雅黑';
        margin-bottom: 20px;
    }
    /* 白色条框 */
    .header-2{
        margin: 0;
        height:60px;
        width:100%;
        color:black;
        font-weight: 500;
        overflow: hidden;
    }
    .main-1{
        padding: 2px !important;
    }
    .el-table__body, .el-table__footer, .el-table__header{


        font-size: 12px;
    }
    .el-main-2{
        padding: 2px !important;
    }
    /*tabs的颜色 */
    .el-tabs__item.is-active{
        color: #666666 !important;
    }
    .el-tabs__item:hover{
        color: #E95513 !important;
    }
    /*导航栏背景颜色*/
    .el-tabs__nav-wrap.is-left {
        background: #F2F2F2;
    }
    .el-tabs__nav-wrap::after {
        background: #F2F2F2;
    }
    .el-tabs--card>.el-tabs__header .el-tabs__nav {
        background: #F2F2F2;
    }
    /*导航栏间隔*/
    .el-tabs__header {
        padding: 0;
        position: relative;
        margin: 0 0 10px;
    }
    .el-tabs__item:active {
        color: #E95513 !important;
        background: #fff;
    }
    .el-tabs__item:focus, .el-tabs__item:active {
        color: #E95513 !important;
        outline: 0;
        background: #fff;
    }
    .el-tabs--left .el-tabs__active-bar.is-left, .el-tabs--left .el-tabs__nav-wrap.is-left::after {
        background: #fff;
    }
    /*标签页背景色*/
    .el-tabs__item {
        font-size: 12px;
        font-weight: normal;
        color: #666666;
        background: #F2F2F2;
    }
    .el-tabs__item:focus:active {
        outline: 0;
        /* font-size: 12px; */
        /* border-bottom-color: #E95513; */
        color: #E95513 !important;
        background: #fff;
        border-bottom: 2px solid #E95513;
    }
    /*悬停时的背景色*/
    .el-tabs__item:hover{
        color: #E95513 !important;
    }
    /*导航栏激活时下面有颜色的border*/
    .el-tabs--card>.el-tabs__header .el-tabs__item.is-active{
        border-bottom: 2px solid #E95513;
    }
    /*导航栏样式*/
    .el-tabs__item.is-left.is-active{
        color: #E95513 !important;
    }

    /*表格样式*/
    .el-table th>.cell {
        background: #e95513;
        color: #fff;
        font-weight: lighter;
        font-size: 12px;
        vertical-align: center;
        padding-left: 20px;
        margin-bottom: 0px;
    }

    .tab-1-2 tr:hover{
        background-color: #fff !important;
    }
    /********************************** 查看详情的颜色 */
    .el-button--text{

        color:#E95513;
    }
    .el-button--text.is-active{
        color: #E95513;
    }
    .el-button--text:hover{
        color: #E95513;
    }

    .tab-1-1{
        margin-left: 30px;
        margin-top:15px;
        margin-bottom: 10px;
    }

    .tab-2-1{
        margin-left: 30px;
        margin-top:15px;
        margin-bottom: 10px;
    }

    .table-p1{
        font-family: 'Microsoft YaHei';
        font-size: 12pt;
        color:#BFBFBF;
    }
    /* 翻页背景色 */
    .el-pagination .el-pager .active{
        background-color: #E95513 !important;
    }
    .el-pagination.is-background .el-pager li:not(.disabled):hover{
        color:#E95513 !important;
    }
    .el-pagination .el-select .el-input .el-input__inner{
        float:left;
    }
    /*分页*/
    .el-pagination .el-select .el-input {
        position: absolute;
        left: -640px;
        top:-15px;
        font-size: 12px;
        border-radius: 0px;
    }
    .el-pagination__jump{
        position: relative;
        left: -1140px;
        top:9px;
    }
    el-pagination__sizes .el-input .el-input__inner:hover {
        border-color: #fff;
    }
    .el-select-dropdown__item.selected {
        color: #fff;
        font-weight: 700;
        background: #e95513;
    }
    .el-select .el-input .el-select__caret{
        font-size: 12px;
    }
    .el-select.el-input__icon{
        line-height: 30px;
    }
    .el-input{
        font-size: 12px;
    }
    .el-select-dropdown__item.hover, .el-select-dropdown__item:hover:active{
        background: #e95513;
    }
    /*.el-select.el-input*/ .el-input--suffix{
                                height: 30px;
                            }
    .el-select .el-input.is-focus .el-input__inner{
        border-color:#c0c4cc;
    }
    .el-select.el-input.el-input__inner {
        color: #606266;
        height: 30px;
        line-height: 30px;
    }
    .el-select.el-input__icon{
        line-height: 30px;
        height: 30px;
    }
    .el-select>.el-input--suffix{
        line-height: 30px;
        height: 30px;
    }

    /*********************确定 跳转 按钮样式*********************/
    .button2{
        background-color: #E95513 !important;
        color: #ffff !important;
        width: 60px;
        height: 30px;
        border-radius: 0px;
        vertical-align: center;
        padding: 2px;
        font-size: 12px;
        margin-left:10px ;
    }
    /*********************取消按钮样式*********************/
    .button3{
        background-color: #ffffff !important;
        color: black !important;
        width: 60px;
        height: 30px;
        border-radius: 0px;
        vertical-align: center;
        padding: 2px;
        font-size: 12px;
        margin-left:10px ;
    }
    /*********************普通按钮样式*********************/
    .button4{
        background-color: #E95513 !important;
        color: #ffff !important;
        width: 80px;
        height: 30px;
        border-radius: 0px;
        vertical-align: center;
        padding: 2px;
        font-size: 12px;
        margin-left:10px ;
    }
</style>
<script>
    import '../assets/css/new.css'
export default {

      data () {
        return {

          dialog: false,
          dialogFormVisible: false,
          dialogText: false,
          dialogTable: false,
          form: {
            name: '',
            IP: '',
            temserver: '',
            region: '',
            date1: '',
            date2: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
          },
          formLabelWidth: '120px',
          // 表的名字
          potdata_ip: '',
          currentPage: 1,
          jumper: 1,
          pagesize: 10,
          potdata: []
        }
      },
      mounted: function () {
        this.getListPot()
      },
      methods: {
        // 获取应用蜜罐信息
        getListPot () {
          var that = this
          this.$axios.get('/getListHost')
            .then(function (response) {
              that.potdata = response.data
            })
            .catch(function (error) {
              alert('handle error')
              console.log(error)
            })
            .then(function () {
            })
        },
        // 蜜罐信息查询
        getPotList () {
          var that = this
          this.$axios.get('/getPotByIp', {
            params: {
              ip: that.potdata_ip
            }
          })
            .then(function (response) {
              that.potdata = response.data
            })
            .then(function () {
              // 什么时候都执行的
            })
        },
        // 删除功能交互
        open2 () {
          this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            })
          })
        },
        // 分页功能
        handleSizeChange (size) {
          this.pagesize = size
        },
        // 页面跳转
        handleCurrentChange (currentPage) {
          this.currentPage = currentPage
        }
      }
    }
</script>
