package UD3Repaso;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio1 {

    static ConexionBD conect = new ConexionBD();

    public static void ejercicio1() {
        try {
            conect.conexion();
            String sql;
            Statement st;
            ResultSet rs;
            
            // CREACION TABLA JUGADORES
            sql = "CREATE TABLE jugadores (ID_JUGADOR INT NOT NULL AUTO_INCREMENT, "
                    + "NOMBRE_JUGADOR VARCHAR(45) NULL, "
                    + "APELLIDOS_JUGADOR VARCHAR(45) NULL, "
                    + "ALTURA INT NULL, "
                    + "DEMARCACION ENUM('Portero', 'Defensa', 'Centrocampista', 'Delantero') NULL, "
                    + "SELECCION VARCHAR(45) NULL, "
                    + "PRIMARY KEY(ID_JUGADOR))";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("TABLA JUGADORES CREADA.");
            
            // CREACION TABLA SELECCIONES
            sql = "CREATE TABLE selecciones (NOMBRE_SELECCION VARCHAR(45) NOT NULL, "
                    + "ENTRENADOR VARCHAR(45) NULL, "
                    + "PRIMARY KEY (NOMBRE_SELECCION))";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("TABLA SELECCIONES CREADA.");
            
            // CONFIGURACIÓN DE CLAVES FORANEAS
            sql = "ALTER TABLE jugadores ADD CONSTRAINT FOREIGN KEY (SELECCION) REFERENCES selecciones (NOMBRE_SELECCION) ON DELETE CASCADE ON UPDATE CASCADE";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CLAVES FORANEAS CONFIGURADAS.");
            
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
            
            // BRASIL
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('Brasil', 'Tite')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("BRASIL AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Alisson', 'Becker', 193, 'Portero', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("ALISSON AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Eder', 'Militao', 186, 'Defensa', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MILITAO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Marquinhos', 189, 'Defensa', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MARQUINHOS AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Thiago', 'Silva', 183, 'Defensa', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("THIAGO SILVA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Alex', 'Sandro', 180, 'Defensa', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("ALEX SANDRO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Raphinha', 176, 'Delantero', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RAPHINHA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Fred', 169, 'Centrocampista', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("FRED AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Lucas', 'Paquetá', 180, 'Centrocampista', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("PAQUETÁ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Carlos Henrique', 'Casemiro', 185, 'Centrocampista', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CASEMIRO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Vinicius', 'Júnior', 176, 'Delantero', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("VINI JR AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Richarlison', 184, 'Delantero', 'Brasil')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RICHARLISON AÑADIDO.");
            
            // PORTUGAL
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('Portugal', 'Fernando Santos')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("PORTUGAL AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Diogo', 'Costa', 188, 'Portero', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("DIOGO COSTA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Joao', 'Cancelo', 182, 'Defensa', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CANCELO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Kleper Lima', 'Pepe', 188, 'Defensa', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("PEPE AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Ruben', 'Dias', 187, 'Defensa', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RUBEN DIAS AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Nuno', 'Mendes', 176, 'Defensa', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("NUNO MENDES AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Bernardo', 'Silva', 173, 'Centrocampista', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("BERNARDO SILVA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Ruben', 'Neves', 180, 'Centrocampista', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RUBEN NEVES AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('William', 'Carvalho', 187, 'Centrocampista', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("WILLIAM CARVALHO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Bruno', 'Fernandes', 179, 'Centrocampista', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("BRUNO FERNANDES AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Cristiano', 'Ronaldo', 185, 'Delantero', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("CR7 AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Joao', 'Felix', 181, 'Delantero', 'Portugal')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("JOAO FELIX AÑADIDO.");
            
            // ARGENTINA
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('Argentina', 'Lionel Scaloni')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("ARGENTINA AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Emiliano', 'Martinez', 195, 'Portero', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("DIBU MARTÍNEZ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Gonzalo', 'Montiel', 175, 'Defensa', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MONTIEL AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Nicolás', 'Otamendi', 183, 'Defensa', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("OTAMENDI AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Lisandro', 'Martínez', 175, 'Defensa', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LISANDRO MARTÍNEZ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Marcos', 'Acuña', 172, 'Defensa', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("ACUÑA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Ángel', 'Di Maria', 178, 'Delantero', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("DI MARÍA AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Rodrigo', 'De Paul', 180, 'Centrocampista', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("DE PAUL AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Guido', 'Rodriguez', 185, 'Centrocampista', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GUIDO RODRÍGUEZ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Alexis', 'Mac Allister', 175, 'Centrocampista', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MAC ALLISTER AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Lionel', 'Messi', 170, 'Delantero', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("MESSI AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Lautaro', 'Martínez', 174, 'Delantero', 'Argentina')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LAUTARO AÑADIDO.");
            
            // FRANCIA
            sql = "INSERT INTO selecciones (NOMBRE_SELECCION, ENTRENADOR) VALUES ('Francia', 'Didier Deschamps')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("FRANCIA AÑADIDO.");

            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Hugo', 'Lloris', 188, 'Portero', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("LLORIS AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Jules', 'Koundé', 178, 'Defensa', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("KOUNDÉ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Raphael', 'Varane', 191, 'Defensa', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("VARANE AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Dayot', 'Upamecano', 186, 'Defensa', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("UPAMECANO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Theo', 'Hernández', 184, 'Defensa', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("THEO AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Ousmane', 'Dembélé', 178, 'Delantero', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("DEMBÉLÉ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Aurélien', 'Tchouaméni', 188, 'Centrocampista', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("TCHOUAMENÍ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Antoine', 'Griezmann', 176, 'Delantero', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GRIEZMANN AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Adrien', 'Rabiot', 188, 'Centrocampista', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RABIOT AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Kylian', 'Mbappé', 178, 'Delantero', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("RATAPPÉ AÑADIDO.");
            
            sql = "INSERT INTO jugadores (NOMBRE_JUGADOR, APELLIDOS_JUGADOR, ALTURA, DEMARCACION, SELECCION) VALUES ('Olivier', 'Giroud', 193, 'Delantero', 'Francia')";
            st = conect.conect.createStatement();
            st.execute(sql);
            System.out.println("GIROUD AÑADIDO.");
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ejercicio1();
    }
}
