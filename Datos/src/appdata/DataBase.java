package appdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBase {
    private Connection conn;
        
        public DataBase() {
        }

        public Connection getConn() {
            return this.conn;
        }
        
        public void conectarSqlServer(){
            try{
                String info = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String connecturl = "jdbc:sqlserver://127.0.0.1:1433;"+"databaseName=Test;user=sa;password=souleater07;";
                
                Class.forName(info);
                this.conn = DriverManager.getConnection(connecturl);
                
            }catch(Exception e){
                e.printStackTrace();
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
                Stmt = this.conn.createStatement();
                Stmt.executeUpdate(Sql);
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
                Stmt = this.conn.createStatement();
                Rs = Stmt.executeQuery(Sql);
                return Rs;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return null;
        }
}
