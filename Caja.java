
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

            cantidadItems--; 

    }

    public void verEstado() {

        System.out.println("Caja " + numeroCaja + ":" + "[" + cantidadItems + "]");

    }

    public int obtenerArticulos(){

        return cantidadItems;
    }

    public boolean tieneItems(){
        return cantidadItems>0;
    }

}
