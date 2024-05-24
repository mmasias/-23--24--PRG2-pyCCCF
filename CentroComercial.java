
public class CentroComercial {

    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;

    public CentroComercial(){
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
        cola = new Cliente[100];
        ultimo = 0;
    }

    public void recibe(Cliente cliente) {
    }

    public void actualizar() {
    }

    public void verEstado(int minutoActual) {
    }

}
