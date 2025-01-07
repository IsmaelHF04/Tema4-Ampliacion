/**
 * Esta clase representa los propietarios donde se guarda la informacion  de cada uno de los propietarios.
 * @author Ismael el Haddad Fellah
 * @version 1.0
 */

public class Propietarios {
    private String DNI;
    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;

    /**
     * Constructor por defecto. Las cadenas se inicializarán a vacía, los datos
     * numéricos a –1 y los objetos usarán su respectivo constructor por defecto
     */
    public Propietarios(){
        DNI = nombre = apellidos = correo = "";
        edad = -1;
    }

    /**
     * Constructor por parámetros que permite inicializar el objeto con todos los
     *parámetros.
     * @param DNI inicializa el DNI para el que se configura el constructor
     * @param nombre inicializa la nombre para el que se configura el constructor
     * @param apellidos inicializa el apellidos de la pagina para el que se configura el constructor
     * @param edad inicializa el edad para el que se configura el constructor
     * @param correo inicializa el correo para el que se configura el constructor
     * */
    public Propietarios(String DNI, String nombre, String apellidos, int edad, String correo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
    }

    /**
     * Constructor de copia
     * @param copia permite realizar una copia del constructor
     * */
    public Propietarios (Propietarios copia){
        this.edad = copia.edad;
        this.apellidos = copia.apellidos;
        this.correo = copia.correo;
        this.nombre = copia.nombre;
        this.DNI = copia.DNI;
    }
    /**
     * Getter del atributo DNI
     * @return Devuelve el valor actual del atributo DNI
     * */
    public String getDNI() {
        return DNI;
    }

    /**
     * Setter del atributo DNI.
     * @param DNI Parámetro que trata de la composición de un DNI.
     * */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Getter del atributo nombre
     * @return Devuelve el valor actual del atributo nombre.
     * */
    public String getNombre() {
        return nombre;
    }
    /**
     * Setter del atributo nombre.
     * @param nombre Parámetro que consiste en guardar la primera letra en mayúscula
     * y en caso de que el nombre sea compuesto, deberá llevar mayúsculas en la primera letra de cada parte.
     * */
    public void setNombre(String nombre) {
        this.nombre = nuevoFormato(nombre);
    }

    /**
     * Getter del atributo apellidos
     * @return Devuelve el valor actual del atributo apellidos.
     * */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter del atributo apellidos.
     * @param apellidos Parámetro que consiste en estar separados por espacios y al igual que el atributo nombre guardar la primera letra en mayúscula
     * y en caso de que el nombre sea compuesto, deberá llevar mayúsculas en la primera letra de cada parte.
     * Además, en caso de que un apellido contenga un guión este será eliminado.
     * */
    public void setApellidos(String apellidos) {
        this.apellidos = nuevoFormato(apellidos).replace("-", " ");
    }

    /**
     * Getter del atributo edad
     * @return Devuelve el valor actual del atributo edad.
     * */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter del atributo edad.
     * @param edad Parámetro que asegura de que el propietario tenga más de 18 años y menos que 70 años.
     * */
    public void setEdad(int edad) {
        if (edad >= 18 && edad < 70) {
            this.edad = edad;
        }else {
            System.err.println("La edad deber ser mayor o igual a 18 y menor a 70.");
        }
    }

    /**
     * Getter del atributo correo
     * @return Devuelve el valor actual del atributo correo.
     * */
    public String getCorreo() {
        return correo;
    }

    /**
     * Setter del atributo correo.
     * @param correo Parámetro que se asegura de que el correo contenga el caracter especial "@"
     * y que pertenece a alguno de los siguientes dominios:
     * <ul>
     *    <li>outlook.es</li>
     *    <li>gmail.com</li>
     *    <li>Hosted.net</li>
     * </ul>
     * */
    public void setCorreo(String correo) {
        if (correo.contains("@") && (correo.endsWith("@outlook.es") || correo.endsWith("@gmail.com") || correo.endsWith("@Hosted.net"))) {
            this.correo = correo;
        } else {
            System.err.println("El correo no es válido. Debe contener '@' y un dominio válido.");
        }
    }

    /**
     * Constructor de clonación
     * @return Permite realizar una clonación del constructor.
     * */
    public Propietarios clone(){
        Propietarios clon = new Propietarios();
        clon.DNI = this.DNI;
        clon.nombre = this.nombre;
        clon.apellidos = this.apellidos;
        clon.correo = this.correo;
        clon.edad = this.edad;

        return clon;
    }

    /**
     * Comparación del objeto Propietarios con otro para poder saber si son iguales o no.
     * Este comprueba si los atributos DNI, apellidos, nombre, correo y edad son iguales.
     * @param otro Este es el objeto que se utiliza para comparar todos los atributos mencionados.
     * @return si los atributos DNI, apellidos, nombre, correo y edad son iguales devolverá true en caso contrario devolverá false.
     * */

    public boolean equals (Propietarios otro){
        if (this.DNI.equals(otro.DNI) == false)
            return false;
        if (this.apellidos.equals(otro.apellidos) == false)
            return false;
        if (this.nombre.equals(otro.nombre) == false)
            return false;
        if (this.correo.equals(otro.correo) == false)
            return false;
        if (this.edad == (otro.edad) == false)
            return false;
        return true;
    }
    /**
     * Este método devuelve una copia en String del estado acutal del objeto.
     * @return una copia en formato String del estado del objeto.
     */
    public String toString(){
        String resultado = "El nombre completo del propietario es: " + nombre + " " + apellidos +
                " cuya edad es: " + edad +
                " ,cuyo correo es el siguiente: " + correo + " y cuyo DNI es el siguiente: "+ DNI;
        return resultado;
    }
    /**
     * Este método consiste como hemos mencionado anteriormente en darle un nuevo formato al nombre.
     * @param nombre Parámetro que consiste en guardar la primera letra en mayúscula
     * y en caso de que el nombre sea compuesto, deberá llevar mayúsculas en la primera letra de cada parte.
     * */
    private static String nuevoFormato (String nombre){
        String nuevoFormato ="";
        String convertirMinusculas = nombre.toLowerCase();
        nuevoFormato = nuevoFormato.concat(nombre.substring(0,1).toUpperCase());
        for (int i = 1; i<nombre.length(); i++){
            if (nombre.charAt(i) != convertirMinusculas.charAt(i))
                nuevoFormato =nuevoFormato.concat(" " + nombre.substring(i, i+1));
            else nuevoFormato = nuevoFormato.concat(nombre.substring(i,i+1));
            if (nombre.charAt(i - 1) == ' ' && nombre.charAt(i) ==convertirMinusculas.charAt(i))
                nuevoFormato = nuevoFormato.concat(nombre.substring(i, i+1).toUpperCase());
        }
        return nuevoFormato;
    }
}
