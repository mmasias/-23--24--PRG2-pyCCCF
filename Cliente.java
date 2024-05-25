class Cliente {
    private int numeroDeItems;
    
    public Cliente() {
        this.numeroDeItems = 5 + (int)(Math.random() * 11);
    }
    
    public int getNumeroDeItems() {
        return numeroDeItems;
    }
}