class Mundo {
    private CentroComercial centroComercial;
    private Cliente[] cola;
    private int numClientes;
    private int minutosSinCola;
    private int personasAtendidas;
    private int itemsVendidos;

    public Mundo(int numCajas, int tiempoAtencion) {
        centroComercial = new CentroComercial(numCajas, tiempoAtencion);
        cola = new Cliente[100];
        numClientes = 0;
        minutosSinCola = 0;
        personasAtendidas = 0;
        itemsVendidos = 0;
    }

    public void llegadaCliente() {
        Random random = new Random();
        if (random.nextDouble() <= 0.6) {
            cola[numClientes] = new Cliente(random.nextInt(11) + 5);
            numClientes++;
        }
    }

    public void avanzarTiempo() {
        if (numClientes == 0) {
            minutosSinCola++;
        }

        for (int i = 0; i < numClientes; i++) {
            Caja caja = centroComercial.getCajaDisponible();
            if (caja != null) {
                caja.atenderCliente(cola[i].getPacks());
                itemsVendidos += cola[i].getPacks();
                personasAtendidas++;
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

    public void mostrarResumen() {
        System.out.println("Resumen al finalizar la jornada:");
        System.out.println("Número de minutos sin nadie en cola: " + minutosSinCola);
        System.out.println("Número de personas en cola al finalizar el día: " + numClientes);
        System.out.println("Número de personas atendidas durante el día: " + personasAtendidas);
        System.out.println("Número de items vendidos en el día: " + itemsVendidos);
    }
}