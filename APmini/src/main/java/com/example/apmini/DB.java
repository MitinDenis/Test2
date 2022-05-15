package com.example.apmini;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private final String HOST = "Localhost";
    private final String PORT = "8889";
    private final String DB_NAME = "sensors";
    private final String LOGIN = "root"; //mysql
    private final String PASS = "root"; //mysql

    private Connection dbConn = null;

    private Connection getDbConn() throws ClassNotFoundException, SQLException{
        String conn = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConn = DriverManager.getConnection(conn, LOGIN, PASS);
        return dbConn;
    }

    public void insertsensor(String sensor) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO 'sensors' (sensor) VALUES (?)";
        PreparedStatement prSt = getDbConn().prepareStatement(sql);
        prSt.setString(1, sensor);
        prSt.executeUpdate();
    }

    public ArrayList<String> getSensors() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM sensors ORDER BY 'id' DESC";
        Statement statement = getDbConn().createStatement();
        ResultSet res = statement.executeQuery(sql);
        ArrayList<String> sensors = new ArrayList<>();
        while(res.next()){
           sensors.add(res.getString("sensor"));
        }
        return sensors;
    }
}
