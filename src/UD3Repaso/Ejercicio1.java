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
            
            // ALEMANIA
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('Alemania', 'Hansi Flick')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("HANSI FLICK AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Manuel', 'Neuer', 193, 'Portero', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("NEUER AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('David', 'Raum', 180, 'Defensa', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RAUM AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Antonio', 'Rüdiger', 190, 'Defensa', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RÜDIGER AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Niklas', 'Süle', 195, 'Defensa', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("SÜLE AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Thilo', 'Kehrer', 186, 'Defensa', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("KEHRER AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Leon', 'Goreztka', 189, 'Centrocampista', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GOREZTKA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Joshua', 'Kimmich', 177, 'Centrocampista', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("KIMMICH AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Íllkay', 'Gündogan', 180, 'Centrocampista', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GÜNDOGAN AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Jamal', 'Musiala', 183, 'Centrocampista', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MUSIALA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Serge', 'Gnabry', 176, 'Delantero', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GNABRY AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Thomas', 'Müller', 185, 'Delantero', 'Alemania')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MÜLLER AÑADIDO.");
            
            // CROACIA
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('Croacia', 'Zlatko Dalic')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CROACIA AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Dominik', 'Livakovic', 188, 'Portero', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LIVAKOVIC AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Josip', 'Juranovic', 173, 'Defensa', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("JURANOVIC AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Dejan', 'Lovren', 188, 'Defensa', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LOVREN AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Josko', 'Gvardiol', 185, 'Defensa', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GVARDIOL AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Borna', 'Sosa', 187, 'Defensa', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("SOSA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Luka', 'Modric', 172, 'Centrocampista', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MODRIC AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Marcelo', 'Brozovic', 181, 'Centrocampista', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("BROZOVIC AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Mateo', 'Kovacic', 177, 'Centrocampista', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("KOVACIC AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Andrej', 'Kramaric', 177, 'Delantero', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("KRAMARIC AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Marko', 'Livaja', 182, 'Delantero', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LIVAJA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Ivan', 'Perisic', 187, 'Delantero', 'Croacia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("PERISIC AÑADIDO.");
            
            // BELGICA
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('Belgica', 'Roberto Martínez')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CROACIA AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Thibaut', 'Courtois', 199, 'Portero', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("COURTOIS AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Toby', 'Alderweireld', 186, 'Defensa', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("ALDERWEIRELD AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Jan', 'Vertonghen', 189, 'Defensa', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("VERTONGHEN AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Timoty', 'Castagne', 185, 'Defensa', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CASTAGNE AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Thomas', 'Meunier', 190, 'Defensa', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MEUNIER AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Amadou', 'Onana', 192, 'Centrocampista', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("ONANA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Axel', 'Witsel', 186, 'Centrocampista', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("WITSEL AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Thorgan', 'Hazard', 174, 'Delantero', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("THROGAN HAZARD AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Kevin', 'De Bruyne', 181, 'Centrocampista', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("DE BRUYNE AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Eden', 'Hazard', 175, 'Delantero', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("EDEN HAZARD AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Michy', 'Batshuayi', 185, 'Delantero', 'Belgica')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("BATSHUAYI AÑADIDO.");
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ejercicio1();
    }
}
