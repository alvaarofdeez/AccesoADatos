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
            ConexionBD conect = new ConexionBD();
            conect.conexion();

            Statement st = conect.conexion().createStatement();

            st.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))");
            
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
