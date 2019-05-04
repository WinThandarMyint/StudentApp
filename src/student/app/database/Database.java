/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Win Thandar
 */
public class Database {
    private String url="jdbc:mysql://localhost:3306/studentapp";
    private String username="root";
    private String pw="";
    private static Database db;
    private Connection conn;
   
    public Database() throws SQLException{
        connect();
    }
    
    public boolean connect() throws SQLException{
       conn=DriverManager.getConnection(url, username, pw);
        return true;
    }
    
    public static Database getInstance() throws SQLException{
        if (db==null){db=new Database();}
        return db;
    }
    
    public Connection getConnection(){
    return conn;
    }
}
