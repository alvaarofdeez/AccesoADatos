package UD3Repaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Seleccion1 seleccion = new Seleccion1();
        Jugador1 jugador = new Jugador1();

        System.out.println("**********************************");
        System.out.println("************** MENU **************");
        System.out.println("**********************************");
        System.out.println("**** 1. CREAR NUEVA SELECCION ****");
        System.out.println("***** 2. CREAR NUEVO JUGADOR *****");
        System.out.println("****** 3. LISTAR SELECCIONES *****");
        System.out.println("* 4. LISTAR SELECCION ESPECIFICA *");
        System.out.println("******* 5. LISTAR JUGADORES ******");
        System.out.println("** 6. LISTAR JUGADOR ESPECIFICO **");
        System.out.println("***** 7. MODIFICAR SELECCION *****");
        System.out.println("****** 8. MODIFICAR JUGADOR ******");
        System.out.println("******* 9. ELIMINAR JUGADOR ******");
        System.out.println("***** 10. ELIMINAR SELECCION *****");
        System.out.println("**********************************");
        System.out.print("Selecciona opcion: ");
        int opcion = Integer.parseInt(br.readLine());

        switch (opcion) {
            case 1:
                seleccion.nuevaSeleccion();
                break;
            case 2:
                jugador.nuevoJugador();
                break;
            case 3:
                seleccion.listarSelecciones();
                break;
            case 4:
                seleccion.listarSeleccion();
                break;
            case 5:
                jugador.listarJugadores();
                break;
            case 6:
                jugador.listarJugador();
                break;
            case 7:
                seleccion.modificarSeleccion();
                break;
            case 8:
                jugador.modificarJugador();
                break;
            case 9:
                jugador.eliminarJugador();
                break;
            case 10:
                seleccion.eliminarSeleccion();
                break;
            default:
                break;
        }
    }
}
