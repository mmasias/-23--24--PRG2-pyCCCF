
class Cliente {
    private int packs;

    public Cliente(){
        this.packs = (int) Math.floor(Math.random()*10+5);
    }

    public boolean tienePacks(){
        return packs > 0;
    }

    public void entregarPack(){
        if (packs > 0) {
            packs--; 
        }
    }

    public void verEstado(){
        System.out.println("Número de paquetes " + packs);
    }
}
