<template>
  <div class="center">
    <div class="login">
      <h2>Bienvenido a Tweetgames</h2>
      <form class="login-form">
        <div class="form-group">
          <label class="label-info">E-mail:  </label>
          <input class="input-info" type="text" v-model="userName" />
        </div>
        <div class="form-group">
          <label class="label-info">Password:</label>
          <input class="input-info" type="password" v-model="password" />
        </div>
        <div class="form-control">
          <button class="button" type="submit" @click="login">Enter</button>
        </div>
      </form>
    </div>
    </div>
</template>

<script >

export default {
  name: 'login',
  data () {
    return {
      user: {
        userName: '',
        password: ''
      },
    }
  },
  mounted() {

  },
  methods: {
    login() {
      if(this.userName == 'admin'){
        if(this.password == '123'){
          window.open("#/Juegos");
        }
      }      
      alert("Datos Incorrectos")
      console.log("user: " + this.userName);
      console.log("paswowd: " + this.password);
      
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
.login
  position: relative;
  left: 30%;
  top: 10em;
  width: 40%;
  font-family: Arial;
  .login-form
    margin: 0 auto;
    width: 80%;
    font-size: 18px;
    .form-group
      padding-top: 10px;
      height: 60px;
      .label-info
        width: 40%;
        height: 60px;
        line-height: 60px;
        text-align: right;
        font-weight: bold;
      .input-info
        width: 60%;
        height: 35px;
        border-radius: 4px;
        font-size: 18px;
        outline: none;
    .form-control
      text-align: right;
      margin-right: 62px;
      .button
        width: 100px;
        height: 30px;
        border-radius: 5px;

</style>
