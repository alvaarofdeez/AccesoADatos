package UD2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio3Repaso {

    static String nomFich = "ficheroEjercicio3.txt";

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;

        File archivo = null;

        PrintWriter pw = null;
        FileWriter fw = null;

        FileReader fr = null;

        FileInputStream in = null;

        try {
            System.out.println("********************** MENÚ **********************");
            System.out.println("1. CREAR FICHERO DE TEXTO.");
            System.out.println("2. MOSTRAR CONTENIDO DEL FICHERO DE TEXTO CREADO.");
            System.out.println("3. INSERCIÓN DE NÚMEROS AL FINAL DEL FICHERO.");
            System.out.println("4. COMPROBACIÓN DEL FICHERO.");
            System.out.println("5. SALIR.");
            System.out.println("**************************************************");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(br.readLine()); // ALMACENAMOS LA OPCIÓN

            switch (opcion) {
                case 1: // OPCIÓN 1
                    archivo = new File(nomFich); // INDICAMOS FICHERO

                    if (archivo.exists()) { // SI EXISTE
                        System.out.println("El archivo ya existe."); // INDICAMOS
                    } else { // SI NO

                        int[] numeros = new int[49]; // CREAMOS ARRAY DE 49 POSICIONES, YA QUE EMPIEZA POR 0

                        int num = 0; // NUMEROS
                        int contador = 0; // POSICION DE ARRAY

                        while (contador != 49) { // BUCLE HASTA 'LLENAR ARRAY'
                            if (num % 2 != 0) { // SI ES IMPAR
                                numeros[contador] = num; // AÑADIMOS AL ARRAY
                                contador++; // INCREMENTAMOS POSICIÓN
                            }
                            num++; // INCREMENTAMOS NUMERO
                        }

                        fw = new FileWriter(archivo, true); // INDICAMOS ARCHIVO A ESCRIBIR Y QUE ESCRIBIREMOS DESDE LA ULTIMA LINEA ESCRITA, ES DECIR, NO SE SOBREESCRIBIRÁ
                        pw = new PrintWriter(fw); // LO HAREMOS CON 'PW'

                        for (int i = 0; i < numeros.length; i++) { // BUCLE HASTA RECORRER ARRAY
                            pw.println(numeros[i]); // ESCRIBIMOS LOS NUMEROS EN EL ARCHIVO
                        }
                    }
                    break; // SALIMOS
                case 2:
                    archivo = new File(nomFich); // INDICAMOS FICHERO

                    fr = new FileReader(archivo); // INDICAMOS ARCHIVO A LEER
                    br = new BufferedReader(fr); // LO LEEREMOS CON 'BR'

                    String linea; // CON 'LINEA' LEEREMOS EL FICHERO

                    while ((linea = br.readLine()) != null) { // BUCLE HASTA RECORRER FICHERO
                        System.out.println(linea); // IMPRIMIMOS LINEA
                    }
                    break; // SALIMOS
                case 3:
                    archivo = new File(nomFich); // INDICAMOS FICHERO

                    int num; // NUMERO

                    boolean bandera = true; // BANDERA, PARA CONTROLAR SI QUEREMOS ESCRIBIR MAS NUMEROS

                    fw = new FileWriter(archivo, true); // INDICAMOS ARCHIVO A ESCRIBIR Y QUE ESCRIBIREMOS DESDE LA ULTIMA LINEA ESCRITA, ES DECIR, NO SE SOBREESCRIBIRÁ
                    pw = new PrintWriter(fw); // LO HAREMOS CON 'PW'

                    do {
                        System.out.print("Introduce un número para añadir al fichero: ");
                        num = Integer.parseInt(br.readLine()); // ALMACENAMOS NUMERO A AÑADIR
                        pw.println(num); // AÑADIMOS

                        System.out.println("¿Deseas introducir más números? S/n");
                        String res = br.readLine(); // ALMACENAMOS SI QUEREMOS ALMACENAR MAS NUMEROS

                        if (res.equalsIgnoreCase("n")) { // SI NO QUEREMOS INTRODUCIR MAS
                            bandera = false; // PONEMOS 'BANDERA' A 'FALSE'
                        }
                    } while (bandera != false); // BUCLE HASTA NO QUERER INTRODUCIR MAS NUMEROS
                    break; // SALIMOS
                case 4:
                    System.out.println("FABIÁN TE HAS PASADO"); 
                    break; // SALIMOS
                case 5:
                    break; // SALIMOS
                default:
                    break; // SALIMOS
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pw) {
                    pw.close(); // CERRAMOS 'PW' PARA GUARDAR CAMBIOS
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
