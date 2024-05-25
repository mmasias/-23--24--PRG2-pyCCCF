class CentroComercial {
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
        if (ultimo < cola.length) {
            cola[ultimo] = cliente;
            ultimo++;
        } else {
            System.out.println("La cola está llena, no se puede recibir más clientes.");
        }
    }

    public void actualizar() {
        if (ultimo > 0) {
            deColaACaja();
        }
        atiendeCajas();
    }

    private void deColaACaja() {
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i].estaLibre() && ultimo > 0) {
                Cliente cliente = cola[ultimo - 1];
                if (cliente != null) {
                    cajas[i].recibe(cliente);
                    cola[ultimo - 1] = null; 
                    ultimo--;
                }
            }
        }
    }

    private void atiendeCajas() {
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].atiende();
        }
    }

    public void verEstado(int minutoActual) {
        System.out.println("Minuto actual: " + minutoActual);
        System.out.println(ultimo + " personas en cola");
        for (int i = 0; i < cajas.length; i++) {
            cajas[i].verEstado();
        }
    }
}