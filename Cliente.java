class Cliente {

    private int numeroProductos;

    public Cliente() {
        this.numeroProductos = (int) (Math.random() * 5) + 10;
    }

    public boolean tieneProductos() {
        return numeroProductos > 0;
    }

    public void verEstado() {
        System.out.print(" / Cliente " + "#".repeat(numeroProductos));
    }

    public void entregarProductos() {
        numeroProductos--;
    }
}
