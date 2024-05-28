package SdeCos.src;

class CentroComercial {

    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;
    private int clientesAtendidosTotal;

    public CentroComercial(){
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
        cola = new Cliente[100];
        ultimo = 0;
    }

    public void recibe(Cliente cliente) {
        cola[ultimo] = cliente;
        ultimo++;
    }

    public void actualizar() {
        deColaACaja();
        atiendeCajas();
    }

    private void deColaACaja() {
        for(int i=0;i<cajas.length;i++){
            if (cajas[i].estaLibre() && ultimo >=1){
                ultimo--;
                Cliente cliente = cola[ultimo];
                cajas[i].recibe(cliente);
            }
        }
    }

    private void atiendeCajas() {
        for (int i = 0; i < cajas.length; i++) {
            if(!cajas[i].estaLibre()){
            cajas[i].atiende();
            }
        }
    }

    public void verEstado(int minutoActual) {
        clientesAtendidosTotal = 0;
        System.out.println("Minuto actual: "+ minutoActual);
        System.out.println(ultimo + " personas en cola");
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].verEstado();
            clientesAtendidosTotal += cajas[i].getClientesAtendidos(); 
        }
        System.out.println("En total se han atendido a " + clientesAtendidosTotal + " clientes");

    }
}
