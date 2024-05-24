class Mundo{

    private CentroComercial centroComercial;
    private int tiempoTotal;

    public Mundo(int tiempoTotal){
        centroComercial = new CentroComercial();
        this.tiempoTotal = tiempoTotal;
    }

    public void simular(){

    }

    public static void main(String[] args) {
        new Mundo(720).simular();
    }
}