package UD3Repaso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ConexionBD conect = new ConexionBD();
    static Seleccion seleccion = new Seleccion();
    static Jugador jugador = new Jugador();

    public static void ejercicio1() {
        try {
            // 8 SELECCIONES, 11 JUG POR SELECCION
            conect.conexion();
            String sql;
            Statement st;
            ResultSet rs;

            // SELECCIONES
            // ESPAÑA
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('España', 'Luis Padrique')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LUIS PADRIQUE AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Unai', 'Simon', 190, 'Portero', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("UNAI SIMÓN AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Daniel', 'Carvajal', 173, 'Defensa', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CARVAJAL AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Rodrigo', 'Hernandez', 190, 'Centrocampista', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RODRI AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Aymeric', 'Laporte', 190, 'Defensa', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LAPORTE AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Jordi', 'Alba', 170, 'Defensa', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("JORDI ALBA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Sergio', 'Busquets', 189, 'Centrocampista', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("BUSQUETS AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Pablo', 'Gavi', 173, 'Centrocampista', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GAVI AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Pedri', 174, 'Centrocampista', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("PEDRI AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Ferran', 'Torres', 184, 'Delantero', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("FERRAN TORRES AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Marco', 'Asensio', 182, 'Delantero', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("ASENSIO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Dani', 'Olmo', 179, 'Delantero', 'España')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("DANI OLMO AÑADIDO.");
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ejercicio1();
    }
}
