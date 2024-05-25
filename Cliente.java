
class Cliente {

    private int cantidadItems;

    public Cliente(){

        cantidadItems = (int)(Math.random() *11)+5;

    }

    public int entregaItems() {

        return cantidadItems;
        
    }

}
