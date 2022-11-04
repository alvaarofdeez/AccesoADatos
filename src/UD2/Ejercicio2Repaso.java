package UD2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejercicio2Repaso {

    public static void main(String[] args) {
        try {
            File origen = new File("datos.dat"); // INICIAMOS VARIABLE 'FILE' DEL FICHERO DE ORIGEN
            File destino = new File("destino.dat"); // INICIAMOS VARIABLE 'FILE' DEL FICHERO DE DESTINO

            InputStream in = new FileInputStream(origen); // FICHERO DE ENTRADA 'ORIGEN'
            OutputStream out = new FileOutputStream(destino); // FICHERO DE SALIDA 'DESTINO'

            byte tamano = (byte) origen.length(); // GUARDAMOS EN UNA VARIABLE BYTES EL TAMAÑO DEL FICHERO DE ORIGEN

            byte[] datos = new byte[tamano]; // CREAMOS UN ARRAY DE BYTES CON TAMAÑO DEL FICHERO DE ORIGEN
            int linea; // VARIABLE LINEA

            while ((linea = in.read(datos)) > 0) { // BUCLE PARA RECORRER TODO EL FICHERO
                out.write(datos); // ESCRIBIMOS EN EL 'FICHERO DESTINO' LOS 'DATOS' LEIDOS
            }

            in.close(); // CERRAMOS VARIABLE ENTRADA
            out.close(); // CERRAMOS VARIABLE SALIDA
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
