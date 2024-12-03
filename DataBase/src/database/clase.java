package database;

import javax.swing.JOptionPane;


public class clase {
    public void saludar(){
        JOptionPane.showMessageDialog(null, "Hola! \nComo estas?");
    }
    
    public void ingName(){
        String name = JOptionPane.showInputDialog("Ingrese su nombre: ");
        JOptionPane.showMessageDialog(null, "Tu nombre es: " + name );
    }
}
