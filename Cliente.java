
class Cliente {
    
    private int ITEM_MAX = 15;
    private int ITEM_MIN = 5;
    private int numeroItems;

  
    public Cliente() {
    
        this.numeroItems= (int) (Math.random() * (ITEM_MAX - ITEM_MIN + 1)) + ITEM_MIN;

    }

    public int numeroItems() {

        int items=0;
        int oldItems= items;
        return oldItems;

    }
}
