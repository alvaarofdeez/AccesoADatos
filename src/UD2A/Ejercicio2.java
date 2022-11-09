package UD2A;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        // EXCEPCIÓN 1
        // Comprobar si introducimos dos numeros para una suma
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el primer número: ");
            int num1 = sc.nextInt();

            System.out.println("Introduce el segundo número: ");
            int num2 = sc.nextInt();

            System.out.println("La suma es: " + (num1 + num2));
        } catch (Exception e) {
            System.err.println("Nos has introducido un número.");
        }
        
        // EXCEPCIÓN 2
        // Comprobar que no se puede hacer una división entre 0
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el primer número: ");
            int num1 = sc.nextInt();

            System.out.println("Introduce el segundo número: ");
            int num2 = sc.nextInt();

            System.out.println("La suma es: " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.err.println("No se puede dividir un número entre 0.");
        }
        
        // EXCEPCIÓN 3
        
        // EXCEPCIÓN 4
        
        // EXCEPCIÓN 5
    }
}
