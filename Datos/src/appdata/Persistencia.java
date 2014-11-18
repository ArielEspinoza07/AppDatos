package appdata;

import appentities.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Persistencia {
    DataBase DB = null;
        
        public Persistencia(){
            this.DB = new DataBase();
        }
        
        public int Insert(String Sql){
            
            DB.conectarSqlServer();
            return DB.execute(Sql);
        }
        
        public int Update(String Sql){
            DB.conectarSqlServer();
            return DB.execute(Sql);
        }
        
        public int Delete(String Sql){
            DB.conectarSqlServer();
            return DB.execute(Sql);
        }
        
        public Persona Select(String Sql) throws SQLException{
            DB.conectarSqlServer();
             
            ResultSet Rs = DB.executeQuery(Sql);
            Persona P = null;
                        
            if(Rs.next()){
                P = new Persona();
                P.setCedula(Rs.getString("Cedula"));
                P.setNombre(Rs.getString("Nombre"));
                P.setApellidos(Rs.getString("Apellidos"));
                P.setTelefono(Rs.getString("Telefono"));
                P.setEmail(Rs.getString("Email"));
                P.setEstado(Rs.getInt("Estado"));
                return P;
            }else{
                return P;
            }
        }
        
        public LinkedList SelectAll(String Sql) throws SQLException{
            DB.conectarSqlServer();
            LinkedList lista = new LinkedList();
            Persona P; 
            ResultSet Rs = DB.executeQuery(Sql); 
            
            while(Rs.next()){
                P = new Persona();
                P.setCedula(Rs.getString("Cedula"));
                P.setNombre(Rs.getString("Nombre"));
                P.setApellidos(Rs.getString("Apellidos"));
                P.setTelefono(Rs.getString("Telefono"));
                P.setEmail(Rs.getString("Email"));
                P.setEstado(Rs.getInt("Estado"));

                            lista.add(P);
            }
            return lista;   
        }
}
