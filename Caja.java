class Caja {
    private Cliente clienteActual;
    private int itemsRestantes;
    
    public boolean estaLibre() {
        return clienteActual == null;
    }
    
    public void recibe(Cliente cliente) {
        this.clienteActual = cliente;
        this.itemsRestantes = cliente.getNumeroDeItems();
    }
    
    public void atiende() {
        if (clienteActual != null) {
            itemsRestantes--;
            if (itemsRestantes <= 0) {
                clienteActual = null;
            }
        }
    }
    
    public void verEstado() {
        if (clienteActual == null) {
            System.out.println("Caja libre");
        } else {
            System.out.println("Atendiendo a un cliente con " + itemsRestantes + " items restantes.");
        }
    }
}