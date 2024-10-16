import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        try (FileWriter fw = new FileWriter("C:\\ficheritos\\burros.txt")) {
            PrintWriter pw = new PrintWriter(fw);
            int opc;
            ArrayList<Burro> burros = new ArrayList<Burro>();

            
            // burrete.cargarFichero("C:\\ficheritos\\burros.txt", burros);

            do {
                System.out.println("BIENVENIDO AL VETENERIO: ");
                System.out.println("1. AÑADIR BURROS A LA LISTA");
                System.out.println("2. MOSTRAR BURROS DE LAS LISTA");
                System.out.println("3. ACTUALIZAR DATOS DE LOS BURROS");
                System.out.println("4. BORRAR BURROS DE LA LISTA");
                System.out.println("5. SALIR DEL PROGRAMA");

                opc = Integer.parseInt(System.console().readLine());

                switch (opc) {
                    case 1:
                        Burro burrete = new Burro();
                        burrete.crearBurro();
                        burros.add(burrete);

                        break;
                    case 2:
                        for (Burro burrito : burros) {
                            System.out.println("------------------------------------");
                            System.out.println(burrito);
                            System.out.println("------------------------------------");
                        }
                        break;
                    case 3:
                        System.out.println("NOMBRE DEL BURRO QUE DESEAS ACTUALIZAR: ");
                        String nombre = System.console().readLine();
                        for (Burro burrito : burros) {
                            if (burrito.getNombre().equals(nombre)) {
                                System.out.println("QUE CAMPO DESEA CAMBIAR:");
                                System.out.println("nombre");
                                System.out.println("altura");
                                String campo = System.console().readLine();
                                switch (campo) {
                                    case "nombre":
                                        System.out.println("DIME EL NUEVO NOMBRE:");
                                        burrito.setNombre(System.console().readLine());

                                        break;
                                    case "altura":
                                        System.out.println("DIME LA NUEVA ALTURA:");
                                        burrito.setAltura(Integer.parseInt(System.console().readLine()));
                                        break;
                                    default:
                                        System.out.println("OPCIÓN INVÁLIDA");
                                        break;
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("FUNCIÓN A FALTA DE IMPLEMENTACIÓN");
                        break;
                    case 5:
                        for (Burro burrito : burros) {
                            pw.write(burrito + "\n");
                        }
                        System.out.println("SALIENDO DEL PROGRAMA");
                        break;

                    default:
                        System.out.println("OPCIÓN INVÁLIDA");
                        break;
                }

            } while (opc != 5);

        } catch (Exception e) {
            System.out.println("ALGO HA PASADO"); //Mostramos mensaje por pantalla en caso de que suceda una excepcion
        }
    }
}
