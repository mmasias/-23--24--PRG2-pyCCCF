
class Caja {
    private boolean enServicio;
    private Cliente clienteActual;

    public Caja() {
        this.enServicio = false;
    }

    public boolean estaDisponible() {
        return !enServicio;
    }

    public void asignarCliente(Cliente cliente) {
        this.clienteActual = cliente;
        this.enServicio = true;
    }

    public void procesarCliente() {
        if (clienteActual != null) {
            clienteActual.procesarProducto();
            if (clienteActual.sinProductos()) {
                this.clienteActual = null;
                this.enServicio = false;
            }
        }
    }

    public void mostrarEstado() {
        System.out.print("Caja " + (enServicio ? "en servicio" : "disponible"));
        if (clienteActual != null) {
            clienteActual.mostrarEstado();
        }
        System.out.println();
    }
}
