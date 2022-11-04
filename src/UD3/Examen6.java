package UD3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Examen6 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // CON EL 'BR' LEEREMOS LO QUE INTRODUZCAMOS POR TECLADO

        File archivo = null;
        FileReader fr = null; // VARIABLE PARA LEER EL ARCHIVO

        FileWriter fw = null; // VARIABLES PARA ESCRIBIR EN EL FICHERO
        PrintWriter pw = null;
        try {
            // MOSTRAMOS MENU
            System.out.println("******************* MENÚ *******************");
            System.out.println("1. CREACIÓN DE FICHERO.");
            System.out.println("2. MOSTRAR CONTENIDO COMPLETO DEL FICHERO.");
            System.out.println("3. INSERCCIÓN DE DATOS AL FINAL DEL FICHERO.");
            System.out.println("4. SALIR.");
            System.out.println("********************************************");
            System.out.print("Introduce tu elección: ");
            int opcion = Integer.parseInt(br.readLine()); // GUARDAMOS ELECCION

            switch (opcion) {
                case 1: // ELECCIÓN 1
                    System.out.println("Introduce el nombre/ruta del fichero: "); // PEDIMOS RUTA O NOMBRE DEL ARCHIVO
                    archivo = new File(br.readLine()); // INDICAMOS QUE EL ARCHIVO TIENE ESE NOMBRE NO ESTÁ EN ESA RUTA, CON 'BR.READLINE()' REOCGE LO QUE HAYAMOS INTRODUCIDO
                    if (!archivo.exists()) { // SI EL ARCHIVO NO EXISTE
                        archivo.createNewFile(); // CREAMOS EL ARCHIVO

                        fw = new FileWriter(archivo); // INDICAMOS QUE VAMOS A ESCRBIR EL ARCHIVO
                        pw = new PrintWriter(fw); // LO HAREMOS CON LA VARIABLE 'PW'

                        String nombre; // ALMACENAREMOS EL NOMBRE DE LA CIUDAD
                        String provincia; // ALMACENAREMOS LA PROVINCIA DE LA CIUDAD
                        int habitantes; // ALMACENAREMOS EL NUMERO DE HABITANTES DE LA CIUDAD
                        double temp; // ALMACENAREMOS LA TEMPERATURA DE LA CIUDAD

                        for (int i = 1; i <= 3; i++) { // BUCLE SE EJECUTARÁ 3 VECES SOLO, PARA METER 3 CIUDADES
                            System.out.println("Introduce el nombre de la ciudad " + i + ": ");
                            nombre = br.readLine(); // ALMACENAMOS NOMBRE DE LA CIUDAD
                            pw.print("Ciudad: " + nombre + ", "); // AÑADIMOS AL FICHERO

                            System.out.println("Introduce la provincia de la ciudad " + i + ": ");
                            provincia = br.readLine(); // ALMACENAMOS LA PROVINCIA DE LA CIUDAD
                            pw.print("Provincia: " + provincia + ", "); // AÑADIMOS AL FICHERO

                            System.out.println("Introduce el número de habitantes de la ciudad " + i + ": ");
                            habitantes = Integer.parseInt(br.readLine()); // ALMACENAMOS EL NUMERO DE HABITANTES DE LA CIUDAD
                            pw.print("Número de Habitantes: " + habitantes + ", "); // AÑADIMOS AL FICHERO

                            System.out.println("Introduce la temperatura de la ciudad " + i + ": ");
                            temp = Double.parseDouble(br.readLine()); // ALMACENAMOS LA TEMPERATURA DE LA CIUDAD
                            pw.println("Temperatura: " + temp + "."); // AÑADIMOS AL FICHERO
                        }
                    } else { // SI EXISTE
                        System.out.println("El fichero ya existe."); // INDICAMOS QUE EXISTE
                    }
                    break; // SALIMOS
                case 2: // ELECCIÓN 2
                    System.out.println("Introduce el nombre/ruta del fichero: "); // PEDIMOS RUTA O NOMBRE DEL ARCHIVO
                    archivo = new File(br.readLine()); // INDICAMOS QUE EL ARCHIVO TIENE ESE NOMBRE NO ESTÁ EN ESA RUTA, CON 'BR.READLINE()' REOCGE LO QUE HAYAMOS INTRODUCIDO
                    if (archivo.exists()) { // SI EL ARCHIVO EXISTE
                        fr = new FileReader(archivo); // INDICAMOS QUE VAMOS A LEER EL FICHERO
                        br = new BufferedReader(fr); // LO HAREMOS CON 'BR'

                        String linea; // AQUI LEEREMOS CADA LÍNEA

                        while ((linea = br.readLine()) != null) { // BUCLE HASTA QUE NO QUEDEN LINEAS
                            System.out.println(linea); // MOSTRAMOS LA LÍNEA
                        }
                    } else { // SI NO EXISTE
                        System.out.println("El archivo/ruta introducido no existe o es errone@."); // INDICAMOS QUE NO EXISTE 
                    }
                    break; // SALIMOS
                case 3: // ELECCIÓN 3
                    System.out.println("Introduce el nombre/ruta del fichero: "); // PEDIMOS RUTA O NOMBRE DEL ARCHIVO
                    archivo = new File(br.readLine()); // INDICAMOS QUE EL ARCHIVO TIENE ESE NOMBRE NO ESTÁ EN ESA RUTA, CON 'BR.READLINE()' REOCGE LO QUE HAYAMOS INTRODUCIDO
                    if (archivo.exists()) { // SI EL ARCHIVO EXISTE
                        fw = new FileWriter(archivo, true); // INDICAMOS QUE VAMOS ESCRIBIR EL ARCHIVO, Y QUE NO VAMOS A SOBREESCRIBIR POR ESO PONEMOS EL 'TRUE', SI PUSIESEMOS 'FALSE' ELIMINARIA TODO Y ESCRIBIRÍA LO NUEVO
                        pw = new PrintWriter(fw); // LO HAREMOS CON 'PW'

                        boolean bandera = true; // CON ESTA VARIABLE CONTROLAREMOS EL BUCLE
                        int contador = 1; // CONTADOR DE CIUDADES

                        String nombre; // ALMACENAREMOS EL NOMBRE DE LA CIUDAD
                        String provincia; // ALMACENAREMOS LA PROVINCIA DE LA CIUDAD
                        int habitantes; // ALMACENAREMOS EL NUMERO DE HABITANTES DE LA CIUDAD
                        double temp; // ALMACENAREMOS LA TEMPERATURA DE LA CIUDAD                   
                        
                        do {
                            System.out.println("Introduce el nombre de la ciudad " + contador + ": ");
                            nombre = br.readLine(); // ALMACENAMOS NOMBRE DE LA CIUDAD
                            pw.print("Ciudad: " + nombre + ", "); // AÑADIMOS AL FICHERO

                            System.out.println("Introduce la provincia de la ciudad " + contador + ": ");
                            provincia = br.readLine(); // ALMACENAMOS LA PROVINCIA DE LA CIUDAD
                            pw.print("Provincia: " + provincia + ", "); // AÑADIMOS AL FICHERO

                            System.out.println("Introduce el número de habitantes de la ciudad " + contador + ": ");
                            habitantes = Integer.parseInt(br.readLine()); // ALMACENAMOS EL NUMERO DE HABITANTES DE LA CIUDAD
                            pw.print("Número de Habitantes: " + habitantes + ", "); // AÑADIMOS AL FICHERO

                            System.out.println("Introduce la temperatura de la ciudad " + contador + ": ");
                            temp = Double.parseDouble(br.readLine()); // ALMACENAMOS LA TEMPERATURA DE LA CIUDAD
                            pw.println("Temperatura: " + temp + "."); // AÑADIMOS AL FICHERO

                            System.out.println("¿Deseas seguir introduciendo ciudades? S/n"); // PREGUNTAMOS SI QUEREMOS INTRODUCIR MAS CIUDAD
                            if (br.readLine().equalsIgnoreCase("n")) { // SI NO QUEREMOS
                                bandera = false; // PONEMOS 'BANDERA' A 'FALSE', ES DECIR SALDRÁ DEL BUCLE YA QUE EL BUCLE SERÁ HASTA QUE 'BANDERA' VALGA ' FALSE'
                            }
                            contador++; // INCREMENTAMOS CONTADOR
                        } while (bandera != false); // BUCLE HASTA QUE BANDERA VALGA FALSE
                    } else { // SI NO EXISTE
                        System.out.println("El archivo/ruta introducido no existe o es errone@."); // INDICAMOS QUE NO EXISTE
                    }
                    break; // SALIMOS
                case 4: // ELECCIÓN 4
                    System.out.println("Saliendo..."); // INDICAMOS QUE VAMOS A SALIR
                    break; // SALIMOS
                default: // SI NO INTRODUCIMOS NINGUNA OPCIÓN VALIDA
                    System.out.println("No has introducido una opción válida."); // INDICAMOS QUE NO ES VÁLIDA
                    break; // SALIMOS
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (null != pw) {
                    pw.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
