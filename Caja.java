
class Caja {

    private boolean estaAtendiendo;
    private Cliente cliente;
    private int numeroItems;

    public Caja() {

        this.estaAtendiendo = false;

    }

    public boolean estaLibre() {

        return !estaAtendiendo;
    }

    public void recibe(Cliente cliente) {
        if (estaLibre()) {
            this.cliente = cliente;
            this.estaAtendiendo = true;
        } else {
            System.out.println("The cashier is occupied.");
        }
    }

    public void atiende() {
        if (cliente != null) {
            numeroItems--;
            if (numeroItems <= 0) {
                estaLibre();
            }
        }

    }

    public void verEstado() {

        if (estaLibre()) {

            System.out.println("The cashier is free to attend to you!!");
            
        } else {

            System.out.println("The cashier is occupied whit " + numeroItems + " items left");
        }

    }

}
