public class Localidad {
    private String nombre;
    private double precio;
    private int capacidad;
    private int ventas;

    public Localidad(String nombre, double precio, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
        this.ventas = 0;
    }
    public int BoletosDisponibles(){
        return capacidad - ventas;
    }
    public boolean tieneEspacioPara(int cantidad){
        return BoletosDisponibles() >= cantidad;
    }
    public boolean dentroDePresupuesto(double presupuesto){
        return precio <= presupuesto;
    }
    public void venderBoletos(int cantidad){
        if(tieneEspacioPara(cantidad)){
            ventas += cantidad;
        }else{
            System.out.println("No hay espacio suficiente para vender " + cantidad + " boletos");
        }
    }
    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public int getVentas(){
        return ventas;
    }
}
