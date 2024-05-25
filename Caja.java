
class Caja {

    private int cantidadItems;
    private int numeroCaja;

    public Caja(int numeroCaja){
        cantidadItems = 0;
        this.numeroCaja = numeroCaja +1;

    }

    public boolean estaLibre() {

        return cantidadItems==0;

    }

    public void recibe(Cliente cliente) {

        cantidadItems = cliente.entregaItems();

    }

    public void atiende() {

        if (cantidadItems>0) {
            cantidadItems--; 
        }

    }

    public void verEstado() {

        System.out.println("Caja " + numeroCaja + ":" + "[" + cantidadItems + "]");

    }
}
