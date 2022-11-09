package UD3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionBD {

    public Connection conect;
    public Statement sentencia;
    public ResultSet resultado;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
            sentencia = conect.createStatement();
        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return conect;
    }
}
