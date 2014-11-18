package appgui;

import appdata.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import appentities.Persona;

public class AppData {
    public static void main(String[] args) throws SQLException {
                Persona P = null;
                
                Persistencia Pr = new Persistencia();
                
                ResultSet Rs = null;
                
                String Sql = "";
                
                LinkedList lista = new LinkedList();
                
                int opcion;
                
                JOptionPane.showMessageDialog(null, "Bienvenido");
                
        do{
                    opcion=Integer.parseInt(JOptionPane.showInputDialog("Menu:\n"+
                            "\n1.Insertar Persona"+
                            "\n2.Modificar Persona"+
                            "\n3.Eliminar Persona"+
                            "\n4.Buscar Persona"+
                            "\n5.Obtener Todos"+
                            "\n6.Salir"));
                    switch(opcion){
                    case 1:
                            String ced = JOptionPane.showInputDialog("Digite el numero de cedula de la persona");
                            
                            Sql = "select * from Persona where cedula ='"+ced+"'";
                            
                            P = Pr.Select(Sql);
                            
                            if(P!=null){

                                JOptionPane.showMessageDialog(null, "Ya existe una persona con esa cedula");
                            }
                            else{
                                String nomb = JOptionPane.showInputDialog("Digite el nombre de la persona");
                                String ape = JOptionPane.showInputDialog("Digite el apellido de la persona");
                                String tel = JOptionPane.showInputDialog("Digite el numero de telefono de la persona");
                                String ema = JOptionPane.showInputDialog("Digite el email de la persona");
                                
                                String query = "insert into persona (Cedula,Nombre,Apellidos,Telefono,Email) values ('"+ced+"','"+nomb+"','"+ape+
                                    "','"+tel+"','"+ema+"')";
                            
                                int res = Pr.Insert(query);
                            
                                if(res!=0){
                                    JOptionPane.showMessageDialog(null, "Persona registrada");
                                }else{
                                    JOptionPane.showMessageDialog(null, "No se pudo registrar a la persona");
                                }
                            }
                            
                        break;
                    case 2:
                        break;
                    case 3:
                            String id = JOptionPane.showInputDialog("Digite el numero de cedula de la persona");
                            
                            Sql = "update Persona set estado=0 where cedula ='"+id+"'";
                            
                            int resp = Pr.Delete(Sql);
                            
                            if(resp!=0){
                                JOptionPane.showMessageDialog(null, "Persona eliminada");
                            }else{
                                JOptionPane.showMessageDialog(null, "No existe esa Persona");                        
                            }
                        break;
                    case 4:
                            String cedula = JOptionPane.showInputDialog("Digite el numero de cedula de la persona");
                            Sql = "select * from Persona where cedula ='"+cedula+"'";
                            
                            P = Pr.Select(Sql);
                            
                            if(P!=null){
                                JOptionPane.showMessageDialog(null, P.toString());
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "No existe esa Persona");
                            }
                        break;
                    case 5:
                            Sql = "select * from Persona where estado=1";
                
                            lista = Pr.SelectAll(Sql);
                             
                            if(!lista.isEmpty()){
                                ListIterator ite = lista.listIterator();
                                
                                while(ite.hasNext()){
                                    JOptionPane.showMessageDialog(null, ite.next());
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "No hay Personas");
                            }
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                    }
                }while(opcion!=6);
    }
}
