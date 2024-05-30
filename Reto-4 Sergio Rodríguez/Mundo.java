class Mundo {
    private CentroComercial centroComercial;
    private Cliente[] cola;
    private int numClientes;

    public Mundo(int numCajas, int tiempoAtencion) {
        centroComercial = new CentroComercial(numCajas, tiempoAtencion);
        cola = new Cliente[100]; // Capacidad máxima de la cola
        numClientes = 0;
    }

    public void llegadaCliente() {
        Random random = new Random();
        if (random.nextDouble() <= 0.6) {
            cola[numClientes] = new Cliente(random.nextInt(11) + 5);  // Entre 5 y 15 packs
            numClientes++;
        }
    }

    public void avanzarTiempo() {
        for (int i = 0; i < numClientes; i++) {
            Caja caja = centroComercial.getCajaDisponible();
            if (caja != null) {
                caja.atenderCliente(cola[i].getPacks());
                for (int j = i; j < numClientes - 1; j++) {
                    cola[j] = cola[j + 1];
                }
                numClientes--;
                i--;
            }
        }

        for (Caja caja : centroComercial.getCajas()) {
            caja.avanzarTiempo();
        }
    }

    public Caja[] getCajas() {
        return centroComercial.getCajas();
    }
}