package UD3;

import java.sql.*;

/**
 *
 * @author Alvaro
 */
public class Ejercicio7 {

    static ConexionBD conect = new ConexionBD(); // CREAMOS OBJETO DE LA CLASE DE CONEXION A LA BASE DE DATOS

    public static void muestraDatos() {
        conect.conexion(); // CONECTAMOS CON EL METODO CREADO EN LA CLASE DE LA CONEXION

        Statement st; // VARIABLE PARA EJECUTAR CONSULTA
        ResultSet rs; // VARIABLE PARA GUARDAR RESULTADO
        String sql = "SELECT * FROM clientes"; // CONSULTA 

        try {
            st = conect.conect.createStatement(); // CREAMOS ESTADO
            rs = st.executeQuery(sql); // EJECUTAMOS CONSULTA

            while (rs.next()) { // BUCLE MIENTRAS HAYA RESULTADOS
                System.out.println("DNI: " + rs.getString("DNI") + "\nApellidos: " + rs.getString("APELLIDOS") + "\nCodigo Postal: " + rs.getInt("CP")); // IMPRIMIMOS
                System.out.println(); // SALTO DE LINEA
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        muestraDatos(); // MOSTRAMOS DATOS
    }
}
