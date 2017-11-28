<template>
  <div class="center">
    <h2>{{title}}</h2>
    <a class="uno" href="http://localhost:8081/#/Nodos" >1# Usuario maás popular</a>

      <center> <table>

    <th><ul class="user-list">
      <li v-for="u,i in users">
     <img  width="60" height="50"  :src="u.user_profile_image_url"/>
        <a v-bind:href="u.user_url">{{u.user_name}}</a>

      </li>
    </ul>
    </th>

</table></center>
  </div>
</template>
<script>
export default {
  data(){
    return{
      title:'Usuarios más Influyentes',
      users:[]
    }
  },
  mounted:function(){
    console.log('Index.vue');
    // GET /someUrl
    this.$http.get('http://localhost:8080/restApi-tweetgame/top')
    .then(response=>{
       // get body data
      this.users = response.body;
     console.log('users',this.users)
    }, response=>{
       // error callback
       console.log('error cargando lista');
    })
  }
}
</script>

<style>

.table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
}

.td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

.tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
