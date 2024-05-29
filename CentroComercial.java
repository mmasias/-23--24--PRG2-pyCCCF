class CentroComercial {
    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;
    private int minutosSinCola;

    public CentroComercial(){
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i);
        }
        cola = new Cliente[100];
        ultimo = 0;
        minutosSinCola = 0;
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
            if (cajas[i].estaLibre()){
                Cliente cliente = cola[ultimo-1];
                ultimo--;
                cajas[i].recibe(cliente);

            }
            if (ultimo==0) {
                minutosSinCola++;
                break;
            }
        }
    }
    private void atiendeCajas() {
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].atiende();
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

        int personasAtendidasTotal = 0;
        for (int i = 0; i < cajas.length; i++) {
            personasAtendidasTotal = personasAtendidasTotal + cajas[i].obtenerPersonasAtendidas();
        }

        int articulosTotalesVendidos = 0;
        for (int i = 0; i < cajas.length; i++) {
            articulosTotalesVendidos = articulosTotalesVendidos + cajas[i].obtenerArticulosVendidos();
        }

        System.out.println("RESUMEN");
        System.out.println("=".repeat(60));
        System.out.println("Minutos con cola en cero: " + minutosSinCola);
        System.out.println("Personas en la cola al cierre: " + ultimo);
        System.out.println("Personas atendidas en el dia: " + personasAtendidasTotal);
        System.out.println("Articulos vendidos en el dia: " + articulosTotalesVendidos);
        System.out.println("=".repeat(60));

    }
}
}
