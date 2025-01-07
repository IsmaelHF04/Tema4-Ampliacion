import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Creación de una factura
        Facturas facturas = new Facturas(LocalDate.of(2040,4,20),"www.google.com", "Juan Antonio",8456,11);

        //Comprobar el atributo propietario
        Propietarios propietario = new Propietarios("78954612E","Juan", "Antonio", 20, "juanantonio@outlook.es");
        System.out.println("¿Este es el propietario? " + GestorWeb.comprobacionPrimera(propietario,facturas));

        //Comprobar descuento por la edad indicada
        System.out.println("El precio final tras el descuento por edad es el siguiente: " + GestorWeb.comprobacionSegunda(propietario,facturas) + "€.");

        //Comprobar descuento por el aniversario
        System.out.println("El precio final tras el descuento por el aniversario es el siguiente: " + GestorWeb.comprobacionTercera(facturas) + "€.");

        //Anular la URL en caso de deuda
        HostingWeb hostingWeb = new HostingWeb("E4","Ismael's Industries", "www.ismaelsindustries.com");
    }
}