package UD2A;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Ejercicio1 {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\fernandez.coalv\\Desktop\\prueba"; // GUARDAMOS LA RUTA EN UNA VARIABLE
        if (args.length >= 1) {
            ruta = args[0];
        }
        File fich = new File(ruta); // INDICAMOS QUE ES UN FICHERO Y LE PASAMOS LA RUTA
        if (!fich.exists()) { // COMPROBAMOS SI EXISTE, SI NO EXISTE ENTRARÁ EN ESTE 'IF'
            System.out.println("No existe el fichero o directorio (" + ruta + ")."); // SI NO EXISTE NOS MOSTRARÁ ESTE MENSAJE POR PANTALLA
        } else { // EN CASO CONTRARIO, ES DECIR, QUE SI EXISTA, HARÁ LO SIGUIENTE
            if (fich.isFile()) { // SI ES UN FICHERO ENTRARÁ EN ESTE 'IF'
                System.out.println(ruta + " es un fichero."); // NOS DIRÁ QUE ES UN FICHERO

                // TAMAÑO
                System.out.println("Tamaño: " + fich.length() / 1000 + " KB"); // MOSTRAREMOS EL TAMAÑO

                // PERMISOS
                if (fich.canRead() && !fich.canWrite() && !fich.canExecute()) { // COMPROBAMOS SI SOLO TIENE PERMISOS DE LECTURA
                    System.out.println("Permisos: -r--");
                } else if (!fich.canRead() && fich.canWrite() && !fich.canExecute()) { // COMPROBAMOS SI SOLO TIENE PERMISOS DE ESCRITURA
                    System.out.println("Permisos: --w-");
                } else if (!fich.canRead() && !fich.canWrite() && fich.canExecute()) { // COMPROBAMOS SI SOLO TIENE PERMISOS DE EJECUCIÓN
                    System.out.println("Permisos: ---x");
                } else if (fich.canRead() && fich.canWrite() && !fich.canExecute()) { // COMPROBAMOS SI TIENE PERMISOS DE LECTURA Y ESCRIURA
                    System.out.println("Permisos: -rw-");
                } else if (fich.canRead() && !fich.canWrite() && fich.canExecute()) { // COMPROBAMOS SI TIENE PERMISOS DE LECTURA Y EJECUCIÓN
                    System.out.println("Permisos: -r-x");
                } else if (!fich.canRead() && fich.canWrite() && fich.canExecute()) { // COMPROBAMOS SI TIENE PERMISOS DE ESCRITURA Y EJECUCIÓN
                    System.out.println("Permisos: --wx");
                } else { // EN CASO DE NO SER NINGUNO DE LOS ANTERIORES, TENDRÁ TODOS LOS PERMISOS
                    System.out.println("Permisos: -rwx");
                }

                // FECHA DE MODIFICACIÓN
                long fecha = fich.lastModified(); // ALMACENAMOS LA FECHA DE MODIFICACIÓN EN VARIABLE
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yy hh:mm aa"); // INDICAMOS EL FORMATO DE FECHA
                System.out.println("Fecha de Modificación: " + date.format(fecha)); // LA MOSTRAMOS POR PANTALLA
            } else { // EN CASO DE NO SER UN FICHERO, SERÁ UN DIRECTORIO
                System.out.println(ruta + " es un directorio."); // NOS DIRÁ QUE ES UN DIRECTORIO

                // TAMAÑO
                System.out.println("Tamaño: " + fich.length() / 1000 + " KB"); // MOSTRAREMOS EL TAMAÑO

                // PERMISOS
                if (fich.canRead() && !fich.canWrite() && !fich.canExecute()) { // COMPROBAMOS SI SOLO TIENE PERMISOS DE LECTURA
                    System.out.println("Permisos: dr--");
                } else if (!fich.canRead() && fich.canWrite() && !fich.canExecute()) { // COMPROBAMOS SI SOLO TIENE PERMISOS DE ESCRITURA
                    System.out.println("Permisos: d-w-");
                } else if (!fich.canRead() && !fich.canWrite() && fich.canExecute()) { // COMPROBAMOS SI SOLO TIENE PERMISOS DE EJECUCIÓN
                    System.out.println("Permisos: d--x");
                } else if (fich.canRead() && fich.canWrite() && !fich.canExecute()) { // COMPROBAMOS SI TIENE PERMISOS DE LECTURA Y ESCRIURA
                    System.out.println("Permisos: drw-");
                } else if (fich.canRead() && !fich.canWrite() && fich.canExecute()) { // COMPROBAMOS SI TIENE PERMISOS DE LECTURA Y EJECUCIÓN
                    System.out.println("Permisos: dr-x");
                } else if (!fich.canRead() && fich.canWrite() && fich.canExecute()) { // COMPROBAMOS SI TIENE PERMISOS DE ESCRITURA Y EJECUCIÓN
                    System.out.println("Permisos: d-wx");
                } else { // EN CASO DE NO SER NINGUNO DE LOS ANTERIORES, TENDRÁ TODOS LOS PERMISOS
                    System.out.println("Permisos: drwx");
                }

                // FECHA DE MODIFICACIÓN
                long fecha = fich.lastModified(); // ALMACENAMOS LA FECHA DE MODIFICACIÓN EN VARIABLE
                DateFormat date = new SimpleDateFormat("dd/MM/yy hh:mm aa"); // INDICAMOS EL FORMATO DE FECHA
                System.out.println("Fecha de Modificación: " + date.format(fecha)); // LA MOSTRAMOS POR PANTALLA

                System.out.println("Contenido:");
                File[] ficheros = fich.listFiles(); // CREAMOS UN ARRAY PARA ALMACENAR LOS FICHEROS DEL DIRECTORIO
                for (File f : ficheros) { // CON EL BUCLE RECORREREMOS TODO EL DIRECTORIO Y LO IREMOS MOSTRANDO
                    String textoDescr = f.isDirectory() ? "/"
                            : f.isFile() ? "_" : "?";
                    System.out.println("(" + textoDescr + ") " + f.getName());
                }
            }
        }
    }
}
