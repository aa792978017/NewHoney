<template>

    <el-main class="m-table">
      <el-table
        :header-cell-style="{background:'#E95513',padding:0,color:'#FFFFFF'}"
        class="table1"
        row-style="30px"
        cell-style="padding:0"
        id="table11"
        @selection-change="getAlarmExtendInfo"
        :data="Alarminfo.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        style="width: 100%">
        <!-- <el-table-column
          type="selection"
          width="55">
        </el-table-column> -->
        <el-table-column
          prop="num"
          width="80"
          label="序号">
        </el-table-column>
        <el-table-column
          prop="id"
          width="80"
          label="id">
        </el-table-column>
        <el-table-column
          prop="processName"
          label="进程名称"
          width="150">
        </el-table-column>
        <el-table-column
          prop="path"
          label="路径"
          width="500">
        </el-table-column>
        <el-table-column
          prop="explain1"
          label="说明"
          width="200">
        </el-table-column>
        <el-table-column
          prop="time"
          label="操作时间">
        </el-table-column>
        <el-table-column
          prop="operater"
          label="基本操作">
          <template slot-scope="scope">
            <el-button 
              type="text"
              size="mini"
              @click="getAlarmExtendInfo(scope.$index,Alarminfo)">详细信息</el-button>
          </template>
        </el-table-column>
      </el-table>
          <div class="p-page" style="font-size: 12px;padding-left: 34px;margin-top:15px">显示第{{(currentPage-1) * pagesize +1}}到第{{((currentPage * pagesize)<(Alarminfo.length))?currentPage * pagesize:Alarminfo.length}}条记录，总共{{Alarminfo.length}}条记录
            <span style="position: relative;left: 33px;font-size: 12px;">每页显示</span>
            <el-select v-model="pagesize" slot="prepend" placeholder="" id="pagesize" style="width: 65px;height: 30px;border-radius: 0px;font-size: 12px;left: 35px;">
              <el-option label="10" value="10"></el-option>
              <el-option label="20" value="20"></el-option>
            </el-select>
            <span style="margin-left:2px;position: relative;left: 32px">条信息<span style="margin-left: 20px">转到<el-input  v-model="jumper" style="width: 50px;height: 30px;margin-left: 2px;margin-right: 4px"></el-input>页</span><el-button class="button2" style="font-size: 12px;" @click="handleCurrentChange(jumper)">跳转</el-button></span>
          
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
              :total="Alarminfo.length"
              layout="slot,prev, pager, next">
              <!-- <slot name="as">dddd</slot> -->
            </el-pagination>
          </div>
        </div>
      <el-table
        :header-cell-style="{background:'#E95513',padding:0,color:'#FFFFFF'}"
        class="table1"
        row-style="30px"
        cell-style="padding:0"
        id="table11"
        :data="Alarmextendinfo.slice((currentPage2-1)*pagesize2,currentPage2*pagesize2)"
        style="width: 100%;margin-top:30px">
        <el-table-column
          prop="num"
          width="80"
          label="序号">
        </el-table-column>
        <el-table-column
          prop="id"
          width="80"
          label="id">
        </el-table-column>
        <el-table-column
          prop="uniqueId"
          width="150"
          label="uniqueId">
        </el-table-column>
        <el-table-column
          prop="opType"
          label="操作类型"
          width="150">
        </el-table-column>
        <el-table-column
          prop="processName1"
          label="进程名称1"
          width="150">
        </el-table-column>
        <el-table-column
          prop="path"
          label="路径"
          width="500">
        </el-table-column>
        <el-table-column
          prop="processName2"
          label="进程名称2"
          width="150">
        </el-table-column>
        <el-table-column
          prop="time"
          label="操作时间">
        </el-table-column>
       
      </el-table>
      <div class="p-page" style="font-size: 12px;padding-left: 34px;margin-top:15px">显示第{{(currentPage2-1) * pagesize2 +1}}到第{{((currentPage2 * pagesize2)<(Alarmextendinfo.length))?currentPage2 * pagesize2:Alarmextendinfo.length}}条记录，总共{{Alarmextendinfo.length}}条记录
            <span style="position: relative;left: 33px;font-size: 12px;">每页显示</span>
            <el-select v-model="pagesize2" slot="prepend" placeholder="" id="pagesize" style="width: 65px;height: 30px;border-radius: 0px;font-size: 12px;left: 35px;">
              <el-option label="10" value="10"></el-option>
              <el-option label="20" value="20"></el-option>
            </el-select>
            <span style="margin-left:2px;position: relative;left: 32px">条信息<span style="margin-left: 20px">转到<el-input  v-model="jumper2" style="width: 50px;height: 30px;margin-left: 2px;margin-right: 4px"></el-input>页</span><el-button class="button2" style="font-size: 12px;" @click="handleCurrentChange2(jumper2)">跳转</el-button></span>
          
            <div style="float:right;margin-top:10px;margin-right: 30px;">
              <!-- *********************************分页按钮 -->
            <el-pagination
              background="#E95513"
              prev-text="上一页"
              next-text="下一页"
              jumper-text="转到"
              @size-change="handleSizeChange2"
              @current-change="handleCurrentChange2"
              :current-page="currentPage2"
              :page-sizes="[10, 20]"
              :page-size="pagesize2"
              :total="Alarmextendinfo.length"
              layout="slot,prev, pager, next">
              <!-- <slot name="as">dddd</slot> -->
            </el-pagination>
          </div>
        </div>
    </el-main>

