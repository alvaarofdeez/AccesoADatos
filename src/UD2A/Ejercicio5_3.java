package UD2A;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Ejercicio5_3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static RandomAccessFile fichero = null;

    public static void main(String[] args) {
        boolean bandera = true;

        try {
            fichero = new RandomAccessFile("C:\\Users\\fernandez.coalv\\Desktop\\datos.dat", "rw");

            System.out.println("ARCHIVO ORIGINAL.");
            viewFile();

            System.out.println("Ahora añadiremos datos al fichero.");

            fichero.seek(fichero.length());
            System.out.println("Introduce un número entero.");
            int n = Integer.parseInt(br.readLine());
            fichero.writeInt(n);

            System.out.println("ARCHIVO MODIFICADO.");
            viewFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void viewFile() {
        int n;
        try {
            fichero.seek(0); // NOS SITUAMOS AL PRINCIPIO
            while (true) {
                n = fichero.readInt();
                System.out.println(n);
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
