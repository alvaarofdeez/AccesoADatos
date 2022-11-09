package UD2A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio5_2 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            FileReader fr = null;

            FileWriter fw = null;
            PrintWriter pw = null;

            File archivo = null;

            String ruta;

            System.out.println("--- MENÚ ---");
            System.out.println("1. Crear un fichero.");
            System.out.println("2. Mostrar contenido de un fichero.");
            System.out.println("3. Escribir al final de un fichero.");
            System.out.println("4. Salir.");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    try {
                    ruta = "C:\\Users\\fernandez.coalv\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicio 5\\holasucolega.txt";
                    archivo = new File(ruta);

                    if (!archivo.exists()) {
                        archivo.createNewFile();
                    } else {
                        System.out.println("No se ha podido crear el archivo o ya existe.");
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                case 2:
                    try {
                    ruta = "C:\\Users\\fernandez.coalv\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicio 5\\holasucolega.txt";
                    archivo = new File(ruta);

                    if (!archivo.exists()) {
                        System.out.println("El archivo no existe.");
                    } else {
                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);

                        String linea;

                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                case 3:
                    try {
                    ruta = "C:\\Users\\fernandez.coalv\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicio 5\\holasucolega.txt";
                    archivo = new File(ruta);

                    if (!archivo.exists()) {
                        System.out.println("El archivo no existe.");
                    } else {
                        fw = new FileWriter(archivo, true);
                        pw = new PrintWriter(fw);

                        boolean bandera = true;
                        pw.println();
                        do {
                            System.out.println("Introduce el contenido que deseas añadir:");
                            pw.println("" + br.readLine());

                            System.out.println("¿Desea introducir otra línea? S/n");
                            String eleccion = br.readLine();
                            if (eleccion.equalsIgnoreCase("n")) {
                                bandera = false;
                            } else {
                                bandera = true;
                            }
                        } while (bandera != false);
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != pw) {
                        pw.close();
                    }
                }
                case 4:
                    break;
                default:
                    break;
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
