package UD2A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio4_1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = null;

        File archivo = null;
        String ruta = "";

        try {
            ruta = "C:\\Users\\Alvaro\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicios\\info_dam.txt";
            archivo = new File(ruta);

            if (archivo.exists()) {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                String linea;

                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } else {
                System.out.println("El fichero no existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
