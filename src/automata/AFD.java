package automata;

public class AFD {
    private String nombre;
    private Integer estados;
    private Character[] simbolos;
    private Integer[][] transiciones;
    private Integer[] estadosFinales;

    public AFD() {

        System.out.println("***Creacion de un nuevo Automata***");

        System.out.println("Ingrese un nombre para su Automata:");
        this.nombre = Utilidades.scanner.nextLine();

        System.out.println("Ingrese la cantidad de estados:");

        estados = Utilidades.obtenerEntradaNumerica();

        System.out.println("Ingrese la cantidad de simbolos:");
        Integer cSimbolos = Utilidades.obtenerEntradaNumerica();
        simbolos = new Character[cSimbolos];
        for (int i = 0; i < cSimbolos; i++) {
            System.out.println("Ingrese el simbolo " + (i+1) + ": ");
            simbolos[i] = Utilidades.obtenerEntradaCaracter();
        }

        System.out.println("Carga de transiciones:");
        transiciones = new Integer[estados][cSimbolos];
        for(int i = 0; i < estados; i++){
            for(int j = 0; j < cSimbolos; j++){
                System.out.println("Ingrese la transisicion para el estado q" + i + " con el simbolo " + simbolos[j] + ": ");
                transiciones[i][j] = Utilidades.obtenerEntradaNumerica();
            }
        }

        System.out.println("Ingrese la cantidad de estados finales:");
        Integer cEstadosFinales = Utilidades.obtenerEntradaNumerica();
        estadosFinales = new Integer[cEstadosFinales];
        for(int i = 0; i < cEstadosFinales; i++) {
            System.out.println("Ingrese el estado final " + i + ": ");
            estadosFinales[i] = Utilidades.obtenerEntradaNumerica();
        }
    }

    public void validarCadena(String cadena) {

        Integer estadoActual = 0;
        Character caracterActual;

        for (int i = 0; i < cadena.length(); i++) {
            caracterActual = cadena.charAt(i);
            Integer caracterIndice = obtenerCaracterIndice(caracterActual);
            if(caracterIndice != null){
                estadoActual = transiciones[estadoActual][caracterIndice];
            } else {
                System.out.println("Hay caracter/es invalido/s en la cadena ingresada");
                return;
            }
        }

        System.out.println("Estado final de la cadena: q" + estadoActual);
        if(esEstadoFinal(estadoActual)) {
            System.out.println("La cadena ingresada es valida");
        } else {
            System.out.println("La cadena ingresada NO es valida");
        }
        return;
    }

    public String getNombre() {
        return nombre;
    }

    private Integer obtenerCaracterIndice(Character caracter) {
        for(int i = 0; i < simbolos.length; i++){
            if(simbolos[i] == caracter){
                return i;
            }
        }
        return null;
    }

    private Boolean esEstadoFinal(Integer estado) {
        for (Integer estadoFinal: estadosFinales) {
            if(estado.equals(estadoFinal)){
                return true;
            }
        }
        return false;
    }
}
