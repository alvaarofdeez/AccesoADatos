/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UD2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Ejercicio4_2 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        FileWriter fw = null;
        PrintWriter pw = null;

        File archivo = null;
        String ruta = "";

        try {
            ruta = "C:\\Users\\Alvaro\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicios\\info_dam.txt";
            archivo = new File(ruta);

            fw = new FileWriter(archivo, true);
            pw = new PrintWriter(fw);

            System.out.println("Introduce el número de módulos de 2º DAM: ");
            int modulos = Integer.parseInt(br.readLine());

            do {
                System.out.println("Introduce la información del módulo: ");
                pw.println("" + br.readLine());

                modulos--;
            } while (modulos != 0);
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
