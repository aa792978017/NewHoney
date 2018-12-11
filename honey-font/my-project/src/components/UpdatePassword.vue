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
                            <span style="color:grey ;font-size:14pt">{{identityName}}</span>&nbsp;{{administrator}}&nbsp;
                      </span>
                            <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item><router-link to="systemindex" style="text-decoration: none;">登录账户</router-link></el-dropdown-item>
                            <el-dropdown-item><router-link to="updatepassword" style="text-decoration: none;">忘记密码</router-link></el-dropdown-item>
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
                    <div class="lefttop"style="overflow: hidden;height: 78px;margin-right: 500px">
                        <!--<img src="../assets/lefttop.png"/>-->
                        <img src="../assets/elex.png" style="width:333px;height: 77px;margin-left: 5px;overflow-y: hidden"/>
                    </div>
                    <!-- <i class="el-icon-minus"></i> <i class="el-icon-close"></i>     减号和X号 -->
                </div>
            </el-header>



            <!--<div class="page">-->
                <!--<img class="logo"  src="../assets/elex.png"/>-->
            <!--</div>-->
            <div class="login"  >
                <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="用户名" prop="username" >
                        <el-input v-model.number="ruleForm2.username" style="width: 400px;height: 40px;color: #E95513"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="ruleForm2.password" autocomplete="off" style="width: 400px;height: 40px"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="checkPass">
                        <el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off" style="width: 400px;height: 40px"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="submitForm" style="width: 193px">确认</el-button>
                        <el-button @click="resetForm" style="width: 193px">重置</el-button>
                    </el-form-item>
                </el-form>

                <!--<div class="ss">&nbsp;&nbsp;&nbsp;&nbsp;-->
                    <!--<el-button  type="danger" class="loginbutton" style="width:400px;position: relative;left: -56px" @click="login" >&nbsp;&nbsp;&nbsp;&nbsp;确认&nbsp;&nbsp;&nbsp;</el-button>-->
                <!--</div>-->

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
        position: relative;
        left:1100px;
        margin-top: 280px;
        /*top:px;*/
    }
    .name{
        position: relative;

    }
    .password{
        position: relative;
        top:20px;
        right:8px;
    }

    .ss{
        position: relative;
        top:15px;
        left:30px;
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
    /*账号密码框文字样式*/
    .updatepassword{
        color: #E95513;
        display: block;
        margin: 10px 5px 10px 0px
    }
    .login {

    }



</style>

<script>
    import '../assets/css/new.css'
    import { formatDate } from './common/date.js'

    export default {
      data () {
        // 把两次输入的密码校验
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'))
          } else {
            if (this.ruleForm2.checkPass !== '') {
              this.$refs.ruleForm2.validateField('checkPass')
            }
            callback()
          }
        }
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'))
          } else if (value !== this.ruleForm2.password) {
            callback(new Error('两次输入密码不一致!'))
          } else {
            callback()
          }
        }
        return {
          date: {},
          username: '',
          password: '',
          passwordAgain: '',
          identityName: '未登录',
          errorPassword: false,
          ruleForm2: {
            username: '',
            password: '',
            checkPass: ''
          },
          rules2: {
            password: [
              { validator: validatePass, trigger: 'blur' }
            ],
            checkPass: [
              { validator: validatePass2, trigger: 'blur' }
            ]
            // username: [
            //   { validator: checkUserName, trigger: 'blur' }
            // ]
          }
        }
  },
      // beforeCreate () {
      //   sessionStorage.setItem('username', '0')
      // },
      mounted: function () {
        var _this = this
        setInterval(function () {
          _this.date = new Date() // 修改数据date
        }, 1000)
      },
      methods: {
        // 提交密码更改
        submitForm () {
          if (this.ruleForm2.checkPass === this.ruleForm2.password && this.ruleForm2.password !== '' &&
          this.ruleForm2.username !== '' && this.ruleForm2.checkPass !== '') {
            var json = {
              'username': this.ruleForm2.username,
              'password': this.ruleForm2.password
            }
            this.$axios.post('/updatepassword', json).then(function (response) {
              if (response.data.statusCode === 200) {
                sessionStorage.setItem('username', '1')
                alert('修改成功，准备跳转到登录页面')
                window.location.href = '#/systemindex'
              } else {
                alert(response.data.message)
              }
            })
            this.resetForm()
          }
        },
        // 制空表单
        resetForm () {
          this.ruleForm2.password = ''
          this.ruleForm2.checkPass = ''
          this.ruleForm2.username = ''
        }
      },
      filters: {
        formatDate (time) {
          return formatDate(time, 'yyyy-MM-dd hh:mm')
        }
      }

    }
</script>

