public class UsuarioUTN extends Persona {
    private TipoDeUsuario tipoDeUsuario;
    private int legajo;

    public UsuarioUTN() {}

    public UsuarioUTN(String nombre, String apellido, String documento, String domicilio,
                      String localidad, String fechaNacimiento, String telefono, String mail,
                      TipoDeUsuario tipoDeUsuario, int legajo) {
        super(nombre, apellido, documento, domicilio, localidad, fechaNacimiento, telefono, mail);
        this.tipoDeUsuario=tipoDeUsuario;
        this.legajo=legajo;
    }

    public void tomarTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario=tipoDeUsuario;
    }

    public void tomarLegajo(int legajo) {
        this.legajo=legajo;
    }

    public TipoDeUsuario mostrarTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public int mostrarLegajo() {
        return legajo;
    }

    @Override
    public String toString() {
        return "Nombre: "+mostrarNombre()+
               "\nApellido: "+mostrarApellido()+
               "\nDocumento: "+mostrarDocumento()+
               "\nDomicilio: "+mostrarDomicilio()+
               "\nLocalidad: "+mostrarLocalidad()+
               "\nFecha de nacimiento: "+mostrarFechaNacimiento()+
               "\nTeléfono: "+mostrarTelefono()+
               "\nMail: "+mostrarMail()+
               "\nTipo de usuario: "+(tipoDeUsuario!=null?tipoDeUsuario.mostrarNombre():"null")+
               "\nLegajo: "+legajo;
    }
}
