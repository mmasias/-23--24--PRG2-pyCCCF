import java.util.Scanner;

public class Mundo {

    private CentroComercial carrefour;
    private int tiempoTotal;

    public Mundo(int tiempoTotal) {
        carrefour = new CentroComercial();
        this.tiempoTotal = tiempoTotal;
    }

    public void simular() {
        int minutoActual = 0;
        while (minutoActual < this.tiempoTotal) {
            minutoActual++;
            if (llegaUnCliente()) {
                Cliente cliente = new Cliente();
                carrefour.recibirCliente(cliente);
            }
            carrefour.actualizar();
            carrefour.mostrarEstado(minutoActual);

            // Descomentar para pausas cada minuto
            // new Scanner(System.in).nextLine();
        }
    }

    private boolean llegaUnCliente() {
        return Math.random() <= 0.4;
    }

    public static void main(String[] args) {
        final int TIEMPO_TOTAL = 12 * 60;
        new Mundo(TIEMPO_TOTAL).simular();
    }
}
