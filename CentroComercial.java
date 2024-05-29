
class CentroComercial {
    private Caja[] cajas;
    private Cliente[] colaClientes;
    private int cantidadEnCola;

    public CentroComercial() {
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
        colaClientes = new Cliente[100];
        cantidadEnCola = 0;
    }

    public void recibirCliente(Cliente cliente) {
        if (cantidadEnCola < colaClientes.length) {
            colaClientes[cantidadEnCola] = cliente;
            cantidadEnCola++;
        }
    }

    public void actualizar() {
        if (cantidadEnCola > 0) {
            asignarClientesACajas();
        }
        procesarCajas();
    }

    private void asignarClientesACajas() {
        for (int i = 0; i < cajas.length && cantidadEnCola > 0; i++) {
            if (cajas[i].estaDisponible()) {
                Cliente cliente = colaClientes[0];
                for (int j = 0; j < cantidadEnCola - 1; j++) {
                    colaClientes[j] = colaClientes[j + 1];
                }
                cantidadEnCola--;
                cajas[i].asignarCliente(cliente);
            }
        }
    }

    private void procesarCajas() {
        for (Caja caja : cajas) {
            caja.procesarCliente();
        }
    }

    public void mostrarEstado(int minutoActual) {
        System.out.println("Minuto actual: " + minutoActual);
        System.out.println(cantidadEnCola + " clientes en cola");
        for (Caja caja : cajas) {
            caja.mostrarEstado();
        }
    }
}
