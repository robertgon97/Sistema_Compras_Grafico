/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


/**
 *
 * 
 */
public class ActualizarInventario {
    
    String conString ="jdbc:mysql://localhost:3306/sistemainventario";
    String username ="root";
    String passward ="";
    
    public boolean add(String name,int stock,float price,String type,String weight,String buy_price,String barcode,int di){
        
        String sql="INSERT INTO productos(`id`, `producto`, `cantidad`, `precio`, `tipo`, `peso`, `precio_compra`, `codigo`) VALUES(NULL,'"+name+"','"+stock+"','"+price+"','"+type+"','"+weight+"','"+buy_price+"','"+barcode+"')";
        
        try{
            
            System.out.println("añadir");
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            sql = "SELECT MAX(ID) from productos";
            
            s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs = s.executeQuery(sql);
            
            if(rs.next()){
            
                String sp = rs.getString(1);

                System.out.println(sp);
                
                int id = Integer.parseInt( sp );
            
                sql = "INSERT INTO `historialinv`(`eid`, `inid`, `operacion`, `tiempo`, `cantidad_antes`, `cantidad_nueva`) VALUES ('"+di+"','"+id+"','inserted',NOW(),'0','"+stock+"')";


                s =(Statement) con.prepareStatement(sql);


                s.execute(sql);
            
            }
            else{
               
            }
            
            /**/
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public DefaultTableModel getData(){
        
        DefaultTableModel dm = new DefaultTableModel(){
             @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dm.addColumn("ID");
        dm.addColumn("Producto");
        dm.addColumn("Cantidad");
        dm.addColumn("Precio");
        dm.addColumn("Tipo");
        dm.addColumn("Peso");
        dm.addColumn("Precio de Compra");
        dm.addColumn("Codigo");
        
        String sql = "SELECT * FROM productos";
        
        try{
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs =s.executeQuery(sql);
            
            while(rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                String price = rs.getString(3);
                String stock = rs.getString(4);
                String type = rs.getString(5);
                String weight = rs.getString(6);
                String buy_price = rs.getString(7);
                String barcode = rs.getString(8);
                
                dm.addRow(new String[]{id,name,price,stock,type,weight,buy_price,barcode});
                
            }
            
            return dm;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public boolean update(String id,String name,int stock,float price,String type,String weight,String buy_price,String barcode,int di){
        
        
        String sql = "select cantidad from `productos` WHERE `id`='"+id+"'";
        int pre_stock = 0;
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs =s.executeQuery(sql);
            
            if(rs.next()){
                pre_stock = Integer.parseInt(rs.getString(1));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        sql="UPDATE `productos` SET `producto`='"+name+"',`cantidad`=`cantidad` +'"+stock+"',`precio`='"+price+"',`tipo`='"+type+"',`peso`='"+weight+"',`precio_compra`='"+buy_price+"',`codigo`='"+barcode+"' WHERE `id`='"+id+"'";
        
        
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            sql = "select cantidad from `productos` WHERE `id`='"+id+"'";
            
            s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs =s.executeQuery(sql);
            
            int now_stock = 0;
            
            if(rs.next()){
                now_stock = Integer.parseInt(rs.getString(1));
            }
            
            
            
            sql = "INSERT INTO `historialinv`(`eid`, `inid`, `operacion`, `tiempo`, `cantidad_antes`, `cantidad_nueva`) VALUES ('"+di+"','"+id+"','updated',NOW(),'"+pre_stock+"','"+now_stock+"')";
            
            
            System.out.println(sql);
            
            s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    public boolean update(int iid,int stock,int di){
        
        
        String sql = "select cantidad from `productos` WHERE `id`='"+iid+"'";
        int pre_stock = 0;
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            ResultSet rs =s.executeQuery(sql);
            
            if(rs.next()){
                pre_stock = Integer.parseInt(rs.getString(1));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        sql="UPDATE `productos` SET `cantidad`='"+stock+"' WHERE `id`='"+iid+"'";
        
        
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            sql = "INSERT INTO `historialinv`(`eid`, `inid`, `operacion`, `tiempo`, `cantidad_antes`, `cantidad_nueva`) VALUES ('"+di+"','"+iid+"','updated',NOW(),'"+pre_stock+"','"+stock+"')";
            
            
            System.out.println(sql);
            
            s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    
    public boolean delete(String id,int di){
        
        String sql="DELETE FROM productos WHERE id='"+id+"'";
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            Statement s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            sql = "INSERT INTO `historialinv`(`eid`, `inid`, `operacion`, `tiempo`, `cantidad_antes`, `cantidad_nueva`) VALUES ('"+di+"','"+id+"','deleted',NOW(),'0','0')";
            
            s =(Statement) con.prepareStatement(sql);
            
            s.execute(sql);
            
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
    }
    
    public DefaultTableModel search(String name,String stock,String price,String type,String weight,String buy_price){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Producto");
        dm.addColumn("Cantidad");
        dm.addColumn("Precio");
        dm.addColumn("Tipo");
        dm.addColumn("Peso");
        dm.addColumn("Precio Compra");
        dm.addColumn("Codigo");
        
        String sql=null;
        String a=null;
        
        if(name.equalsIgnoreCase("")==false){
            
            
            a=name;
            
            sql="SELECT * FROM productos WHERE producto LIKE  '"+a+"%' ";
        }
        else if(stock.equalsIgnoreCase("")==false){
            
            sql="SELECT * FROM productos WHERE cantidad=? ";
            a=stock;
        }
        else if(price.equalsIgnoreCase("")==false){
            
            sql="SELECT * FROM productos WHERE precio=? ";
            a=price;
        }
        else if(type.equalsIgnoreCase("")==false){
            
            sql="SELECT * FROM productos WHERE tipo=? ";
            a=type;
        }
        else if(weight.equalsIgnoreCase("")==false){
            
            sql="SELECT * FROM productos WHERE precio=? ";
            a=weight;
        }
        else if(buy_price.equalsIgnoreCase("")==false){
            
            sql="SELECT * FROM productos WHERE 'precio_compra'=? ";
            a=buy_price;
        }
        
        
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            
            
            ResultSet rs;
            
            if(a.equalsIgnoreCase(name)){
                rs = s.executeQuery(sql);
            }
            else{
                s.setString(1,a);
                rs = s.executeQuery();
            }
            
            
            
            //ResultSet rs = 
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String b = rs.getString(7);
                String bc = rs.getString(8);
                
                dm.addRow(new String[]{i,n,p,st,t,w,b,bc});
                
            }
            
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    
    
    public DefaultTableModel search(int choice,String text){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Producto");
        dm.addColumn("Cantidad");
        dm.addColumn("Precio");
        dm.addColumn("Tipo");
        dm.addColumn("Peso");
        dm.addColumn("Precio Compra");
        dm.addColumn("Codigo");
        
        String sql=null;
        
        
        if(choice==0){
            
            sql="SELECT * FROM productos WHERE producto LIKE  '"+text+"%'  ";
            
        }
        else if(choice==1){
            
            sql="SELECT * FROM productos WHERE tipo LIKE '"+text+"%' ";
            
        }
        else if(choice==2){
            
            sql="SELECT * FROM productos WHERE precio=? ";
            
        }
        else if(choice==3){
            
            sql="SELECT * FROM productos WHERE peso=? ";
            
        }
        else if(choice == 4){
            
            sql="SELECT * FROM productos WHERE codigo=? ";
        }
        
        
        try{
            
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            
            ResultSet rs;
            
            if(choice==0 || choice == 1){
                rs = s.executeQuery(sql);
            }
            else{
                s.setString(1,text);
                rs = s.executeQuery();
            }
            
            while(rs.next()){
                String i = rs.getString(1);
                String n = rs.getString(2);
                String p = rs.getString(3);
                String st = rs.getString(4);
                String t = rs.getString(5);
                String w = rs.getString(6);
                String bp = rs.getString(7);
                String bc = rs.getString(8);
                
                dm.addRow(new String[]{i,n,p,st,t,w,bp,bc});
                
            }
            
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return null;
    }
    
    
    
    
}
