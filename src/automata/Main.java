package automata;

import java.util.ArrayList;

public class Main {
    public static ArrayList<AFD> automatas = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Automata Deterministico Finito UB 2019");

        Integer opcion;
        do {
            System.out.println("********************************************");
            System.out.println("********************************************");
            Utilidades.mostrarMenu();
            opcion = Utilidades.obtenerEntradaNumerica();

            switch (opcion){
                case 1:
                    automatas.add(new AFD());
                    break;
                case 2:
                    System.out.println("Automatas cargados:");
                    int i = 0;
                    for (AFD afd: automatas) {
                        System.out.println(i + "-" + afd.getNombre());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el número de automata a utilizar:");
                    Integer automataElegido = Utilidades.obtenerEntradaNumerica();
                    System.out.println("Ingrese la cadena a validar:");
                    String cadena = Utilidades.scanner.nextLine();
                    automatas.get(automataElegido).validarCadena(cadena);
                    break;
            }
        } while(opcion != 4);
    }
}
