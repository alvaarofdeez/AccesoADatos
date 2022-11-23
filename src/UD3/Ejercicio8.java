package UD3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio8 {

    static ConexionBD conect = new ConexionBD();

    public static void muestraDatos() {
        conect.conexion();

        int contador = 0;
        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM clientes";

        try {
            st = conect.conect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);

            rs.afterLast();
            while (rs.previous()) {
                System.out.println("DNI: " + rs.getString("DNI") + "\nApellidos: " + rs.getString("APELLIDOS") + "\nCodigo Postal: " + rs.getInt("CP"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                conect.conexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        muestraDatos();
    }
}
