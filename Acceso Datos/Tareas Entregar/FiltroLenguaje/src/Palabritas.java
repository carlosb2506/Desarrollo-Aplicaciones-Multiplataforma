import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Palabritas 
{

    String palabrass;


    public Palabritas(){
        this.palabrass = "";
    }
    public Palabritas(String palabras){
        this.palabrass = palabras;
    }

    public String getPalabras() {
        return palabrass;
    }
    public void setPalabras(String palabras) {
        this.palabrass = palabras;
    }
    //@Override
    //public String toString() {
        //return this.palabrass;
    //}

    public void cargarFichero(String fichero, ArrayList<Palabritas> palabras) {

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) 
            { 
                Palabritas palabra = new Palabritas();

                String[] separado = linea.split("\n");
                if (separado.length < 1 ) {
                    
                    palabras.add(palabra);
                    System.out.println(palabras.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("ALGO HA PASADO"); //Mostramos mensaje por pantalla en caso de que suceda una excepcion
        }

    }
}
