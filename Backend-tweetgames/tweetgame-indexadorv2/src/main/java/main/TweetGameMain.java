package main;




import MySQLConnection.MySQLDB;
import model.userModel;
import org.apache.lucene.queryparser.classic.ParseException;
import java.io.IOException;
import java.util.List;

import neo4j.neo4j;

import org.json.JSONObject;
import tweetgame_core.tweetgame_core;


import geoLocation.geoLocation;


public class TweetGameMain {

    public static void main(String[] args) throws IOException, ParseException {


        //1: Inicial controlador recolector e indexador

        tweetgame_core tc = new tweetgame_core();
        tc.beginProcess();

        //MySQLDB db = new MySQLDB();
        //db.updateCountry("test",(float)-5.232,(float)70.231);


        //2: Inicial controladores de neo4j
        //neo4j n4 = new neo4j("bolt://localhost:7687","neo4j","123");
        //n4.createNodes();
        //n4.obtaintopUser();

        //geoLocation geo = new geoLocation();
        //System.out.println(geo.getTweetCountry("https://maps.googleapis.com/maps/api/geocode/json?latlng=40.3577264,-2.4757481&key=AIzaSyDPcBuAO5CwFUoXwj6aoX2poU8JVFR1eic"));
        //geo.updateTweetsCount();


    }


}
