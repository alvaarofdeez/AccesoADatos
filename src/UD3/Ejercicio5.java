package UD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alvaro
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        try {
            ConexionBD conect = new ConexionBD(); // CREAMOS OBJETO DE LA CLASE DE CONEXION A LA BASE DE DATOS
            conect.conexion(); // CONECTAMOS CON EL METODO CREADO EN LA CLASE DE LA CONEXION

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            PreparedStatement ps; // VARIABLE PARA EJECUTAR CONSULTA
            String sql; // AQUI ALMACENAREMOS CONSULTA

            for (int i = 1; i <= 5; i++) { // BUCLE SE REPETIRA 5 VECES
                System.out.println("Introduce el DNI del cliente " + i + ": ");
                String dni = br.readLine(); // GUARDAMOS DNI

                System.out.println("Introduce los apellidos del cliente " + i + ": ");
                String apellidos = br.readLine(); // GUARDAMOS APELLIDOS

                System.out.println("Introduce el código postal del cliente " + i + ": ");
                int cp = Integer.parseInt(br.readLine()); // GUARDAMOS CODIGO POSTAL

                sql = "INSERT INTO clientes (dni, apellidos, cp) VALUES (?, ?, ?)";
                ps = conect.conect.prepareStatement(sql); // EJECUTAMOS CONSULTA, POSTERIORMENTE INDICAREMOS LOS DATOS DE DICHA CONSULTA

                ps.setString(1, dni); // COLOCAMOS DATOS EN CADA INTERROGACION
                ps.setString(2, apellidos);
                ps.setInt(3, cp);

                ps.executeUpdate(); // EJECUTAMOS ACTUALIZACION DE CONSULTA
            }
            
            System.out.println("*********************");
            System.out.println("* CLIENTES AÑADIDOS *");
            System.out.println("*********************");
            conect.conect.close();
        } catch (SQLException | IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
