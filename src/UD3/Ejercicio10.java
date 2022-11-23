package UD3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alvaro
 */
public class Ejercicio10 {

    static ConexionBD conect = new ConexionBD();

    public static void muestraLosMejores() {
        conect.conexion();

        String[] apellidos = {"Alors", "Bretones", "Cañas", "Fulop", "Gavilán", "Jurado", "Millán", "Montero", "Ortega", "Ramírez", "Reina", "Roldán", "Trillo", "Serrano", "Fernandez"};

        Statement st;
        ResultSet rs;
        String sql = "SELECT * FROM clientes";

        try {
            st = conect.conect.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                for (int i = 0; i < apellidos.length; i++) {
                    if (rs.getString("APELLIDOS").equalsIgnoreCase(apellidos[i])) {
                        System.out.println("DNI: " + rs.getString("DNI") + "\nApellidos: " + rs.getString("APELLIDOS") + "\nCodigo Postal: " + rs.getInt("CP"));
                        System.out.println();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        muestraLosMejores();
    }
}
