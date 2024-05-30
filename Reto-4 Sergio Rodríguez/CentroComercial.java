class CentroComercial {
    private Caja[] cajas;

    public CentroComercial(int numCajas, int tiempoAtencion) {
        cajas = new Caja[numCajas];
        for (int i = 0; i < numCajas; i++) {
            cajas[i] = new Caja(tiempoAtencion);
        }
    }

    public Caja getCajaDisponible() {
        for (Caja caja : cajas) {
            if (caja.estaLibre()) {
                return caja;
            }
        }
        return null;
    }

    public Caja[] getCajas() {
        return cajas;
    }
}