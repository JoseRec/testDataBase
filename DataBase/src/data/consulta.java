/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class consulta extends Conexion {

    public boolean registrar(Persona p) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO persona (Nombre, Numero, Cedula) VALUES (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getNumeroTelefono());
            ps.setString(3, p.getCedula());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<Persona> todosArticulo() {
        ArrayList<Persona> miListaArticulo = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try {
            Connection con = getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Persona persona = new Persona(
                        rs.getString("Nombre"),
                        rs.getInt("Numero"),
                        rs.getString("Cedula")
                );
                miListaArticulo.add(persona);
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(consulta.class.getName()).log(Level.SEVERE, null, e);
        }
        return miListaArticulo;
    }

    public void mostrarLista() {
        ArrayList<Persona> lista = todosArticulo(); // Obtenemos la lista de personas
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Lista de Personas:");
            for (Persona persona : lista) {
                System.out.println("Nombre: " + persona.getNombre()
                        + ", Número: " + persona.getNumeroTelefono()
                        + ", Cédula: " + persona.getCedula());
            }
        }
    }
}
