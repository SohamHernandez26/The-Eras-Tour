import java.util.Random;
import java.util.Scanner;

public class Main {

    // Método para validar si un ticket está dentro del rango definido por a y b
    public static boolean esTicketApto(int ticket, int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return ticket >= min && ticket <= max;
    }

    // Método para seleccionar aleatoriamente una localidad
    public static Localidad seleccionarLocalidad(Localidad[] localidades, Random rand) {
        return localidades[rand.nextInt(localidades.length)];
    }

    // Método para procesar la compra: valida y realiza la venta si es posible
    public static int procesarCompra(Comprador comprador, Localidad localidad) {
        if (localidad.BoletosDisponibles() == 0) {
            System.out.println("No hay espacio en " + localidad.getNombre());
            return 0;
        }

        if (!localidad.dentroDePresupuesto(comprador.getPresupuesto())) {
            System.out.println("Presupuesto insuficiente para " + localidad.getNombre());
            return 0;
        }

        int cantidadAVender = Math.min(localidad.BoletosDisponibles(), comprador.getCant());
        localidad.venderBoletos(cantidadAVender);
        comprador.setBoletosComprados(cantidadAVender);
        System.out.println("Venta exitosa: " + cantidadAVender + " boletos en " + localidad.getNombre());
        return cantidadAVender;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Crear localidades
        Localidad loc1 = new Localidad("Localidad 1", 100, 20);
        Localidad loc5 = new Localidad("Localidad 5", 500, 20);
        Localidad loc10 = new Localidad("Localidad 10", 1000, 20);
        Localidad[] localidades = { loc1, loc5, loc10 };

        int totalBoletosVendidos = 0;

        while (totalBoletosVendidos < 60) {
            System.out.println("\n--- Nueva Solicitud de Compra ---");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Cantidad de boletos a comprar: ");
            int cant = sc.nextInt();

            System.out.print("Presupuesto máximo: ");
            double presupuesto = sc.nextDouble();
            sc.nextLine(); // limpiar buffer

            // Crear comprador
            Comprador comprador = new Comprador(nombre, email, cant, presupuesto);

            // Generar ticket y rango aleatorio
            int ticketComprador = rand.nextInt(15000) + 1;
            int a = rand.nextInt(15000) + 1;
            int b = rand.nextInt(15000) + 1;
            comprador.setNumeroTicket(ticketComprador);

            System.out.println("Número de ticket: " + ticketComprador + " (Debe estar entre " + Math.min(a,b) + " y " + Math.max(a,b) + ")");

            // Validar ticket
            if (esTicketApto(ticketComprador, a, b)) {
                System.out.println("¡Ticket válido!");

                // Seleccionar localidad
                Localidad localidadElegida = seleccionarLocalidad(localidades, rand);
                System.out.println("Localidad asignada: " + localidadElegida.getNombre());

                // Procesar compra
                int vendidos = procesarCompra(comprador, localidadElegida);

                if (vendidos > 0) {
                    totalBoletosVendidos += vendidos;
                    System.out.println("¡Venta realizada! Se vendieron " + vendidos + " boletos a " + comprador.getNombre());
                } else {
                    System.out.println("No se pudo completar la venta para " + comprador.getNombre());
                }

            } else {
                System.out.println("Ticket no válido. No puede comprar boletos.");
            }

            System.out.println("Total de boletos vendidos hasta ahora: " + totalBoletosVendidos);
        }

        System.out.println("\n--- Venta Finalizada ---");
        System.out.println("Boletos vendidos en Localidad 1: " + loc1.getVentas());
        System.out.println("Boletos vendidos en Localidad 5: " + loc5.getVentas());
        System.out.println("Boletos vendidos en Localidad 10: " + loc10.getVentas());

        sc.close();
    }
}
