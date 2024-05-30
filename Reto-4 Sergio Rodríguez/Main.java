import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Mundo mundo = new Mundo(4, 1);
        for (int tiempo = 9; tiempo < 21; tiempo++) {
            System.out.println("Tiempo: " + tiempo + ":00");
            mundo.llegadaCliente();
            System.out.println("Número de personas en cola: " + mundo.numClientes);
            mundo.avanzarTiempo();
            System.out.println("Estado de atención de las cajas: ");
            for (Caja caja : mundo.getCajas()) {
                System.out.println("Caja " + caja + ": " + (caja.estaLibre() ? "Libre" : "Ocupada"));
            }
        }
    }
}