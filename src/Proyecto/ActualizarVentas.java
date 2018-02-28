/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * 
 */
public class ActualizarVentas {
    
    
    String conString ="jdbc:mysql://localhost:3306/sistemainventario";
    String username ="root";
    String passward ="";
    
    public void add(String name,String qua,String price,String bp,String type,String date){
        
        String sql="INSERT INTO `ventash`(`numero`, `producto`, `cantidad`, `precio`, `precio_compra`, `tipo`, `fecha`) VALUES (NULL,'"+name+"','"+qua+"','"+price+"','"+bp+"','"+type+"','"+date+"')";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public void update(String name,String qua,String price,String date){
        
        
        String sql="UPDATE `ventash` SET cantidad=cantidad+'"+qua+"',`fecha`='"+date+"' WHERE `precio_compra`='"+price+"' AND `producto`='"+name+"'";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            System.out.println("Hecho");
            s.execute(sql);
            System.out.println("Hecho");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public boolean checkdate(String date){
        
        String sql = "SELECT * FROM ventash ORDER BY numero ASC LIMIT 1";
        
        try{
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs =s.executeQuery(sql);
            
            String d= "";
            
            while(rs.next()){
                
                d = rs.getString(7);
            }
            
            System.out.println(d);
            System.out.println(date);
            if(date.equalsIgnoreCase(d)){
                System.out.println(d);
                return true;
            }
            else return false;
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
        
    }
    
    
    public boolean searchtodaysell(String name,String buyprice){
        
        String sql = "SELECT * FROM `ventash` WHERE `producto` ='"+name+"' AND `precio_compra`='"+buyprice+"'";
        
        
       
        String st;
        
        try{
            
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.createStatement();           
            
            
            
            
            
            ResultSet rs = s.executeQuery(sql);
            
            
            
            while(rs.next()){
                
                return true;
 
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return false;
    }
    
    
    
    
    
}
