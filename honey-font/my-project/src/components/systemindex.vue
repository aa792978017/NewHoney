<template>
<div style="height: 95%;width: 100%">
    <div class="biggest"  >
        <el-header height=80px; >
            <div class="header-1">

                <p class="ps-1">

                    <el-dropdown>
                      <span class="el-dropdown-link" >
                          <span class="smallpeople">
                            <img src="../assets/smallpeople.png"/></span>
                            <span style="color:grey ;font-size:14pt">{{identityName}}</span>
                      </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item><router-link to="/updatepassword" style="text-decoration: none;">修改密码</router-link></el-dropdown-item>
                            <el-dropdown-item v-if="dialog" style="padding: 0px"><a @click="loginOut" style="text-decoration: none; width: 100%; height: 100%;padding: 20px" >注销账号</a></el-dropdown-item>
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
              =
                </div>
                <!-- <i class="el-icon-minus"></i> <i class="el-icon-close"></i>     减号和X号 -->
            </div>
        </el-header>



        <!--<div class="page">-->
            <!--<img class="logo"  src="../assets/elex.png"/>-->
        <!--</div>-->
        <div style="float:right    ">

        </div>
        <div class="login" v-if="wheatherLogin">
            <div style="height:77px;font-size:20px;">
                <img src="../assets/biaoti.png" style="height: 77px; display: inline-block"/>

                <!--<span style="font-size:20px;text-align:center;position: relative;top: 25%;transform:translateY(-25%); color: white">博智蜜罐系统</span>-->

                <div style="height: 77px;display: inline-block;line-height: 77px;position: relative;top: -31px">
                    <span  class="span_biaoti" style="color: white;">博智蜜罐系统</span>
                </div>
            </div>

            <div class="first">
                <img  class="name" src="../assets/name.png" style=""/>
                <el-input class="common_input" size="large" v-model="username" style="width:270px" ></el-input>
            </div>

            <div class="second">
                <img  class="password" src="../assets/password.png" style=""/>
                <el-input class="common_input" v-model="password" style="width:270px;top:5px" type="password"></el-input>
            </div>

            <div class="ss">&nbsp;&nbsp;&nbsp;&nbsp;
                <el-button  type="danger" class="loginbutton" style="width:273px" @click="login" >&nbsp;&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;</el-button>
            </div>

        </div>
        <div class="login" v-if="!wheatherLogin" style="color: #ffffff">
            <p>已登入</p>
            <router-link to="Checkstatus1"> 进入系统</router-link>
        </div>
    </div>
    <div class="footer-1" style=" float: bottom;">
        <p class="footer-p"> <i class="el-icon-info"></i>&nbsp;&nbsp;&nbsp;监测状态：</p>
        <p class="footer-p2">登录时间:&nbsp;&nbsp;{{date|formatDate}}</p>

    </div>
</div>
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
        color:#76EE00;
    ;}

    .loginbutton{
        background-color:#e95513;
        color: #eeeeee;
        margin-top: 20px;
    }

    .biggest{
        background:url("../assets/indexbackground.png");
        width:100%;
        height:100%;
    }
    .page{
        position: relative;
        top:120px;
    }
    .login{
        /*background:url("../assets/indexbackground.png");*/
        position: relative;
        left: 1238px;
        top: 200px;
    }
    .name{
        position: relative;
        top:18px;
        width: 40px;height: 40px
    }
    .password{
        position: relative;
        top:20px;
        right:1px;
        width: 40px;height: 40px
    }

    .ss{
        position: relative;
        top:15px;
        left:29px;
    }
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
        height: 80px;
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




</style>

<script>
    import '../assets/css/new.css'
import { formatDate } from './common/date.js'

export default {
      data () {
        return {
          dialog: false,
          date: {},
          username: '',
          password: '',
          identityName: '未登录',
          wheatherLogin: true
        }
      },
      // mounted () {
      //   if (sessionStorage.getItem('username') !== null) {
      //     this.wheatherLogin = false
      //     console.log(this.wheatherLogin)
      //   }
      // },
      mounted: function () {
        if (sessionStorage.getItem('username') !== null) {
          this.wheatherLogin = false
          this.dialog = true
          this.identityName = sessionStorage.getItem('username')
          console.log(this.wheatherLogin)
        }
        var _this = this
        setInterval(function () {
          _this.date = new Date() // 修改数据date
        }, 1000)
      },
      methods: {
        loginOut () {
          this.dialog = !this.dialog
          this.wheatherLogin = !this.wheatherLogin
          this.identityName = '未登录'
          sessionStorage.clear()
          console.log(sessionStorage.getItem('username'))
          window.location.href = '#/Checkstatus1'
        },
        // 用户登录
        login () {
          var that = this
          var json = {
            'username': this.username,
            'password': this.password
          }
          this.$axios.post('/login', json).then(function (response) {
            if (response.data.statusCode === 200) {
              sessionStorage.setItem('username', response.data.username)
                sessionStorage.setItem('authority', response.data.authority)
              that.dialog = true
              alert('登录成功，准备跳转页面')
              // if (response.data.authority === 1) {
              //   window.location.href = '#/Checkstatus1'
              // } else {
              //   window.location.href = '#/userindex/Checkstatus1'
              // }
                window.location.href = '#/Checkstatus1'
            } else {
              alert(response.data.message)
              if (response.data.statusCode === 1) {
                window.location.href = '#/updatepassword'
              }
            }
            that.username = ''
            that.password = ''
          })
        }
      },
      // 设置当前时间
      filters: {
        formatDate (time) {
          // var data = new Date(time)
          return formatDate(time, 'yyyy-MM-dd hh:mm')
        }
      }

    }
</script>

