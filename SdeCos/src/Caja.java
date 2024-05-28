package SdeCos.src;

class Caja {
    private Cliente cliente;
    private int clientesAtendidos;

    public Caja(){
        clientesAtendidos = 0;
    }

    public boolean estaLibre() {
        return cliente == null;
    }

    public void recibe(Cliente cliente) {
        this.cliente = cliente;

    }

    public void atiende() {
        if(cliente.tieneObjetos()){
            cliente.esAtendido();
        } else {
            cliente = null;
            clientesAtendidos += 1;
        }
    }

    public void verEstado() {
        if(!estaLibre()){
            System.out.println("Items cliente: " + cliente.devolverItems() + " / Clientes Atendidos: " + clientesAtendidos);
        } else {
            System.out.println("Libre!");
        }
    }
}
