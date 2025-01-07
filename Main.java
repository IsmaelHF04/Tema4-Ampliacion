import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Creación de una factura
        Facturas facturas = new Facturas(LocalDate.of(2025,4,20),"www.google.com", "Juan Antonio",8456,11);

        //Comprobar el atributo propietario

        Propietarios propietario = new Propietarios("78954612E","Juan", "Antonio", 20, "juanantonio@outlook.es");
        System.out.println("¿Este es el propietario? " + GestorWeb.comprobacionPrimera());
    }
}