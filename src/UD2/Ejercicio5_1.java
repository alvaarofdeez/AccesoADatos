package UD2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Ejercicio5_1 {

    public static void main(String[] args) {
        FileReader fr = null;
        File archivo = null;

        String ruta;
        try {
            ruta = "C:\\Users\\fernandez.coalv\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicio 5\\AlvaroFernandezdecordova.txt";
            archivo = new File(ruta);

            fr = new FileReader(archivo);

            int caracter = fr.read();

            while (caracter != -1) {
                if (caracter != 32) {
                    System.out.print((char) caracter);
                }
                caracter = fr.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
