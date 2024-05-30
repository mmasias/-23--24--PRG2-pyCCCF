class Caja {
    private int tiempoAtencion;
    private int tiempoRestante;

    public Caja(int tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
        this.tiempoRestante = 0;
    }

    public boolean estaLibre() {
        return tiempoRestante == 0;
    }

    public void atenderCliente(int packs) {
        tiempoRestante = tiempoAtencion * packs;
    }

    public void avanzarTiempo() {
        if (tiempoRestante > 0) {
            tiempoRestante--;
        }
    }
}