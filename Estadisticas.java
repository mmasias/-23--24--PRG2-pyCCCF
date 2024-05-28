
public class Estadisticas {

    private int minutosSinCola;
    private int cola;
    private int personasAtendidas;
    private int articulosVendidos;

    public Estadisticas(){

        minutosSinCola = 0;
        cola = 0;
        personasAtendidas = 0;
        articulosVendidos = 0;
    }

    public void incrementarMinutosSinCola(){
        minutosSinCola++;
    }

    public int obtenerMinutosSinCola(){
        return minutosSinCola;
    }

    public int obtenerCola() {
        return cola;
    }

    public void incrementarPersonasAtendidas(){
        personasAtendidas++;
    }

    public int obtenerPersonasAtendidas() {
        return personasAtendidas;
    }

    public void incrementarArticulosVendidos(){
        articulosVendidos++;
    }

    public int obtenerArticulosVendidos() {
        return articulosVendidos;
    }

    public void actualizar(CentroComercial carrefour) {
        cola = carrefour.obtenerPersonasEnCola();
        personasAtendidas = carrefour.obtenerPersonasAtendidas();
        articulosVendidos = carrefour.obtenerArticulosVendidos();
    }

    public void mostrar() {
        System.out.println("RESUMEN");
        System.out.println("=".repeat(60));
        System.out.println("Minutos con cola en cero: " + minutosSinCola);
        System.out.println("Personas en la cola al cierre: " + cola);
        System.out.println("Personas atendidas en el dia: " + personasAtendidas);
        System.out.println("Articulos vendidos en el dia: " + articulosVendidos);
        System.out.println("=".repeat(60));
    }

    

    

}
