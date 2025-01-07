/**
 * Esta clase representa un hosting web que permite contabilizar los sitios web
 * Emplea tres atributos String para representar código de identificación, el nombre de la página y la URL
 * @author Ismael el Haddad Fellah
 * @version 1.0
 */
public class HostingWeb {
    private String CI;
    private String nombrePagina;
    private String URL;

    /**
     * Constructor por defecto. Las cadenas se inicializarán a vacía, los datos
     * numéricos a –1 y los objetos usarán su respectivo constructor por defecto
     */
    public HostingWeb(){
        CI = nombrePagina = URL = "";
    }

    /**
     * Constructor por parámetros que permite inicializar el objeto con todos los
     *parámetros.
     * @param CI inicializa el código de identificación para el que se configura el constructor
     * @param URL inicializa la URL para el que se configura el constructor
     * @param nombrePagina inicializa el nombre de la pagina para el que se configura el constructor
     */
    public HostingWeb(String CI, String nombrePagina, String URL) {
        this.CI = CI;
        this.nombrePagina = nombrePagina;
        this.URL = URL;
    }

    /**
     * Constructor por parámetros que permite inicializar el objeto con todos los
     parámetros a excepción de la URL.
     * @param CI inicializa el código de identificación para el que se configura el constructor
     * @param nombrePagina inicializa el nombre de la pagina para el que se configura el constructor
     * */
    public HostingWeb(String CI, String nombrePagina) {
        this.CI = CI;
        this.nombrePagina = nombrePagina;
    }

    /**
     * Constructor de copia
     * @param copia permite realizar una copia del constructor
     * */
    public HostingWeb(HostingWeb copia){
        this.CI = copia.CI;
        this.nombrePagina = copia.nombrePagina;
        this.URL = copia.URL;
    }

    /**
     * Getter del atributo CI
     * @return Devuelve el valor actual del atributo CI
     * */
    public String getCI() {
        return CI;
    }

    /**
     * Setter del atributo CI.
     * @param CI Parámetro que trata de una composición de las tres primeras letras del
     * nombre de la página y los tres últimos dígitos del DNI del propietario.
     * */
    public void setCI(String CI) {
        this.CI = CI;
    }

    /**
     * Getter del atributo nombrePagina
     * @return Devuelve el valor actual del atributo nombrePagina.
     * */
    public String getNombrePagina() {
        return nombrePagina;
    }

    /**
     * Setter del atributo nombrePagina.
     * @param nombrePagina Parámetro que sustituye los espacios por guiones bajos.
     * */
    public void setNombrePagina(String nombrePagina) {
        if (nombrePagina.contains(" ")){
            this.nombrePagina = nombrePagina.replace(" ","_");
        }
    }

    /**
     * Getter del atributo URL
     * @return Devuelve el valor actual del atributo URL.
     * */
    public String getURL() {
        return URL;
    }

    /**
     * Setter del atributo URL.
     * @param URL Parámetro que nos obliga a empezar por "www." y finalizar con ".es".
     * */
    public void setURL(String URL) {
        if (URL.startsWith("www.") && URL.endsWith(".es")){
            this.URL = URL;
        }
    }

    /**
     * Constructor de clonación
     * @return Permite realizar una clonación del constructor.
     * */
    public HostingWeb clone(){
        HostingWeb clon = new HostingWeb();
        clon.URL = this.URL;
        clon.nombrePagina = this.nombrePagina;
        clon.CI = this.CI;

        return clon;
    }

    /**
     * Comparación del objeto HostingWeb con otro para poder saber si son iguales o no.
     * Este comprueba si los atributos nombrePagina, URL, y CI son iguales.
     * @param otro Este es el objeto que se utiliza para comparar todos los atributos mencionados.
     * @return si los atributos nombrePagina, URL y CI son iguales devolverá true en caso contrario devolverá false.
     * */
    public boolean equals (HostingWeb otro){
        if (this.nombrePagina.equals(otro.nombrePagina) == false)
            return false;
        if (this.URL.equals(otro.URL) == false)
            return false;
        if (this.CI.equals(otro.CI) == false)
            return false;
        return true;
    }

    /**
     * Este método devuelve una copia en String del estado acutal del objeto.
     * @return una copia en formato String del estado del objeto.
     */
    public String toString(){
        String resultado = "El nombre de la página es: " + nombrePagina +
                " con URL " + URL +
                " y cuyo código de identificación es el siguiente: " + CI;
        return resultado;
    }

}
