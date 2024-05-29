class CentroComercial {
    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;
    private int minutosSinCola;
    private Estadisticas estadisticas;

    public CentroComercial(){
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i);
        }
        cola = new Cliente[100];
        ultimo = 0;
        minutosSinCola = 0;
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
            cajas[i].atiende();
            incrementarArticulosVendidos();
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

    public void mostrarEstadisticasJornada() {
    public boolean colaVacia() {
        return ultimo == 0;
    }

        int personasAtendidasTotal = 0;
        for (int i = 0; i < cajas.length; i++) {
            personasAtendidasTotal = personasAtendidasTotal + cajas[i].obtenerPersonasAtendidas();
        }
    public int obtenerPersonasEnCola() {
        return ultimo;
    }

        int articulosTotalesVendidos = 0;
        for (int i = 0; i < cajas.length; i++) {
            articulosTotalesVendidos = articulosTotalesVendidos + cajas[i].obtenerArticulosVendidos();
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

        System.out.println("RESUMEN");
        System.out.println("=".repeat(60));
        System.out.println("Minutos con cola en cero: " + minutosSinCola);
        System.out.println("Personas en la cola al cierre: " + ultimo);
        System.out.println("Personas atendidas en el dia: " + personasAtendidasTotal);
        System.out.println("Articulos vendidos en el dia: " + articulosTotalesVendidos);
        System.out.println("=".repeat(60));

    public void incrementarPersonasAtendidas() {
        estadisticas.incrementarPersonasAtendidas();
    }

}
