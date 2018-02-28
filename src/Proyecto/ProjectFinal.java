package Proyecto;

import javax.swing.UIManager;
public class ProjectFinal {
    public static void main(String[] args) {
        new Thread(){
            public void run() {
                try {
                    Thread.sleep(3500);
                    System.out.println("Inicio de la App");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new LogIn().setVisible(true);
            }
        }.start();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Error" + ex.toString());
        }
    }
}
