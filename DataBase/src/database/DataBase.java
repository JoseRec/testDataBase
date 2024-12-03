package database;

import data.Persona;
import data.consulta;
import javax.swing.JOptionPane;

public class DataBase {
    public static void main(String[] args) {
        consulta c = new consulta();
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero: "));
        String cedula = JOptionPane.showInputDialog("Ingrese su cedula: ");
        Persona p = new Persona(nombre, numero, cedula);
        c.registrar(p);
        c.mostrarLista();
    }
}
