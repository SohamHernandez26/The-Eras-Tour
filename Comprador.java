public class Comprador {
    private String nombre;
    private String email;
    private int cant;
    private double presupuesto;
    private int numeroTicket;
    private int boletosComprados;

    public Comprador(String nombre, String email, int cant , double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cant = cant;
        this.presupuesto = presupuesto;
        this.boletosComprados = 0;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getCant(){
        return cant;
    }
    public void setCant(int cant){
        this.cant = cant;
    }
    public double getPresupuesto(){
        return presupuesto;
    }
    public void setPresupuesto(double presupuesto){
        this.presupuesto = presupuesto;
    }
    public int getNumeroTicket(){
        return numeroTicket;
    }
    public void setNumeroTicket(int numeroTicket){
        this.numeroTicket = numeroTicket;
    }
    public int getBoletosComprados(){
        return boletosComprados;
    }
    public void setBoletosComprados(int boletosComprados){
        this.boletosComprados = boletosComprados;
    }
}