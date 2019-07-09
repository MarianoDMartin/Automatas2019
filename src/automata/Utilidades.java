package automata;


import java.util.Scanner;

public class Utilidades {

    public static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu(){
        System.out.println("1) Cargar un nuevo automata");
        System.out.println("2) Listar automatas cargados");
        System.out.println("3) Validar una cadena");
        System.out.println("4) Salir");
        System.out.println("Ingrese una opcion:");
    }

    public static Integer obtenerEntradaNumerica(){
        boolean valido;

        String entrada = scanner.nextLine();

        do {
            try {
                Integer.parseInt(entrada);
                return new Integer(entrada);
            } catch (NumberFormatException excepcion) {
                valido = false;
                System.out.println("Debe ingresar un valor numerico, intente nuevamente:");
                entrada = scanner.nextLine();
            }
        } while(!valido);

        return null;
    }

    public static Character obtenerEntradaCaracter(){
        boolean valido;

        String entrada = scanner.nextLine();

        do {
            try {
                return entrada.charAt(0);
            } catch (Exception e) {
                valido = false;
                System.out.println("Debe ingresar un caracter, intente nuevamente:");
                entrada = scanner.nextLine();
            }
        } while(!valido);

        return null;
    }
}
