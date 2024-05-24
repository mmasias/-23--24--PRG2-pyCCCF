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

    private void operar() {
        for (int hora = 0; hora <= ultimaHora; hora++) {
            mostrarHora(hora);

            for (int minuto = 1; minuto <= 60; minuto++) {
                procesarMinuto(minuto);
            }

            if (hora == ultimaHora) {
                mostrarResumen();
            }
        }
    }

    private void mostrarHora(int hora) {
        System.out.println("-----------------------------------------------------------------------------");
        switch (hora) {
            case 0: System.out.println("Hora 09:00 - Apertura de tienda"); break;
            case 1: System.out.println("Hora 10:00"); break;
            case 2: System.out.println("Hora 11:00"); break;
            case 3: System.out.println("Hora 12:00"); break;
            case 4: System.out.println("Hora 13:00"); break;
            case 5: System.out.println("Hora 14:00"); break;
            case 6: System.out.println("Hora 15:00"); break;
            case 7: System.out.println("Hora 16:00"); break;
            case 8: System.out.println("Hora 17:00"); break;
            case 9: System.out.println("Hora 18:00"); break;
            case 10: System.out.println("Hora 19:00"); break;
            case 11: System.out.println("Hora 20:00"); break;
            case 12: System.out.println("Hora 21:00 - Ultima Hora"); break;
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    
}