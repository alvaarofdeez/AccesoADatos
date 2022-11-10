package UD3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

/**
 *
 * @author Alvaro
 */
public class Ejercicio6 {

    public static void main(String[] args) {
        try {
            ConexionBD conect = new ConexionBD();
            conect.conexion();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            PreparedStatement ps;
            String sql;

            System.out.print("Introduce el DNI del cliente que quieres modificar: ");
            String cliente = br.readLine();

            System.out.print("Introduce el DNI nuevo: ");
            String dni = br.readLine();

            System.out.print("Introduce los apellidos nuevos: ");
            String apellidos = br.readLine();

            System.out.print("Introduce el código postal nuevo: ");
            int cp = Integer.parseInt(br.readLine());

            sql = "UPDATE clientes SET dni = ?, apellidos = ?, cp = ? WHERE (dni = ?)";
            ps = conect.conect.prepareStatement(sql);

            ps.setString(1, dni);
            ps.setString(2, apellidos);
            ps.setInt(3, cp);
            ps.setString(4, cliente);
            ps.executeUpdate();

            System.out.println("**********************");
            System.out.println("* CLIENTE MODIFICADO *");
            System.out.println("**********************");

            for (int i = 0; i <= 2; i++) {
                System.out.print("Introduce el DNI del usuario que quieres eliminar: ");
                cliente = br.readLine();

                sql = "DELETE FROM clientes WHERE (dni = ?)";
                ps = conect.conect.prepareStatement(sql);

                ps.setString(1, cliente);
                ps.executeUpdate();
            }

            System.out.println("***********************");
            System.out.println("* CLIENTES ELIMINADOS *");
            System.out.println("***********************");

            for (int i = 1; i <= 2; i++) {
                System.out.println("Introduce el DNI del cliente a añadir" + i + ": ");
                dni = br.readLine();

                System.out.println("Introduce los apellidos del cliente a añadir" + i + ": ");
                apellidos = br.readLine();

                System.out.println("Introduce el código postal del cliente a añadir" + i + ": ");
                cp = Integer.parseInt(br.readLine());

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
        } catch (Exception e) {
        }
    }
}
