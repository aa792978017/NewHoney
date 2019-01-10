<template>
    <el-container style="height:100%; width:100% ;overflow-y:hidden; " direction="vertrcal">
        <!--******************************* head -->
        <!--<el-header height=80px; >-->
      <div class="header-1">

          <p class="ps-1">

               <el-dropdown>
                  <span class="el-dropdown-link" >
                      <span class="smallpeople">
                        <img src="../assets/smallpeople.png"/></span>
                        <span style="color:grey ;font-size:14pt">{{identityName}}</span>&nbsp;&nbsp;
                  </span>
                   <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item><router-link to="updatepassword" style="text-decoration: none;">修改密码</router-link></el-dropdown-item>
                        <el-dropdown-item style="padding: 0px"><router-link to="systemindex" style="text-decoration: none; width: 100%; height: 100%;padding: 20px" >注销账号</router-link></el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
                <el-dropdown>
                    <span class="el-dropdown-link">
                        <i class="el-icon-tickets"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item>资质</el-dropdown-item>
                        <el-dropdown-item>帮助</el-dropdown-item>
                        <el-dropdown-item>关于</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>

          </p>
             <div class="lefttop" style="overflow: hidden;height: 85px;margin-right: 500px">
              <!--<img src="../assets/lefttop.png"/>-->
               <img src="../assets/elex.png" style="width:80px;height: 80px;margin-left: 5px;overflow-y: hidden"/>
                 <div style="height: 77px;display: inline-block;line-height: 77px;position: relative;top: -31px">
                     <span  class="span_biaoti" style="color: white;">博智蜜罐系统</span>
                 </div>
          </div>



          <!-- <i class="el-icon-minus"></i> <i class="el-icon-close"></i>     减号和X号 -->
          </div>


      <!--</el-header>-->
    <el-main class="ttt">
        <router-view></router-view>
    </el-main>
  <el-footer class="nmd">
      <hr class="image"/>


         <el-menu
       :default-active="$route.name"
       background-color=""
       mode="horizontal"
       active-text-color="#5EBF18"

       @select="handleSelect"
        router
        class="font"
       >
    <el-menu-item  index="systemindex"><p class="menu-1" style="font-size:18pt"><i class="iconfont">&#xe61f;</i>系统主页</p></el-menu-item>
    <el-menu-item index="Checkstatus1" ><p class="menu-1" style="font-size:18pt"><i class="iconfont">&#xe61a;</i>监测状态</p></el-menu-item>
    <el-menu-item index="honeybuild" ><p class="menu-1" style="font-size:18pt"><i class="iconfont">&#xe603;</i>蜜网构建</p></el-menu-item>
    <el-menu-item index="applyhoney"><p class="menu-1" style="font-size:18pt"><i class="iconfont">&#xe651;</i>应用蜜罐</p></el-menu-item>
    <el-menu-item index="Hosthoneypot"><p class="menu-1" style="font-size:18pt"><i class="iconfont">&#xe652;</i>主机蜜罐</p></el-menu-item>
    <el-menu-item index="Operator"><p class="menu-1" style="font-size:18pt"><i class="iconfont">&#xe652;</i>样本操作</p></el-menu-item>
    <el-menu-item index="honeycontrol"><p class="menu-1"  style="font-size:18pt" ><i class="iconfont">&#xe606;</i>平台管理</p></el-menu-item>
    </el-menu>
    <div class="footer-1">
        <p class="footer-p"> <i class="el-icon-info"></i>&nbsp;&nbsp;&nbsp;监测状态：</p>
        <p class="footer-p2">登录时间:&nbsp;&nbsp;{{date|formatDate}}</p>

    </div>


  </el-footer>
