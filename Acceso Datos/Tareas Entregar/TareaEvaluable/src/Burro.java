import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Burro {

    private String nombre;
    private double altura;
    private String raza;
    private boolean colino;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setColino(boolean colino) {
        this.colino = colino;
    }

    public boolean getColino() {
        return colino;
    }

    public Burro(String nombre, double altura, String raza, boolean colino) {
        this.nombre = nombre;
        this.altura = altura;
        this.raza = raza;
        this.colino = colino;
    }

    public Burro() {
    }

    public void crearBurro() {
        System.out.println("Nombre del burro: ");

        String nombre = System.console().readLine();

        System.out.println("altura: ");

        double altura = Double.parseDouble(System.console().readLine());

        System.out.println("raza: ");

        String raza = System.console().readLine();

        System.out.println("¿Es colino?: ");
        boolean colino;
        if (System.console().readLine() == "Si" || System.console().readLine() == "si") {
            colino = true;
        } else
            colino = false;

        this.setNombre(nombre);
        this.setAltura(altura);
        this.setRaza(raza);
        this.setColino(colino);
    }

    public void cargarFichero(String fichero, ArrayList<Burro> burros) {

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) { // Recuerdo usar esta condicion en clase para leer todo el fichero hasta la ultima linea
                                                      

                Burro burro = new Burro();

                String[] separado = linea.split(" ");
                if (separado.length == 4) {
                    burro.setNombre(separado[0]);
                    burro.setAltura(Double.parseDouble(separado[1]));
                    burro.setRaza(separado[2]);
                    burro.setColino(Boolean.parseBoolean(separado[3]));

                    burros.add(burro);
                }

            }
        } catch (Exception e) {
            System.out.println("ALGO HA PASADO"); //Mostramos mensaje por pantalla en caso de que suceda una excepcion
        }

    }

    @Override
    public String toString() {
        String Cadena = "NOMBRE: " + this.getNombre() + "\nALTURA: " + this.getAltura() + "\nRAZA: " + this.getRaza() + "\nCOLINO: " + this.getColino();

        return Cadena;
    }

}
