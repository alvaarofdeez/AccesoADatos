package UD2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio1Repaso {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileWriter fw = null;
        PrintWriter pw = null;

        FileReader fr = null;
        try {

            fr = new FileReader("origen.txt"); // INDICAMOS EL FICHERO A LEER
            br = new BufferedReader(fr); // LO LEEREMOS CON 'BR'

            int caracter = fr.read(); // CON ESTA VARIABLE LEEREMOS CARACTER A CARACTER

            fw = new FileWriter("destino.txt"); // INDICAMOS EL FICHERO A ESCRIBIR
            pw = new PrintWriter(fw); // LO ESCRIBIREMOS CON 'PW'

            while (caracter != -1) { // BUCLE HASTA QUE NO QUEDEN CARACTERES
                if (caracter <= 65 || caracter >= 90) { // LETRAS MINUSCULAS 'ASCII'
                    char mayus = (char) Character.toUpperCase(caracter); // PASAMOS A MAYUSCULAS
                    pw.print(mayus); // AÑADIMOS
                } else if (caracter <= 97 || caracter >= 122) { // LETRAS MAYUSCULAS 'ASCII'
                    char mayus = (char) Character.toUpperCase(caracter); // PASAMOS A MAYUSCULA
                    pw.print(mayus); // AÑADIMOS
                }
                caracter = fr.read(); // LEEMOS SIGUIENTE CARACTER
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pw) {
                    pw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
