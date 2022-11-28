package UD3;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alvaro
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        try {
            ConexionBD conect = new ConexionBD(); // CREAMOS OBJETO DE LA CLASE DE CONEXION A LA BASE DE DATOS
            conect.conexion(); // CONECTAMOS CON EL METODO CREADO EN LA CLASE DE LA CONEXION

            Statement st = conect.conexion().createStatement(); // // CREAMOS STATEMENT

            st.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))"); // EJECUTAMOS CONSULTA
            
            System.out.println("****************");
            System.out.println("* TABLA CREADA *");
            System.out.println("****************");

        } catch (SQLException e) {
            muestraErrorSQL(e);
        } catch(Exception e){
            e.printStackTrace(System.err);
        }
    }

    private static void muestraErrorSQL(SQLException e) {
        System.out.println("SQL Error Mensaje: " + e.getMessage());
        System.out.println("SQL Estado: " + e.getSQLState());
        System.out.println("SQL Código Específico: " + e.getErrorCode());
    }
}
