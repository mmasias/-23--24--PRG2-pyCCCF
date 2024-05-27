
class Caja {

    private int cantidadItems;
    private int numeroCaja;
    private int personasAtendidas;
    private int articulosVendidos;

    public Caja(int numeroCaja){
        cantidadItems = 0;
        this.numeroCaja = numeroCaja +1;
        personasAtendidas = 0;
        articulosVendidos = 0;

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
            articulosVendidos++;
            if (cantidadItems==0) {
                personasAtendidas++; 
            }
        }

    }

    public void verEstado() {

        System.out.println("Caja " + numeroCaja + ":" + "[" + cantidadItems + "]");

    }

    public int obtenerPersonasAtendidas(){

        return personasAtendidas;
    }

    public int obtenerArticulosVendidos(){

        return articulosVendidos;
    }
}
