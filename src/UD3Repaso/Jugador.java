package UD3Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Jugador {

    static ConexionBD conect = new ConexionBD();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Jugador jugador = new Jugador();

    private int idJugador;
    private String nombreJugador;
    private String apellidosJugador;
    private int altura;
    private String demarcacion;
    private String seleccion;

    public Jugador() {
        this.nombreJugador = "";
        this.apellidosJugador = "";
        this.altura = 0;
        this.demarcacion = "";
        this.seleccion = "";
    }

    // GETTERS
    public int getIdJugador() {
        return this.idJugador;
    }

    public String getNombreJugador() {
        return this.nombreJugador;
    }

    public String getApellidosJugador() {
        return this.apellidosJugador;
    }

    public int getAltura() {
        return this.altura;
    }

    public String getDemarcacion() {
        return this.demarcacion;
    }

    public String getSeleccion() {
        return this.seleccion;
    }

    // SETTERS
    public void setIdJugador(int id) {
        this.idJugador = id;
    }

    public void setNombreJugador(String nombre) {
        this.nombreJugador = nombre;
    }

    public void setApellidosJugador(String apellidos) {
        this.apellidosJugador = apellidos;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setDemarcacion(String demarcacion) {
        this.demarcacion = demarcacion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

    // METODOS
    public void nuevoJugador() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            ResultSet rs; // VARIABLE PARA SABER RESULTADO
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA

            System.out.print("Introduce el nombre del jugador: ");
            jugador.setNombreJugador(br.readLine()); // ALMACENAMOS NOMBRE DEL JUGADOR
            System.out.print("Introduce los apellidos del jugador: ");
            jugador.setApellidosJugador(br.readLine()); // ALMACENAMOS APELLIDOS DEL JUGADOR

            String sql = "SELECT * FROM jugadores WHERE NOMBRE_JUGADOR = ? AND APELLIDOS_JUGADOR = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setString(1, jugador.getNombreJugador()); // RELLENAMOS CAMPOS
            ps.setString(2, jugador.getApellidosJugador());
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            if (!rs.next()) { // SI EL RESULTADO ES NULO, AÑADIREMOS EL JUGADOR
                System.out.print("Introduce la altura del jugador (cm): ");
                jugador.setAltura(Integer.parseInt(br.readLine())); // ALMACENAMOS ALTURA

                System.out.print("Introduce la demarcacion del jugador: ");
                jugador.setDemarcacion(br.readLine()); // ALMACENAMOS DEMARCACION

                System.out.print("Introduce la seleccion del jugador: ");
                jugador.setSeleccion(br.readLine()); // ALMACENAMOS SELECCION

                int contador = 0;
                boolean bandera = true;

                sql = "SELECT * FROM jugadores WHERE SELECCION = ?"; // CONSULTA PARA COMPROBAR SI LA SELECCION ESTÁ COMPLETA
                ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                ps.setString(1, jugador.getSeleccion()); // RELLENAMOS SELECCION
                rs = ps.executeQuery(); // LANZAMOS RESULTADO

                while (rs.next()) { // RECORREMOS TODOS LOS RESULTADOS DE LA CONSULTA
                    contador++; // INCREMENTAMOS CONTADOR CADA VEZ QUE HAYA UN CAMPO
                    if (contador < 26) { // SI EL CONTADOR ES MENOR DE 26
                        bandera = true; // VARIABLE BANDERA NOS DEJARÁ AÑADIRLO
                    } else { // SI ES IGUAL O MAYOR 
                        bandera = false; // VARIABLE BANDERA NO NOS DEJARÁ AÑADIRLO
                    }
                }

                if (bandera == true) { // SI NOS DEJA AÑADIRLO
                    sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES (?, ?, ?, ?, ?)"; // CONSULTA PARA AÑADIRLO
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setString(1, jugador.getNombreJugador()); // RELLENAMOS CAMPOS
                    ps.setString(2, jugador.getApellidosJugador());
                    ps.setInt(3, jugador.getAltura());
                    ps.setString(4, jugador.getDemarcacion());
                    ps.setString(5, jugador.getSeleccion());
                    ps.executeUpdate(); // LANZAMOS CONSULTA

                    System.out.println("JUGADOR AÑADIDO"); // INDICAMOS QUE SE HA AÑADIDO
                } else { // SI NO NOS DEJA AÑADIRLO
                    System.out.println("La selección está completa."); // INDICAMOS QUE ESTÁ COMPLETA
                }
            } else { // SI NO ES NULO
                System.out.println("Esta jugador ya existe en la base de datos."); // INDICAMOS QUE EL JUGADOR YA EXISTE
            }
        } catch (IOException | NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listarJugadores() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            String sql = "SELECT * FROM jugadores"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            while (rs.next()) { // RECORREMOS TODOS LOS RESULTADOS DE LA CONSULTA
                System.out.println("ID: " + rs.getString("ID_JUGADOR")
                        + "\nNombre: " + rs.getString("NOMBRE_JUGADOR")
                        + "\nApellidos: " + rs.getString("APELLIDOS_JUGADOR")
                        + "\nAltura: " + rs.getString("ALTURA")
                        + "\nDemarcacion: " + rs.getString("DEMARCACION")
                        + "\nSeleccion: " + rs.getString("SELECCION")); // MOSTRAMOS
                System.out.println(); // SALTO DE LÍNEA
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listarJugador() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            System.out.print("Introduce la ID del jugador: ");
            jugador.setIdJugador(Integer.parseInt(br.readLine())); // ALAMCENAMOS ID 

            String sql = "SELECT * FROM jugadores WHERE ID_JUGADOR = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setInt(1, jugador.getIdJugador()); // RELLENAMOS ID
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            while (rs.next()) { // RECORREMOS TODOS LOS RESULTADOS DE LA CONSULTA
                System.out.println("ID: " + rs.getString("ID_JUGADOR")
                        + "\nNombre: " + rs.getString("NOMBRE_JUGADOR")
                        + "\nApellidos: " + rs.getString("APELLIDOS_JUGADOR")
                        + "\nAltura: " + rs.getString("ALTURA")
                        + "\nDemarcacion: " + rs.getString("DEMARCACION")
                        + "\nSeleccion: " + rs.getString("SELECCION"));
                System.out.println(); // SALTO DE LÍNEA
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void modificarJugador() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            String sql; // VARIABLE PARA ALMACENAR CONSULTA
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            System.out.print("Introduce el ID del jugador: ");
            jugador.setIdJugador(Integer.parseInt(br.readLine())); // ALAMCENAMOS ID 

            sql = "SELECT * FROM jugadores WHERE ID_JUGADOR = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setInt(1, jugador.getIdJugador()); // RELLENAMOS ID
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            if (rs.next()) { // SI NO ES NULO, ES DECIR, EL JUGADOR EXISTE
                System.out.print("¿Quieres modificar el nombre del jugador? S/n "); // PREGUNTAMOS SI QUIERE MODIFICAR ESTE CAMPO
                if (br.readLine().equalsIgnoreCase("s")) { // SI QUIERE
                    System.out.print("Introduce el nuevo nombre del jugador: ");
                    jugador.setNombreJugador(br.readLine()); // ALAMCENAMOS NOMBRE

                    sql = "UPDATE jugadores SET NOMBRE_JUGADOR = ? WHERE (ID_JUGADOR = ?)"; // ESCRIBIMOS CONSULTA
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setString(1, jugador.getNombreJugador()); // RELLENAMOS CAMPOS
                    ps.setInt(2, jugador.getIdJugador());
                    ps.executeUpdate(); // LANZAMOS CONSULTA
                    System.out.println("SE HA MODIFICADO EL NOMBRE."); // INDICAMOS
                }
                System.out.print("¿Quieres modificar los apellidos del jugador? S/n "); // PREGUNTAMOS SI QUIERE MODIFICAR ESTE CAMPO
                if (br.readLine().equalsIgnoreCase("s")) { // SI QUIERE
                    System.out.print("Introduce los nuevos apellidos del jugador: ");
                    jugador.setApellidosJugador(br.readLine()); // ALAMCENAMOS APELLIDOS

                    sql = "UPDATE jugadores SET APELLIDOS_JUGADOR = ? WHERE (ID_JUGADOR = ?)"; // ESCRIBIMOS CONSULTA
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setString(1, jugador.getApellidosJugador()); // RELLENAMOS CAMPOS
                    ps.setInt(2, jugador.getIdJugador());
                    ps.executeUpdate(); // LANZAMOS CONSULTA
                    System.out.println("SE HAN MODIFICADO LOS APELLIDOS."); // INDICAMOS
                }
                System.out.print("¿Quieres modificar la altura del jugador? S/n "); // PREGUNTAMOS SI QUIERE MODIFICAR ESTE CAMPO
                if (br.readLine().equalsIgnoreCase("s")) { // SI QUIERE
                    System.out.print("Introduce la nuva altura (cm) del jugador: ");
                    jugador.setAltura(Integer.parseInt(br.readLine())); // ALAMCENAMOS ALTURA

                    sql = "UPDATE jugadores SET ALTURA = ? WHERE (ID_JUGADOR = ?)"; // ESCRIBIMOS CONSULTA
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setInt(1, jugador.getAltura()); // RELLENAMOS CAMPOS
                    ps.setInt(2, jugador.getIdJugador());
                    ps.executeUpdate(); // LANZAMOS CONSULTA
                    System.out.println("SE HA MODIFICADO LA ALTURA."); // INDICAMOS
                }
                System.out.print("¿Quieres modificar la demarcacion del jugador? S/n "); // PREGUNTAMOS SI QUIERE MODIFICAR ESTE CAMPO
                if (br.readLine().equalsIgnoreCase("s")) { // SI QUIERE
                    System.out.print("Introduce la nueva demarcacion del jugador: ");
                    jugador.setDemarcacion(br.readLine()); // ALAMCENAMOS DEMARCACION

                    sql = "UPDATE jugadores SET DEMARCACION = ? WHERE (ID_JUGADOR = ?)"; // ESCRIBIMOS CONSULTA
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setString(1, jugador.getDemarcacion()); // RELLENAMOS CAMPOS
                    ps.setInt(2, jugador.getIdJugador());
                    ps.executeUpdate(); // LANZAMOS CONSULTA
                    System.out.println("SE HA MODIFICADO LA DEMARCACION."); // INDICAMOS
                }
                System.out.print("¿Quieres modificar la seleccion del jugador? S/n "); // PREGUNTAMOS SI QUIERE MODIFICAR ESTE CAMPO
                if (br.readLine().equalsIgnoreCase("s")) { // SI QUIERE
                    System.out.print("Introduce la nueva seleccion del jugador: ");
                    jugador.setSeleccion(br.readLine()); // ALAMCENAMOS SELECCION

                    int contador = 0;
                    boolean bandera = true;

                    sql = "SELECT * FROM jugadores WHERE SELECCION = ?";  // CONSULTA PARA COMPROBAR SI LA SELECCION ESTÁ COMPLETA
                    ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                    ps.setString(1, jugador.getSeleccion()); // RELLENAMOS SELECCION
                    rs = ps.executeQuery(); // LANZAMOS RESULTADO

                    while (rs.next()) { // RECORREMOS TODOS LOS RESULTADOS DE LA CONSULTA
                        contador++; // INCREMENTAMOS CONTADOR CADA VEZ QUE HAYA UN CAMPO
                        if (contador < 26) { // SI EL CONTADOR ES MENOR DE 26
                            bandera = true; // VARIABLE BANDERA NOS DEJARÁ AÑADIRLO
                        } else { // SI ES IGUAL O MAYOR 
                            bandera = false; // VARIABLE BANDERA NO NOS DEJARÁ AÑADIRLO
                        }
                    }

                    if (bandera == true) { // SI NOS DEJA AÑADIRLO
                        sql = "UPDATE jugadores SET SELECCION = ? WHERE (ID_JUGADOR = ?)"; // ESCRIBIMOS CONSULTA
                        ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                        ps.setString(1, jugador.getSeleccion()); // RELLENAMOS CAMPOS
                        ps.setInt(2, jugador.getIdJugador());
                        ps.executeUpdate(); // LANZAMOS CONSULTA
                        System.out.println("SE HA MODIFICADO LA SELECCION."); // INDICAMOS
                    } else { // SI NO NOS DEJA
                        System.out.println("LA SELECCION ESTA COMPLETA."); // INDICAMOS
                    }
                }
            } else { // SI ES NULO, ES DECIR, EL JUGADOR NO EXISTE
                System.out.println("NO EXISTE ESE JUGADOR."); // INDICAMOS
            }
        } catch (IOException | NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void eliminarJugador() {
        try {
            conect.conexion(); // REALIZAMOS CONEXION
            String sql; // VARIABLE PARA ALMACENAR CONSULTA
            PreparedStatement ps; // VARIABLE PARA LANZAR CONSULTA
            ResultSet rs; // VARIABLE PARA SABER RESULTADO

            System.out.print("Introduce el ID del jugador: ");
            jugador.setIdJugador(Integer.parseInt(br.readLine())); // ALMACENAMOS ID

            sql = "SELECT * FROM jugadores WHERE ID_JUGADOR = ?"; // ESCRIBIMOS CONSULTA
            ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
            ps.setInt(1, jugador.getIdJugador()); // RELLENAMOS ID
            rs = ps.executeQuery(); // LANZAMOS RESULTADO

            if (rs.next()) { // SI NO ES NULO, ES DECIR, EL JUGADOR EXISTE
                sql = "DELETE FROM jugadores WHERE (ID_JUGADOR = ?)"; // ESCRIBIMOS CONSULTA
                ps = conect.conect.prepareStatement(sql); // LANZAMOS CONSULTA
                ps.setInt(1, jugador.getIdJugador()); // RELLENAMOS ID
                ps.executeUpdate(); // LANZAMOS CONSULTA

                System.out.println("FUTBOLISTA BORRADO."); // INDICAMOS
            } else { // SI ES NULO, ES DECIR, EL JUGADOR NO EXISTE
                System.out.println("NO EXISTE ESE JUGADOR."); // INDICAMOS
            }
        } catch (IOException | NumberFormatException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
