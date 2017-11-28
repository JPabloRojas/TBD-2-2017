<template>

<div class="w3-container" >
 <h1>Geolocalización</h1>
<center><a class="w1" > </a><a class="w2"></a><a class="w3"></a><a class="w4"></a><a class="w5"></a></center>
<center><p>Paises en los que se habla más de juegos</p></center>
<div id="map_bombs" class="pull-left" style="position: relative;width: 1200px; height: 800px;margin-left: 10px;"></div>
</div>

</template>
<script src="http://d3js.org/d3.v3.min.js"></script>
    <script src="http://d3js.org/topojson.v1.min.js"></script>
<script>
    import Datamap from 'datamaps';
    export default{
      mounted: function(){
          var bombs=[{"name":"Locacion","radius":32,"country":"Mexico","significance":"Lugar popular de tweet","date":"2017-11-28 02:31:39","latitude":19.4333,"longitude":-99.1333,"fillKey":"4"},{"name":"Locacion","radius":22,"country":"USA","significance":"Lugar popular de tweet","date":"2017-11-28 02:31:40","latitude":33.8001,"longitude":-117.921,"fillKey":"4"},{"name":"Locacion","radius":10,"country":"Chile","significance":"Lugar popular de tweet","date":"2017-11-28 02:31:43","latitude":-33.0465,"longitude":-71.6145,"fillKey":"5"},{"name":"Locacion","radius":10,"country":"Venezuela","significance":"Lugar popular de tweet","date":"2017-11-28 02:31:46","latitude":10.496,"longitude":-66.8983,"fillKey":"5"},{"name":"Locacion","radius":10,"country":"Peru","significance":"Lugar popular de tweet","date":"2017-11-28 02:31:47","latitude":-11.3483,"longitude":-76.9922,"fillKey":"5"},{"name":"Locacion","radius":5,"country":"Argentina","significance":"Lugar popular de tweet","date":"2017-11-28 02:31:51","latitude":-51.6333,"longitude":-69.2333,"fillKey":"5"}];

      this.$http.get('http://localhost:8080/restApi-tweetgame/locations').then(response=>{
      this.bombs = response.body;
      console.log('as',this.bombs);
    }, response=>{
      console.log("error de conexion");
    });
    console.log('asxsxs',this.bombs);
        var bombMap = new Datamap({
        element: document.getElementById('map_bombs'),
    scope: 'world',
    geographyConfig: {
        popupOnHover: false,
        highlightOnHover: false
},
        fills: {
        '1': '#78281f',
        '2': '#b03a2e',
        '3': '#e74c3c',
        '4': '#f1948a',
        '5': '#fadbd8',
        defaultFill: '#34c14b'
      },
       //dataUrl: 'http://localhost:8090/restApi-tweetgame/locations',
      //dataType: 'json',
       /*data:{
        "CHL": {
            "fillKey": "1",
            "tweets": ""
        },
        "ARG": {
            "fillKey": "2",
            "tweets": ""
        },
        "COL": {
            "fillKey": "3",
            "tweets": ""
        },
        "BRA": {
            "fillKey": "4",
            "tweets": ""
        },
        "ECU": {
            "fillKey": "5",
            "tweets": ""
        },
        },*/
      });
        bombMap.bubbles(bombs, {
    popupTemplate:function (geography, data) {
            return ['<div class="hoverinfo"><strong>' +  data.name + '</strong>',
            '<br/>Payload: ' +  data.yeild + ' kilotons',
            '<br/>Country: ' +  data.country + '',
            '<br/>Date: ' +  data.date + '',
            '</div>'].join('');
    }
});
      }
    }
</script>
