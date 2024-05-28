public class Cliente {
    private int cantidadDeProductos;

    public Cliente() {
        cantidadDeProductos = 10 + (int) (Math.random() * 5);
    }

    public boolean tieneProductos() {
        return cantidadDeProductos > 0;
    }

    public void procesarProducto() {
        if (tieneProductos()) {
            cantidadDeProductos--;
        }
    }

    public void mostrarEstado() {
        System.out.print(" / Cliente con " + cantidadDeProductos + " productos");
    }
}
