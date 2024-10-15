import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Palabritas p1 = new Palabritas();
        ArrayList<Palabritas> palabras = new ArrayList<>();

        p1.cargarFichero("C:\\Ficheritos\\Palabras.txt", palabras);
        System.out.println("hola");
    }
}
