import java.util.Random;

class Cliente {
   private int productos;

   public Cliente() {
      productos = new Random().nextInt(11) + 5;
   }

   public boolean tieneProductos() {
      return productos > 0;
   }
   
   public void despacharProducto() {
      productos -= 1;
   }

   public int productos() {
      return productos;
   }
}
