<template>
    <el-container style="height:100%;" direction="vertrcal">
        <!-- header -->
        <!-- main -->
        <el-main class="el-main-2" >
            <div class="header-2">
                <p class="menu-1" style="font-size:18pt;position: relative;top: -15px;left:17px;"><i class="iconfont"style="margin-right: 2px">&#xe603;</i>蜜网构建</p>
            </div>
            <hr style="margin-bottom:0;"/>
            <div class="main-1">
                <el-tabs
                        class="tabs-1"
                        :tab-position="top"
                        type="card"
                        @tab-click="handleClick">
                    <!-- 节点配置 -->
                    <el-tab-pane label="节点配置">
                        <div class="tab-1">
                            <div class="tab-1-1">
                                <el-button  class="button4"  @click="dialogText1 = true">添加模板</el-button>
                                <el-dialog title="添加模板" :visible.sync="dialogText1" class="set-net">


                                    <div style="position: relative;left: 50px;margin-bottom: 20px">
                                        <span>模板名称</span>
                                        <el-input v-model="moduleName" auto-complete="off" label="模板名称" style="width: 800px;margin-left: 10px;"></el-input>
                                    </div>


                                    <el-form :model="form" v-for="form in forms" :key="form.ip">
                                        <div>
                                            <el-form-item label="IP" :label-width="formLabelWidth">
                                                <el-input v-model="form.ip" auto-complete="off" style="display: inline-block;width: 70%"></el-input>
                                            </el-form-item>
                                            <el-form-item label="服务器" :label-width="formLabelWidth">
                                                <el-select v-model="form.serverIp" placeholder="请选择">
                                                    <el-option
                                                            v-for="item in serverType"
                                                            :key="item.serverIp"
                                                            :label="item.server"
                                                            :value="item.serverIp">
                                                    </el-option>
                                                </el-select>
                                            </el-form-item>
                                            <el-form-item label="蜜罐类型" :label-width="formLabelWidth">

                                                <el-select v-model="form.honeyTypeValue1" placeholder="请选择" @change="changeType(form.honeyTypeValue1)">
                                                    <el-option
                                                            v-for="item in honeyType1"
                                                            :key="item.value"
                                                            :label="item.label"
                                                            :value="item.value">
                                                    </el-option>
                                                </el-select>
                                                <el-select v-model="form.type" placeholder="请选择">
                                                    <el-option
                                                            v-for="item in honeyType2"
                                                            :key="item.value"
                                                            :label="item.label"
                                                            :value="item.label">
                                                    </el-option>
                                                </el-select>
                                                <img src="../assets/加号.png" @click=" addHoneypot" style="width: 31px;height: 31px;display: inline-block;position: relative;top: 12px;left: 20px"/>
                                                <img src="../assets/减号.png" @click=" delHoneypot" style="width: 28px;height: 28px;display: inline-block;position: relative;top: 10px;left: 20px"/>
                                            </el-form-item>
                                        </div>
                                    </el-form>
                                    <div slot="footer" class="dialog-footer">
                                        <el-button class="button3" @click="dialogText1 = false">取 消</el-button>
                                        <el-button class="button2" @click="addModel">确 定</el-button>
                                    </div>
                                </el-dialog>
                                <el-button class="button4" @click="dialogText = true" style="background-color:#E95513">部署网络</el-button>

                                &nbsp;&nbsp;
                                <el-button class="button4"  @click="delectModel" >删除</el-button>
                            </div><!--table-1-1-->
                            <div class="tab-1-2">
                                <el-table
                                        :header-cell-style="{background:'#E95513',padding:0,color:'#FFFFFF'}"
                                        class="table1"
                                        row-style="30px"
                                        cell-style="padding:0"
                                        id="table11"
                                        :data="modeldata.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                                        @selection-change="handleSelectionChange"
                                        style="width: 100%"><!--表的名字-->
                                    <!-- 选择框   -->
                                    <el-table-column
                                            type="selection"
                                            width="55">
                                    </el-table-column>
                                    <el-table-column
                                            prop="index"
                                            width="130"
                                            label="编号"
                                            :index="indexMethod">
                                    </el-table-column>
                                    <el-table-column
                                            prop="modelName"
                                            label="模板名"
                                            width="250">
                                    </el-table-column>
                                    <el-table-column
                                            prop="operation"
                                            label="操作">
                                        <template slot-scope="scope">
                                            <el-button
                                                    type="text"
                                                    size="mini"
                                                    style="font-weight: bold"
                                                    @click="getModuleDetail(scope.row.modelName)">查看详情</el-button>
                                            <el-dialog title="查看详情" :visible.sync="dialog">
                                                <div class="parent_div">
                                                    <div class="div_table">
                                                       <span class="table_cell">模板名称</span>
                                                        <span class="table_cell table_cell_right">{{selectModuleData.modelName}}</span>
                                                    </div>
                                                    <div v-for="item in selectModuleData.models" class="div_table" >
                                                        <span class="table_cell">IP</span>
                                                        <span class="table_cell table_cell_right">{{item.ip}}</span><br>
                                                        <span class="table_cell">服务器</span>
                                                        <span class="table_cell table_cell_right">{{item.server}}</span><br>
                                                        <span class="table_cell">蜜罐类型</span>
                                                        <span class="table_cell table_cell_right">{{item.type}}</span>

                                                    </div>

                                                </div>
                                                <div slot="footer" class="dialog-footer">
                                                    <el-button class="button3" @click="dialog = false">取 消</el-button>
                                                    <el-button class="button2" @click="dialog = false">确 定</el-button>
                                                </div>
                                            </el-dialog>
                                        </template>

                                    </el-table-column>
                                </el-table>
                            </div><!--table-1-2-->
                        </div><!--table-1-->
                        <div class="p-page" style="font-size: 12px;padding-left: 34px"><span  style="position: relative;top: 10px;">显示第{{(currentPage-1) * pagesize +1}}
                        到第{{((currentPage * pagesize)<(modeldata.length))?currentPage * pagesize:modeldata.length}}条记录，
                        总共{{modeldata.length}}条记录</span>
                            <span style="position: relative;left: 33px;font-size: 12px;top: 10px;">每页显示</span>
                            <el-select v-model="pagesize" slot="prepend" placeholder="" id="pagesize" style="width: 65px;height: 30px;border-radius: 0px;font-size: 12px;left: 35px;top: 10px;">
                                <el-option label="10" value="10"></el-option>
                                <el-option label="20" value="20"></el-option>
                            </el-select>
                            <span style="margin-left:2px;position: relative;left: 32px;top: 10px;">条信息<span style="margin-left: 20px">转到<el-input  v-model="jumper" style="width: 50px;height: 30px;margin-left: 2px;margin-right: 4px"></el-input>页</span><el-button class="button2" style="font-size: 12px;" @click="handleCurrentChange(jumper)">跳转</el-button></span>

                        </div>
                        <div style="float:right;margin-top:10px;margin-right: 30px;">
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
                                    :total="modeldata.length"
                                    layout="slot,prev, pager, next,total" >
                                <!-- <slot name="as">dddd</slot> -->
                            </el-pagination>
                        </div>
                    </el-tab-pane>
                    <!-- 服务器配置 -->
                    <el-tab-pane label="服务器配置">
                        <div class="tab-2">
                            <div class="tab-2-1">
                                <el-button class="button4" @click="dialogFormVisible = true" >添加服务器</el-button>
                                <el-dialog title="添加服务器" :visible.sync="dialogFormVisible">
                                    <el-form :model="form">
                                        <el-form-item label="服务器名称" :label-width="formLabelWidth">
                                            <el-input v-model="addServerForm.server" auto-complete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="服务器IP" :label-width="formLabelWidth">
                                            <el-input v-model="addServerForm.serverIp" auto-complete="off"></el-input>
                                        </el-form-item>
                                    </el-form>
                                    <div slot="footer" class="dialog-footer">
                                        <el-button class="button3" @click="dialogFormVisible = false">取 消</el-button>
                                        <el-button class="button2" @click="addServer">确 定</el-button>
                                    </div>
                                </el-dialog>
                                &nbsp;&nbsp;
                                <el-button class="button4"  @click=delectServer>删除</el-button>
                                &nbsp;&nbsp;
                            </div><!--table-2-1-->

                            <div class="tab-2-2">
                                <el-table
                                        :header-cell-style="{background:'#E95513',padding:0,color:'#FFFFFF'}"
                                        class="table1"
                                        row-style="30px"
                                        cell-style="padding:0"
                                        id="table21"
                                        :data="serverData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                                        @selection-change="handleSelectionChange"
                                        style="width: 100%"><!--表的名字-->
                                    <!-- 选择框   -->
                                    <el-table-column
                                            type="selection"
                                            width="55">
                                    </el-table-column>
                                    <el-table-column
                                            prop="id"
                                            width="130"
                                            label="编号"
                                            :index="indexMethod">
                                    </el-table-column>
                                    <el-table-column
                                            prop="server"
                                            label="服务器名"
                                            width="250">
                                    </el-table-column>
                                    <el-table-column
                                            prop="serverIp"
                                            label="服务器IP">
                                    </el-table-column>
                                </el-table>
                            </div><!--table-2-2-->
                            <div class="p-page" style="font-size: 12px;padding-left: 34px"><span style="position: relative;top: 10px">显示第{{(currentPage-1) * pagesize +1}}到第{{((currentPage * pagesize)<(serverData.length))?currentPage * pagesize:serverData.length}}条记录，总共{{serverData.length}}条记录</span>
                                <span style="position: relative;left: 33px;font-size: 12px;top: 10px">每页显示</span>
                                <el-select v-model="pagesize" slot="prepend" placeholder="" id="pagesize" style="width: 65px;height: 30px;border-radius: 0px;font-size: 12px;left: 35px;top: 10px">
                                    <el-option label="10" value="10"></el-option>
                                    <el-option label="20" value="20"></el-option>
                                </el-select>
                                <span style="margin-left:2px;position: relative;left: 32px;top: 10px;">条信息<span style="margin-left: 20px">转到<el-input  v-model="jumper" style="width: 50px;height: 30px;margin-left: 2px;margin-right: 4px;"></el-input>页</span><el-button class="button2" style="font-size: 12px;" @click="handleCurrentChange(jumper)">跳转</el-button></span>

                            </div>
                            <div style="float:right;margin-right: 30px;position: relative;top: -20px">
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
                                        :total="serverData.length"
                                        layout="slot,prev, pager, next,total" >
                                    <!-- <slot name="as">dddd</slot> -->
                                </el-pagination>
                            </div>



                        </div>
                    </el-tab-pane>

                    <!-- 原始日志查询 -->
                    <el-tab-pane label="网络拓扑"><!--写了部分代码，但是一直没有出现树形图-->
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
        color: #5ebf18;
    ;}

    /* *********************************************mian start*****************/
    /* 绿色字体 */

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
    .el-pagination__sizes .el-input .el-input__inner:hover {
        border-color: #fff;
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

    /*导航栏样式*/
    .el-table th>.cell {
        background: #e95513;
        color: #fff;
        /*border-right: 1px solid #fff;*/
        font-size: 12px;

        vertical-align: center;
        padding-left: 20px;
        margin-bottom: 0px;
        /* line-height: initial; */
    }
    .el-table th{
        height: 29px;
        border-right: 1px solid #fff;
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
    .el-input__suffix{
        height: 30px;
    }
    .el-input__inner{
        line-height: 30px;
        height: 30px;
    }

    .el-icon-arrow-up{
        line-height: 10px;
        height: 30px;
    }
    .is-reverse{
        line-height: 30px;
        height: 30px;
    }
    html {
        overflow-y:hidden;
        overflow-x:hidden;
        overflow: hidden;

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
    .el-table__body, .el-table__footer, .el-table__header{

        font-size: 12px;
    }

    .el-table__body, .el-table__footer, .el-table__header{
        font-size: 12px;
    }
    .table-p1{
        font-family: 'Microsoft YaHei';
        font-size: 12pt;
        color:#BFBFBF;
    }
    /* ******原始日志查询-左侧菜单栏 start*/
    .tab-aside{
        height: 100%;
        overflow: hidden;

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
    /*----------------------------------------------------------------------------------------------------------------新加不能删    */
    .el-main-2{
        padding: 2px !important;
    }
    .set-net > .el-input__inner {
        width: 70%;
    }
    /*节点配置里面,查询详情的样式*/
    .table_cell{
        padding-left: 10px;
        background-color: #EDEDED;
        display: inline-block;
        border: 1px solid #d0cccc;
        width: 180px;
        height:34px;
        text-align: left;
        line-height: 34px;
    }
    .table_cell_right{
        position: relative;
        left: -5px;
        width: 450px;
    }
    .div_table {
        margin: 6.5px 0px 10px 0px;
    }
    .parent_div {
        margin: 0px 13% 0px 13%;
    }


</style>
<script>
    import '../assets/css/new.css'
export default {

      data () {
        return {
          selectModuleData: {},
          form1: {
            name: '',
            IP: '',
            honeyTypeValue1: '',
            honeyTypeValue2: '',
            serverTypeValue: ''
          },
          honeyType1: [{
            value: 'hostPot',
            label: '主机蜜罐'
          },
          {
            value: 'applyPot',
            label: '应用蜜罐'
          }],
          honeyType2: [],
          hostPot: [{
            value: '1',
            label: 'win732'
          }, {
            value: '2',
            label: 'win764'
          },
          {
            value: '3',
            label: 'centos'
          }],
          applyPot: [{
            value: '4',
            label: '路由器蜜罐'
          },
          {
            value: '5',
            label: '复合蜜罐'
          }],
          serverType: [{
            serverIp: '192.168.1.1',
            server: '服务器'
          }],
          jumper: 1,
          pagesize: 10,
          chartData: [
            {
              IP: '168.196.2.1',
              user: 'win789',
              temserver: 'server1'
            },
            {
              IP: '168.196.2.1',
              user: 'win789',
              temserver: 'server2'
            },
            {
              IP: '168.196.2.1',
              user: 'win789',
              temserver: 'server1'
            },
            {
              IP: '168.196.2.1',
              user: 'win789',
              temserver: 'server2'
            }
          ],
          modeldata: [
            {
              template: 'centos+pot'
            }
          ],
          multipleSelection: [],

          currentPage: 1,
          currentPage1: 5,
          currentPage2: 5,
          currentPage3: 5,
          currentPage4: 4,
          dialogFormVisible: false,
          dialogText1: false,
          dialogText: false,
          dialog: false,
          forms: [{
            name: '',
            ip: '',
            server: '',
            type: '',
            serverIp: '',
            serverId: ''
          }],
          formLabelWidth: '120px',
          // 表的名字
          serverData: [
            {
              IP: '168.196.2.1',
              template: '123',
              user: 'win789',
              temserver: 'server1'
            }
          ],
          addServerForm: {
            server: '',
            serverIp: ''
          }
        }
      },
      mounted () {
        this.getModel()
        this.getServer()
      },

      methods: {
        // 获取模板详细信息方法
        getModuleDetail (modelName) {
          this.dialog = true
          for (var i = 0; i < this.modeldata.length; i++) {
            if (modelName === this.modeldata[i].modelName) {
              for (var j = 0; j < this.modeldata[i].models.length; j++) {
                if (this.modeldata[i].models[j].server == null) {
                  this.modeldata[i].models[j].server = '未设置'
                }
              }
              var json = this.modeldata[i]
              break
            }
          }
          this.selectModuleData = json
        },
        // 删除一个蜜罐模板
        delHoneypot () {
          this.forms.pop()
        },
        // 添加一个蜜罐模板
        addHoneypot () {
          var json = {
            name: '',
            ip: '',
            server: '',
            type: '',
            serverIp: '',
            serverId: ''
          }
          this.forms.push(json)
        },
        // 蜜罐类型二级分类方法
        changeType (type) {
          // alert(type)
          if (type === 'hostPot') {
            this.honeyType2 = this.hostPot
          } else if (type === 'applyPot') {
            this.honeyType2 = this.applyPot
          }
        },
        // 增加模板的方法
        addModel () {
          var jsondata = []
          for (var i = 0; i < this.forms.length; i++) {
            this.forms[i].name = this.moduleName
            for (var j = 0; j < this.serverData.length; j++) {
              if (this.forms[i].serverIp === this.serverData[j].serverIp) {
                this.forms[i].server = this.serverData[j].server
                this.forms[i].serverId = this.serverData[j].id
              }
            }
            jsondata.push(this.forms[i])
          }
          var that = this
          this.$axios.post('/addModel', jsondata).then(function (response) {
            alert('模板添加成功')
            var json = [{
              name: '',
              ip: '',
              server: '',
              type: '',
              serverIp: '',
              serverId: ''
            }]
            that.modelName = ''
            that.forms = json
            that.getModel()
          })
          that.dialogText1 = false
        },
        // 获取表格选中项信息的方法
        handleSelectionChange (val) {
          this.multipleSelection = val
        },
        // 处理分页的两个方法
        handleSizeChange (size) {
          this.pagesize = size
        },
        handleCurrentChange (currentPage) {
          this.currentPage = currentPage
        },
        // 删除服务器方法
        delectServer () {
          var that = this
          var json = []
          for (var i = 0; i < this.multipleSelection.length; i++) {
            json.push(this.multipleSelection[i].id)
          }
          this.$axios.post('/delServer', json).then(function (response) {
            alert('删除成功')
            that.getServer()
          })
        },
        // 获取所有服务器方法
        getServer () {
          var that = this
          this.$axios.get('/getAllServer').then(function (response) {
            that.serverData = response.data.serverList
            that.serverType = response.data.serverList
          })
        },
        // 添加服务器方法
        addServer () {
          var that = this
          this.$axios.post('/addServer?serverIp=' + that.addServerForm.serverIp + '&' + 'server=' + that.addServerForm.server + '&' + 'id=' + (that.serverData.length + 1)).then(function (response) {
            alert('服务器添加成功')
            that.dialogFormVisible = false
            that.getServer()
          })
          that.addServerForm.server = ''
          that.addServerForm.serverIp = ''
        },
        // 获取模板列表方法
        getModel () {
          var that = this

          this.$axios.post('/getModelList').then(function (response) {
            that.modeldata = response.data
          })
        },
        // 删除模板方法
        delectModel () {
          var that = this
          var json = []
          for (var i = 0; i < this.multipleSelection.length; i++) {
            json.push(this.multipleSelection[i].id)
          }

          this.$axios.post('/delectModel', json).then(function (response) {
            if (response.data) {
              alert('删除成功')
              that.getModel()
            }
          })
        },
        // 原来删除键的方法
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
        hidePopoverPanel () {
          this.popoverPanelShow = false
        }

      }
    }
</script>
