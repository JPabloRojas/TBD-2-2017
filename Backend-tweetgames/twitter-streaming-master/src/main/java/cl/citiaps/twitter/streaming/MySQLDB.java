package cl.citiaps.twitter.streaming;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MySQLDB {
    private Connection connection;
    private String username;
    private String password;
    private String host;
    private String db_name;

    public MySQLDB(){
        this.username = "root";
        this.password = "qweert123456";
        this.host = "jdbc:mysql://localhost:3306/";
        this.db_name = "tweet-schema";
        connectDB();
    }
    public void connectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.host + this.db_name, this.username, this.password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }

    }
    public Set<String> getAllkeywords(){
        String query = "SELECT keyword FROM keywords";
        Set<String> keywords = new HashSet<>();
        try {
            Statement s = this.connection.createStatement();
            ResultSet re = s.executeQuery(query);
            while(re.next()){
                keywords.add(re.getString("keyword"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for(String s:keywords){
            System.out.println(s);
        }
        return keywords;
    }
}
