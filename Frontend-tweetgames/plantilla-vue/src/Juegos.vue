<template>
   <div class="center">
 <div class="login">
      <h2>Agregar nuevo juego</h2>
      <form class="login-form">
    <form>
    <div align="center" class="form-group">
      <label for="game_name">Nombre</label>
        <input class="form-control " id="game_name" type="text" v-model="actor.game_name">
    </div>
   <div align="center" class="form-group">
    <label for="desarrollador">Desarrollador</label>
    <input class="form-control" id="desarrollador" type="text" v-model="actor.desarrollador">
  </div>
  <div align="center" class="form-group">
      <label for="fecha_lanzamiento">Fecha</label>
        <input class="form-control " id="fecha_lanzamiento" type="text" v-model="actor.fecha_lanzamiento">
    </div>
    <div align="center" class="form-group">
      <label for="genero">Genero</label>
      <input class="form-control " id="genero" type="text" v-model="actor.genero">
    </div>
     <div align="center" class="form-group">
      <label for="keyword">Keyword</label>
        <input class="form-control " id="keyword" type="text" v-model="actor1.keyword">
    </div>

</form>

<form>
<div align="center">
  <button v-on:click.prevent="post"">Guardar</button>

  </div>
</form>

</form>

</form>
      </form>

    </div>
     </div>
</template>

<script>
export default {
  data(){
    return{
      actor:{
        game_name:'',
        desarrollador:'',
        fecha_lanzamiento:'',
        genero:''
      },
      actor1:{
        keyword:''
      }
    }
  },
  methods:{

    post:function(){
      this.$http.post('http://localhost:8080/restApi-tweetgame/games',{
         game_name: this.actor.game_name,
         desarrollador: this.actor.desarrollador,
         fecha_lanzamiento: this.actor.fecha_lanzamiento,
         genero: this.actor.genero
      }).then(function(data){
        console.log(data);
      });

       this.$http.post('http://localhost:8080/restApi-tweetgame/keywords',{
         keyword: this.actor1.keyword
      }).then(function(data){
        console.log(data);
      });
    }

  }
}
</script>
