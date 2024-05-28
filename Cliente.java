
class Cliente {
    private int numeroItems;
    
    public Cliente(int numeroItems){
        this.numeroItems = numeroItems;
    }

    public boolean tieneObjetos() {
        return numeroItems > 0;
    }

    public void esAtendido() {
        numeroItems -= 1;
    }

    public int devolverItems() {
        return numeroItems;
    }

}
