/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UD3;

import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author Alvaro
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        try {
            ConexionBD conect = new ConexionBD();
            Statement st = conect.conect.createStatement();
            
            st.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))");

        } catch (Exception e) {
        }
    }
}
