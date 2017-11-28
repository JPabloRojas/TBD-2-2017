package geoLocation;


import MongoConnection.MongoDB;
import MySQLConnection.MySQLDB;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;



public class geoLocation {
    //API KEY: AIzaSyDPcBuAO5CwFUoXwj6aoX2poU8JVFR1eic
    //Service: http://maps.googleapis.com/maps/api/geocode/json?latlng=______,______&key=AIzaSyDPcBuAO5CwFUoXwj6aoX2poU8JVFR1eic
    MySQLDB mysqldb;
    MongoDB mongodb;


    public geoLocation(){
        this.mysqldb = new MySQLDB();
        this.mongodb = new MongoDB();
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    public String getTweetCountry(String url) throws IOException {

        /*
        String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=40.3577264,-2.4757481&key=AIzaSyDPcBuAO5CwFUoXwj6aoX2poU8JVFR1eic";
        JSONObject json = readJsonFromUrl(url);
        System.out.println(json.toString());
        System.out.println("__________________________________");
        System.out.println(json.get("results").toString());
        System.out.println("__________________________________");
        JSONArray json_array = json.getJSONArray("results");
        JSONObject test = json_array.getJSONObject(0);
        System.out.println(test.toString());
        System.out.println("__________________________________");
        System.out.println(test.get("formatted_address"));
        System.out.println("__________________________________");
        String[] info_r = test.get("formatted_address").toString().split(",");
        System.out.println(info_r[info_r.length-1].trim());
         */

        JSONObject json = readJsonFromUrl(url);
        JSONArray jArray = json.getJSONArray("results");
        JSONObject infoBody = jArray.getJSONObject(0);
        String[] arrayInfo = infoBody.get("formatted_address").toString().split(",");
        String country = arrayInfo[arrayInfo.length-1].trim();
        return country;
    }

    public void updateTweetsCount() throws IOException {
        this.mysqldb.truncateGeo();
        MongoDB mongo = new MongoDB();
        MongoCollection<Document> tweetsCollection = mongo.gettweetsColl();
        MongoCursor<Document> collCursor = tweetsCollection.find().iterator();
        while(collCursor.hasNext()){
            Document doc = collCursor.next();
            if(!doc.get("tweet_latitude").toString().equals("none") && !doc.get("tweet_longitude").toString().equals("none")){
                String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?latlng=%s,%s&key=AIzaSyDPcBuAO5CwFUoXwj6aoX2poU8JVFR1eic", doc.get("tweet_latitude"), doc.get("tweet_longitude"));
                String country = getTweetCountry(url);
                this.mysqldb.updateCountry(country,Float.parseFloat(doc.get("tweet_latitude").toString()),Float.parseFloat(doc.get("tweet_longitude").toString()));
            }
        }
    }

    public void test() throws IOException {
        /*MongoClient client = new MongoClient( "localhost" , 27017 );
        MongoDatabase mongoDB = client.getDatabase("tweetGamesDB");
        MongoCollection<Document> tweetsColl = mongoDB.getCollection("twitterCollection");
        MongoCursor<Document> collCursor = tweetsColl.find().iterator();
        int cont = 0;
        while(collCursor.hasNext())
        {
            Document doc = collCursor.next();
            if(!doc.get("tweet_latitude").toString().equals("none") && !doc.get("tweet_longitude").toString().equals("none")){
                System.out.println("latitude: " + doc.get("tweet_latitude").toString() + " longitude: " + doc.get("tweet_longitude").toString());
                cont++;
            }
        }
        System.out.println("total: "+cont);*/


        //40.714224,-73.961452
        //19.4333,-99.1333

    }
}
