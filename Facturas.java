import java.time.LocalDate;
import java.util.Objects;

/**
 * Esta clase representa las facturas que se generan a partir de las operaciones de los propietarios por el alquiler de sitios web.
 * @author Ismael el Haddad Fellah
 * @version 1.0
 */
public class Facturas {
    private LocalDate fecha;
    private String sitioWeb;
    private String propietario;
    private double precio;
    private int numeroPlazos;

    /**
     * Constructor por defecto. Las cadenas se inicializarán a vacía, los datos
     * numéricos a –1 y los objetos usarán su respectivo constructor por defecto
     */
    public Facturas(){
        fecha = LocalDate.now();
        sitioWeb = propietario = "";
        precio = numeroPlazos = -1;
    }

    /**
     * Constructor por parámetros que permite inicializar el objeto con todos los
     *parámetros.
     * @param fecha inicializa el fecha para el que se configura el constructor
     * @param sitioWeb inicializa la sitioWeb para el que se configura el constructor
     * @param propietario inicializa el propietario de la pagina para el que se configura el constructor
     * @param precio inicializa el precio para el que se configura el constructor
     * @param numeroPlazos inicializa el numeroPlazos para el que se configura el constructor
     * */
    public Facturas(LocalDate fecha, String sitioWeb, String propietario, double precio, int numeroPlazos) {
        setFecha(fecha);
        this.sitioWeb = sitioWeb;
        this.propietario = propietario;
        setPrecio(precio);
        setNumeroPlazos(numeroPlazos);
    }

    /**
     * Constructor por parámetros que permite inicializar el objeto con todos los
     *parámetros.
     * @param fecha inicializa el fecha para el que se configura el constructor
     * @param sitioWeb inicializa la sitioWeb para el que se configura el constructor
     * */
    public Facturas(LocalDate fecha, String sitioWeb){
        setFecha(fecha);
        this.sitioWeb = sitioWeb;
    }

    /**
     * Constructor de copia
     * @param copia permite realizar una copia del constructor
     * */
    public Facturas(Facturas copia){
        this.fecha = copia.fecha;
        this.sitioWeb = copia.sitioWeb;
        this.propietario = copia.propietario;
        this.precio = copia.precio;
        this.numeroPlazos = copia.numeroPlazos;
    }

    /**
     * Getter del atributo fecha
     * @return Devuelve el valor actual del atributo fecha
     * */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Setter del atributo fecha.
     * @param fecha Parámetro que sirve para asegurarse que la fecha no sea previa a la actual.
     * */
    public void setFecha(LocalDate fecha){
        if (fecha.isBefore(LocalDate.now())){
            System.err.println("La fecha no puede ser previa a la actual.");
        }
        this.fecha = fecha;
    }

    /**
     * Getter del atributo sitioWeb.
     * @return Devuelve el valor actual del atributo sitioWeb.
     * */
    public String getSitioWeb(){
        return sitioWeb;
    }

    /**
     * Setter del atributo sitioWeb.
     * @param sitioWeb Parámetro que representa el alquiler de sitios web.
     * */
    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    /**
     * Getter del atributo propietario
     * @return Devuelve el valor actual del atributo propietario
     * */
    public String getPropietario(){
        return propietario;
    }

    /**
     * Setter del atributo propietario.
     * @param propietario Parámetro que asegura de que cada propietario tenga su sitio web.
     * */
    public void setPropietario(String propietario){
        if (this.sitioWeb.isEmpty() && !propietario.isEmpty()){
            System.err.println("Que no puede haber propietarios sin sitios web");
        }
        this.propietario = propietario;
    }

    /**
     * Getter del atributo precio
     * @return Devuelve el valor actual del atributo precio
     * */
    public double getPrecio(){
        return precio;
    }

    /**
     * Setter del atributo precio.
     * @param precio Parámetro que obliga al cliente a poner un precio de transacción superior al cero.
     * */
    public void setPrecio(double precio){
        if (precio < 0){
            System.err.println("El precio no puede ser menor que 0 euros zoquete.");
        }
        this.precio = precio;
    }

    /**
     * Getter del atributo numeroPlazos
     * @return Devuelve el valor actual del atributo numeroPlazos
     * */
    public int getNumeroPlazos() {
        return numeroPlazos;
    }

    /**
     * Setter del atributo numeroPlazos.
     * @param numeroPlazos Parámetro que nos permite saber que el nº de plazos no puede ser inferior a 1 ni superior a 48.
     * */
    public void setNumeroPlazos(int numeroPlazos) {
        if (numeroPlazos < 1 || numeroPlazos > 48){
            System.err.println("El número de plazos tiene que estar entre 1 y 48 personas.");
        }
        this.numeroPlazos = numeroPlazos;
    }

    /**
     * Constructor de clonación
     * @return Permite realizar una clonación del constructor.
     * */
    public Facturas clone(){
        Facturas clon = new Facturas();
        clon.fecha = this.fecha;
        clon.sitioWeb = this.sitioWeb;
        clon.propietario = this.propietario;
        clon.precio = this.precio;
        clon.numeroPlazos = this.numeroPlazos;

        return clon;
    }

    /**
     * Comparación del objeto Facturas con otro para poder saber si son iguales o no.
     * Este comprueba si los atributos fecha, sitioWeb, propietario, precio y numeroPlazos son iguales.
     * @param otro Este es el objeto que se utiliza para comparar todos los atributos mencionados.
     * @return si los atributos fecha, sitioWeb, propietario, precio y numeroPlazos son iguales devolverá true en caso contrario devolverá false.
     * */
    public boolean equals(Facturas otro) {
        if (otro == null || getClass() != otro.getClass()) return false;
        return Double.compare(precio, ((Facturas) otro).precio) == 0 && numeroPlazos == ((Facturas) otro).numeroPlazos && Objects.equals(fecha, ((Facturas) otro).fecha) && Objects.equals(sitioWeb, ((Facturas) otro).sitioWeb) && Objects.equals(propietario, ((Facturas) otro).propietario);
    }

    /**
     * Este método devuelve una copia en String del estado acutal del objeto.
     * @return una copia en formato String del estado del objeto.
     */
    public String toString() {
        return "Facturas{" +
                "fecha=" + fecha +
                ", sitioWeb= " + sitioWeb + '\'' +
                ", propietario= " + propietario + '\'' +
                ", precio= " + precio +
                ", numeroPlazos= " + numeroPlazos +
                '}';
    }

    /**
     * Este método consiste en devolver la cantidad a pagar en cada plazo con la configuración que tiene actualmente.
     * @return devuelve el precio dividido entre el numero de plazos que haya.
     * */
    public double PagosPlazos(){
        if (numeroPlazos <=0){
            System.err.println("No puedes poner un valor inferior o igual a 0");
        }
        return precio / numeroPlazos;
    }
    /**
     * Este método consiste en incrementar la cantidad a pagar un 0,2% por cada plaza que haya restante
     * @return devuelve el precio original más el incremento que se le haya dado y lo multiplicamos por el 0.002 que es el porcentaje
     * añadido y multiplicado por el numero de plazas que tiene actualmente.
     * */
    public void incrementarPrecio() {
        if (numeroPlazos <= 0){
            System.err.println("No puedes poner un valor inferior o igual a 0");
        }
        this.precio += this.precio * 0.002 * this.numeroPlazos;
    }
}
