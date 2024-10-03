import java.io.Console;

public class JuegoAhorcado {
    private Palabra palabra;
    private Ahorcado ahorcado;
    
    public JuegoAhorcado(String palabraOriginal) {
        this.palabra = new Palabra(palabraOriginal);
        this.ahorcado = new Ahorcado();
    }

    public void jugar() {
        Console console = System.console();
        if (console == null) {
            System.out.println("La consola no está disponible. Por favor, ejecute en una terminal.");
            return;
        }

        boolean palabraAdivinadaCompletamente = false;
        while (ahorcado.getIntentosFallidos() < 6 && !palabraAdivinadaCompletamente) {
            palabra.mostrarPalabra();
            System.out.print("Estudiante, adivine una letra: ");
            char letra = console.readLine().toLowerCase().charAt(0);

            if (!palabra.adivinarLetra(letra)) {
                ahorcado.aumentarIntentos();
                ahorcado.mostrarAhorcado();
            }

            palabraAdivinadaCompletamente = palabra.estaAdivinada();
        }

        if (palabraAdivinadaCompletamente) {
            System.out.println("¡Felicidades, adivinaste la palabra!");
        } else {
            System.out.println("La palabra era: " + palabra.getPalabraOriginal());
        }
    }

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("La consola no está disponible. Por favor, ejecute en una terminal.");
            return;
        }

        // El método readPassword captura lo que escribe el profesor sin mostrarlo
        char[] palabraIngresada = console.readPassword("Profesor, ingrese una palabra: ");
        String palabraOriginal = new String(palabraIngresada).toLowerCase();

        // Limpiar la pantalla
        System.out.println("\n\n\n\n\n\n\n\n\n");

        // Iniciar el juego con la palabra ingresada
        JuegoAhorcado juego = new JuegoAhorcado(palabraOriginal);
        juego.jugar();
    }
}
