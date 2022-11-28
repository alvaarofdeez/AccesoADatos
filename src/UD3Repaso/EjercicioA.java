package UD3Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class EjercicioA {

    static ConexionBD conect = new ConexionBD();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void nuevaSeleccion() {
        try {
            conect.conexion();
            PreparedStatement ps;
            Statement st;
            ResultSet rs;

            System.out.print("Introduce el nombre de la seleccion: ");
            String nombre = br.readLine();

            String sql = "SELECT * FROM seleccion WHERE NOMBRE_SELECCION = '" + nombre + "'";
            st = conect.conect.createStatement();
            rs = st.executeQuery(sql);

            if (rs == null) {
                System.out.print("Introduce el nombre del entrenador: ");
                String entrenador = br.readLine();

                sql = "INSERT INTO seleccion (NOMBRE_SELECCION, ENTRENADOR) VALUES (?, ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, nombre);
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

    public static void nuevoJuegador() {
        try {
            conect.conexion();
            Statement st;
            ResultSet rs;
            PreparedStatement ps;

            System.out.print("Introduce el nombre del jugador: ");
            String nombre = br.readLine();
            System.out.print("Introduce los apellidos del jugador: ");
            String apellidos = br.readLine();

            String sql = "SELECT * FROM jugadores WHERE NOMBRE_JUGADOR = '" + nombre + "' AND APELLIDOS_JUGADOR = '" + apellidos + "'";
            st = conect.conect.createStatement();
            rs = st.executeQuery(sql);

            if (rs == null) {
                System.out.print("Introduce la altura del jugador (cm): ");
                int altura = Integer.parseInt(br.readLine());

                System.out.print("Introduce la demarcacion del jugador: ");
                String demarcacion = br.readLine();

                System.out.print("Introduce la seleccion del jugador: ");
                String seleccion = br.readLine();

                sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES (?, ?, ?, ?, ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, apellidos);
                ps.setInt(3, altura);
                ps.setString(4, demarcacion);
                ps.setString(5, seleccion);
                ps.executeUpdate();

                System.out.println("JUGADOR AÑADIDO");
            } else {
                System.out.println("Esta jugador ya existe en la base de datos.");
            }
        } catch (IOException | NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void listarSelecciones() {
        try {
            conect.conexion();
            Statement st;
            ResultSet rs;

            String sql = "SELECT * FROM selecciones";
            st = conect.conect.createStatement();
            rs = st.executeQuery(sql);

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
            String nombre = br.readLine();

            String sql = "SELECT * FROM selecciones WHERE NOMBRE_SELECCION = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setString(1, nombre);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("NOMBRE_SELECCION") + "\nEntrenador: " + rs.getString("ENTRENADOR"));
                System.out.println();
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void listarJugadores() {
        try {
            conect.conexion();
            Statement st;
            ResultSet rs;

            String sql = "SELECT * FROM jugadores";
            st = conect.conect.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("ID_JUGADOR") + "\nNombre: " + rs.getString("NOMBRE_JUGADOR") + "\nApellidos: " + rs.getString("APELLIDOS_JUGADOR") + "\nAltura: " + rs.getString("ALTURA") + "\nDemarcacion: " + rs.getString("DEMARCACION") + "\nSeleccion: " + rs.getString("SELECCION"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void listarJugador() {
        try {
            conect.conexion();
            PreparedStatement ps;
            ResultSet rs;

            System.out.print("Introduce la ID del jugador: ");
            int id = Integer.parseInt(br.readLine());

            String sql = "SELECT * FROM jugadores WHERE ID_JUGADOR = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getString("ID_JUGADOR") + "\nNombre: " + rs.getString("NOMBRE_JUGADOR") + "\nApellidos: " + rs.getString("APELLIDOS_JUGADOR") + "\nAltura: " + rs.getString("ALTURA") + "\nDemarcacion: " + rs.getString("DEMARCACION") + "\nSeleccion: " + rs.getString("SELECCION"));
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
                String nombre = br.readLine();

                sql = "UPDATE seleccion SET NOMBRE_SELECCION = ? WHERE (NOMBRE_SELECCION = ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, seleccion);
                ps.executeUpdate();
                System.out.println("SE HA MODIFICADO EL NOMBRE.");
            }
            System.out.println("¿Quieres modificar el entrenador de la seleccion? S/n");
            if (br.readLine().equalsIgnoreCase("s")) {
                System.out.print("Introduce el nuevo nombre del entrenador: ");
                String entrenador = br.readLine();

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

    public static void modificarJugador() {
        try {
            conect.conexion();
            String sql;
            PreparedStatement ps;
            ResultSet rs;

            System.out.print("Introduce el ID del jugador: ");
            int id = Integer.parseInt(br.readLine());

            sql = "SELECT * FROM futbolistas WHERE ID_JUGADOR = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs != null) {
                System.out.println("¿Quieres modificar el nombre del jugador? S/n");
                if (br.readLine().equalsIgnoreCase("s")) {
                    System.out.print("Introduce el nuevo nombre del jugador: ");
                    String nombre = br.readLine();

                    sql = "UPDATE jugadores SET NOMBRE_JUGADOR = ? WHERE (ID_JUGADOR = ?)";
                    ps = conect.conect.prepareStatement(sql);
                    ps.setString(1, nombre);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("SE HA MODIFICADO EL NOMBRE.");
                }
                System.out.println("¿Quieres modificar los apellidos del jugador? S/n");
                if (br.readLine().equalsIgnoreCase("s")) {
                    System.out.print("Introduce los nuevos apellidos del jugador: ");
                    String apellidos = br.readLine();

                    sql = "UPDATE jugadores SET APELLIDOS_JUGADOR = ? WHERE (ID_JUGADOR = ?)";
                    ps = conect.conect.prepareStatement(sql);
                    ps.setString(1, apellidos);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("SE HAN MODIFICADO LOS APELLIDOS.");
                }
                System.out.println("¿Quieres modificar la altura del jugador? S/n");
                if (br.readLine().equalsIgnoreCase("s")) {
                    System.out.print("Introduce la nuva altura (cm) del jugador: ");
                    int altura = Integer.parseInt(br.readLine());

                    sql = "UPDATE jugadores SET ALTURA = ? WHERE (ID_JUGADOR = ?)";
                    ps = conect.conect.prepareStatement(sql);
                    ps.setInt(1, altura);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("SE HA MODIFICADO LA ALTURA.");
                }
                System.out.println("¿Quieres modificar la demarcacion del jugador? S/n");
                if (br.readLine().equalsIgnoreCase("s")) {
                    System.out.print("Introduce la nueva demarcacion del jugador: ");
                    String demarcacion = br.readLine();

                    sql = "UPDATE jugadores SET DEMARCACION = ? WHERE (ID_JUGADOR = ?)";
                    ps = conect.conect.prepareStatement(sql);
                    ps.setString(1, demarcacion);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    System.out.println("SE HA MODIFICADO LA DEMARCACION.");
                }
                System.out.println("¿Quieres modificar la seleccion del jugador? S/n");
                if (br.readLine().equalsIgnoreCase("s")) {
                    System.out.print("Introduce la nueva seleccion del jugador: ");
                    String seleccion = br.readLine();

                    int contador = 0;
                    boolean bandera = true;

                    sql = "SELECT * FROM jugadores WHERE SELECCION = ?";
                    ps = conect.conect.prepareStatement(sql);
                    ps.setString(1, seleccion);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        contador++;
                        if (contador < 26) {
                            bandera = true;
                        } else {
                            bandera = false;
                        }
                    }

                    if (bandera == true) {
                        sql = "UPDATE jugadores SET SELECCION = ? WHERE (ID_JUGADOR = ?)";
                        ps = conect.conect.prepareStatement(sql);
                        ps.setString(1, seleccion);
                        ps.setInt(2, id);
                        ps.executeUpdate();
                        System.out.println("SE HA MODIFICADO LA SELECCION.");
                    } else {
                        System.out.println("LA SELECCION ESTA COMPLETA.");
                    }
                }
            } else {
                System.out.println("NO EXISTE ESE JUGADOR.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void eliminarJugador() {
        try {
            conect.conexion();
            String sql;
            PreparedStatement ps;
            ResultSet rs;

            System.out.print("Introduce el ID del jugador: ");
            int id = Integer.parseInt(br.readLine());

            sql = "SELECT * FROM futbolistas WHERE ID_JUGADOR = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs != null) {
                sql = "DELETE FROM jugadores WHERE (ID_JUGADOR = ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();

                System.out.println("FUTBOLISTA BORRADO.");
            } else {
                System.out.println("NO EXISTE ESE JUGADOR.");
            }
        } catch (IOException | NumberFormatException | SQLException e) {
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
            String seleccion = br.readLine();
            
            sql = "SELECT * FROM jugadores WHERE SELECCION = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setString(1, seleccion);
            rs = ps.executeQuery();
            
            int contador = 0;
            boolean bandera = true;
            
            while (rs.next()){
                contador++;
                if (contador < 1){
                    bandera = true;
                } else {
                    bandera = false;
                }
            }
            
            if (bandera == true){
                sql = "DELETE FROM seleccion WHERE (NOMBRE_SELECCION = ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, seleccion);
                ps.executeUpdate();
                
                System.out.println("SELECCION ELIMINADA.");
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

    }
}
