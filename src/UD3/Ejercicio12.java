package UD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Ejercicio12 {

    static ConexionBD conect = new ConexionBD();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void mostrarDatos() throws IOException {
        conect.conexion();

        System.out.print("Introduce el apellido a buscar: ");
        String apellido = br.readLine();

        String apellidoRenovado = apellido.substring(0, apellido.length() - 1);

        Statement st;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM clientes WHERE apellidos = '" + apellido + "'";

        try {
            st = conect.conect.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("DNI: " + rs.getString("DNI") + "\nApellidos: " + rs.getString("APELLIDOS") + "\nCodigo Postal: " + rs.getInt("CP"));
                System.out.println();
            }

            System.out.println("ACTUALIZANDO APELLIDOS...");

            sql = "UPDATE clientes SET apellidos = ? WHERE (apellidos = ?)";
            ps = conect.conect.prepareStatement(sql);
            ps.setString(1, apellidoRenovado);
            ps.setString(2, apellido);
            ps.executeUpdate();

            System.out.println("APELLIDOS MODIFICADOS");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        mostrarDatos();
    }
}
