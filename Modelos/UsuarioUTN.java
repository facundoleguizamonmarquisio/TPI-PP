package modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUTN extends Persona {
    private TipoDeUsuario tipoDeUsuario;
    private int legajo;

    public UsuarioUTN() {
    }

    public UsuarioUTN(String nombre, String apellido, String documento, String domicilio, String localidad,
            String fechaNacimiento, String telefono, String mail, TipoDeUsuario tipoDeUsuario, int legajo) {
        super(nombre, apellido, documento, domicilio, localidad, fechaNacimiento, telefono, mail);
        this.tipoDeUsuario = tipoDeUsuario;
        this.legajo = legajo;
    }

}