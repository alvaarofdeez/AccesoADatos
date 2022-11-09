package UD2A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Ejercicio3 {

    public static void main(String[] args) {
        // VARIABLES
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = null;
        File archivo = null;
        String ruta; // AQUI ALMACENAREMOS LA RUTA DEL ARCHIVO
        String cadena = ""; // AQUI LA CADENA DE TEXTO PARA BUSCAR
        int contador = 1; // ESTE SERÁ EL CONTADOR DE LA LÍNEA EN LA QUE SE ENCUENTRA 
        boolean contiene = false; // CON ESTO CONTROLAREMOS SI LA CADENA SE ENCUENTRA O NO

        try {
            ruta = "C:\\Users\\Alvaro\\Desktop\\prueba.txt"; // ALMACENAMOS RUTA
            archivo = new File(ruta); // INDICAMOS QUE EL ARCHIVO ESTA EN ESTA RUTA

            System.out.println("Introduce el texto a buscar: ");
            cadena = br.readLine(); // LEEMOS LO INTRODUCIDO

            if (archivo.exists()) { // SI EL ARCHIVO EXISTE 
                fr = new FileReader(archivo); // INDICAMOS QUE VAMOS A LEER EL ARCHIVO
                br = new BufferedReader(fr); // Y ASIGNAMOS LA LECTURA A 'BR'

                String linea; // INICIAMOS 'LINEA'

                System.out.println(); // SALTO DE LÍNEA (ESTÉTICA)
                System.out.println("Archivo: " + archivo.getName()); // INDICAMOS EL NOMBRE DEL ARCHIVO
                System.out.println("Texto a buscar: " + cadena); // INDICAMOS EL TEXTO A BUSCAR
                while (br.readLine() != null) { // LEEREMOS TODO EL ARCHIVO HASTA QUE NO QUEDE NADA
                    linea = br.readLine(); // LEEMOS LA LÍNEA
                    if (linea.contains(cadena)) { // SI EN DICHA LÍNEA SE ENCUENTRA EL TEXTO INDICADO ENTRARÁ EN EL 'IF'
                        System.out.println("Línea " + contador + ": " + linea); // INDICAMOS LA LÍNEA Y EL TEXTO DE DICHA LÍNEA
                        contiene = true; // PONEMOS A 'TRUE' LA VARIABLE 'CONTIENE' YA QUE LA PALABRA SI SE ENCUENTRA
                    }
                    contador++; // INCREMENTAMOS 'CONTADOR', POR QUE VAMOS A LA SIGUIENTE LÍNEA
                }
                if (!contiene) { // SI LA VARIABLE 'CONTIENE' ESTÁ A 'FALSE', SIGNIFICA QUE NO EXISTE LA PALABRA EN EL FICHERO
                    System.out.println(cadena + " no se encuentra en el archivo."); // INDICAMOS QUE NO EXISTE
                }
            } else { // SI EL ARCHIVO NO EXISTE
                System.out.println("El fichero no existe."); // INDICAMOS QUE NO EXISTE
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
