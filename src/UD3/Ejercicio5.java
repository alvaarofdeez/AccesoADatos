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
            ConexionBD conect = new ConexionBD();
            conect.conexion();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            PreparedStatement ps;
            String sql;

            for (int i = 1; i <= 5; i++) {
                System.out.println("Introduce el DNI del cliente " + i + ": ");
                String dni = br.readLine();

                System.out.println("Introduce los apellidos del cliente " + i + ": ");
                String apellidos = br.readLine();

                System.out.println("Introduce el código postal del cliente " + i + ": ");
                int cp = Integer.parseInt(br.readLine());

                sql = "INSERT INTO clientes (dni, apellidos, cp) VALUES (?, ?, ?)";
                ps = conect.conect.prepareStatement(sql);

                ps.setString(1, dni);
                ps.setString(2, apellidos);
                ps.setInt(3, cp);

                ps.executeUpdate();
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
