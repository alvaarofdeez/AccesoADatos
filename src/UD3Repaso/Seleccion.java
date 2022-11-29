package UD3Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Seleccion {

    static ConexionBD conect = new ConexionBD();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String nombreSeleccion;
    public static String entrenador;

    public Seleccion() {
        Seleccion.nombreSeleccion = "";
        Seleccion.entrenador = "";
    }

    // GETTERS
    public String getNombreSeleccion() {
        return Seleccion.nombreSeleccion;
    }

    public String getEntrenador() {
        return Seleccion.entrenador;
    }

    // SETTERS
    public void setNombreSeleccion(String nombre) {
        Seleccion.nombreSeleccion = nombre;
    }

    public void setEntrenador(String entrenador) {
        Seleccion.entrenador = entrenador;
    }

    // METODOS
    public static void nuevaSeleccion() {
        try {
            conect.conexion();
            PreparedStatement ps;
            ResultSet rs;

            System.out.print("Introduce el nombre de la seleccion: ");
            nombreSeleccion = br.readLine();

            String sql = "SELECT * FROM seleccion WHERE NOMBRE_SELECCION = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setString(1, nombreSeleccion);
            rs = ps.executeQuery();

            if (rs == null) {
                System.out.print("Introduce el nombre del entrenador: ");
                entrenador = br.readLine();

                sql = "INSERT INTO seleccion (NOMBRE_SELECCION, ENTRENADOR) VALUES (?, ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, nombreSeleccion);
                ps.setString(2, entrenador);
                ps.executeUpdate();

                System.out.println("SELECCION AÑADIDA");
            } else {
                System.out.println("Esta seleccion ya existe en la base de datos.");
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void listarSelecciones() {
        try {
            conect.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "SELECT * FROM selecciones";
            ps = conect.conect.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("NOMBRE_SELECCION") + "\nEntrenador: " + rs.getString("ENTRENADOR"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void listarSeleccion() {
        try {
            conect.conexion();
            PreparedStatement ps;
            ResultSet rs;

            System.out.print("Introduce el nombre de la seleccion: ");
            nombreSeleccion = br.readLine();

            String sql = "SELECT * FROM selecciones WHERE NOMBRE_SELECCION = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setString(1, nombreSeleccion);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("NOMBRE_SELECCION") + "\nEntrenador: " + rs.getString("ENTRENADOR"));
                System.out.println();
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void modificarSeleccion() {
        try {
            conect.conexion();
            String sql;
            PreparedStatement ps;

            System.out.print("Introduce el nombre de la seleccion: ");
            String seleccion = br.readLine();

            System.out.println("¿Quieres modificar el nombre de la seleccion? S/n");
            if (br.readLine().equalsIgnoreCase("s")) {
                System.out.print("Introduce el nuevo nombre de la seleccion: ");
                nombreSeleccion = br.readLine();

                sql = "UPDATE seleccion SET NOMBRE_SELECCION = ? WHERE (NOMBRE_SELECCION = ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, nombreSeleccion);
                ps.setString(2, seleccion);
                ps.executeUpdate();
                System.out.println("SE HA MODIFICADO EL NOMBRE.");
            }
            System.out.println("¿Quieres modificar el entrenador de la seleccion? S/n");
            if (br.readLine().equalsIgnoreCase("s")) {
                System.out.print("Introduce el nuevo nombre del entrenador: ");
                entrenador = br.readLine();

                sql = "UPDATE seleccion SET ENTRENADOR = ? WHERE (NOMBRE_SELECCION = ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, entrenador);
                ps.setString(2, seleccion);
                ps.executeUpdate();
                System.out.println("SE HA MODIFICADO EL ENTRENADOR.");
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void eliminarSeleccion() {
        try {
            conect.conexion();
            String sql;
            PreparedStatement ps;
            ResultSet rs;

            System.out.println("Introduce el nombre de la seleccion: ");
            nombreSeleccion = br.readLine();

            sql = "SELECT * FROM jugadores WHERE SELECCION = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setString(1, nombreSeleccion);
            rs = ps.executeQuery();
            
            if (rs == null){
                sql = "DELETE FROM selecciones WHERE (NOMBRE_SELECCION = ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, nombreSeleccion);
                ps.executeUpdate();

                System.out.println("SELECCION ELIMINADA.");
            } else {
                System.out.println("ESTA SELECCION CONTIENE JUGADORES EN ACTIVO, NO SE PUEDE ELIMINAR.");
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
