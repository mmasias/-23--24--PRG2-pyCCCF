class Cliente {
    private int productos;

    public Cliente() {
        this.productos = (int) (Math.random() * 5) + 10;
    }

    public boolean sinProductos() {
        return productos == 0;
    }

    public void procesarProducto() {
        if (productos > 0) {
            productos--;
        }
    }

    public void mostrarEstado() {
        System.out.print(" / Cliente con " + productos + " productos restantes");
    }
}