</template>
<style scoped>
  /* .table1 td{
          padding: 0;
          height: 30px;
  } */
  /*删除 添加的颜色*/
  .el-button--text{
        color:#E95513;
    }
 /*布局对齐*/
  .el-row {
    margin-bottom: 0px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #ffffff;
  }
  .bg-purple {
    background: #ffffff;
  }
  .bg-purple-light {
    background: #ffffff;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 10px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #ffffff;
  }

  .m-table{
    width: 100%;
    height: 100%;
  }
  .h-input{
    width: 100%;
  }
  .p-page{
    font-size: 12pt;
  }
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
</style>
<script>
    import '../../assets/css/new.css'
export default {
    data () {
        return {
          jumper: 1,
          pagesize: 10,
          currentPage: 1,
          jumper2: 1,
          pagesize2: 10,
          currentPage2: 1,
          dialog: false,
          dialogFormVisible: false,
          dialogText: false,
          dialogTable: false,
          detailshow: false,
          Alarminfodata: {
            processname: '',
            time: '',
            id: '',
            explain: '',
            uniqueId:'',
            type:'',
            path:'',
            opType:'',
            processname1: '',
            processname2: ''
          },
          Alarmextendinfo:[],
          Alarminfo:[],
          multipleSelection:[]
        }
    },
  created () {
        this.getAlarmInfo()
    },
  mounted: function () {
        this.getAlarmInfo()

  },

    methods: {
      getAlarmInfo() {
           var that = this
     this.$axios.get('/getAlarmInfo', {
             params: {
               uniqueId: sessionStorage.getItem('uniqueId'),
               type: '13'
             }
     })
             .then(function (response) {
               that.Alarminfo = response.data
               for(var i=1;i<response.data.length+1;i++)
              {
                that.Alarminfo[i-1].num=i
              }
             })
             .catch(function (error) {
               alert('handle error')
               console.log(error)
             })
             .then(function () {
             })
    },
    getAlarmExtendInfo(index,rowdata) {
           var that = this
     this.$axios.get('/getAlarmExtendInfo', {
             params: {
               id:rowdata[index].id//'866'
             }
     })
             .then(function (response) {
               that.Alarmextendinfo = response.data
               for(var i=1;i<response.data.length+1;i++)
              {
                that.Alarmextendinfo[i-1].num=i
              }
             })
             .catch(function (error) {
               alert('handle error')
               console.log(error)
             })
             .then(function () {
             })
    },
     // 分页
    handleSizeChange (size) {
      this.pagesize = size
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (currentPage) {
      this.currentPage = currentPage
      console.log(`当前页: ${val}`)
    },
    // 分页2
    handleSizeChange2 (size2) {
      this.pagesize2 = size2
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange2 (currentPage2) {
      this.currentPage2 = currentPage2
      console.log(`当前页: ${val}`)
    },
    handleSlect (key, keypath) {
      this.$emit('updata:activ', key)
    },
    indexMethod (index) {
      return index
    },
  onSubmit () {
    console.log('submit!')
    }
    }
}
</script>
