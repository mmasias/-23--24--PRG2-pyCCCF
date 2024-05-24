public class Caja {
    private int productos;
    private boolean abierta;

    public Caja() {
        this.productos = 0;
        this.abierta = false;
    }

    public int getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public void procesarProducto() {
        if (productos > 0) {
            productos--;
        }
    }
}

