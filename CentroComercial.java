import java.util.Scanner;

public class CentroComercial {
    private Caja[] cajas;
    private Caja cajaAuxiliar;
    private boolean superAbierto;
    private int cola;
    private float porcentajeNuevo;
    private int ultimaHora;
    private int clientesAtendidos;
    private int productosVendidos;
    private int minutosSinCola;

    public CentroComercial() {
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
        cajaAuxiliar = new Caja();
        superAbierto = true;
        cola = 0;
        porcentajeNuevo = 0.4f;
        ultimaHora = 12;
        clientesAtendidos = 0;
        productosVendidos = 0;
        minutosSinCola = 0;
    }

    public void abrir() {
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido Super Administrador");
        
        for (int i = 0; i < cajas.length; i++) {
            System.out.println("Desea abrir la caja " + (i + 1) + " (1 = Si, Otro = No)");
            cajas[i].setAbierta(s.nextInt() == 1);
        }

        if (ningunaCajaAbierta()) {
            System.out.println("Señor Super Administrador no hay ninguna caja abierta");
            System.out.println("¿Desea cerrar el Supermercado? (1 = Si, Otro = No)");
            if (s.nextInt() == 1) {
                superAbierto = false;
            } else {
                superAbierto = true;
                System.out.println("Se procede a abrir la Caja1");
                cajas[0].setAbierta(true);
            }
        }

        if (superAbierto) {
            operar();
        } else {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("EL SUPERMERCADO HA PERMANECIDO CERRADO");
            System.out.println("-----------------------------------------------------------------------------");
        }
        s.close();
    }
}