package UD2B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Examen5 {

    public static void main(String[] args) throws FileNotFoundException {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // CON EL 'BR' LEEREMOS LO QUE INTRODUZCAMOS POR TECLADO
            System.out.println("Introduce la ruta del primer fichero: ");
            String ruta1 = br.readLine(); // ALMACENAMOS RUTA DEL PRIMER FICHERO

            System.out.println("Introduce la ruta del segundo fichero: ");
            String ruta2 = br.readLine(); // ALMACENAMOS RUTA DEL SEGUNDO FICHERO

            System.out.println("Introduce la ruta del fichero destino: ");
            String ruta3 = br.readLine(); // ALMACENAMOS RUTA DESTINO

            File fich1 = new File(ruta1); // ARCHIVO 1
            File fich2 = new File(ruta2); // ARCHIVO 2
            String nom1 = fich1.getName(); // ALMACENAMOS NOMBRE DEL FICHERO 1, RECOGIDO DE LA RUTA
            nom1 = nom1.substring(0, nom1.length() - 4); // ACORTAMOS EL NOMBRE Y QUITAMOS LA EXTENSIÓN
            String nom2 = fich2.getName(); // ALMACENAMOS NOMBRE DEL FICHERO 2, RECOGIDO DE LA RUTA
            nom2 = nom2.substring(0, nom2.length() - 4); // ACORTAMOS EL NOMBRE Y QUITAMOS LA EXTENSIÓN
            String destino = nom1 + "-" + nom2 + ".txt"; // CONCATENAMOS AMBOS NOMBRES PARA FORMAR NOMBRE DE ARCHIVO DE DESTINO
            File fich3 = new File(ruta3 + "\\" + destino); // ARCHIVO DESTINO, CON RUTA MAS NOMBRE, YA QUE NO INTRODUCIMOS EL NOMBRE EN LA RUTA

            InputStream in = new FileInputStream(fich1); // FICHERO DE ENTRADA, FICHERO 1
            OutputStream out = new FileOutputStream(fich3); // FICHERO DE SALIDA, FICHERO DESTINO

            int linea; // AQUI LEEREMOS CADA LINEA DEL FICHERO DE ENTRADA

            while ((linea = in.read()) > 0) { // BUCLE HASTA QUE NO QUEDE NADA
                out.write(linea); // ESCRIBIMOS EN EL FICHERO DE SALIDA (DESTINO)
            }
            in = new FileInputStream(fich2); // CAMBIAMOS EL FICHERO DE ENTRADA A FICHERO 2
            while ((linea = in.read()) > 0) { // BUCLE HASTA QUE NO QUEDE NADA
                out.write(linea); // ESCRIBIMOS EN EL FICHERO DE SALIDA (DESTINO)
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
