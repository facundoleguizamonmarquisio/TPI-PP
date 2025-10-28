package modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDeUsuario {

    private String nombre;
    private String descripcion;

    public TipoDeUsuario(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoDeUsuario(String nombre) {
        this.nombre = nombre;
    }
}