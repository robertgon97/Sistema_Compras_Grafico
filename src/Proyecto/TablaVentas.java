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
import javax.swing.table.DefaultTableModel;

/**
 *
 * 
 */
public class TablaVentas {
    
    String conString ="jdbc:mysql://localhost:3306/sistemainventario";
    String username ="root";
    String passward ="";
    float total=0;
    
    public int getSellNumber(){
        
        String cons ="jdbc:mysql://localhost:3306/sistemainventario";
        String user ="root";
        String pass ="";
        
        int a=0;
        String sql = "SELECT numero FROM ventanumero";
        String id="";
        
        
        try{
            Connection con= (Connection) DriverManager.getConnection(cons,user,pass);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs =s.executeQuery(sql);
            
            while(rs.next()){
                id = rs.getString(1);
            }
            
            
            a= Integer.parseInt(id);
            return a;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return a;
    }
    
    public boolean updateSellNumber(){
        String cons ="jdbc:mysql://localhost:3306/sistemainventario";
        String user ="root";
        String pass ="";
        int b = getSellNumber();
        b++;
        
        String sql="UPDATE ventanumero SET numero='"+b+"'";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(cons, user, pass);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean createtable(String a){
        
        String sql="CREATE TABLE "+a+"( `numero` INT(11) NOT NULL AUTO_INCREMENT , `producto` VARCHAR(250) NOT NULL , `cantidad` INT(11) NOT NULL , `pprecio` FLOAT(10) NOT NULL , `valor` VARCHAR(250) NOT NULL , `precio` FLOAT(10) NOT NULL , `precio_compra` FLOAT(10) NOT NULL ,`tipo` VARCHAR(250) NOT NULL , PRIMARY KEY (`numero`))";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean add(String a,String name,float perprice,String vat,float buy_price,String type){
        
        int quantity=1;
        float price = (perprice)*quantity;
        String sql="INSERT INTO `sistemainventario`.`"+a+"` (`numero`, `producto`, `cantidad`, `pprecio`, `valor`, `precio`, `precio_compra`, `tipo`) VALUES (NULL, '"+name+"', '"+quantity+"', '"+perprice+"', '0%', '"+price+"', '"+buy_price+"', '"+type+"')";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    public boolean updateSell(String a,String id,String perprice){
        
        
        String sql = "UPDATE "+a+" SET cantidad=cantidad-1,precio=precio-pprecio  WHERE numero='"+id+"' AND pprecio='"+perprice+"'";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    //use hoitase naa;
    public boolean update(String a,String name,float perprice){
        
        
        /*UPDATE `sellno39` SET `quantity`=`quantity`+5 , `price` = `perprice`*5 WHERE `name` = 'Elit Choco Eggy' AND `perprice` = 448*/
        
        String sql = "UPDATE "+a+" SET cantidad=cantidad+1,precio=precio+pprecio  WHERE producto='"+name+"' AND pprecio='"+perprice+"'";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean update(String a,String name,float perprice,int st){
        
        
        /*UPDATE `sellno39` SET `quantity`=+5 , `price` = `perprice`*5 WHERE `name` = 'Elit Choco Eggy' AND `perprice` = 448*/
        
        String sql = "UPDATE "+a+" SET `cantidad`="+st+" , `precio` = `pprecio`*"+st+"  WHERE producto='"+name+"' AND pprecio='"+perprice+"'";
        System.out.println(sql);
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public DefaultTableModel getData(String a){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("No");
        dm.addColumn("Producto");
        dm.addColumn("Precio Un.");
        dm.addColumn("Cantidad");
        //dm.addColumn("Vat");
        dm.addColumn("Precio");
        
        
        String sql = "SELECT * FROM "+a;
        
        try{
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs =s.executeQuery(sql);
            
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String quantity = rs.getString(3);
                String perprice = rs.getString(4);
                //String vat = rs.getString(5);
                String price = rs.getString(6);
                String buy_price = rs.getString(7);
                
                total = total+Float.parseFloat(price);
                
                //System.out.println(total);
                
                dm.addRow(new String[]{id,name,perprice,quantity,price,buy_price});
                
                
                
            }
            
            return dm;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
    
    
    public boolean dropTable(String a){
        
        String sq="DROP TABLE "+a;
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sq);
            
            s.execute(sq);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public boolean delete(String id,String a){
        
        String sql="DELETE FROM "+a+" WHERE numero='"+id+"'";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            System.out.println("aaaa");
            s.execute(sql);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    
    public boolean SearchExistItem(String name,String price,String a){
        String conString ="jdbc:mysql://localhost:3306/sistemainventario";
        String username ="root";
        String passward ="";
        
        String sql1 = "SELECT * FROM "+a+" WHERE producto ='"+name+"'AND pprecio='"+price+"'";
        
        
       
        String st;
        
        try{
            
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.createStatement();           
            
            
            
            
            
            ResultSet rs = s.executeQuery(sql1);
            
            
            
            while(rs.next()){
                
                return true;
 
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    public boolean updateItem(String a,String name,float perprice,String qua){
        
        
        String conString ="jdbc:mysql://localhost:3306/sistemainventario";
        String username ="root";
        String passward ="";
        
        String sql = "UPDATE "+a+" SET cantidad=cantidad+"+qua+",precio=precio+pprecio  WHERE producto='"+name+"' AND pprecio='"+perprice+"'";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean addItem(String a,String name,float perprice,String vat,float buy_price,String type,String quantity){
        
        String conString ="jdbc:mysql://localhost:3306/sistemainventario";
        String username ="root";
        String passward ="";
        
        //int quantity=1;
        float price = (perprice*Integer.parseInt(quantity));
        String sql="INSERT INTO `"+a+"` (`id`, `producto`, `cantidad`, `pprecio`, `valor`, `precio`, `precio_compra`, `tipo`) VALUES (NULL, '"+name+"', '"+quantity+"', '"+perprice+"', '', '"+price+"', '"+buy_price+"', '"+type+"')";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
}