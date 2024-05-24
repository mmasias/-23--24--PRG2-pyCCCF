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

    private void procesarMinuto(int minuto) {
        for (Caja caja : cajas) {
            if (caja.isAbierta() && caja.getProductos() > 0) {
                caja.procesarProducto();
                productosVendidos++;
                if (caja.getProductos() <= 0) {
                    clientesAtendidos++;
                }
            }
        }

        if (cajaAuxiliar.getProductos() > 0) {
            cajaAuxiliar.procesarProducto();
            productosVendidos++;
            if (cajaAuxiliar.getProductos() <= 0) {
                clientesAtendidos++;
            }
        }

        if (Math.random() <= porcentajeNuevo) {
            cola++;
        }

        distribuirClientes();

        if (cola > 15 && !cajaAuxiliar.isAbierta()) {
            cajaAuxiliar.setAbierta(true);
        }

        if (cajaAuxiliar.isAbierta() && cajaAuxiliar.getProductos() <= 0 && cola < 15) {
            cajaAuxiliar.setAbierta(false);
        }

        mostrarEstado(minuto);
        
        if (cola == 0) {
            minutosSinCola++;
        }
    }

    private void distribuirClientes() {
        for (Caja caja : cajas) {
            if (cola >= 1 && caja.getProductos() <= 0 && caja.isAbierta()) {
                int art = (int) (Math.random() * 10) + 5;
                caja.setProductos(art);
                cola--;
            }
        }

        if (cola >= 1 && cajaAuxiliar.getProductos() <= 0 && cajaAuxiliar.isAbierta()) {
            int art = (int) (Math.random() * 10) + 5;
            cajaAuxiliar.setProductos(art);
            cola--;
        }
    }

    private void mostrarEstado(int minuto) {
        System.out.print("MINUTO " + minuto);
        if (cola > 0) {
            System.out.print(" - Llega " + cola + " cliente(s)");
        } else {
            System.out.print(" - No llega ningun cliente nuevo");
        }
        System.out.println(" - Hay " + cola + " clientes en la cola");
        
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i].isAbierta()) {
                System.out.print("Caja " + (i + 1) + ": " + cajas[i].getProductos() + " ");
            } else {
                System.out.print("Caja " + (i + 1) + ": Cerrada ");
            }
        }
        
        if (cajaAuxiliar.isAbierta()) {
            System.out.println(" - Caja Auxiliar: " + cajaAuxiliar.getProductos());
        } else {
            System.out.println(" - Caja Auxiliar: Cerrada");
        }
        
        System.out.println("-----------------------------------------------------------------------------");
    }

    private void mostrarResumen() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Resumen cierre de tienda");
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Productos vendidos: " + productosVendidos);
        System.out.println("Clientes sin atender en la cola: " + cola);
        System.out.println("Minutos sin cola: " + minutosSinCola);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("CIERRE DE TIENDA");
        System.out.println("-----------------------------------------------------------------------------");
    }

    private boolean ningunaCajaAbierta() {
        for (Caja caja : cajas) {
            if (caja.isAbierta()) {
                return false;
            }
        }
        return true;
    }
}