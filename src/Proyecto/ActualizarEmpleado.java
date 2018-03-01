package Proyecto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ActualizarEmpleado {
    String conString ="jdbc:mysql://localhost:3306/sistemainventario";
    String username ="root";
    String passward ="";
    
    public boolean add(String First_name,String Last_name,String Post,String salary,String pass){
        String sql="INSERT INTO `empleados` (`nombre`, `apellido`, `tipo`, `salario` , `contraseña`) VALUES('"+First_name+"','"+Last_name+"','"+Post+"','"+salary+"','"+pass+"')";
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
    
    public DefaultTableModel getData(){
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Nombre");
        dm.addColumn("Apellido");
        dm.addColumn("Tipo");
        dm.addColumn("Salario");
        String sql = "SELECT * FROM empleados";
        try{
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            Statement s =(Statement) con.prepareStatement(sql);
            ResultSet rs =s.executeQuery(sql);
            while(rs.next()){
                String i = rs.getString(1);
                String f = rs.getString(2);
                if(f.equalsIgnoreCase("sistemainventario")) continue;
                String l = rs.getString(3);
                String p = rs.getString(4);
                String sa = rs.getString(5);
                dm.addRow(new String[]{i,f,l,p,sa});
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(String id,String First_name,String Last_name,String Post,String salary){
        String sql="UPDATE  `empleados` SET  `nombre` =  '"+First_name+"',`apellido` =  '"+Last_name+"',`tipo` =  '"+Post+"',`salario` =  '"+salary+"' WHERE  `id` =  '"+id+"'";
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
        String sql="DELETE FROM empleados WHERE id='"+id+"'";
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
        dm.addColumn("Nomber");
        dm.addColumn("Apellido");
        dm.addColumn("Puesto");
        dm.addColumn("Salario");
        String sql=null;
        if(choice==0){
            sql="SELECT * FROM  `empleados` WHERE  `nombre`=?";
        }
        else if(choice==1){
            sql="SELECT * FROM `empleados` WHERE `apellido`=?";
        }
        else if(choice==2){
            sql="SELECT * FROM `empleados` WHERE `tipo`=?";
        }
        else if(choice==3){
            sql="SELECT * FROM `empleados` WHERE `salario`=?";
        }
        else if(choice==4){
            sql="SELECT * FROM `empleados` WHERE `id`=?";
        }
        try{
            Connection con= (Connection) DriverManager.getConnection(conString, username, passward);
            PreparedStatement s =(PreparedStatement) con.prepareStatement(sql);
            s.setString(1,text);
            ResultSet rs = s.executeQuery();
            while(rs.next()){
                String i = rs.getString(1);
                String f = rs.getString(2);
                if(f.equalsIgnoreCase("sistemainventario")) continue;
                String l = rs.getString(3);
                String p = rs.getString(4);
                String sa = rs.getString(5);
                dm.addRow(new String[]{i,f,l,p,sa});
            }
            return dm;
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("---");
        return null;
    }
}