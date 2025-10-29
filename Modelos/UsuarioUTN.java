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
    public void setTipoDeUsario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    // Getter
    public TipoDeUsuario getTipoDeUsario() {
        return this.tipoDeUsuario;
    }

    public int getLegajo() {
        return this.legajo;
    }

    // Métodos
}