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

  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  // Getter
  public String getNombre() {
    return this.nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public String getDocumento() {
    return this.documento;
  }

  public String getDomicilio() {
    return this.domicilio;
  }

  public String getLocalidad() {
    return this.localidad;
  }

  public String getFechaNacimiento() {
    return this.fechaNacimiento;
  }

  public String getTelefono() {
    return this.telefono;
  }
  
  public String getMail() {
    return this.mail;
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