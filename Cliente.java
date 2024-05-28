class Cliente {
    private int numeroDeItems;
    
    public Cliente() {
        this.numeroDeItems = 5 + (int)(Math.random() * 11);
    }
    
    public int getNumeroDeItems() {
        int oldItems = numeroDeItems;
        numeroDeItems = 0;
        return oldItems;
    }
}