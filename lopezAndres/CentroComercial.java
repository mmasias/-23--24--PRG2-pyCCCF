class CentroComercial {
    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;
    private Estadisticas estadisticas;

    public CentroComercial(){
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i);
        }
        cola = new Cliente[100];
        ultimo = 0;
        estadisticas = new Estadisticas();
    }

    public void recibe(Cliente cliente) {
        cola[ultimo] = cliente;
        ultimo++;
    }

    public void actualizar() {
        if(ultimo>0) {
            deColaACaja();
        }
        atiendeCajas();
    }

    private void deColaACaja() {
        for(int i=0;i<cajas.length;i++){
            if (cajas[i].estaLibre() && ultimo>0){
                Cliente cliente = cola[ultimo-1];
                ultimo--;
                cajas[i].recibe(cliente);

            }
        }
    }

    private void atiendeCajas() {
        for (int i = 0; i < cajas.length; i++) {
            if(cajas[i].tieneItems()){
                cajas[i].atiende(); 
                incrementarArticulosVendidos(); 
            }
            if (cajas[i].obtenerArticulos() == 0) {
                incrementarPersonasAtendidas();
            }
        }
    }

    public void verEstado(int minutoActual) {
        System.out.println("Minuto actual: "+minutoActual);
        System.out.println(ultimo + " personas en cola");
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].verEstado();
        }
    }

    public boolean colaVacia() {
        return ultimo == 0;
    }

    public int obtenerPersonasEnCola() {
        return ultimo;
    }

    public int obtenerPersonasAtendidas() {
        return estadisticas.obtenerPersonasAtendidas();
    }

    public int obtenerArticulosVendidos() {
        return estadisticas.obtenerArticulosVendidos();
    }

    public void incrementarArticulosVendidos() {
        estadisticas.incrementarArticulosVendidos();
    }

    public void incrementarPersonasAtendidas() {
        estadisticas.incrementarPersonasAtendidas();
    }

}