</el-container>
</template>
<style scoped>

    header.el-header
    {
        padding-left: 0px;
        padding-right: 0px;
    }


    @font-face {
        font-family: 'iconfont';  /* project id 789791 */
        src: url('//at.alicdn.com/t/font_789791_1n8tl020l1l.eot');
        src: url('//at.alicdn.com/t/font_789791_1n8tl020l1l.eot?#iefix') format('embedded-opentype'),
        url('//at.alicdn.com/t/font_789791_1n8tl020l1l.woff') format('woff'),
        url('//at.alicdn.com/t/font_789791_1n8tl020l1l.ttf') format('truetype'),
        url('//at.alicdn.com/t/font_789791_1n8tl020l1l.svg#iconfont') format('svg');
    }
    .iconfont{
        font-family:"iconfont" !important;
        font-size:36px;font-style:normal;
        -webkit-font-smoothing: antialiased;
        -webkit-text-stroke-width: 0px;
    ;}


    /* ***********************head开始*********************** */
    /* 黑色条框 */
    html {
        overflow-y:hidden;
        overflow-x:hidden;
        margin-left: 0px;
    }
    hr{
        margin-top: 0px;
    }
    .ttt{
        padding: 0px;
    }
    .smallpeople{
        position: relative;
        top:6px;
    }
    .el-dropdown-link{
        position: relative;
        bottom:5px;
    }
    div.lefttop{
        text-align: left;
        margin-right:1600px;
        position: relative;
        bottom:45px;

    }
    .nmd{
        padding:0;
    }

    .header-1{
        text-align: right;
        background:url("../assets/back.jpg");
        /*color: rgb(252, 249, 249);*/
         height: 96px;
        font-family: "微软雅黑";
        width: 100%;
    }
    /* 黑色管理员 */
    .el-dropdown-link{
        color: rgb(252, 249, 249);
        font-size: 14pt;
    }
    .ps-1{
        position: relative;
        right:80px;
        top: 27px;
    }
    /* ***********************************head end */

    /* ****************************************foot */
    .menu-1{
        font-size: 15pt;
        font-weight: normal;
        margin: 0;
    }
    .footer-2,.footer-1{
        width: 100%;
        height: 25px;
        margin: 0;
        background-color: #515151;
    }

    .footer-p{
        margin: 0;
        position: relative;
        left: 35px;
        top:4px;
        font-size: 12px;
        font-family: 'Microsoft YaHei';
        color:aliceblue;
        float: left;
    }
    .footer-p2{
        position: relative;
        right: 35px;
        top:4px;
        font-size: 12px;
        font-family: 'Microsoft YaHei';
        color:aliceblue;
        margin: 0;
        float: right;
    }
    .el-footer{

        margin-bottom:40px;


    }
    .span_biaoti{

        font-size: 20px;
        display: inline-block;
        margin-left: 10px;
        vertical-align: center;

    }
    /* ***************************************foot end */
</style>
<script>
import { formatDate } from './common/date.js'
export default {
  data () {
    return {
      date: {},
      identityName: '未登录'
    }
  },
  mounted () {
    this.$nextTick(function () {
      if (sessionStorage.getItem('username') !== null) {
        console.log(sessionStorage.getItem('username'))
        this.identityName = sessionStorage.getItem('username')
      }
    })

    var _this = this
    setInterval(function () {
      _this.date = new Date() // 修改数据date
    }, 1000)
  },
  method: {
    // 设置身份信息
    // setUserType () {
    //   if (sessionStorage.getItem('username') !== null) {
    //     this.identityName = sessionStorage.getItem('username')
    //   }
    //   // var j = 1
    //   // alert(j)
    //   // if (j) {
    //   //   this.identityName = '系统管理员[SysAdmin]'
    //   // } else {
    //   //   this.identityName = '普通用户[ComUser]'
    //   // }
    // },
    // // 清除用户名
    // cleanUserName () {
    //   sessionStorage.setItem('username', '0')
    //   window.location.href = '#/systemindex'
    // },
    // 获取用户信息
    getUser () {
      this.$axios.get('/getuser')
        .then(function (response) {
          var jsondata = []
          jsondata = response.data
          alert(jsondata[0].username)
        })
        .then(function () {
        })
    }
  },

  // 获取当前日期
  filters: {
    formatDate (time) {
      return formatDate(time, 'yyyy-MM-dd hh:mm')
    }
  }

}
</script>
