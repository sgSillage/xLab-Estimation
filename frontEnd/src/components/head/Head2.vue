<!-- 头部组件样式2 -->
<template>
<div class="head_home">
  <!-- <router-link to='/'>智码</router-link>
  <router-link to="/projects">项目</router-link> -->
  <router-link to="/ver">估算</router-link>
  <!-- <a href="http://172.16.101.90:8080" title="测试" target="_blank">代码托管</a>
  <a>帮助</a> -->

  <div class="head_center">
    <el-dropdown>
      <span class="el-dropdown-link">
        个人中心<i class="el-icon-caret-bottom el-icon--right"></i>
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item><router-link style="color: #000000" to="/center">个人中心</router-link></el-dropdown-item>
        <el-dropdown-item><router-link style="color: #000000" to="/center">设置</router-link></el-dropdown-item>
        <el-dropdown-item divided><a @click ="logout" style="color: black">退出</a></el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</div>

</template>

<script>
import server from '../../../config/index';
import axios from '../../axios/http';

export default {
  name: "Header2",
  data() {
      return {
          url: server.estimation + '/estimation/logout'
      }
  },
  methods:{
    logout:function(){
      axios(
          {
            url: this.url,
            method: "POST",
            /*transformRequest: [function (data) {
              // Do whatever you want to transform the data
              let ret = ''
              for (let it in data) {
                ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
              }
              return ret
            }],*/
            //headers: {'Content-Type': 'application/x-www-form-urlencoded'}
          }
        ).then(function (response) {
          if (response.data.status == "200") {
            this.$message({
              message: '成功退出登录',
              type: 'success'
            });
             this.$store.commit("reset");
             sessionStorage.removeItem("tokenid");
             this.$router.push( '/login' );
          }
        }.bind(this))
          .catch(function (error) {
            if (error.status == 500) {
              alert('服务器错误');
            }
          });
     

    }
  }
};
</script>
