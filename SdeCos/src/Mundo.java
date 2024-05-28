package SdeCos.src;
import java.util.Scanner;
class Mundo {

    private CentroComercial carrefour;
    private int tiempoTotal;

    public Mundo(int tiempoTotal) {
        carrefour = new CentroComercial();
        this.tiempoTotal = tiempoTotal;
    }

    public void simular() {
        boolean centroAbierto = true;
        int minutoActual = 0;
        do {
            minutoActual++;
            centroAbierto = minutoActual <= this.tiempoTotal;
            if (llegaUnCliente()){
                int numeroItems = (int) (Math.random() * (15 - 1 + 1) + 1);
                Cliente cliente = new Cliente(numeroItems);
                carrefour.recibe(cliente);
            }
            carrefour.actualizar();
            carrefour.verEstado(minutoActual);
            new Scanner(System.in).nextLine();
        } while (centroAbierto);



    }

    private boolean llegaUnCliente() {
        return Math.random()<=0.4;
    }

    public static void main(String[] args) {
        final int TIEMPO_TOTAL = 12 * 60;
        new Mundo(TIEMPO_TOTAL).simular();
    }
}