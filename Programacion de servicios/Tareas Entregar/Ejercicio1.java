import java.util.Random;


class Cliente {
    private int id; // Atributo identificador del cliente

    // Aquí declaramos el constructor del cliente
    public Cliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // simulamos los intentos de entrada del cliente
    public boolean intentaEntrar(int intentosMaximos) {
        Random random = new Random();// números aleatorios
        
        for (int i = 0; i < intentosMaximos; i++) {
            if (random.nextBoolean()) {
                return true; // El cliente logra entrar
            }
        }
        return false; // El cliente se marchara si después de 10 intentos no logra entrar
    }
}

class Almacen {
    private int productosDisponibles; // Cantidad de productos disponibles

    // Constructor del almacén
    public Almacen(int productos) {
        this.productosDisponibles = productos;
    }

    // Método que maneja la entrada de un cliente
    public synchronized boolean clienteEntra(Cliente cliente) {
        // Vemos si quedan productos disponibles
        if (productosDisponibles > 0) {
            productosDisponibles--; // Se decrementa el número de productos
            System.out.println("Cliente " + cliente.getId() + " ha entrado y tomó un producto. Productos restantes: " + productosDisponibles);
            return true; // Cliente consiguio entrar y coger un producto
        } else {
            // Si no hay productos, el cliente se marcha
            System.out.println("Cliente " + cliente.getId() + " ha entrado pero no quedan productos.");
            return false; // Cliente entró pero no pudo coger un producto
        }
    }
}

// Clase principal
public class Ejercicio1 {
    public static void main(String[] args) {
        final int TOTAL_CLIENTES = 300; // Total de clientes
        final int PRODUCTOS = 100; // Total de productos disponibles
        final int MAX_INTENTOS = 10; // Número máximo de intentos de entrada por cliente

        Almacen almacen = new Almacen(PRODUCTOS); // Inicializa el almacén con productos disponibles
        Cliente[] clientes = new Cliente[TOTAL_CLIENTES]; // Array para almacenar clientes

        // Crear clientes
        for (int i = 0; i < TOTAL_CLIENTES; i++) {
            clientes[i] = new Cliente(i + 1);
        }

        // Simular los intentos de cada cliente
        for (Cliente cliente : clientes) {
            // Si el cliente logra entrar, se intenta acceder al almacén
            if (cliente.intentaEntrar(MAX_INTENTOS)) {
                almacen.clienteEntra(cliente); // El cliente entra al almacén
            } else {
                // Si no logra entrar después de 10 intentos, se marcha
                System.out.println("Cliente " + cliente.getId() + " se marcha después de 10 intentos.");
            }
        }
    }
}

