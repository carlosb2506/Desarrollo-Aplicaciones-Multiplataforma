public class Tarea1 {

    public static void main(String[] args) {
        // Crear e iniciar los hilos
        Thread hilo1 = new Thread(new MiTarea("Hilo 1"));
        Thread hilo2 = new Thread(new MiTarea("Hilo 2"));
        
        hilo1.start();
        hilo2.start();
        
        try {
            // Esperar a que los hilos terminen
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.err.println("Un hilo fue interrumpido.");
        }

        System.out.println("Finalizaron ambos hilos.");
    }
}

class MiTarea implements Runnable {
    private String nombre;

    public MiTarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + ": " + i);
            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                System.err.println(nombre + " fue interrumpido.");
            }
        }
    }
}