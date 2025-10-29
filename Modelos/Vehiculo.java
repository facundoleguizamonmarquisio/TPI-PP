package modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String patente;
    protected String color;
    protected String fechaRegistro;
    protected String horaRegistro;

    public Vehiculo(String marca, String modelo, String patente, String color, String fechaRegistro,
            String horaRegistro) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.color = color;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }
}
