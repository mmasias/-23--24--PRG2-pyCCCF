package src;

class CentroComercial {

    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;
    private Estadisticas estadisticas;

    public CentroComercial() {
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(this);
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
        if (ultimo > 0) {
            deColaACaja();
        }
        atiendeCajas();
    }

    private void deColaACaja() {
        for (int i = 0; i < cajas.length; i++) {
            if (ultimo > 0 && cajas[i].estaLibre()) {
                Cliente cliente = cola[ultimo - 1];
                ultimo--;
                cajas[i].recibe(cliente);
            }
        }
    }

    private void atiendeCajas() {
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].atiende();
        }
    }

    public boolean colaVacia() {
        return ultimo == 0;
    }

    public int getPersonasEnCola() {
        return ultimo;
    }

    public void incrementarPersonasAtendidas() {
        estadisticas.incrementarPersonasAtendidas();
    }

    public void incrementarItemsVendidos(int items) {
        estadisticas.incrementarItemsVendidos(items);
    }

    public int getPersonasAtendidas() {
        return estadisticas.getPersonasAtendidas();
    }

    public int getItemsVendidos() {
        return estadisticas.getItemsVendidos();
    }

    public void verEstado(int minutoActual) {
        System.out.println("Minuto actual: " + minutoActual);
        System.out.println(ultimo + " personas en cola");
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].verEstado();
        }
    }

}
