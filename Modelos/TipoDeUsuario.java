package modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDeUsuario {

    private String nombre;

    public TipoDeUsuario() {
    }

    public TipoDeUsuario(String nombre) {
        this.nombre = nombre;
    }
}