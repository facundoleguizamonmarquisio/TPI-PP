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

  // Setter
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  // Getter
  public int getNumeroDeCuenta() {
    return this.numeroDeCuenta;
  }

  // Métodos
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