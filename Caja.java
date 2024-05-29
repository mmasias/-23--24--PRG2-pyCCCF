
class Caja {
    private Cliente cliente;

    public boolean estaLibre() {
        return cliente == null;
    }

    public void recibe(Cliente cliente) {
        this.cliente = cliente;
    }

    public void atiende() {
        if(!estaLibre()){
            if (cliente.tienePacks()){
                cliente.entregarPack();
            }
            if (!cliente.tienePacks()){
                cliente = null;
            }
        }
    }

    public void verEstado() {
        System.out.println(estaLibre() ? "Caja [Libre]" : "Caja [Ocupada]" );
        if (!estaLibre()) {
            cliente.verEstado();   
        }
    }
}
