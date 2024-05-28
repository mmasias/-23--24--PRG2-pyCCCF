public class CentroComercial {
    private Caja[] cajas;
    private Cliente[] cola;
    private int ultimo;

    public CentroComercial() {
        cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja();
        }
        cola = new Cliente[100];
        ultimo = -1;
    }

    public void recibirCliente(Cliente cliente) {
        if (ultimo < cola.length - 1) {
            cola[++ultimo] = cliente;
        }
    }

    public void actualizar() {
        deColaACaja();
        atiendeCajas();
    }

    private void deColaACaja() {
        int index = 0;
        while (index <= ultimo) {
            boolean clienteAsignado = false;
            for (int i = 0; i < cajas.length && index <= ultimo; i++) {
                if (cajas[i].estaLibre()) {
                    cajas[i].asignarCliente(cola[index]);
                    index++;
                    clienteAsignado = true;
                    break;
                }
            }
            if (!clienteAsignado) break;
        }
      
        if (index <= ultimo) {
            System.arraycopy(cola, index, cola, 0, ultimo - index + 1);
        }
        ultimo -= index;
    }

    private void atiendeCajas() {
        for (Caja caja : cajas) {
            caja.procesarAtencion();
        }
    }

    public void mostrarEstado(int minutoActual) {
        System.out.println("Minuto actual: " + minutoActual);
        System.out.println((ultimo + 1) + " personas en cola");
        for (Caja caja : cajas) {
            caja.mostrarEstado();
        }
    }
}
