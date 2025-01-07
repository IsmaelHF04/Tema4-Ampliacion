import java.time.LocalDate;

/**
 * Esta clase representa un hosting web que permite contabilizar los sitios web
 * Emplea tres atributos String para representar código de identificación, el nombre de la página y la URL
 * @author Ismael el Haddad Fellah
 * @version 1.0
 */
public class GestorWeb {
    /**
     * Este método se utilizará para comprobar que un determinado propietario
     * pasado por parámetros es el figurante en una factura que se recibe también por parámetros.
     * @param propietarios este parámetro se utiliza para poder sacar todos los getters y setters
     * necesarios de la clase Propietarios para poder utilizarlos en nuestro método.
     * @param facturas este parámetro se utiliza para poder sacar todos los getters y setters
     * necesarios de la clase Facturas para poder utilizarlos en nuestro método.
     * @return el método devolverá true en caso de que en el nombre y apellidos de propietarios
     * sea igual o lo contenga en el nombre y apellidos de facturas en caso contrario devolverá falso.
     * */
    public static boolean comprobacionPrimera(Propietarios propietarios, Facturas facturas){
        String nombreCompleto = propietarios.getNombre() + " " + propietarios.getApellidos();
        if (nombreCompleto.equals(facturas.getPropietario()))
            return true;
        return false;
    }

    /**
     * Este método se utilizará para comprobar que a partir de un propietario y una factura que se reciben por parámetros
     * rebaje el precio a pagar en un % que sea equivalente a la edad del propietario
     * @param propietarios este parámetro se utiliza para poder sacar todos los getters y setters
     * necesarios de la clase Propietarios para poder utilizarlos en nuestro método.
     * @param facturas este parámetro se utiliza para poder sacar todos los getters y setters
     * necesarios de la clase Facturas para poder utilizarlos en nuestro método.
     * @return el método devolverá el precio actual del propietario menos el descuento realizado anteriormente.
     * */
    public static double comprobacionSegunda(Propietarios propietarios, Facturas facturas){
        double descuento = (facturas.getPrecio() * propietarios.getEdad()) / 100;
        return facturas.getPrecio() - descuento;
    }

    /**
     * Este método se utilizará para reducir el precio cuando sea el aniversario de la realización de la factura.
     * La reducción será de tanto % como años que hayan pasado desde que se realizó.
     * @param facturas este parámetro se utiliza para poder sacar todos los getters y setters
     * necesarios de la clase Facturas para poder utilizarlos en nuestro método.
     * @return el método devolverá el precio actual del propietario menos el descuento realizado anteriormente según los años transcurridos.
     * */
    public static double comprobacionTercera(Facturas facturas){
        double añosTranscurridos = facturas.getFecha().getYear() - LocalDate.now().getYear();
        double descuento = (facturas.getPrecio() * añosTranscurridos) / 100;
        return facturas.getPrecio() - descuento;
    }

    /**
     * Este método se utilizará para anular la URL en caso de que tenga una deuda de mas de 5000 euros.
     * @param facturas este parámetro se utiliza para poder sacar todos los getters y setters
     * necesarios de la clase Facturas para poder utilizarlos en nuestro método.
     * @param hostingWeb este parámetro se utiliza para poder sacar todos los getters y setters
     * necesarios de la clase HostingWeb para poder utilizarlos en nuestro método.
     * */
    public static void comprobacionCuarta(HostingWeb hostingWeb, Facturas facturas){
        double enDeuda = facturas.PagosPlazos() * facturas.getNumeroPlazos();

        if (enDeuda > 5000){
            hostingWeb.setURL("");
            System.out.println("Tienes que pagar las deudas pendientes zoquete que es la siguiente: " + enDeuda + "€.");
        }
    }
}
