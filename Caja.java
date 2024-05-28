public class Caja {
    private Cliente clienteActual;
    private boolean estaOcupada;

    public Caja() {
        estaOcupada = false;
    }

    public boolean estaLibre() {
        return !estaOcupada;
    }

    public void asignarCliente(Cliente cliente) {
        if (estaLibre()) {
            clienteActual = cliente;
            estaOcupada = true;
        }
    }

    public void procesarAtencion() {
        if (clienteActual != null && clienteActual.tieneProductos()) {
            clienteActual.procesarProducto();
            if (!clienteActual.tieneProductos()) {
                clienteActual = null;
                estaOcupada = false;
            }
        }
    }

    public void mostrarEstado() {
        System.out.print("Caja " + (estaOcupada ? "ocupada" : "libre"));
        if (clienteActual != null) {
            clienteActual.mostrarEstado();
        }
        System.out.println();
    }
}
