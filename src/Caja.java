package src;

class Caja {

    private Cliente clienteActual;
    private int itemsFaltantes;

    public Caja() {
        this.clienteActual = null;
        this.itemsFaltantes = 0;
    }

    public boolean estaLibre() {
        return clienteActual == null;
    }

    public void recibe(Cliente cliente) {
        if (cliente != null) {
            this.clienteActual = cliente;
            this.itemsFaltantes = cliente.getNumeroItems();
        }
    }

    public void atiende() {
        if (clienteActual != null) {
            itemsFaltantes--;
            if (itemsFaltantes <= 0) {
                cajaLibre();
            }
        }
    }

    private void cajaLibre() {
        this.clienteActual = null;
        this.itemsFaltantes = 0;
    }

    public void verEstado() {
        if (estaLibre()) {
            System.out.println("Caja libre");
        } else {
            System.out.println("Atendiendo a un cliente con " + itemsFaltantes + " items");
        }
    }
}
