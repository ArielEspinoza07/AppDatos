package appdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBase {
    
    private Connection conn;
    private String driver;
    private String server;
    private String database;
    private String user;
    private String pass;
    
    public DataBase() {
    }

    public Connection getConn() {
        return this.conn;
    }
    
    public void conectarSqlServer(){
        try{
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            server = "jdbc:sqlserver://127.0.0.1:1433;";
            database = "databaseName=Test;";
            user = "user=sa;";
            pass = "password=12345;";
            
            Class.forName(driver);
            this.conn = DriverManager.getConnection(server+database+user+pass);
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public void conectarMySQL(){
        try{
            driver = "com.mysql.jdbc.Driver";
            server = "jdbc:mysql://localhost:3306/";
            database = "Test";
            user = "root";
            pass = "";
            
            Class.forName(driver);
            this.conn = DriverManager.getConnection(server+database,user,pass);
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void cerrarConexion(){
        try{
            if(this.conn != null){
                this.conn.close();
                this.conn = null;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public int execute(String Sql){
        Statement Stmt;
        try{
            //call this method if are using MS SQL Server
            //conectarSqlServer();
            
            //or this if you are using MySql
            //conectarMySQL;
            
            Stmt = this.conn.createStatement();
            Stmt.executeUpdate(Sql);
            
            cerrarConexion();
            
            return 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public ResultSet executeQuery(String Sql){
        ResultSet Rs;
        Statement Stmt;
        try{
            
            //call this method if are using MS SQL Server
            //conectarSqlServer();
            
            //or this if you are using MySql
            //conectarMySQL;
            
            Stmt = this.conn.createStatement();
            Rs = Stmt.executeQuery(Sql);
            
            cerrarConexion();
            
            return Rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
