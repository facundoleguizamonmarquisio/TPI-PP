package modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDeCuenta {
    protected String nombre;
    protected String descripcion;

    public TipoDeCuenta() {
    }

    public TipoDeCuenta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

}
