class Caja {

    private boolean atendiendo;
    private Cliente cliente;

    public Caja() {
        this.atendiendo = false;
    }

    public boolean estaLibre() {
        return !atendiendo;
    }

    public void recibe(Cliente cliente) {
        this.cliente = cliente;
        this.atendiendo = true;
    }

    public void atiende() {
        if (this.cliente != null && this.cliente.tieneProductos()) {
            cliente.entregarProductos();
            if (!cliente.tieneProductos()) {
                this.cliente = null;
                this.atendiendo = false;
            }
        }
    }

    public void verEstado() {
        System.out.print("Caja " + (atendiendo ? "ocupada " : "libre "));
        if (this.cliente != null)
            cliente.verEstado();
        System.out.println();
    }
}