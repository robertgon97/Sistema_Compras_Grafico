package Proyecto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class CustomersUpdater {
    String conString ="jdbc:mysql://localhost:3306/sistemainventario";
    String username ="root";
    String passward ="";
    public DefaultTableModel getData(){
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Nombre");
        dm.addColumn("Apellido");
        dm.addColumn("Tipo");
        dm.addColumn("Descuento");
        dm.addColumn("Cedula");
        String sql = "SELECT * FROM clientes";
        try{
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            Statement s =(Statement) con.prepareStatement(sql);
            ResultSet rs =s.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String mType = rs.getString(4);
                String dis = rs.getString(5)+"%";
                String cNumber = rs.getString(6);
                dm.addRow(new String[]{id,fName,lName,mType,dis,cNumber});
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean add(String fname,String lname,String mtype,String dis,String card){
        String sql="INSERT INTO clientes(`id`, `nombre`, `apellido`, `tipo`, `descuento`, `cedula`) VALUES(NULL,'"+fname+"','"+lname+"','"+mtype+"','"+dis+"','"+card+"')";
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
    
    public boolean update(String id,String fname,String lname,String mtype,String dis,String card){
        String sql="UPDATE `clientes` SET `nombre`='"+fname+"',`apellido`='"+lname+"',`tipo`='"+mtype+"',`descuento`='"+dis+"',`cedula`='"+card+"' WHERE `id`='"+id+"'";
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
    public boolean delete(String id){
        String sql="DELETE FROM clientes WHERE id='"+id+"'";
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
    
    public DefaultTableModel search(int choice,String text){
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Nombre");
        dm.addColumn("Apellido");
        dm.addColumn("Tipo");
        dm.addColumn("Descuento");
        dm.addColumn("Cedula");
        String sql=null;
        if(choice==0){
            System.out.println("0");
            sql="SELECT * FROM `clientes` WHERE `cedula`=?";
        }
        else if(choice==1){
            System.out.println("1");
            sql="SELECT * FROM `clientes` WHERE `nombre`=?";
            
        }
        else if(choice==2){
            System.out.println("2");
            sql="SELECT * FROM `clientes` WHERE `tipo`=?";
        }
        try{
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            s.setString(1,text);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
                String i = rs.getString(1);
                String f = rs.getString(2);
                String l = rs.getString(3);
                String mt = rs.getString(4);
                String ds = rs.getString(5);
                String c = rs.getString(5);
               dm.addRow(new String[]{i,f,l,mt,ds,c});
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}