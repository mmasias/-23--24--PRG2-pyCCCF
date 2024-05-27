
class Caja {
   public Cliente cliente;

   public Caja() {
      cliente = null;
   }

   public boolean estaLibre() {
      return this.cliente == null;
   }

   public void recibe(Cliente cliente) {
      if (this.estaLibre()) {
         this.cliente = cliente;
      }
   }

   public void atiende() {
      if (!this.estaLibre()) {
         if (cliente.tieneProductos()) {
            cliente.despacharProducto();
         } else {
            cliente = null;
         }
      }
   }

   public void verEstado() {
      if (cliente != null) {
         System.out.print("[" + cliente.productos() + "]");
      }
   }
}
