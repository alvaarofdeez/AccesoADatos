package UD3Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Seleccion1 {

    static ConexionBD conect = new ConexionBD();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Seleccion1 seleccion = new Seleccion1();

    private String nombreSeleccion;
    private String entrenador;

    public Seleccion1() {
        this.nombreSeleccion = "";
        this.entrenador = "";
    }

    // GETTERS
    public String getNombreSeleccion() {
        return this.nombreSeleccion;
    }

    public String getEntrenador() {
        return this.entrenador;
    }

    // SETTERS
    public void setNombreSeleccion(String nombre) {
        this.nombreSeleccion = nombre;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    // METODOS
    public void nuevaSeleccion() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            System.out.print("Introduce el nombre de la seleccion: ");
            seleccion.setNombreSeleccion(br.readLine()); // ALMACENAMOS NOMBRE DEL JUGADOR

            String sql = "SELECT * FROM selecciones WHERE NOMBRE_SELECCION = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setString(1, seleccion.getNombreSeleccion()); // RELLENAMOS NOMBRE
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            if (!rs.next()) { // SI EL RESULTADO ES NULO, AÑADIREMOS LA SELECCION
                System.out.print("Introduce el nombre del entrenador: ");
                seleccion.setEntrenador(br.readLine()); // ALMACENAMOS ENTRENADOR

                sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES (?, ?)"; // CONSULTA PARA AÑADIR LA SELECCION
                ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                ps.setString(1, seleccion.getNombreSeleccion()); // RELLENAMOS NOMBRE
                ps.setString(2, seleccion.getEntrenador()); // RELLENAMOS ENTRENADOR
                ps.executeUpdate(); // LANZAMOS CONSULTA

                System.out.println("SELECCION AÑADIDA"); // INDICAMOS QUE SE HA AÑADIDO
            } else { // SI NO ES NULO
                System.out.println("Esta seleccion ya existe en la base de datos."); // INDICAMOS QUE LA SELECCION YA EXISTE
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listarSelecciones() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            String sql = "SELECT * FROM selecciones"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            while (rs.next()) { // RECORREMOS TODOS LOS RESULTADOS DE LA CONSULTA
                System.out.println("Nombre: " + rs.getString("NOMBRE_SELECCION") 
                        + "\nEntrenador: " + rs.getString("ENTRENADOR")); // MOSTRAMOS
                System.out.println(); // SALTO DE LÍNEA
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listarSeleccion() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            System.out.print("Introduce el nombre de la seleccion: ");
            seleccion.setNombreSeleccion(br.readLine()); // ALMACENAMOS NOMBRE

            String sql = "SELECT * FROM selecciones WHERE NOMBRE_SELECCION = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setString(1, seleccion.getNombreSeleccion()); // RELLENAMOS NOMBRE
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            while (rs.next()) { // RECORREMOS TODOS LOS RESULTADOS DE LA CONSULTA
                System.out.println("Nombre: " + rs.getString("NOMBRE_SELECCION") 
                        + "\nEntrenador: " + rs.getString("ENTRENADOR")); // MOSTRAMOS
                System.out.println(); // SALTO DE LÍNEA
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void modificarSeleccion() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            String sql; // VARIABLE PARA ALMACENAR CONSULTA
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            System.out.print("Introduce el nombre de la seleccion: ");
            String nombre = br.readLine(); // ALMACENAMOS NOMBRE

            sql = "SELECT * FROM selecciones WHERE NOMBRE_SELECCION = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setString(1, nombre); // RELLENAMOS NOMBRE
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            if (rs.next()) { // SI EL RESULTADO NO ES NULO, ES DECIR, LA SELECCIÓN ESTÁ EN LA BASE DE DATOS
                System.out.println("¿Quieres modificar el nombre de la seleccion? S/n"); // PREGUNTAMOS SI QUIERE MODIFICAR ESTE CAMPO
                if (br.readLine().equalsIgnoreCase("s")) { // SI QUIERE
                    System.out.print("Introduce el nuevo nombre de la seleccion: ");
                    seleccion.setNombreSeleccion(br.readLine()); // ALMACENAMOS NOMBRE

                    sql = "UPDATE selecciones SET NOMBRE_SELECCION = ? WHERE (NOMBRE_SELECCION = ?)"; // ESCRIBIMOS CONSULTA
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setString(1, seleccion.getNombreSeleccion()); // RELLENAMOS CAMPOS
                    ps.setString(2, nombre);
                    ps.executeUpdate(); // LANZAMOS CONSULTA
                    System.out.println("SE HA MODIFICADO EL NOMBRE."); // INDICAMOS
                }
                System.out.println("¿Quieres modificar el entrenador de la seleccion? S/n"); // PREGUNTAMOS SI QUIERE MODIFICAR ESTE CAMPO
                if (br.readLine().equalsIgnoreCase("s")) { // SI QUIERE
                    System.out.print("Introduce el nuevo nombre del entrenador: ");
                    seleccion.setEntrenador(br.readLine()); // ALMACENAMOS ENTRENADOR

                    sql = "UPDATE selecciones SET ENTRENADOR = ? WHERE (NOMBRE_SELECCION = ?)"; // ESCRIBIMOS CONSULTA
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setString(1, seleccion.getEntrenador()); // RELLENAMOS CAMPOS
                    ps.setString(2, nombre);
                    ps.executeUpdate(); // LANZAMOS CONSULTA
                    System.out.println("SE HA MODIFICADO EL ENTRENADOR."); // INDICAMOS
                }
            } else { // SI ES NULO
                System.out.println("Esta seleccion no existe en la base de datos."); // INDICAMOS QUE NO EXISTE
            }

        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void eliminarSeleccion() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            String sql; // VARIABLE PARA ALMACENAR CONSULTA
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            System.out.println("Introduce el nombre de la seleccion: ");
            seleccion.setNombreSeleccion(br.readLine()); // ALAMCENAMOS NOMBRE

            sql = "SELECT * FROM jugadores WHERE SELECCION = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setString(1, seleccion.getNombreSeleccion()); // RELLENAMOS NOMBRE
            rs = ps.executeQuery(); // LANZAMOS REUSLTADO

            if (!rs.next()) { // SI EL RESULTADO ES NULO, ES DECIR NO HAY NINGUN JUGADOR EN ESA SELECCION
                sql = "DELETE FROM selecciones WHERE (NOMBRE_SELECCION = ?)"; // ESCRIBIMOS CONSULTA
                ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                ps.setString(1, seleccion.getNombreSeleccion()); // RELLENAMOS NOMBRE
                ps.executeUpdate(); // LANZAMOS CONSULTA

                System.out.println("SELECCION ELIMINADA."); // INDICAMOS
            } else { // SI NO ES NULA, ES DECIR, TIENE JUGADORES
                System.out.println("ESTA SELECCION CONTIENE JUGADORES EN ACTIVO, NO SE PUEDE ELIMINAR."); // INDICAMOS QUE NO SE PUEDE ELIMINAR
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
