package UD3;

import java.sql.*;

/**
 *
 * @author Alvaro
 */
public class Ejercicio9 {

    static ConexionBD conect = new ConexionBD();

    public static void muestraDatosOrdenados() {
        conect.conexion();

        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM clientes ORDER BY apellidos DESC";

        try {
            st = conect.conect.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("DNI: " + rs.getString("DNI") + "\nApellidos: " + rs.getString("APELLIDOS") + "\nCodigo Postal: " + rs.getInt("CP"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        muestraDatosOrdenados();
    }
}
