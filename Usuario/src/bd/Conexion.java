/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import telepizza.Cliente;
import telepizza.Pedido;
import telepizza.Pizza;

/**
 *
 * @author alumno
 */
public class Conexion {
    private String url;
    private String usuario;
    private String pass;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Conexion() {
        this.url = "jdbc:mysql://192.168.4.115:3310/telepizza";
        this.usuario = "jsancho";
        this.pass = "Admin1234";
    }
    
    

    public Conexion(String url, String usuario, String pass) {
        this.url = url;
        this.usuario = usuario;
        this.pass = pass;
    }
    
    private void conectar(){
    
        
        try {
            con = (Connection) DriverManager.getConnection(url,usuario,pass);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        

    }
    private void desconectar(){
        try {           
            con.close();                   
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String consultarDatos(){
    
        String aux="";
        
       try { 
           conectar();
           st = con.createStatement();
           rs = st.executeQuery("Select * from cliente;");
            while (rs.next()) {
                aux+=rs.getInt(1) + " ";
                aux+=rs.getString(2) + " ";
                aux+=rs.getInt(3) + " ";
                aux+=rs.getString(4) + "\n";
                aux+="------" + "\n";
           }
           desconectar();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
       
      return aux;  
    }
    
    public ArrayList<String> rellenarPizzas(){
        ArrayList<String> a1 = new ArrayList<>();
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select nombre from pizza");
            while (rs.next()){
                a1.add(rs.getString(1));
            }
            desconectar();       
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a1;
    }
    
    public Cliente telefonoCliente(int telefono){
        Cliente c1 = null;
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select * from cliente where telefono="+telefono+";");
            if (rs.next()){   
                c1 = new Cliente(rs.getString(2), rs.getInt(3), rs.getString(4));
            }
            desconectar();       
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c1;
    }
    
    public void consultaCliente(Cliente c1){
       
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select * from cliente where telefono="+c1.getTelefono()+";");
            if (!rs.next()){   
                st.executeUpdate("Insert into cliente values('0','"+c1.getNombre()+"','"+c1.getTelefono()+"','"+c1.getDireccion()+"')");
            }
            desconectar();       
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertarPedido(Pedido p1){
       Calendar c = Calendar.getInstance();
        try {
            conectar();
            st = con.createStatement();
            rs = st.executeQuery("Select id from cliente where telefono="+p1.getC1().getTelefono()+";");
            if (rs.next()){ 
                int id = rs.getInt(1);
                st.executeUpdate("Insert into pedido values('0',"+id+",'"+p1.DevolverPizzas()+"',"+p1.getPizzas().size()+","+p1.getPrecioFinal()+",sysdate())");
            }
            desconectar();       
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
