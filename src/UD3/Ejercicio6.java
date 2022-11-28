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
public class Ejercicio6 {

    public static void main(String[] args) {
        try {
            ConexionBD conect = new ConexionBD(); // CREAMOS OBJETO DE LA CLASE DE CONEXION A LA BASE DE DATOS
            conect.conexion(); // CONECTAMOS CON EL METODO CREADO EN LA CLASE DE LA CONEXION

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            PreparedStatement ps; // VARIABLE PARA EJECUTAR CONSULTA
            String sql; // AQUI ALMACENAREMOS CONSULTA

            System.out.print("Introduce el DNI del cliente que quieres modificar: ");
            String cliente = br.readLine(); // GUARDAMOS DNI A MODIFICAR

            System.out.print("Introduce el DNI nuevo: ");
            String dni = br.readLine(); // GUARDAMOS DNI NUEVO

            System.out.print("Introduce los apellidos nuevos: ");
            String apellidos = br.readLine(); // GUARDAMOS APELLIDOS NUEVOS

            System.out.print("Introduce el código postal nuevo: ");
            int cp = Integer.parseInt(br.readLine()); // GUARDAMOS CODIGO POSTAL NUEVO

            sql = "UPDATE clientes SET dni = ?, apellidos = ?, cp = ? WHERE (dni = ?)";
            ps = conect.conect.prepareStatement(sql); // EJECUTAMOS CONSULTA, POSTERIORMENTE INDICAREMOS LOS DATOS DE DICHA CONSULTA

            ps.setString(1, dni);
            ps.setString(2, apellidos);
            ps.setInt(3, cp);
            ps.setString(4, cliente);

            ps.executeUpdate(); // EJECUTAMOS ACTUALIZACION DE CONSULTA

            System.out.println("**********************");
            System.out.println("* CLIENTE MODIFICADO *");
            System.out.println("**********************");

            for (int i = 0; i < 2; i++) { // BUCLE SE REPETIRÁ 2 VECES
                System.out.print("Introduce el DNI del usuario que quieres eliminar: ");
                cliente = br.readLine(); // GUARDAMOS DNI USUARIO A ELIMINAR

                sql = "DELETE FROM clientes WHERE (dni = ?)";
                ps = conect.conect.prepareStatement(sql); // EJECUTAMOS CONSULTA, POSTERIORMENTE INDICAREMOS LOS DATOS DE DICHA CONSULTA

                ps.setString(1, cliente);

                ps.executeUpdate(); // EJECUTAMOS ACTUALIZACION DE CONSULTA
            }

            System.out.println("***********************");
            System.out.println("* CLIENTES ELIMINADOS *");
            System.out.println("***********************");

            for (int i = 1; i <= 2; i++) { // BUCLE SE REPETIRÁ 2 VECES
                System.out.println("Introduce el DNI del cliente a añadir" + i + ": ");
                dni = br.readLine(); // GUARDAMOS DNI A AÑADIR

                System.out.println("Introduce los apellidos del cliente a añadir" + i + ": ");
                apellidos = br.readLine(); // GUARDAMOS APELLIDOS A AÑADIR

                System.out.println("Introduce el código postal del cliente a añadir" + i + ": ");
                cp = Integer.parseInt(br.readLine()); // GUARDAMOS CODIGO POSTAL A AÑADIR

                sql = "INSERT INTO clientes (dni, apellidos, cp) VALUES (?, ?, ?)";
                ps = conect.conect.prepareStatement(sql); // EJECUTAMOS CONSULTA, POSTERIORMENTE INDICAREMOS LOS DATOS DE DICHA CONSULTA

                ps.setString(1, dni);
                ps.setString(2, apellidos);
                ps.setInt(3, cp);

                ps.executeUpdate(); // EJECUTAMOS ACTUALIZACION DE CONSULTA
            }

            System.out.println("*********************");
            System.out.println("* CLIENTES AÑADIDOS *");
            System.out.println("*********************");
        } catch (IOException | NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }
}
