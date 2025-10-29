package modelos;

public class UsuarioUTN extends Persona {
    private TipoDeUsuario tipoDeUsuario;
    private int legajo;

    public UsuarioUTN(String nombre, String apellido, String documento, String domicilio, String localidad,
            String fechaNacimiento, String telefono, String mail, TipoDeUsuario tipoDeUsuario, int legajo) {
        super(nombre, apellido, documento, domicilio, localidad, fechaNacimiento, telefono, mail);
        this.tipoDeUsuario = tipoDeUsuario;
        this.legajo = legajo;
    }

    // Setter
    public void setTipoDeUusario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    // Getter
    public TipoDeUsuario getTipoDeUusario() {
        return this.tipoDeUsuario;
    }

    public int getLegajo() {
        return this.legajo;
    }

    // Métodos
}