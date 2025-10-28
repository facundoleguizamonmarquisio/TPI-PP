package modelos;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String documento;
    protected String domicilio;
    protected String localidad;
    protected String fechaNacimiento;
    protected String telefono;
    protected String mail;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String documento, String domicilio, String localidad,
            String fechaNacimiento, String telefono, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.mail = mail;
    }

    public void tomarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void tomarApellido(String apellido) {
        this.apellido = apellido;
    }

    public void tomarDocumento(String documento) {
        this.documento = documento;
    }

    public void tomarDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void tomarLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void tomarFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void tomarTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void tomarMail(String mail) {
        this.mail = mail;
    }

    public String mostrarNombre() {
        return nombre;
    }

    public String mostrarApellido() {
        return apellido;
    }

    public String mostrarDocumento() {
        return documento;
    }

    public String mostrarDomicilio() {
        return domicilio;
    }

    public String mostrarLocalidad() {
        return localidad;
    }

    public String mostrarFechaNacimiento() {
        return fechaNacimiento;
    }

    public String mostrarTelefono() {
        return telefono;
    }

    public String mostrarMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nDocumento: " + documento +
                "\nDomicilio: " + domicilio +
                "\nLocalidad: " + localidad +
                "\nFecha de nacimiento: " + fechaNacimiento +
                "\nTeléfono: " + telefono +
                "\nMail: " + mail;
    }
}
