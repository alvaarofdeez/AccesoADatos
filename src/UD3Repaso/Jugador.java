package UD3Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Jugador {
    
    static ConexionBD conect = new ConexionBD();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String nombreJugador;
    public static String apellidosJugador;
    public static int altura;
    public static String demarcacion;
    public static String seleccion;

    public Jugador() {
        Jugador.nombreJugador = "";
        Jugador.apellidosJugador = "";
        Jugador.altura = 0;
        Jugador.demarcacion = "";
        Jugador.seleccion = "";
    }

    // GETTERS
    public String getNombreJugador() {
        return Jugador.nombreJugador;
    }

    public String getApellidosJugador() {
        return Jugador.apellidosJugador;
    }

    public int getAltura() {
        return Jugador.altura;
    }

    public String getDemarcacion() {
        return Jugador.demarcacion;
    }

    public String getSeleccion() {
        return Jugador.seleccion;
    }

    // SETTERS
    public void setNombreJugador(String nombre) {
        Jugador.nombreJugador = nombre;
    }

    public void setApellidosJugador(String apellidos) {
        Jugador.apellidosJugador = apellidos;
    }

    public void setAltura(int altura) {
        Jugador.altura = altura;
    }

    public void setDemarcacion(String demarcacion) {
        Jugador.demarcacion = demarcacion;
    }

    public void setSeleccion(String seleccion) {
        Jugador.seleccion = seleccion;
    }
    
    // METODOS
    public static void nuevoJugador() {
        try {
            conect.conexion();
            ResultSet rs;
            PreparedStatement ps;

            System.out.print("Introduce el nombre del jugador: ");
            nombreJugador = br.readLine();
            System.out.print("Introduce los apellidos del jugador: ");
            apellidosJugador = br.readLine();

            String sql = "SELECT * FROM jugadores WHERE NOMBRE_JUGADOR = ? AND APELLIDOS_JUGADOR = ?";
            ps = conect.conect.prepareStatement(sql);
            ps.setString(1, nombreJugador);
            ps.setString(2, apellidosJugador);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.print("Introduce la altura del jugador (cm): ");
                altura = Integer.parseInt(br.readLine());

                System.out.print("Introduce la demarcacion del jugador: ");
                demarcacion = br.readLine();

                System.out.print("Introduce la seleccion del jugador: ");
                seleccion = br.readLine();

                sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES (?, ?, ?, ?, ?)";
                ps = conect.conect.prepareStatement(sql);
                ps.setString(1, nombreJugador);
                ps.setString(2, apellidosJugador);
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

    public static void modificarJugador() {
        try {
            conect.conexion();
            String sql;
            PreparedStatement ps;
            ResultSet rs;

            System.out.print("Introduce el ID del jugador: ");
            int id = Integer.parseInt(br.readLine());

            sql = "SELECT * FROM jugadores WHERE ID_JUGADOR = ?";
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

            sql = "SELECT * FROM jugadores WHERE ID_JUGADOR = ?";
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
}
